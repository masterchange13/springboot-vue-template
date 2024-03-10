<!-- src/App.vue -->

<template>
  <div id="app">
    <el-container class="layout-container">
      <el-aside width="200px">
        <div class="el-aside__logo"></div>
        <!-- 侧边栏内容 -->
        <el-menu
          active-text-color="#ffd04b"
          background-color="#232323"
          text-color="#fff"
          router
        >
          <el-menu-item index="/article/category">
            <el-icon>
              <Management />
            </el-icon>
            <span>招聘启事</span>
          </el-menu-item>
          <el-menu-item index="/master/category">
            <el-icon>
              <Promotion />
            </el-icon>
            <span>用户管理</span>
          </el-menu-item>
          <el-sub-menu>
            <template #title>
              <el-icon>
                <UserFilled />
              </el-icon>
              <span>个人中心</span>
            </template>
            <el-menu-item index="/user/info">
              <el-icon>
                <User />
              </el-icon>
              <span>基本资料</span>
            </el-menu-item>
            <el-menu-item index="/user/avatar">
              <el-icon>
                <Crop />
              </el-icon>
              <span>更换头像</span>
            </el-menu-item>
            <el-menu-item index="/user/resetPassword">
              <el-icon>
                <EditPen />
              </el-icon>
              <span>重置密码</span>
            </el-menu-item>
          </el-sub-menu>
          <el-menu-item index="/article/manage">
                    <el-icon>
                        <Promotion />
                    </el-icon>
                    <span>GitHub</span>
                </el-menu-item>
        </el-menu>
      </el-aside>

      <el-container>
        <el-header>
          <div>
            welcome：<strong>{{ nickname }}</strong>
          </div>
          <!-- 下拉菜单 -->
          <!-- command: 条目被点击后会触发,在事件函数上可以声明一个参数,接收条目对应的指令 -->
        </el-header>

        <el-main>
          <!-- 内容区域 -->
          <router-view></router-view>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
  
<script setup>
import {
  Management,
  Promotion,
  UserFilled,
  User,
  Crop,
  EditPen,
  SwitchButton,
  CaretBottom,
} from "@element-plus/icons-vue";
import avatar from "@/assets/default.png";
import { ref } from "vue";

const nickname = ref("mao");
</script>
  
<style lang="scss" scoped>
/* 根据实际需求添加样式 */
.layout-container {
  height: 100vh;

  .el-aside {
    background-color: #232323;

    &__logo {
      height: 120px;
      background: url("@/assets/zichso3.jpg") no-repeat center / 120px auto;
    }

    .el-menu {
      border-right: none;
    }
  }

  .el-header {
    background-color: #fff;
    display: flex;
    align-items: center;
    justify-content: space-between;

    .el-dropdown__box {
      display: flex;
      align-items: center;

      .el-icon {
        color: #999;
        margin-left: 10px;
      }

      &:active,
      &:focus {
        outline: none;
      }
    }
  }

  .el-footer {
    display: flex;
    align-items: center;
    justify-content: center;
    font-size: 14px;
    color: #666;
  }
}
</style>
  