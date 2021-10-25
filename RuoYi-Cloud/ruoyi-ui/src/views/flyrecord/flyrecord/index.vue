<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="起飞经度" prop="homeLongtitude">
        <el-input
          v-model="queryParams.homeLongtitude"
          placeholder="请输入起飞经度"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="起飞纬度" prop="homeLatittude">
        <el-input
          v-model="queryParams.homeLatittude"
          placeholder="请输入起飞纬度"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="飞行距离" prop="sumDistance">
        <el-input
          v-model="queryParams.sumDistance"
          placeholder="请输入飞行距离"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="终点经度" prop="endLongtitude">
        <el-input
          v-model="queryParams.endLongtitude"
          placeholder="请输入终点经度"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="飞行高度" prop="altitude">
        <el-input
          v-model="queryParams.altitude"
          placeholder="请输入飞行高度"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="水平飞行速度" prop="velocity">
        <el-input
          v-model="queryParams.velocity"
          placeholder="请输入水平飞行速度"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="垂直飞行速度" prop="verticalSpeed">
        <el-input
          v-model="queryParams.verticalSpeed"
          placeholder="请输入垂直飞行速度"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="任务回放" prop="taskReplay">
        <el-input
          v-model="queryParams.taskReplay"
          placeholder="请输入任务回放"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="记录附件" prop="flyDoc">
        <el-input
          v-model="queryParams.flyDoc"
          placeholder="请输入记录附件"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="飞行路线" prop="taskLine">
        <el-input
          v-model="queryParams.taskLine"
          placeholder="请输入飞行路线"
          clearable
          size="small"
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="飞行录像" prop="flyVideo">
        <el-input
          v-model="queryParams.flyVideo"
          placeholder="请输入飞行录像"
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
          v-hasPermi="['flyrecord:flyrecord:add']"
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
          v-hasPermi="['flyrecord:flyrecord:edit']"
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
          v-hasPermi="['flyrecord:flyrecord:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['flyrecord:flyrecord:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="flyrecordList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="飞行记录" align="center" prop="id" />
<!--      <el-table-column label="任务ID" align="center" prop="taskId" />-->
      <el-table-column label="起飞经度" align="center" prop="homeLongtitude" />
      <el-table-column label="起飞纬度" align="center" prop="homeLatittude" />
      <el-table-column label="飞行距离" align="center" prop="sumDistance" />
      <el-table-column label="终点经度" align="center" prop="endLongtitude" />
      <el-table-column label="飞行高度" align="center" prop="altitude" />
      <el-table-column label="水平飞行速度" align="center" prop="velocity" />
      <el-table-column label="垂直飞行速度" align="center" prop="verticalSpeed" />
      <el-table-column label="任务回放" align="center" prop="taskReplay" />
      <el-table-column label="记录附件" align="center" prop="flyDoc" />
      <el-table-column label="飞行路线" align="center" prop="taskLine" />
      <el-table-column label="飞行录像" align="center" prop="flyVideo" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['flyrecord:flyrecord:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['flyrecord:flyrecord:remove']"
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

    <!-- 添加或修改飞行记录对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="起飞经度" prop="homeLongtitude">
          <el-input v-model="form.homeLongtitude" placeholder="请输入起飞经度" />
        </el-form-item>
        <el-form-item label="起飞纬度" prop="homeLatittude">
          <el-input v-model="form.homeLatittude" placeholder="请输入起飞纬度" />
        </el-form-item>
        <el-form-item label="飞行距离" prop="sumDistance">
          <el-input v-model="form.sumDistance" placeholder="请输入飞行距离" />
        </el-form-item>
        <el-form-item label="终点经度" prop="endLongtitude">
          <el-input v-model="form.endLongtitude" placeholder="请输入终点经度" />
        </el-form-item>
        <el-form-item label="飞行高度" prop="altitude">
          <el-input v-model="form.altitude" placeholder="请输入飞行高度" />
        </el-form-item>
        <el-form-item label="水平飞行速度" prop="velocity">
          <el-input v-model="form.velocity" placeholder="请输入水平飞行速度" />
        </el-form-item>
        <el-form-item label="垂直飞行速度" prop="verticalSpeed">
          <el-input v-model="form.verticalSpeed" placeholder="请输入垂直飞行速度" />
        </el-form-item>
        <el-form-item label="任务回放" prop="taskReplay">
          <el-input v-model="form.taskReplay" placeholder="请输入任务回放" />
        </el-form-item>
        <el-form-item label="记录附件" prop="flyDoc">
          <el-input v-model="form.flyDoc" placeholder="请输入记录附件" />
        </el-form-item>
        <el-form-item label="飞行路线" prop="taskLine">
          <el-input v-model="form.taskLine" placeholder="请输入飞行路线" />
        </el-form-item>
        <el-form-item label="飞行录像" prop="flyVideo">
          <el-input v-model="form.flyVideo" placeholder="请输入飞行录像" />
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
import { listFlyrecord, getFlyrecord, delFlyrecord, addFlyrecord, updateFlyrecord } from "@/api/flyrecord/flyrecord";

export default {
  name: "Flyrecord",
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
      // 飞行记录表格数据
      flyrecordList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        homeLongtitude: null,
        homeLatittude: null,
        sumDistance: null,
        endLongtitude: null,
        altitude: null,
        velocity: null,
        verticalSpeed: null,
        taskReplay: null,
        flyDoc: null,
        taskLine: null,
        flyVideo: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询飞行记录列表 */
    getList() {
      this.loading = true;
      listFlyrecord(this.queryParams).then(response => {
        this.flyrecordList = response.rows;
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
        taskId: null,
        homeLongtitude: null,
        homeLatittude: null,
        sumDistance: null,
        endLongtitude: null,
        altitude: null,
        velocity: null,
        verticalSpeed: null,
        taskReplay: null,
        flyDoc: null,
        taskLine: null,
        flyVideo: null
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
      this.title = "添加飞行记录";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getFlyrecord(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改飞行记录";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateFlyrecord(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFlyrecord(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除飞行记录编号为"' + ids + '"的数据项？').then(function() {
        return delFlyrecord(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('flyrecord/flyrecord/export', {
        ...this.queryParams
      }, `flyrecord_flyrecord.xlsx`)
    }
  }
};
</script>
