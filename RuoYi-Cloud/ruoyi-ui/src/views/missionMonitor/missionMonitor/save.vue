<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="无人机归口部门" prop="uavUnit">
        <el-select v-model="queryParams.uavUnit" placeholder="请选择无人机归口部门" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_uav_department"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="无人机命名" prop="uavName">
        <el-input
          v-model="queryParams.uavName"
          placeholder="请输入无人机命名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="无人机类型" prop="uavType">
        <el-select v-model="queryParams.uavType" placeholder="请选择无人机类型" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_pilots_craft_sort"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="无人机产品型号" prop="uavNumber">
        <el-input
          v-model="queryParams.uavNumber"
          placeholder="请输入无人机产品型号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="无人机图片" prop="uavImages">
        <el-input
          v-model="queryParams.uavImages"
          placeholder="请输入无人机图片"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="无人机序列号" prop="uavSn">
        <el-input
          v-model="queryParams.uavSn"
          placeholder="请输入无人机序列号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="无人机飞控编号" prop="uavFlightNumber">
        <el-input
          v-model="queryParams.uavFlightNumber"
          placeholder="请输入无人机飞控编号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="无人机备勤等级" prop="uavBeiqinLevel">
        <el-select v-model="queryParams.uavBeiqinLevel" placeholder="请选择无人机备勤等级" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_uav_readylevel"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="无人机启用状态" prop="uavEnabled">
        <el-select v-model="queryParams.uavEnabled" placeholder="请选择无人机启用状态" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_uav_state"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="无人机保险到期时间" prop="uavInsurance">
        <el-date-picker clearable size="small"
                        v-model="queryParams.uavInsurance"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择无人机保险到期时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="无人机质保到期时间" prop="uavAssurance">
        <el-date-picker clearable size="small"
                        v-model="queryParams.uavAssurance"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择无人机质保到期时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="无人机保养到期时间" prop="uavMaintenance">
        <el-date-picker clearable size="small"
                        v-model="queryParams.uavMaintenance"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择无人机保养到期时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="无人机保管员id" prop="uavKeeperId">
        <el-select v-model="queryParams.uavKeeperId" placeholder="请选择无人机保管员id" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="无人机入库时间" prop="uavPut">
        <el-date-picker clearable size="small"
                        v-model="queryParams.uavPut"
                        type="date"
                        value-format="yyyy-MM-dd"
                        placeholder="选择无人机入库时间">
        </el-date-picker>
      </el-form-item>
      <el-form-item label="无人机录入人" prop="uavUsers">
        <el-input
          v-model="queryParams.uavUsers"
          placeholder="请输入无人机录入人"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="无人机相关附件" prop="uavAttachment">
        <el-input
          v-model="queryParams.uavAttachment"
          placeholder="请输入无人机相关附件"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="删除码" prop="deleteFlag">
        <el-input
          v-model="queryParams.deleteFlag"
          placeholder="请输入删除码"
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
          v-hasPermi="['missionMonitor:missionMonitor:add']"
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
          v-hasPermi="['missionMonitor:missionMonitor:edit']"
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
          v-hasPermi="['missionMonitor:missionMonitor:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['missionMonitor:missionMonitor:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="missionMonitorList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="自增主键" align="center" prop="id" />
      <el-table-column label="无人机归口部门" align="center" prop="uavUnit">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_uav_department" :value="scope.row.uavUnit"/>
        </template>
      </el-table-column>
      <el-table-column label="无人机命名" align="center" prop="uavName" />
      <el-table-column label="无人机类型" align="center" prop="uavType">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_pilots_craft_sort" :value="scope.row.uavType"/>
        </template>
      </el-table-column>
      <el-table-column label="无人机产品型号" align="center" prop="uavNumber" />
      <el-table-column label="无人机图片" align="center" prop="uavImages" />
      <el-table-column label="无人机序列号" align="center" prop="uavSn" />
      <el-table-column label="无人机飞控编号" align="center" prop="uavFlightNumber" />
      <el-table-column label="无人机备勤等级" align="center" prop="uavBeiqinLevel">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_uav_readylevel" :value="scope.row.uavBeiqinLevel"/>
        </template>
      </el-table-column>
      <el-table-column label="无人机启用状态" align="center" prop="uavEnabled">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_uav_state" :value="scope.row.uavEnabled"/>
        </template>
      </el-table-column>
      <el-table-column label="无人机保险到期时间" align="center" prop="uavInsurance" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.uavInsurance, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="无人机质保到期时间" align="center" prop="uavAssurance" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.uavAssurance, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="无人机保养到期时间" align="center" prop="uavMaintenance" width="180">
        <template slot-scope="scope">
          <span>{{ parseTime(scope.row.uavMaintenance, '{y}-{m}-{d}') }}</span>
        </template>
      </el-table-column>
      <el-table-column label="无人机保管员id" align="center" prop="uavKeeperId" />
      <el-table-column label="无人机录入人" align="center" prop="uavUsers" />
      <el-table-column label="无人机相关附件" align="center" prop="uavAttachment" />
      <el-table-column label="删除码" align="center" prop="deleteFlag" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['missionMonitor:missionMonitor:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['missionMonitor:missionMonitor:remove']"
          >删除</el-button>
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

    <!-- 添加或修改无人机信息管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="无人机归口部门" prop="uavUnit">
          <el-select v-model="form.uavUnit" placeholder="请选择无人机归口部门">
            <el-option
              v-for="dict in dict.type.sys_uav_department"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="无人机命名" prop="uavName">
          <el-input v-model="form.uavName" placeholder="请输入无人机命名" />
        </el-form-item>
        <el-form-item label="无人机类型" prop="uavType">
          <el-select v-model="form.uavType" placeholder="请选择无人机类型">
            <el-option
              v-for="dict in dict.type.sys_pilots_craft_sort"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="无人机产品型号" prop="uavNumber">
          <el-input v-model="form.uavNumber" placeholder="请输入无人机产品型号" />
        </el-form-item>
        <el-form-item label="无人机图片" prop="uavImages">
          <el-input v-model="form.uavImages" placeholder="请输入无人机图片" />
        </el-form-item>
        <el-form-item label="无人机序列号" prop="uavSn">
          <el-input v-model="form.uavSn" placeholder="请输入无人机序列号" />
        </el-form-item>
        <el-form-item label="无人机飞控编号" prop="uavFlightNumber">
          <el-input v-model="form.uavFlightNumber" placeholder="请输入无人机飞控编号" />
        </el-form-item>
        <el-form-item label="无人机备勤等级" prop="uavBeiqinLevel">
          <el-select v-model="form.uavBeiqinLevel" placeholder="请选择无人机备勤等级">
            <el-option
              v-for="dict in dict.type.sys_uav_readylevel"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="无人机启用状态" prop="uavEnabled">
          <el-select v-model="form.uavEnabled" placeholder="请选择无人机启用状态">
            <el-option
              v-for="dict in dict.type.sys_uav_state"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
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
        <el-form-item label="无人机保管员id">
          <el-radio-group v-model="form.uavKeeperId">
            <el-radio label="1">请选择字典生成</el-radio>
          </el-radio-group>
        </el-form-item>
        <el-form-item label="无人机入库时间" prop="uavPut">
          <el-date-picker clearable size="small"
                          v-model="form.uavPut"
                          type="date"
                          value-format="yyyy-MM-dd"
                          placeholder="选择无人机入库时间">
          </el-date-picker>
        </el-form-item>
        <el-form-item label="无人机录入人" prop="uavUsers">
          <el-input v-model="form.uavUsers" placeholder="请输入无人机录入人" />
        </el-form-item>
        <el-form-item label="无人机相关附件" prop="uavAttachment">
          <el-input v-model="form.uavAttachment" placeholder="请输入无人机相关附件" />
        </el-form-item>
        <el-form-item label="删除码" prop="deleteFlag">
          <el-input v-model="form.deleteFlag" placeholder="请输入删除码" />
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
import { listMissionMonitor, getMissionMonitor, delMissionMonitor, addMissionMonitor, updateMissionMonitor } from "@/api/missionMonitor/missionMonitor";

export default {
  name: "MissionMonitor",
  dicts: ['sys_uav_department', 'sys_pilots_craft_sort', 'sys_uav_readylevel', 'sys_uav_state'],
  data() {
    return {
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
      missionMonitorList: [],
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
          { required: true, message: "无人机图片不能为空", trigger: "blur" }
        ],
        uavSn: [
          { required: true, message: "无人机序列号不能为空", trigger: "blur" }
        ],
        uavFlightNumber: [
          { required: true, message: "无人机飞控编号不能为空", trigger: "blur" }
        ],
        uavEnabled: [
          { required: true, message: "无人机启用状态不能为空", trigger: "change" }
        ],
        uavUsers: [
          { required: true, message: "无人机录入人不能为空", trigger: "blur" }
        ],
        deleteFlag: [
          { required: true, message: "删除码不能为空", trigger: "blur" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询无人机信息管理列表 */
    getList() {
      this.loading = true;
      listMissionMonitor(this.queryParams).then(response => {
        this.missionMonitorList = response.rows;
        this.total = response.total;
        this.loading = false;
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
        uavKeeperId: 0,
        uavPut: null,
        uavUsers: null,
        uavAttachment: null,
        deleteFlag: null
      };
      this.resetForm("form");
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
      const id = row.id || this.ids
      getMissionMonitor(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改无人机信息管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMissionMonitor(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMissionMonitor(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除无人机信息管理编号为"' + ids + '"的数据项？').then(function() {
        return delMissionMonitor(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('missionMonitor/missionMonitor/export', {
        ...this.queryParams
      }, `missionMonitor_missionMonitor.xlsx`)
    }
  }
};
</script>
