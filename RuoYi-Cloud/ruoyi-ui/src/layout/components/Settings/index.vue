<template>
  <div class="drawer-container">
    <div>
      <div class="setting-drawer-content">
        <div class="setting-drawer-title">
          <h3 class="drawer-title">主题风格设置</h3>
        </div>
        <div class="setting-drawer-block-checbox">
          <div class="setting-drawer-block-checbox-item" @click="handleTheme('theme-dark')">
            <img src="@/assets/images/dark.svg" alt="dark">
            <div v-if="sideTheme === 'theme-dark'" class="setting-drawer-block-checbox-selectIcon" style="display: block;">
              <i aria-label="图标: check" class="anticon anticon-check">
                <svg viewBox="64 64 896 896" data-icon="check" width="1em" height="1em" :fill="theme" aria-hidden="true"
                     focusable="false" class="">
                  <path
                    d="M912 190h-69.9c-9.8 0-19.1 4.5-25.1 12.2L404.7 724.5 207 474a32 32 0 0 0-25.1-12.2H112c-6.7 0-10.4 7.7-6.3 12.9l273.9 347c12.8 16.2 37.4 16.2 50.3 0l488.4-618.9c4.1-5.1.4-12.8-6.3-12.8z"/>
                </svg>
              </i>
            </div>
          </div>
          <div class="setting-drawer-block-checbox-item" @click="handleTheme('theme-light')">
            <img src="@/assets/images/light.svg" alt="light">
            <div v-if="sideTheme === 'theme-light'" class="setting-drawer-block-checbox-selectIcon" style="display: block;">
              <i aria-label="图标: check" class="anticon anticon-check">
                <svg viewBox="64 64 896 896" data-icon="check" width="1em" height="1em" :fill="theme" aria-hidden="true"
                     focusable="false" class="">
                  <path
                    d="M912 190h-69.9c-9.8 0-19.1 4.5-25.1 12.2L404.7 724.5 207 474a32 32 0 0 0-25.1-12.2H112c-6.7 0-10.4 7.7-6.3 12.9l273.9 347c12.8 16.2 37.4 16.2 50.3 0l488.4-618.9c4.1-5.1.4-12.8-6.3-12.8z"/>
                </svg>
              </i>
            </div>
          </div>
        </div>

        <div class="drawer-item">
          <span>主题颜色</span>
          <theme-picker style="float: right;height: 26px;margin: -3px 8px 0 0;" @change="themeChange" />
        </div>
      </div>

      <el-divider/>

      <h3 class="drawer-title">系统布局配置</h3>

      <div class="drawer-item">
        <span>开启 TopNav</span>
        <el-switch v-model="topNav" class="drawer-switch" />
      </div>

      <div class="drawer-item">
        <span>开启 Tags-Views</span>
        <el-switch v-model="tagsView" class="drawer-switch" />
      </div>

      <div class="drawer-item">
        <span>固定 Header</span>
        <el-switch v-model="fixedHeader" class="drawer-switch" />
      </div>



      <div class="drawer-item">
        <span>动态标题</span>
        <el-switch v-model="dynamicTitle" class="drawer-switch" />
      </div>

      <div class="drawer-item">
        <span>显示 Logo</span>
        <el-switch v-model="sidebarLogo" class="drawer-switch" />
      </div>

      <!--      ljt-->
      <div class="drawer-item">
<!--        <el-button size="small"  plain icon="el-icon-plus" @click="userAvatar">上传logo</el-button>-->
          <userAvatar />
      </div>

      <div class="drawer-item">
        <el-button size="small"  plain icon="el-icon-edit" @click="systenameChange">更改系统名</el-button>
      </div>

      <!--      ljt-->

      <el-divider/>

      <el-button size="small" type="primary" plain icon="el-icon-document-add" @click="saveSetting">保存配置</el-button>
      <el-button size="small" plain icon="el-icon-refresh" @click="resetSetting">重置配置</el-button>
    </div>

<!--    ljt-->
    <!-- 修改系统名 -->
    <el-dialog :title="title" :visible.sync="open" width="680px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="100px">
        <el-row>
          <el-col :span="12">
             <el-input v-model="form.perms" placeholder="请输入新的系统名" maxlength="100" />
              <span slot="label">

              </span>
          </el-col>
        </el-row>
      </el-form>

      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitTitle">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
<!--    ljt-->
  </div>
</template>

<script>
import ThemePicker from '@/components/ThemePicker'
import request from '@/utils/request'
// import userAvatar from "@/views/system/user/profile/userAvatar";
import userAvatar from "./userAvatar";

// import Logo form "@components/Sidebar/Logo";

export default {

  components: { ThemePicker,   userAvatar },
  data() {
    return {
      //ljt
      title: this.$store.state.settings.title,
      // 是否显示弹出层
      open: false,
      // 是否展开，默认全部折叠

      form: {},
      // 表单参数
      user: {},
      // ljt


      theme: this.$store.state.settings.theme,
      sideTheme: this.$store.state.settings.sideTheme
    };
  },
  computed: {
    fixedHeader: {
      get() {
        return this.$store.state.settings.fixedHeader
      },
      set(val) {
        this.$store.dispatch('settings/changeSetting', {
          key: 'fixedHeader',
          value: val
        })
      }
    },
    topNav: {
      get() {
        return this.$store.state.settings.topNav
      },
      set(val) {
        this.$store.dispatch('settings/changeSetting', {
          key: 'topNav',
          value: val
        })
        if (!val) {
          this.$store.commit("SET_SIDEBAR_ROUTERS", this.$store.state.permission.defaultRoutes);
        }
      }
    },
    tagsView: {
      get() {
        return this.$store.state.settings.tagsView
      },
      set(val) {
        this.$store.dispatch('settings/changeSetting', {
          key: 'tagsView',
          value: val
        })
      }
    },
    sidebarLogo: {
      get() {
        return this.$store.state.settings.sidebarLogo
      },
      set(val) {
        this.$store.dispatch('settings/changeSetting', {
          key: 'sidebarLogo',
          value: val
        })
      }
    },
    dynamicTitle: {
      get() {
        return this.$store.state.settings.dynamicTitle
      },
      set(val) {
        this.$store.dispatch('settings/changeSetting', {
          key: 'dynamicTitle',
          value: val
        })
      }
    },
  },
  methods: {

    // systemC(){
    //
    // },
    //ljt
    /** 修改系统名操作 */
    systenameChange(){

        this.open = true;
        this.title = "修改系统名";

    },
    // 取消按钮
    cancel() {
      this.open = false;
    },

    //系统名更改提交按钮
    submitTitle(value) {
      console.log("?????");
      console.log(this.form.perms,"zheli");

      this.$store.dispatch("settings/setTitle",this.form.perms);
      this.$message.success("修改成功！")
      this.open= false;

    },
    //ljt

    themeChange(val) {
      this.$store.dispatch('settings/changeSetting', {
        key: 'theme',
        value: val
      })
      this.theme = val;
    },
    handleTheme(val) {
      this.$store.dispatch('settings/changeSetting', {
        key: 'sideTheme',
        value: val
      })
      this.sideTheme = val;
    },
    saveSetting() {
      this.$modal.loading("正在保存到本地，请稍后...");
      this.$cache.local.set(
        "layout-setting",
        `{
            "topNav":${this.topNav},
            "tagsView":${this.tagsView},
            "fixedHeader":${this.fixedHeader},
            "sidebarLogo":${this.sidebarLogo},
            "dynamicTitle":${this.dynamicTitle},
            "sideTheme":"${this.sideTheme}",
            "theme":"${this.theme}"
          }`
      );
      setTimeout(this.$modal.closeLoading(), 1000)
    },
    resetSetting() {
      this.$modal.loading("正在清除设置缓存并刷新，请稍后...");
      this.$cache.local.remove("layout-setting")
      setTimeout("window.location.reload()", 1000)
    }
  }
}



</script>

<style lang="scss" scoped>
  .setting-drawer-content {
    .setting-drawer-title {
      margin-bottom: 12px;
      color: rgba(0, 0, 0, .85);
      font-size: 14px;
      line-height: 22px;
      font-weight: bold;
    }

    .setting-drawer-block-checbox {
      display: flex;
      justify-content: flex-start;
      align-items: center;
      margin-top: 10px;
      margin-bottom: 20px;

      .setting-drawer-block-checbox-item {
        position: relative;
        margin-right: 16px;
        border-radius: 2px;
        cursor: pointer;

        img {
          width: 48px;
          height: 48px;
        }

        .setting-drawer-block-checbox-selectIcon {
          position: absolute;
          top: 0;
          right: 0;
          width: 100%;
          height: 100%;
          padding-top: 15px;
          padding-left: 24px;
          color: #1890ff;
          font-weight: 700;
          font-size: 14px;
        }
      }
    }
  }

  .drawer-container {
    padding: 24px;
    font-size: 14px;
    line-height: 1.5;
    word-wrap: break-word;

    .drawer-title {
      margin-bottom: 12px;
      color: rgba(0, 0, 0, .85);
      font-size: 14px;
      line-height: 22px;
    }

    .drawer-item {
      color: rgba(0, 0, 0, .65);
      font-size: 14px;
      padding: 12px 0;
    }

    .drawer-switch {
      float: right
    }
  }


</style>
