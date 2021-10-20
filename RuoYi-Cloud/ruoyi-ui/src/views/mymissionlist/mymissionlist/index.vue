<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="任务名称" prop="taskName">
        <el-input
          v-model="queryParams.taskName"
          placeholder="请输入任务名称"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务类型" prop="taskType">
        <el-select v-model="queryParams.taskType" placeholder="请选择任务类型" clearable size="small">
          <el-option v-for="item in typelist" :key="item.id"  :label="item.taskType" :value="item.taskType">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="任务时间" prop="taskTime">
        <el-date-picker clearable size="small"
                        v-model="queryParams.taskTime"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择任务时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="结束时间" prop="endTime">
        <el-date-picker clearable size="small"
                        v-model="queryParams.endTime"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择结束时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="无人机编号" prop="taskDrone">
        <el-input
          v-model="queryParams.taskDrone"
          placeholder="请输入无人机编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="驾驶员" prop="taskDriver">
        <el-select v-model="queryParams.taskDriver" placeholder="请选择驾驶员" clearable size="small">
          <el-option v-for="item in drivelist" :key="item.id"  :label="item.driverName" :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="驾驶员手机号码" prop="driverPhone">
        <el-input
          v-model="queryParams.driverPhone"
          placeholder="请输入驾驶员手机号码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="航线" prop="taskAirline">
        <el-input
          v-model="queryParams.taskAirline"
          placeholder="请输入航线"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务封面图片" prop="taskImages">
        <el-input
          v-model="queryParams.taskImages"
          placeholder="请输入任务封面图片"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务地点" prop="taskAddress">
        <el-input
          v-model="queryParams.taskAddress"
          placeholder="请输入任务地点"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="删除码" prop="deleteCode">
        <el-input
          v-model="queryParams.deleteCode"
          placeholder="请输入删除码"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="描述" prop="extraExplain">
        <el-input
          v-model="queryParams.extraExplain"
          placeholder="请输入描述"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务状态" prop="taskState">
        <el-input
          v-model="queryParams.taskState"
          placeholder="请输入任务状态"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['missionlist:missionlist:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['missionlist:missionlist:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['missionlist:missionlist:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['missionlist:missionlist:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="missionlistList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="任务名称" align="center" prop="taskName" />
      <el-table-column label="任务类型" align="center" prop="taskType" />
      <el-table-column label="任务时间" align="center" prop="taskTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.taskTime, '{y}-{m}-{d} {h}:{i}:{s}')}}</span>
        </template>
      </el-table-column>
      <el-table-column label="结束时间" align="center" prop="endTime" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.endTime, '{y}-{m}-{d} {h}:{i}:{s}')}}</span>
        </template>
      </el-table-column>
      <el-table-column label="无人机编号" align="center" prop="taskDrone" />
      <el-table-column label="驾驶员" align="center" prop="driverName" />
      <el-table-column label="驾驶员手机号码" align="center" prop="driverPhone" />
      <el-table-column label="主键id" align="center" prop="id" />
      <el-table-column label="航线" align="center" prop="taskAirline" />
      <el-table-column label="任务封面图片" align="center" prop="taskImages" />
      <el-table-column label="任务地点" align="center" prop="taskAddress" />
      <el-table-column label="删除码" align="center" prop="deleteCode" />
      <el-table-column label="描述" align="center" prop="extraExplain" />
      <el-table-column label="任务状态" align="center" prop="taskState" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
      <!--   开始任务 结束任务 查看回放     -->
        <template slot-scope="scope">

          <p v-if="scope.row.taskState == 0">
            <el-button
              size="mini"
              type="text"
              @click="handleUpdateStartMission(scope.row)"
              v-hasPermi="['mymissionlist:mymissionlist:query']"
            >开始任务</el-button>
          </p>

          <p v-if="scope.row.taskState == 1">
            <el-button
              size="mini"
              type="text"
              @click="handleUpdateFinishMission(scope.row)"
              v-hasPermi="['mymissionlist:mymissionlist:query']"
            >完成任务</el-button>
          </p>

          <p v-if="scope.row.taskState == 2">

            <!-- 视频播放-->
            <el-dialog :title="title" :visible.sync="videoFlag" width="500px" height="500px">
              <vue-ali-player
                :useH5Prism=true
                ref="player"
                control-bar-visibility="hover"
                :source="url"
              ></vue-ali-player>
            </el-dialog>

            <el-button
              size="mini"
              type="text"
              @click="openVideo(scope.row)"
              v-hasPermi="['mymissionlist:mymissionlist:query']"
            >查看回放</el-button>

            <!--上传附件-->
            <el-button
              size="mini"
              type="text"
              @click="finishFile()"
              v-hasPermi="['mymissionlist:mymissionlist:query']"
            >填写记录</el-button>

            <!--调用上传文件组件-->
            <el-dialog :title="title" :visible.sync="uploadFileFlag" width="500px" height="1000px">

                <el-form label-width="80px">
                  <file-upload v-model="flyDoc" :limit="1"></file-upload>
                </el-form>

                <el-button type="primary" @click="submitFlyFile(scope.row)">确 定</el-button>

            </el-dialog>

          </p>

        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改任务列表对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
<!--        <el-form-item label="任务名称" prop="taskName">-->
<!--          <el-input v-model="form.taskName" placeholder="请输入任务名称" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="任务类型" prop="taskType">-->
<!--          <el-select v-model="form.taskType" placeholder="请选择任务类型" clearable size="small">-->
<!--            <el-option v-for="item in typelist" :key="item.id"  :label="item.taskType" :value="item.taskType">-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="任务时间" prop="taskTime">-->
<!--          <el-date-picker clearable size="small"-->
<!--                          v-model="form.taskTime"-->
<!--                          type="date"-->
<!--                          value-format="yyyy-MM-dd"-->
<!--                          placeholder="选择任务时间">-->
<!--          </el-date-picker>-->
<!--        </el-form-item>-->
<!--        <el-form-item label="无人机编号" prop="taskDrone">-->
<!--          <el-input v-model="form.taskDrone" placeholder="请输入无人机编号" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="驾驶员" prop="taskDriver">-->
<!--          <el-select v-model="form.taskDriver" placeholder="请选择驾驶员" clearable size="small">-->
<!--            <el-option v-for="item in drivelist" :key="item.id" :label="item.driverName + ' ' + item.driverPhone" :value="item.id">-->
<!--            </el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->

<!--        <el-form-item label="航线" prop="taskAirline">-->
<!--          <el-input v-model="form.taskAirline" placeholder="请输入航线" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="任务封面图片" prop="taskImages">-->
<!--          <el-input v-model="form.taskImages" placeholder="请输入任务封面图片" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="任务地点" prop="taskAddress">-->
<!--          <el-input v-model="form.taskAddress" placeholder="请输入任务地点" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="任务状态" prop="taskState">-->
<!--          &lt;!&ndash; TODO&ndash;&gt;-->
<!--          <el-input v-model="form.taskState" placeholder="请输入任务状态" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="删除码" prop="deleteCode">-->
<!--          <el-input v-model="form.deleteCode" placeholder="请输入删除码" />-->
<!--        </el-form-item>-->
<!--        <el-form-item label="描述" prop="extraExplain">-->
<!--          <el-input v-model="form.extraExplain" placeholder="请输入描述" />-->
<!--        </el-form-item>-->
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import {listMymissionlist, getMymissionlist} from "@/api/mymissionlist/mymissionlist";
import {listPilots,getPilots} from "@/api/pilots/pilots";
import {getUserProfile} from "../../../api/system/user";
import {getPilotsByName, updatePilots} from "../../../api/pilots/pilots";
import {updateMymissionlist} from "../../../api/mymissionlist/mymissionlist";
import VueAliPlayer from "../../../components/VueAliPlayer/VueAliPlayer";
import FileUpload from "@/components/FileUpload/index.vue";
import {updateMyflyrecord} from "../../../api/myflyrecord/myflyrecord";
import {getMyflyrecord} from "../../../api/myflyrecord/myflyrecord";
import {addMyflyrecord} from "../../../api/myflyrecord/myflyrecord";
import { getUav_manage_by_flightNumber, updateUav_manage} from "../../../api/uav/uav_manage";


export default {
  name: "Missionlist",
  components:{
     VueAliPlayer,
     FileUpload
  },
  data() {
    return {

      // 视频回放弹窗
      videoFlag: false,

      //上传附件窗口
      uploadFileFlag: false,


      uavForm: {},

      url: 'https://www.w3school.com.cn/example/html5/mov_bbb.mp4',

      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 任务列表表格数据
      typeList: [],
      //驾驶员信息列表
      drivelist:[],
      flyDoc: null,
      missionlistList:[],
      //更新飞行记录的表单
      recordForm: {
        taskId: null,
        flyDoc: null
      },


      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        taskName: null,
        taskType: null,
        taskTime: null,
        taskState: null,
        taskDrone: null,
        endTime: null,
        taskDriver: null,
        driverPhone: null,
        taskAirline: null,
        taskImages: null,
        taskAddress: null,
        deleteCode: null,
        extraExplain: null
      },
      //查询保管员的参数
      UserqueryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        phone: null
      },
      //储存任务类型
      typelist:[],
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        taskName: [
          { required: true, message: "任务名称不能为空", trigger: "blur" }
        ],
        taskType: [
          { required: true, message: "任务类型不能为空", trigger: "change" }
        ],
        taskTime: [
          { required: true, message: "任务时间不能为空", trigger: "blur" }
        ],
        taskDrone: [
          { required: true, message: "无人机编号不能为空", trigger: "blur" }
        ],
        taskDriver: [
          { required: true, message: "驾驶员不能为空", trigger: "blur" }
        ],
        driverPhone: [
          { required: true, message: "驾驶员手机号码不能为空", trigger: "blur" }
        ],
        taskState: [
          { required: true, message: "任务状态不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },

  methods: {

    submitFlyFile(row){
      const id = row.id || this.ids
      const docFly = this.flyDoc;
      getMyflyrecord(id).then(response => {
        this.resetForm("recordForm");
        this.recordForm = response.data;
        this.recordForm.flyDoc = docFly;
        //类型转换，字符串转int，解决下拉框只显示id的bug
        updateMyflyrecord(this.recordForm)
        this.uploadFileFlag = false;
        this.reset();
      });

    },

    openVideo(row){
      this.title = "查看回放";
      this.videoFlag = true;
      getMyflyrecord(row.id).then(response => {
        this.url=response.flyVideo;
      })
    },

    finishFile(){
      this.title = "填写记录";
      this.uploadFileFlag = true;
    },

    /** 查询任务列表列表 */
    getList() {
      //查询对应名字的飞行员id
      //找到用户的名字

      getUserProfile().then(response => {

        let name = response.data.nickName;

        let obj = {
          name: name
        }

        getPilotsByName(obj).then(response => {

          if (response.data) {
            this.loading = true;
            this.queryParams.taskDriver = response.data.id

            /** 获取驾驶员信息 */
            listPilots(this.UserqueryParams).then(response => {
              this.drivelist = response.rows;
            });

            listMymissionlist(this.queryParams).then(response => {
              this.missionlistList = response.rows;
              this.total = response.total;
              //查询某个驾驶员信息
              for (let i = 0; i < this.missionlistList.length; i++) {
                if (this.missionlistList[i].id){
                  getPilots(this.missionlistList[i].taskDriver).then(resp=>{
                      this.$set(this.missionlistList[i],'driverName',resp.data.driverName);
                      this.$set(this.missionlistList[i],'driverPhone',resp.data.driverPhone);
                    }
                  )

                }else{//ID 为0时
                  this.uav_manageList[i].driverName="无";
                  this.uav_manageList[i].driverPhone="无";
                }

              }
            });
          }
          else{
            this.missionlistList = null;
          }
          this.loading = false;

        });
      })

    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        taskName: null,
        taskType: null,
        taskTime: null,
        taskDrone: null,
        taskDriver: null,
        endTime: null,
        id: null,
        taskAirline: null,
        taskImages: null,
        taskAddress: null,
        deleteCode: null,
        extraExplain: null,
        taskState: null,
        driverPhone: null
      };
      //飞行记录请求表
      this.recordForm = {
        taskId: null,
        flyDoc: null
      };

      this.pilotForm ={
        trainingTime: null,
        flyingTime: null,
        traingingTime: null,
      };

      this.uavForm = {

      };

      //重置表单
      this.resetForm("form");
      this.resetForm("recordForm");
      this.resetForm("pilotForm");
      this.resetForm("uavForm");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.id)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加任务列表";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.id
      getMymissionlist(id).then(response => {
        this.form = response.data;
        //类型转换，字符串转int，解决下拉框只显示id的bug
        this.form.taskDriver = parseInt(this.form.taskDriver);
        this.open = true;
        this.title = "修改任务列表";
      });
    },
    /** 开始任务更新操作 */
    handleUpdateStartMission(row) {
      this.reset();
      const id = row.id || this.ids
      getMymissionlist(id).then(response => {
        this.form = response.data;
        //类型转换，字符串转int，解决下拉框只显示id的bug
        const date=new Date();
        const year=date.getFullYear(); //获取当前年份
        const mon=date.getMonth()+1; //获取当前月份
        const day=date.getDate(); //获取当前日
        const h=date.getHours(); //获取小时
        const m=date.getMinutes(); //获取分钟
        const s=date.getSeconds(); //获取秒
        this.form.taskTime = year + "-" + mon + "-" + day + " " + h + ":" + m + ":" + s;
        this.form.taskState = 1;
        this.open = true;
        this.title = "确认开始执行任务？";
      });
    },
    /** 完成任务更新操作 */
    handleUpdateFinishMission(row) {
      this.reset();
      const id = row.id || this.ids

      getMymissionlist(id).then(response => {
        this.form = response.data;
        //类型转换，字符串转int，解决下拉框只显示id的bug
        const date=new Date();
        const year=date.getFullYear(); //获取当前年份
        const mon=date.getMonth()+1; //获取当前月份
        const day = date.getDate(); //获取当前日
        const h=date.getHours(); //获取小时
        const m=date.getMinutes(); //获取分钟
        const s=date.getSeconds(); //获取秒
        this.form.endTime = year + "-" + mon + "-" + day + " " + h + ":" + m + ":" + s;
        this.form.taskState = 2;

        //这里写死了训练试飞
        if(this.form.taskType == "训练"){
          this.resetForm("pilotForm");
          //时间相减
          const endTime = new Date(this.form.endTime)
          const startTime = new Date(this.form.taskTime)
          //计算训练总时长，单位为毫秒
          this.pilotForm.trainingTime = (endTime.getTime()-startTime.getTime());
        }
        //这里写死了训练试飞
        else{
          this.resetForm("pilotForm");
          //时间相减
          const endTime = new Date(this.form.endTime)
          const startTime = new Date(this.form.taskTime)
          //计算训练总时长，单位为m秒
          this.pilotForm.flyingTime = (endTime.getTime()-startTime.getTime());
        }

        this.open = true;
        this.title = "确认完成任务？";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {

          if (this.form.id != null) {
            //更新飞行员信息表和飞行器信息表

            //驾驶员ID
            const id = this.form.taskDriver;
            //飞行器编号
            const uav_flight_number = this.form.taskDrone;
            //任务状态
            const taskState = this.form.taskState;

            //查找对应的驾驶员，形成表单更新驾驶员状态
            getPilots(id).then(response =>{
              const traingTime = this.pilotForm.trainingTime;
              const flyingTime = this.pilotForm.flyingTime;
              this.pilotForm = response.data;

              //更新任务状态
              this.pilotForm.driverState = taskState;
              this.pilotForm.trainingTime = this.pilotForm.trainingTime + traingTime;
              this.pilotForm.flyingTime = this.pilotForm.flyingTime + flyingTime;
              this.pilotForm.sumTime = this.pilotForm.flyingTime + this.pilotForm.trainingTime;
              updatePilots(this.pilotForm)
            })

            //查找对应的飞行器，形成表单更新飞行器状态
            getUav_manage_by_flightNumber(uav_flight_number).then(response =>{
              this.uavForm = response.data
              this.uavForm.uavEnabled = taskState
              updateUav_manage(this.uavForm)
            })

            //飞行任务入飞行记录 还需要在这里添加出发点记录入库 TODO
            this.recordForm.taskId = this.form.id;

            getMyflyrecord(this.recordForm.taskId).then(response => {
              if (response.data) {
                //如果可以获取得到数据 即该id已存在，则执行更新
                updateMyflyrecord(this.recordForm)
              } else {
                //否则插入一条记录
                addMyflyrecord(this.recordForm)
              }
            })

            updateMymissionlist(this.form).then(response => {
              this.open = false;
              this.getList();
            });

            this.$modal.msgSuccess("修改成功");
          }
        }
      })
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除任务列表编号为"' + ids + '"的数据项？').then(function() {
        return delMissionlist(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('missionlist/missionlist/export', {
        ...this.queryParams
      }, `missionlist_missionlist.xlsx`)
    }
  }
};
</script>
