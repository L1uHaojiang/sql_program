<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryRef" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="教室名称" prop="name">
        <el-input
          v-model="queryParams.name"
          placeholder="请输入教室名称"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="教室容量" prop="capacity">
        <el-input
          v-model="queryParams.capacity"
          placeholder="请输入教室容量"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所在教学楼" prop="building">
        <el-input
          v-model="queryParams.building"
          placeholder="请输入所在教学楼"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="楼层" prop="floor">
        <el-input
          v-model="queryParams.floor"
          placeholder="请输入楼层"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="教室设备" prop="equipment">
        <el-input
          v-model="queryParams.equipment"
          placeholder="请输入教室设备"
          clearable
          @keyup.enter="handleQuery"
        />
      </el-form-item>
      <el-form-item label="教室状态" prop="status">
        <el-select v-model="queryParams.status" placeholder="请选择教室状态" clearable>
          <el-option
            v-for="dict in sys_job_status"
            :key="dict.value"
            :label="dict.label"
            :value="dict.value"
          />
        </el-select>
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="Search" @click="handleQuery">搜索</el-button>
        <el-button icon="Refresh" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="Plus"
          @click="handleAdd"
          v-hasPermi="['manage:classrooms:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="Edit"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['manage:classrooms:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="Delete"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['manage:classrooms:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="Download"
          @click="handleExport"
          v-hasPermi="['manage:classrooms:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar v-model:showSearch="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="classroomsList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="教室ID" align="center" prop="id" />
      <el-table-column label="教室名称" align="center" prop="name" />
      <el-table-column label="教室容量" align="center" prop="capacity" />
      <el-table-column label="所在教学楼" align="center" prop="building" />
      <el-table-column label="楼层" align="center" prop="floor" />
      <el-table-column label="教室设备" align="center" prop="equipment" />
      <el-table-column label="教室状态" align="center" prop="status">
        <template #default="scope">
          <dict-tag :options="sys_job_status" :value="scope.row.status"/>
        </template>
      </el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template #default="scope">
          <el-button link type="primary" icon="Edit" @click="handleUpdate(scope.row)" v-hasPermi="['manage:classrooms:edit']">修改</el-button>
          <el-button link type="primary" icon="Delete" @click="handleDelete(scope.row)" v-hasPermi="['manage:classrooms:remove']">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      v-model:page="queryParams.pageNum"
      v-model:limit="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改教室信息对话框 -->
    <el-dialog :title="title" v-model="open" width="500px" append-to-body>
      <el-form ref="classroomsRef" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="教室名称" prop="name">
          <el-input v-model="form.name" placeholder="请输入教室名称" />
        </el-form-item>
        <el-form-item label="教室容量" prop="capacity">
          <el-input v-model="form.capacity" placeholder="请输入教室容量" />
        </el-form-item>
        <el-form-item label="所在教学楼" prop="building">
          <el-input v-model="form.building" placeholder="请输入所在教学楼" />
        </el-form-item>
        <el-form-item label="楼层" prop="floor">
          <el-input v-model="form.floor" placeholder="请输入楼层" />
        </el-form-item>
        <el-form-item label="教室设备" prop="equipment">
          <el-input v-model="form.equipment" placeholder="请输入教室设备" />
        </el-form-item>
        <el-form-item label="教室状态" prop="status">
          <el-radio-group v-model="form.status">
            <el-radio
              v-for="dict in sys_job_status"
              :key="dict.value"
              :label="dict.value"
            >{{dict.label}}</el-radio>
          </el-radio-group>
        </el-form-item>
      </el-form>
      <template #footer>
        <div class="dialog-footer">
          <el-button type="primary" @click="submitForm">确 定</el-button>
          <el-button @click="cancel">取 消</el-button>
        </div>
      </template>
    </el-dialog>
  </div>
</template>

<script setup name="Classrooms">
import { listClassrooms, getClassrooms, delClassrooms, addClassrooms, updateClassrooms } from "@/api/manage/classrooms";

const { proxy } = getCurrentInstance();
const { sys_job_status } = proxy.useDict('sys_job_status');

const classroomsList = ref([]);
const open = ref(false);
const loading = ref(true);
const showSearch = ref(true);
const ids = ref([]);
const single = ref(true);
const multiple = ref(true);
const total = ref(0);
const title = ref("");

const data = reactive({
  form: {},
  queryParams: {
    pageNum: 1,
    pageSize: 10,
    name: null,
    capacity: null,
    building: null,
    floor: null,
    equipment: null,
    status: null
  },
  rules: {
    name: [
      { required: true, message: "教室名称不能为空", trigger: "blur" }
    ],
    capacity: [
      { required: true, message: "教室容量不能为空", trigger: "blur" }
    ],
    building: [
      { required: true, message: "所在教学楼不能为空", trigger: "blur" }
    ],
    floor: [
      { required: true, message: "楼层不能为空", trigger: "blur" }
    ],
  }
});

const { queryParams, form, rules } = toRefs(data);

/** 查询教室信息列表 */
function getList() {
  loading.value = true;
  listClassrooms(queryParams.value).then(response => {
    classroomsList.value = response.rows;
    total.value = response.total;
    loading.value = false;
  });
}

// 取消按钮
function cancel() {
  open.value = false;
  reset();
}

// 表单重置
function reset() {
  form.value = {
    id: null,
    name: null,
    capacity: null,
    building: null,
    floor: null,
    equipment: null,
    status: null
  };
  proxy.resetForm("classroomsRef");
}

/** 搜索按钮操作 */
function handleQuery() {
  queryParams.value.pageNum = 1;
  getList();
}

/** 重置按钮操作 */
function resetQuery() {
  proxy.resetForm("queryRef");
  handleQuery();
}

// 多选框选中数据
function handleSelectionChange(selection) {
  ids.value = selection.map(item => item.id);
  single.value = selection.length != 1;
  multiple.value = !selection.length;
}

/** 新增按钮操作 */
function handleAdd() {
  reset();
  open.value = true;
  title.value = "添加教室信息";
}

/** 修改按钮操作 */
function handleUpdate(row) {
  reset();
  const _id = row.id || ids.value
  getClassrooms(_id).then(response => {
    form.value = response.data;
    open.value = true;
    title.value = "修改教室信息";
  });
}

/** 提交按钮 */
function submitForm() {
  proxy.$refs["classroomsRef"].validate(valid => {
    if (valid) {
      if (form.value.id != null) {
        updateClassrooms(form.value).then(response => {
          proxy.$modal.msgSuccess("修改成功");
          open.value = false;
          getList();
        });
      } else {
        addClassrooms(form.value).then(response => {
          proxy.$modal.msgSuccess("新增成功");
          open.value = false;
          getList();
        });
      }
    }
  });
}

/** 删除按钮操作 */
function handleDelete(row) {
  const _ids = row.id || ids.value;
  proxy.$modal.confirm('是否确认删除教室信息编号为"' + _ids + '"的数据项？').then(function() {
    return delClassrooms(_ids);
  }).then(() => {
    getList();
    proxy.$modal.msgSuccess("删除成功");
  }).catch(() => {});
}

/** 导出按钮操作 */
function handleExport() {
  proxy.download('manage/classrooms/export', {
    ...queryParams.value
  }, `classrooms_${new Date().getTime()}.xlsx`)
}

getList();
</script>
