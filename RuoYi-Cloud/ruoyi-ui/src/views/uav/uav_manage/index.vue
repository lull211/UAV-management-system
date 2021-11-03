<template>
  <div class="app-container">
<!--    //信息表单-->
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="归口部门" prop="uavUnit">
        <el-select v-model="queryParams.uavUnit" placeholder="请选择无人机归口部门" clearable size="small">
            <el-option v-for="item in departmentlist" :key="item.id"  :label="item.uavDepartment" :value="item.uavDepartment">
            </el-option>
        </el-select>
      </el-form-item>
      <el-form-item label="命名" prop="uavName">
        <el-input
          v-model="queryParams.uavName"
          placeholder="请输入无人机命名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="类型" prop="uavType">
          <el-select v-model="queryParams.uavType" placeholder="请选择无人机类型">
            <el-option v-for="item in uavTypeList" :key="item.id"  :label="item.uavType" :value="item.uavType">
            </el-option>
          </el-select>
      </el-form-item>

      <el-form-item label="产品型号" prop="uavNumber">
        <el-input
          v-model="queryParams.uavNumber"
          placeholder="请输入无人机产品型号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="序列号" prop="uavSn">
        <el-input
          v-model="queryParams.uavSn"
          placeholder="请输入无人机序列号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="飞控编号" prop="uavFlightNumber">
        <el-input
          v-model="queryParams.uavFlightNumber"
          placeholder="请输入无人机飞控编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>

      <el-form-item label="备勤等级" prop="uavBeiqinLevel">
        <el-select v-model="queryParams.uavBeiqinLevel" placeholder="请选择无人机备勤等级" clearable size="small">
          <el-option
            v-for="dict in this.missionLevelList"
            :key="dict.id"
            :label="dict.level"
            :value="dict.id"
          />
        </el-select>
      </el-form-item>

      <el-form-item label="启用状态" prop="uavEnabled">
        <el-select v-model="queryParams.uavEnabled" placeholder="请选择无人机启用状态" clearable size="small">
          <el-option
            v-for="dict in enableList"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
<!--      <el-form-item label="保险到期时间" prop="uavInsurance">-->
<!--        <el-date-picker clearable size="small"-->
<!--          v-model="queryParams.uavInsurance"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="选择无人机保险到期时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="质保到期时间" prop="uavAssurance">-->
<!--        <el-date-picker clearable size="small"-->
<!--          v-model="queryParams.uavAssurance"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="选择无人机质保到期时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
<!--      <el-form-item label="保养到期时间" prop="uavMaintenance">-->
<!--        <el-date-picker clearable size="small"-->
<!--          v-model="queryParams.uavMaintenance"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="选择无人机保养到期时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
      <el-form-item label="保管员" prop="uavKeeperId">
        <el-select v-model="queryParams.uavKeeperId" placeholder="请选择保管员">
          <el-option v-for="item in keeperList" :key="item.id"  :label="item.name" :value="item.id">
          </el-option>
        </el-select>
      </el-form-item>
<!--      <el-form-item label="入库时间" prop="uavPut">-->
<!--        <el-date-picker clearable size="small"-->
<!--          v-model="queryParams.uavPut"-->
<!--          type="date"-->
<!--          value-format="yyyy-MM-dd"-->
<!--          placeholder="选择无人机入库时间">-->
<!--        </el-date-picker>-->
<!--      </el-form-item>-->
      <el-form-item label="录入人" prop="uavUsers">
        <el-input
          v-model="queryParams.uavUsers"
          placeholder="请输入无人机录入人"
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

<!--    //新增，修改，删除的按钮-->
    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['uav:uav_manage:add']"
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
          v-hasPermi="['uav:uav_manage:edit']"
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
          v-hasPermi="['uav:uav_manage:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['uav:uav_manage:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

<!--    //下面的菜单-->
    <el-table v-loading="loading" :data="uav_manageList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />

      <el-table-column label="无人机命名" align="center" prop="uavName" />

      <el-table-column label="无人机归口部门" align="center" prop="uavUnit" />

<!--      <el-table-column label="无人机飞控编号" align="center" prop="uavFlightNumber" />-->
      <el-table-column label="无人机类型" align="center" prop="uavType"/>
      <el-table-column label="无人机产品型号" align="center" prop="uavNumber" />

<!--      <el-table-column label="无人机序列号" align="center" prop="uavSn" />-->

      <el-table-column label="无人机备勤等级" align="center" prop="uavBeiqinLevelName"/>

      <el-table-column label="无人机启用状态" align="center" prop="uavEnabled">
        <template slot-scope="scope">
          <p v-if="scope.row.uavEnabled != 1">
            空闲中
          </p>
          <p v-if="scope.row.uavEnabled == 1">
            任务中
          </p>
        </template>
      </el-table-column>

      <el-table-column label="保管员姓名" align="center" prop="uavKeeperName" />
      <el-table-column label="保管员手机号" align="center" prop="uavKeeperPhone" />
      <el-table-column label="无人机图片" align="center" prop="uavImages" >
        <template slot-scope="scope">
          <el-image :src="scope.row.uavImages">
          </el-image>
        </template>
      </el-table-column>
<!--      <el-table-column label="无人机相关附件" align="center" class-name="small-padding fixed-width" >-->
<!--      <template slot-scope="scope">-->
<!--        <el-button-->
<!--          size="mini"-->
<!--          type="text"-->
<!--          icon="el-icon-download"-->
<!--          @click="downloadFile(scope.row)"-->
<!--        >下载</el-button>-->
<!--      </template>-->
<!--      </el-table-column>-->
<!--      <el-table-column label="删除码" align="center" prop="deleteFlag" />-->
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="openDetail(scope.row)"
            v-hasPermi="['uav:uav_manage:query']"
          >详情</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['uav:uav_manage:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['uav:uav_manage:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>

<!--    //弹出框修改信息-->
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
    <!--  详情页-->
    <!--  需要展示内容  -->
    <el-dialog :title="title" :visible.sync="detailFlag" width="60%" append-to-body>

      <el-descriptions direction="vertical" class="margin-top" :column="5" border>

        <el-descriptions-item label="命名">{{detailDic.uavName}}</el-descriptions-item>
        <el-descriptions-item label="归口部门">{{detailDic.uavUnit}}</el-descriptions-item>
        <el-descriptions-item label="类型">{{detailDic.uavType}}</el-descriptions-item>
        <el-descriptions-item label="序列号">{{detailDic.uavSn}}</el-descriptions-item>

        <el-descriptions-item label="飞控编号">
          {{detailDic.uavFlightNumber}}
        </el-descriptions-item>

        <el-descriptions-item label="产品型号">
          {{detailDic.uavNumber}}
        </el-descriptions-item>

        <el-descriptions-item label="序列号">
          {{detailDic.uavSn}}
        </el-descriptions-item>


        <el-descriptions-item label="保管员">
          {{detailDic.uavKeeperName}}     {{detailDic.uavKeeperPhone}}
        </el-descriptions-item>

        <el-descriptions-item label="备勤等级">
          {{detailDic.uavBeiqinLevelName}}
        </el-descriptions-item>

        <el-descriptions-item label="保险到期时间">
          {{detailDic.uavInsurance}}
        </el-descriptions-item>

        <el-descriptions-item label="质保到期时间">
          {{detailDic.uavAssurance}}
        </el-descriptions-item>

        <el-descriptions-item label="保养到期时间">
          {{detailDic.uavMaintenance}}
        </el-descriptions-item>

        <el-descriptions-item label="录入人">
          {{detailDic.uavUsers}}
        </el-descriptions-item>

        <el-descriptions-item label="无人机相关图片">
          <el-image :src="detailDic.uavImages">
          </el-image>
        </el-descriptions-item>

        <el-descriptions-item label="无人机相关附件">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-download"
            @click="downloadFileForDetail(detailDic.uavAttachment)"
          >下载</el-button>
        </el-descriptions-item>

      </el-descriptions>

    </el-dialog>

    <!-- 添加或修改无人机信息管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="60%" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="150px" label-position="left">

        <el-form-item label="无人机归口部门" prop="uavUnit">
          <el-select v-model="form.uavUnit" placeholder="请选择无人机归口部门">
            <el-option v-for="item in departmentlist" :key="item.id"  :label="item.uavDepartment" :value="item.uavDepartment">
              </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="无人机命名" prop="uavName">
          <el-input v-model="form.uavName" placeholder="请输入无人机命名" />
        </el-form-item>

        <el-form-item label="无人机类型" prop="uavType">
          <el-select v-model="form.uavType" placeholder="请选择无人机类型">
            <el-option v-for="item in uavTypeList" :key="item.id"  :label="item.uavType+'  '+  item.typeExplain" :value="item.uavType">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="无人机产品型号" prop="uavNumber">
          <el-input v-model="form.uavNumber" placeholder="请输入无人机产品型号" />
        </el-form-item>

        <el-form-item label="无人机图片" prop="uavImages">
          <UploadImage v-model="form.uavImages" :limit="1"></UploadImage>
        </el-form-item>

        <el-form-item label="无人机序列号" prop="uavSn">
          <el-input v-model="form.uavSn" placeholder="请输入无人机序列号" />
        </el-form-item>

        <el-form-item label="无人机飞控编号" prop="uavFlightNumber">
          <el-input v-model="form.uavFlightNumber" placeholder="请输入无人机飞控编号" />
        </el-form-item>

        <el-form-item label="无人机备勤等级" prop="uavBeiqinLevel">
          <el-select v-model="form.uavBeiqinLevel" placeholder="请选择无人机备勤等级">
            <el-option v-for="item in missionLevelList" :key="item.id"  :label="item.level+ '  等级描述:'+  item.explain1" :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
<!--        <el-form-item label="无人机启用状态" prop="uavEnabled">-->
<!--          <el-select v-model="form.uavEnabled" placeholder="请选择无人机启用状态">-->
<!--            <el-option-->
<!--              v-for="dict in dict.type.sys_uav_state"-->
<!--              :key="dict.value"-->
<!--              :label="dict.label"-->
<!--              :value="parseInt(dict.value)"-->
<!--            ></el-option>-->
<!--          </el-select>-->
<!--        </el-form-item>-->
        <el-form-item label="无人机保险到期时间" prop="uavInsurance">
          <el-date-picker clearable size="small"
            v-model="form.uavInsurance"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择无人机保险到期时间">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="无人机质保到期时间" prop="uavAssurance">
          <el-date-picker clearable size="small"
            v-model="form.uavAssurance"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择无人机质保到期时间">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="无人机保养到期时间" prop="uavMaintenance">
          <el-date-picker clearable size="small"
            v-model="form.uavMaintenance"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择无人机保养到期时间">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="保管员" prop="uavKeeperId">
          <!--下拉框保管员选择-->
          <el-select v-model="form.uavKeeperId" placeholder="请选择保管员">
            <el-option v-for="item in keeperList" :key="item.id"  :label="item.name+'  '+  item.phone" :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>

        <el-form-item label="无人机入库时间" prop="uavPut">
          <el-date-picker clearable size="small"
            v-model="form.uavPut"
            type="date"
            value-format="yyyy-MM-dd"
            placeholder="选择无人机入库时间">
          </el-date-picker>
        </el-form-item>

        <el-form-item label="无人机相关附件" prop="uavAttachment">
          <FileUpload  v-model="form.uavAttachment" :limit="1"></FileUpload>
        </el-form-item>
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>

</template>

<script>
import { listUav_manage, getUav_manage, delUav_manage, addUav_manage, updateUav_manage } from "@/api/uav/uav_manage";
import {listUavdepartment} from "@/api/uavdepartment/uavdepartment";
import {listKeeper,getKeeper} from "@/api/keeper/keeper";
import {listMissionlevel} from "@/api/missionlevel/missionlevel";
import {listUavtype} from "@/api/uavtype/uavtype";
import UploadImage from "@/components/ImageUpload";
import FileUpload from "@/components/FileUpload";
import {getMissionlevel} from "../../../api/missionlevel/missionlevel";
import {getSystemprofile} from "../../../api/systemprofile/systemprofile";
import {getUserProfile} from "../../../api/system/user";
import {getMissionlistByUavNumber, getUav_manageByName, getUav_manageByNameAcc} from "../../../api/uav/uav_manage";
import {getMissionlistByDriverId} from "../../../api/pilots/pilots";


export default {
  name: "Uav_manage",
  dicts: ['sys_uav_department', 'sys_pilots_craft_sort', 'sys_uav_readylevel', 'sys_uav_state'],
  components: {UploadImage,FileUpload},
  //初始数据
  data() {
    return {
      //当前账号名称
      userName: "",

      //详情页flag
      detailFlag: false,

      enableList:[{"label": "空闲中", "value": 0},{"label": "任务中", "value": 1}],

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
      // 无人机信息管理表格数据
      uav_manageList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        uavUnit: null,
        uavName: null,
        uavType: null,
        uavNumber: null,
        uavImages: null,
        uavSn: null,
        uavFlightNumber: null,
        uavBeiqinLevel: null,
        uavEnabled: null,
        uavInsurance: null,
        uavAssurance: null,
        uavMaintenance: null,
        uavKeeperId: null,
        uavPut: null,
        uavUsers: null,
        uavAttachment: null,
        deleteFlag: null
      },
      //查询保管员的参数
      UserqueryParams: {
        pageNum: 1,
        pageSize: 10,
        name: null,
        phone: null
      },
      //储存保管员参数
      keeperList:[],
      //储存备勤等级参数
      missionLevelList:[],
      //储存无人机类型
      uavTypeList:[],
      //储存归口部门
      departmentlist:[],

      //细节字典
      detailDic: {},

      // 表单参数
      form: {},
      // 表单校验
      rules: {
        uavUnit: [
          { required: true, message: "无人机归口部门不能为空", trigger: "change" }
        ],
        uavName: [
          { required: true, message: "无人机命名不能为空", trigger: "blur" }
        ],
        uavType: [
          { required: true, message: "无人机类型不能为空", trigger: "change" }
        ],
        uavNumber: [
          { required: true, message: "无人机产品型号不能为空", trigger: "blur" }
        ],
        uavImages: [
          { required: true, message: "无人机图片不能为空", trigger: "change" }
        ],
        uavSn: [
          { required: true, message: "无人机序列号不能为空", trigger: "blur" }
        ],
        uavFlightNumber: [
          { required: true, message: "无人机飞控编号不能为空", trigger: "blur" }
        ],
        uavUsers: [
          { required: true, message: "无人机录入人不能为空", trigger: "blur" }
        ],
        uavBeiqinLevel: [
          { required: true, message: "无人机备勤等级不能为空", trigger: "blur" }
        ],
        uavKeeperId: [
          { required: true, message: "无人机管理员不能为空", trigger: "blur" }
        ]
      },

    };
  },

  created() {
    this.getList();
    this.loading = false;
  },

  methods: {

    /**无人机详情页面**/
    openDetail(row){
      this.resetForm("detailDic");
      const id = row.id || this.ids;
      getUav_manage(id).then(response => {
        this.detailDic = response.data;
        this.title = "无人机详情";
        getKeeper(this.detailDic.uavKeeperId).then(response => {
          this.detailDic.uavKeeperName = response.data.name;
          this.detailDic.uavKeeperPhone = response.data.phone;
        }),
        getMissionlevel(this.detailDic.uavBeiqinLevel).then(response => {
          this.detailDic.uavBeiqinLevelName = response.data.level;
          this.detailFlag = true;
        })

      });
    },

    /** 查询无人机信息管理列表 */
    getList() {
      listUav_manage(this.queryParams).then(response => {
        this.uav_manageList = response.rows;
        this.total = response.total;
        //查询某个保管员信息
        for (let i = 0; i < this.uav_manageList.length; i++) {
          if (this.uav_manageList[i].uavKeeperId){
            getKeeper(this.uav_manageList[i].uavKeeperId).then(resp=>{
              this.$set(this.uav_manageList[i],'uavKeeperName',resp.data.name);
              this.$set(this.uav_manageList[i],'uavKeeperPhone',resp.data.phone);
            })
          }else {//ID 为0时
            this.uav_manageList[i].uavKeeperName = "无";
            this.uav_manageList[i].uavKeeperPhone = "无";
          }

          if(this.uav_manageList[i].uavBeiqinLevel){
            getMissionlevel(this.uav_manageList[i].uavBeiqinLevel).then(resp=>{
              this.$set(this.uav_manageList[i],'uavBeiqinLevelName',resp.data.level);
            })
          }
          else{
            this.uav_manageList[i].uavBeiqinLevelName="无";
          }
        }

        getUserProfile().then(response => {
          this.userName = response.data.nickName
        })
      });

      /** 获取无人机归口部门信息 */
      listUavdepartment(this.UserqueryParams).then(response => {
        this.departmentlist = response.rows;
      });

      /** 获取保管员管理列表 */
      listKeeper(this.UserqueryParams).then(response => {
        this.keeperList = response.rows;

      });

      /** 获取任务备勤等级 */
      listMissionlevel().then(response =>{
        this.missionLevelList = response.rows
      });

      /** 获取无人机类型 **/
      listUavtype(this.UserqueryParams).then(response =>{
        this.uavTypeList = response.rows;
        // console.log(response)
      });
    },

    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },

    // 表单重置
    reset() {
      this.form = {
        id: null,
        uavUnit: null,
        uavName: null,
        uavType: null,
        uavNumber: null,
        uavImages: null,
        uavSn: null,
        uavFlightNumber: null,
        uavBeiqinLevel: null,
        uavEnabled: null,
        uavInsurance: null,
        uavAssurance: null,
        uavMaintenance: null,
        uavKeeperId: null,
        uavPut: null,
        uavUsers: null,
        uavAttachment: null,
        deleteFlag: null
      };
      this.resetForm("form");
      this.resetForm("detailDic")
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
      this.title = "添加无人机信息管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids;
      getUav_manage(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改无人机信息管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(async valid => {
        if (valid) {
          //自动获取录入人姓名并提交
          this.form.uavUsers = this.userName;
          //更新
          if (this.form.id != null) {
            let response = await getUav_manageByNameAcc(this.form.uavName)
            //id不同
            let isDiffId = response.data && response.data.id != this.form.id

            if(isDiffId){this.$modal.msgError("命名错误")}
            else{
              await updateUav_manage(this.form)
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            }

          }
        //插入
        else {
            let res = await getUav_manageByName(this.form.uavName)
            let number = res.data + 1
            let name = await this.validNameGenerate(this.form.uavName, number, 0)

            if (name != null) {
              this.$set(this.form, "uavName", name)
              this.form.uavEnabled = 0;

              addUav_manage(this.form).then(response => {
                this.open = false;
                this.$modal.msgSuccess("新增成功");
                this.getList();
              });
            } else {
              this.$modal.msgError("命名失败！")
            }};
        }
    })},

    async validNameGenerate(name,number,protect){
      let result = name + "_" + number.toString()
      if(protect == 50){
        return null
      }
      //这里要加return
      return getUav_manageByNameAcc(name + "_" + number.toString()).then(resp => {
        if(resp.data){
          return this.validNameGenerate(name,number+1,protect+1)
        }
        else{
          return result
        }
      })

    },

    /** 删除按钮操作 */
    handleDelete(row) {
      const idk = row.uavFlightNumber;
      const ids = row.id || this.ids;
      console.log(this.form)
      let flag = false;

      this.$modal.confirm('是否确认删除数据？').then(async function() {
        //任务列表中是否有该驾驶员
        let confirm1 = await getMissionlistByUavNumber(idk);
        if(!confirm1.data){
          flag = true;
          return delUav_manage(ids);
        }
      }).then(() => {
        this.getList();
        if(flag) this.$modal.msgSuccess("删除成功");
        else{
          this.$modal.msgError("删除失败，请检查其他部分是否占用该记录！");
        }
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('uav/uav_manage/export', {
        ...this.queryParams
      },
      )
    },

    downloadFileForDetail(row){
      window.open(row);
    },

    downloadFile(row){
      window.open(row.uavAttachment)
    }

  },

};
</script>
