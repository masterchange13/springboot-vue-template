<template>
  <el-card class="page-container">
        <template #header>
            <div class="header">
                <span>用户管理</span>
                <div class="extra">
                    <el-button type="primary" @click="visibleDrawer = true">添加文章</el-button>
                </div>
            </div>
        </template>
        <!-- 搜索表单 -->
        <el-form inline v-model="userInfo">
            <el-form-item>
                <el-input placeholder="用户昵称" v-model="userInfo.nickname"></el-input>
            </el-form-item>
            <el-form-item>
                <el-input placeholder="用户名" v-model="userInfo.username"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="userListSearch">搜索</el-button>
                <el-button @click="categoryId = ''; state = ''">重置</el-button>
            </el-form-item>
        </el-form>
        <el-table :data="userList" style="width: 100%">
            <el-table-column label="id" width="200" prop="id"></el-table-column>
            <el-table-column label="姓名" width="200" prop="username"></el-table-column>
            <el-table-column label="昵称" prop="nickname"></el-table-column>
            <el-table-column label="注册时间" prop="createTime"> </el-table-column>
            <el-table-column label=" 邮箱" prop="eamil"></el-table-column>
            <el-table-column label="学校" prop="school"></el-table-column>
            <el-table-column label="操作" width="100">
                <template #default="{ row }">
                    <el-button :icon="Edit" circle plain type="primary"></el-button>
                    <el-button :icon="Delete" circle plain type="danger"></el-button>
                </template>
            </el-table-column>
            <!-- 分页条 -->
            <el-pagination v-model:current-page="pageNum" v-model:page-size="pageSize" :page-sizes="[3, 5, 10, 15]"
                layout="jumper, total, sizes, prev, pager, next" background :total="total" @size-change="onSizeChange"
                @current-change="onCurrentChange" style="margin-top: 20px; justify-content: flex-end" />

            
            <!-- <template #empty> -->
                <!-- <el-empty description="没有数据" /> -->
            <!-- </template> -->
        </el-table>


    </el-card>
</template>

<script setup>
    import { ref } from 'vue';
    import { getUserList } from '@/api/admin.js';

    const userList = ref(
        [
            {
                id: 1,
                username: '张三',
                nickname: '张三',
                createTime: '2022-01-01',
                eamil: '123@qq.com',
                school: '清华大学'
            },
            {
                id: 2,
                username: '李四',
                nickname: '李四',
                createTime: '2022-01-01',
                eamil: '123@qq.com',
                school: '北京大学'
            },
            {
                id: 3,
                username: 'zyq',
                nickname: 'zyq',
                createTime: '2022-01-01',
                eamil: '123@qq.com',
                school: '吉林大学'
            }
        ]
    )
    const row = ref(3)

    const userInfo = ref({
        nickname: '',
        username: '',
    })
    const userListSearch = async()=>{
        let result = await getUserList(userInfo.value);
        userList.value = result.data
    }
</script>

<style lang="scss" scoped>
.page-container {
    min-height: 100%;
    box-sizing: border-box;

    .header {
        display: flex;
        align-items: center;
        justify-content: space-between;
    }
}

/* 抽屉样式 */
.avatar-uploader {
    :deep() {
        .avatar {
            width: 178px;
            height: 178px;
            display: block;
        }

        .el-upload {
            border: 1px dashed var(--el-border-color);
            border-radius: 6px;
            cursor: pointer;
            position: relative;
            overflow: hidden;
            transition: var(--el-transition-duration-fast);
        }

        .el-upload:hover {
            border-color: var(--el-color-primary);
        }

        .el-icon.avatar-uploader-icon {
            font-size: 28px;
            color: #8c939d;
            width: 178px;
            height: 178px;
            text-align: center;
        }
    }
}

.editor {
    width: 100%;

    :deep(.ql-editor) {
        min-height: 200px;
    }
}
</style>