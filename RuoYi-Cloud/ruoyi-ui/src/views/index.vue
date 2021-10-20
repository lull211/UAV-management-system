<template>
  <div class="app-container home">

    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div class="body">
            <img
              src="https://www1.djicdn.com/cms_uploads/ckeditor/pictures/1502/content__%E5%BE%A1__Mavic_Air%E9%9B%AA%E5%9F%9F%E7%99%BD.png"
              alt="uav"
              width="100%"
              height="300px"
            />
            <!--            <span style="display: inline-block; height: 30px; line-height: 30px"-->
            <!--              >你可以请作者喝杯咖啡表示鼓励</span-->
            <!--            >-->
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">

          <div class="body">
            <img
              src="http://img.mp.itc.cn/upload/20160527/13a77f2eaf8f4969bcf16279fae362d4_th.jpg"
              alt="uav2"
              width="100%"
              height="300px"

            />
          </div>
        </el-card>
      </el-col>


    </el-row>
    <el-divider />
    <el-row :gutter="20">
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div class="body">
            <img
              src="http://img004.file.rongbiz.cn/uploadfile/201611/20/11/11-05-44-49-839233.jpg"
              alt="uav"
              width="100%"
              height="300px"
            />
<!--            <span style="display: inline-block; height: 30px; line-height: 30px"-->
<!--              >你可以请作者喝杯咖啡表示鼓励</span-->
<!--            >-->
          </div>
        </el-card>
      </el-col>
      <el-col :xs="24" :sm="24" :md="12" :lg="8">
        <el-card class="update-log">
          <div class="body">
            <img
              src=" https://cdn.jiemodui.com/img/Public/Uploads/item/20170117/1484620528417708.jpeg"
              alt="uav2"
              width="100%"
              height="300px"

            />
          </div>
        </el-card>
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  name: "Index",
  data() {
    return {
      // 版本号
      version: "3.1.0",
    };
  },
  methods: {
    goTarget(href) {
      window.open(href, "_blank");
    },
  },
};
</script>

<style scoped lang="scss">
.home {
  blockquote {
    padding: 10px 20px;
    margin: 0 0 20px;
    font-size: 17.5px;
    border-left: 5px solid #eee;
  }
  hr {
    margin-top: 20px;
    margin-bottom: 20px;
    border: 0;
    border-top: 1px solid #eee;
  }
  .col-item {
    margin-bottom: 20px;
  }

  ul {
    padding: 0;
    margin: 0;
  }

  font-family: "open sans", "Helvetica Neue", Helvetica, Arial, sans-serif;
  font-size: 13px;
  color: #676a6c;
  overflow-x: hidden;

  ul {
    list-style-type: none;
  }

  h4 {
    margin-top: 0px;
  }

  h2 {
    margin-top: 10px;
    font-size: 26px;
    font-weight: 100;
  }

  p {
    margin-top: 10px;

    b {
      font-weight: 700;
    }
  }

  .update-log {
    ol {
      display: block;
      list-style-type: decimal;
      margin-block-start: 1em;
      margin-block-end: 1em;
      margin-inline-start: 0;
      margin-inline-end: 0;
      padding-inline-start: 40px;
    }
  }
}
</style>

