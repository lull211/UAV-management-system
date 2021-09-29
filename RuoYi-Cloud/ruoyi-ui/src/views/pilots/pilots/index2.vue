<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="驾驶员姓名" prop="driverName">
        <el-input
          v-model="queryParams.driverName"
          placeholder="请输入驾驶员姓名"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="驾驶员单位" prop="driverDepartment">
        <el-select v-model="queryParams.driverDepartment" placeholder="请选择驾驶员单位" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_pilots_department"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="驾驶员身份证号" prop="driverIdcard">
        <el-input
          v-model="queryParams.driverIdcard"
          placeholder="请输入驾驶员身份证号"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
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
      <el-form-item label="驾驶员状态" prop="driverState">
        <el-select v-model="queryParams.driverState" placeholder="请选择驾驶员状态" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_pilots_state"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="驾驶员照片" prop="driverPhoto">
        <el-input
          v-model="queryParams.driverPhoto"
          placeholder="请输入驾驶员照片"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="驾驶员附件" prop="driverExtral">
        <el-input
          v-model="queryParams.driverExtral"
          placeholder="请输入驾驶员附件"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="驾驶员训练时间" prop="trainingTime">
        <el-input
          v-model="queryParams.trainingTime"
          placeholder="请输入驾驶员训练时间"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="驾驶员飞行时间" prop="flyingTime">
        <el-input
          v-model="queryParams.flyingTime"
          placeholder="请输入驾驶员飞行时间"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="驾驶员总时间" prop="sumTime">
        <el-input
          v-model="queryParams.sumTime"
          placeholder="请输入驾驶员总时间"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="删除码" prop="deleteFlag">
        <el-select v-model="queryParams.deleteFlag" placeholder="请选择删除码" clearable size="small">
          <el-option label="请选择字典生成" value="" />
        </el-select>
      </el-form-item>
      <el-form-item label="驾驶员性别" prop="driverGender">
        <el-select v-model="queryParams.driverGender" placeholder="请选择驾驶员性别" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_pilots_gender"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item label="驾驶员准驾机型" prop="driverAircraftSoft">
        <el-select v-model="queryParams.driverAircraftSoft" multiple placeholder="请选择驾驶员准驾机型" clearable size="small">
          <el-option
            v-for="dict in dict.type.sys_pilots_craft_sort"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>

<!--      <el-form-item label="多选框组" prop="driverAircraftSoft">-->
<!--        <el-checkbox-group v-model="formData.field104" size="medium">-->
<!--          <el-checkbox v-for="(item, index) in field104Options" :key="index" :label="item.value"-->
<!--                       :disabled="item.disabled">{{item.label}}</el-checkbox>-->
<!--        </el-checkbox-group>-->
<!--      </el-form-item>-->

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
          v-hasPermi="['pilots:pilots:add']"
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
          v-hasPermi="['pilots:pilots:edit']"
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
          v-hasPermi="['pilots:pilots:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['pilots:pilots:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="pilotsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="自增主键" align="center" prop="id" />
      <el-table-column label="驾驶员姓名" align="center" prop="driverName" />
      <el-table-column label="驾驶员单位" align="center" prop="driverDepartment">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_pilots_department" :value="scope.row.driverDepartment"/>
        </template>
      </el-table-column>
      <el-table-column label="驾驶员身份证号" align="center" prop="driverIdcard" />
      <el-table-column label="驾驶员手机号码" align="center" prop="driverPhone" />
      <el-table-column label="驾驶员准驾机型" align="center" prop="driverAircraftSoft">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_pilots_craft_sort" :value="scope.row.driverAircraftSoft"/>
        </template>
      </el-table-column>
      <el-table-column label="驾驶员状态" align="center" prop="driverState">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_pilots_state" :value="scope.row.driverState"/>
        </template>
      </el-table-column>
      <el-table-column label="驾驶员照片" align="center" prop="driverPhoto" />
      <el-table-column label="驾驶员附件" align="center" prop="driverExtral" />
      <el-table-column label="驾驶员训练时间" align="center" prop="trainingTime" />
      <el-table-column label="驾驶员飞行时间" align="center" prop="flyingTime" />
      <el-table-column label="驾驶员总时间" align="center" prop="sumTime" />
      <el-table-column label="删除码" align="center" prop="deleteFlag" />
      <el-table-column label="驾驶员性别" align="center" prop="driverGender">
        <template slot-scope="scope">
          <dict-tag :options="dict.type.sys_pilots_gender" :value="scope.row.driverGender"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['pilots:pilots:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['pilots:pilots:remove']"
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

    <!-- 添加或修改驾驶员管理对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="驾驶员姓名" prop="driverName">
          <el-input v-model="form.driverName" placeholder="请输入驾驶员姓名" />
        </el-form-item>
        <el-form-item label="驾驶员单位" prop="driverDepartment">
          <el-select v-model="form.driverDepartment" placeholder="请选择驾驶员单位">
            <el-option
              v-for="dict in dict.type.sys_pilots_department"
              :key="dict.value"
              :label="dict.label"
              :value="dict.value"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="驾驶员身份证号" prop="driverIdcard">
          <el-input v-model="form.driverIdcard" placeholder="请输入驾驶员身份证号" />
        </el-form-item>
        <el-form-item label="驾驶员手机号码" prop="driverPhone">
          <el-input v-model="form.driverPhone" placeholder="请输入驾驶员手机号码" />
        </el-form-item>
        <el-form-item label="驾驶员准驾机型">
          <el-checkbox-group v-model="form.driverAircraftSoft">
            <el-checkbox
              v-for="dict in dict.type.sys_pilots_craft_sort"
              :key="dict.value"
              :label="dict.value">
              {{dict.label}}
            </el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="驾驶员状态" prop="driverState">
          <el-select v-model="form.driverState" placeholder="请选择驾驶员状态">
            <el-option
              v-for="dict in dict.type.sys_pilots_state"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="驾驶员照片" prop="driverPhoto">
          <el-input v-model="form.driverPhoto" placeholder="请输入驾驶员照片" />
        </el-form-item>
        <el-form-item label="驾驶员附件" prop="driverExtral">
          <el-input v-model="form.driverExtral" placeholder="请输入驾驶员附件" />
        </el-form-item>
        <el-form-item label="驾驶员训练时间" prop="trainingTime">
          <el-input v-model="form.trainingTime" placeholder="请输入驾驶员训练时间" />
        </el-form-item>
        <el-form-item label="驾驶员飞行时间" prop="flyingTime">
          <el-input v-model="form.flyingTime" placeholder="请输入驾驶员飞行时间" />
        </el-form-item>
        <el-form-item label="驾驶员总时间" prop="sumTime">
          <el-input v-model="form.sumTime" placeholder="请输入驾驶员总时间" />
        </el-form-item>
        <el-form-item label="删除码" prop="deleteFlag">
          <el-select v-model="form.deleteFlag" placeholder="请选择删除码">
            <el-option label="请选择字典生成" value="" />
          </el-select>
        </el-form-item>
        <el-form-item label="驾驶员性别" prop="driverGender">
          <el-select v-model="form.driverGender" placeholder="请选择驾驶员性别">
            <el-option
              v-for="dict in dict.type.sys_pilots_gender"
              :key="dict.value"
              :label="dict.label"
              :value="parseInt(dict.value)"
            ></el-option>
          </el-select>
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
import { listPilots, getPilots, delPilots, addPilots, updatePilots } from "@/api/pilots/pilots";

export default {
  name: "Pilots",
  dicts: ['sys_pilots_department', 'sys_pilots_state', 'sys_pilots_gender', 'sys_pilots_craft_sort'],
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
      // 驾驶员管理表格数据
      pilotsList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        driverName: null,
        driverDepartment: null,
        driverIdcard: null,
        driverPhone: null,
        driverAircraftSoft: null,
        driverState: null,
        driverPhoto: null,
        driverExtral: null,
        trainingTime: null,
        flyingTime: null,
        sumTime: null,
        deleteFlag: null,
        driverGender: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        driverName: [
          { required: true, message: "驾驶员姓名不能为空", trigger: "blur" }
        ],
        driverDepartment: [
          { required: true, message: "驾驶员单位不能为空", trigger: "change" }
        ],
        driverPhone: [
          { required: true, message: "驾驶员手机号码不能为空", trigger: "blur" }
        ],
        driverAircraftSoft: [
          { required: true, message: "驾驶员准驾机型不能为空", trigger: "blur" }
        ],
        sumTime: [
          { required: true, message: "驾驶员总时间不能为空", trigger: "blur" }
        ],
        deleteFlag: [
          { required: true, message: "删除码不能为空", trigger: "change" }
        ],
        driverGender: [
          { required: true, message: "驾驶员性别不能为空", trigger: "change" }
        ]
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询驾驶员管理列表 */
    getList() {
      this.loading = true;
      listPilots(this.queryParams).then(response => {
        this.pilotsList = response.rows;
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
        driverName: null,
        driverDepartment: null,
        driverIdcard: null,
        driverPhone: null,
        driverAircraftSoft: [],
        driverState: null,
        driverPhoto: null,
        driverExtral: null,
        trainingTime: null,
        flyingTime: null,
        sumTime: null,
        createTime: null,
        deleteFlag: null,
        driverGender: null
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
      this.title = "添加驾驶员管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getPilots(id).then(response => {
        this.form = response.data;
        this.form.driverAircraftSoft = this.form.driverAircraftSoft.split(",");
        this.open = true;
        this.title = "修改驾驶员管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          this.form.driverAircraftSoft = this.form.driverAircraftSoft.join(",");
          if (this.form.id != null) {
            updatePilots(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addPilots(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除驾驶员管理编号为"' + ids + '"的数据项？').then(function() {
        return delPilots(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('pilots/pilots/export', {
        ...this.queryParams
      }, `pilots_pilots.xlsx`)
    }
  }
};
</script>
