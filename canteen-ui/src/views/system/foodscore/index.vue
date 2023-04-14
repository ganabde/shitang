<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="菜品名称" prop="foodName">
        <el-input
          v-model="queryParams.foodName"
          placeholder="请输入菜品名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="店铺名称" prop="shopName">
        <el-input
          v-model="queryParams.shopName"
          placeholder="请输入店铺名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
<!--      <el-form-item label="菜色评分" prop="csScore">-->
<!--        <el-input-->
<!--          v-model="queryParams.csScore"-->
<!--          placeholder="请输入菜色评分"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="菜品评分" prop="cpScore">-->
<!--        <el-input-->
<!--          v-model="queryParams.cpScore"-->
<!--          placeholder="请输入菜品评分"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="价格评分" prop="jgScore">-->
<!--        <el-input-->
<!--          v-model="queryParams.jgScore"-->
<!--          placeholder="请输入价格评分"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
<!--      <el-form-item label="卫生评分" prop="wsScore">-->
<!--        <el-input-->
<!--          v-model="queryParams.wsScore"-->
<!--          placeholder="请输入卫生评分"-->
<!--          clearable-->
<!--          @keyup.enter.native="handleQuery"-->
<!--        />-->
<!--      </el-form-item>-->
      <el-form-item label="用户名称" prop="userName">
        <el-input
          v-model="queryParams.userName"
          placeholder="请输入用户名称"
          clearable
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
          v-hasPermi="['system:foodscore:add']"
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
          v-hasPermi="['system:foodscore:edit']"
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
          v-hasPermi="['system:foodscore:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['system:foodscore:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="foodscoreList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="ID" align="center" prop="id" />
      <el-table-column label="菜品名称" align="center" prop="foodName" />
      <el-table-column label="店铺名称" align="center" prop="shopName" />
      <el-table-column label="菜色评分" align="center" prop="csScore" />
      <el-table-column label="菜品评分" align="center" prop="cpScore" />
      <el-table-column label="价格评分" align="center" prop="jgScore" />
      <el-table-column label="卫生评分" align="center" prop="wsScore" />
      <el-table-column label="用户名称" align="center" prop="userName" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['system:foodscore:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['system:foodscore:remove']"
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

    <!-- 添加或修改菜品评分信息对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="菜品ID" prop="foodId">
          <el-input v-model="form.foodId" placeholder="请输入菜品ID" />
        </el-form-item>
        <el-form-item label="菜品名称" prop="foodName">
          <el-input v-model="form.foodName" placeholder="请输入菜品名称" />
        </el-form-item>
        <el-form-item label="店铺名称" prop="shopName">
          <el-input v-model="form.shopName" placeholder="请输入店铺名称" />
        </el-form-item>
        <el-form-item label="菜色评分" prop="csScore">
          <el-input v-model="form.csScore" placeholder="请输入菜色评分" />
        </el-form-item>
        <el-form-item label="菜品评分" prop="cpScore">
          <el-input v-model="form.cpScore" placeholder="请输入菜品评分" />
        </el-form-item>
        <el-form-item label="价格评分" prop="jgScore">
          <el-input v-model="form.jgScore" placeholder="请输入价格评分" />
        </el-form-item>
        <el-form-item label="卫生评分" prop="wsScore">
          <el-input v-model="form.wsScore" placeholder="请输入卫生评分" />
        </el-form-item>
        <el-form-item label="用户名称" prop="userName">
          <el-input v-model="form.userName" placeholder="请输入用户名称" />
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
import { listFoodscore, getFoodscore, delFoodscore, addFoodscore, updateFoodscore } from "@/api/system/foodscore";

export default {
  name: "Foodscore",
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
      // 菜品评分信息表格数据
      foodscoreList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        foodName: null,
        shopName: null,
        csScore: null,
        cpScore: null,
        jgScore: null,
        wsScore: null,
        userName: null
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
    /** 查询菜品评分信息列表 */
    getList() {
      this.loading = true;
      listFoodscore(this.queryParams).then(response => {
        this.foodscoreList = response.rows;
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
        ID: null,
        foodId: null,
        foodName: null,
        shopName: null,
        csScore: null,
        cpScore: null,
        jgScore: null,
        wsScore: null,
        userName: null
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
      this.ids = selection.map(item => item.ID)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加菜品评分信息";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const ID = row.ID || this.ids
      getFoodscore(ID).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改菜品评分信息";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.ID != null) {
            updateFoodscore(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addFoodscore(this.form).then(response => {
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
      const IDs = row.ID || this.ids;
      this.$modal.confirm('是否确认删除菜品评分信息编号为"' + IDs + '"的数据项？').then(function() {
        return delFoodscore(IDs);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('system/foodscore/export', {
        ...this.queryParams
      }, `foodscore_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
