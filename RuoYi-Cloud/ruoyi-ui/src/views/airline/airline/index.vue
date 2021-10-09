<template>
<div>
  <el-container style="height: 800px; border: 1px solid #eee">

    <el-aside width="25%" style="background-color: rgb(238, 241, 246)">
      <button class="addButton">添加航线</button>

      <el-menu :default-openeds="['1',]">
        <el-submenu index="1">
          <template slot="title"><i class="el-icon-menu"></i>航线列表</template>
            <div v-for="item in airlineList" :key="item.id">
              <el-menu-item style="color:black" @click="selecteAirline(item)">{{ item.airlineName }}</el-menu-item>
            </div>
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>
    <el-main style="height: 600px">
      <div v-show="true">
        <baidu-map class="map" :center="map_center" :zoom="zoom" @ready="handler" :scroll-wheel-zoom="true" >
          <!--    比例尺-->
          <bm-scale anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-scale>
          <!--    地图类型-->
          <bm-map-type :map-types="['BMAP_NORMAL_MAP','BMAP_SATELLITE_MAP','BMAP_HYBRID_MAP']" anchor="BMAP_ANCHOR_TOP_LEFT"></bm-map-type>
          <!--    定位到当前位置-->
          <bm-geolocation :showAddressBar="true" :autoLocation="true" anchor="BMAP_ANCHOR_BOTTOM_RIGHT"></bm-geolocation>

          <bm-polyline :path="polylinePath" stroke-color="red" :stroke-opacity="1" :stroke-weight="5" :editing="false"></bm-polyline>

        </baidu-map>
      </div>

    </el-main>

    <el-footer style="height: 200px">{{ airlineDescription }}</el-footer>
  </el-container>
  </el-container>

<!--  <p>-->
<!--    {{airlineList}}-->
<!--  </p>-->
</div>
</template>
<style>
.el-header {
  background-color: #B3C0D1;
  color: #333;
  line-height: 80px;
}

.el-aside {
  color: #333;
}
</style>

<script>
import { listAirline, getAirline, delAirline, addAirline, updateAirline } from "@/api/airline/airline";
import BaiduMap from 'vue-baidu-map'
import Vue from "vue";

Vue.use(BaiduMap, {
  // ak 是在百度地图开发者平台申请的密钥 详见 http://lbsyun.baidu.com/apiconsole/key */
  ak: 'webgl&ak=XAZzMQDbVhWrbevkjN0RmMR9XjCZnNHU'
})

export default {
  name: "Airline",
  data() {

    return {
      map_center: {lng: 0, lat: 0}, // 经纬度
      zoom: 0,
      uavList: [{lng: 113.280, lat: 23.126}, {lng: 113.281, lat: 23.127}, {lng: 113.282, lat: 23.128}],
      polylinePath: [],

      /** 百度地图参数 */
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
      airlineDescription:'',
      // 航线管理表格数据
      airlineList: [],

      }
  },  // end of data()

  created() {
    this.getList();
  },

  methods: {
    handler ({BMap, map}) {
      console.log(BMap, map)
      this.map_center.lng = 113.280
      this.map_center.lat = 23.125
      this.zoom = 15


    },

    clickHandler (e) {
      alert(`该无人机的坐标为 经度：${e.point.lng}   纬度：${e.point.lat}`);
    },

    test () {
      alert("hello");
    },

    set_path () {
      this.polylinePath = [this.startPoint,this.endPoint]
    },

    /** 查询航线管理列表 */
    getList() {
      this.loading = true;
      listAirline(this.queryParams).then(response => {
        this.airlineList = response.rows;
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
        airlineName: null,
        airlineDistance: null,
        airlineExplain: null,
        airlinePoints: null,
        createTime: null
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
      this.title = "添加航线管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getAirline(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改航线管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAirline(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addAirline(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除航线管理编号为"' + ids + '"的数据项？').then(function() {
        return delAirline(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('airline/airline/export', {
        ...this.queryParams
      }, `airline_airline.xlsx`)
    },

    selecteAirline(e){
      this.airlineDescription = e.airlineExplain;
      this.updateAirlineInMap(e.airlinePoints,e.airlineDistance);
    },
    updateAirlineInMap(airlinePoints,airlineDistance) {
      this.polylinePath = JSON.parse(airlinePoints);
      this.map_center = this.polylinePath[0];
      var distance =  airlineDistance;
      if (distance < 5){
          this.zoom = 14;
      }else if(distance < 50){
        this.zoom = 13;
      } else if(distance < 100){
        this.zoom = 11;
      }else if(distance < 200){
        this.zoom = 9;
      }else{
        this.zoom = 5;
      }
    },

    /**
     * 获取两经纬度之间的距离
     * @param {number} e1 点1的东经, 单位:角度, 如果是西经则为负
     * @param {number} n1 点1的北纬, 单位:角度, 如果是南纬则为负
     * @param {number} e2
     * @param {number} n2
     */
    getDistance(e1, n1, e2, n2){
      const R = 6371
      const { sin, cos, asin, PI, hypot } = Math

      /** 根据经纬度获取点的坐标 */
      let getPoint = (e, n) => {
        e *= PI/180
        n *= PI/180
        //这里 R* 被去掉, 相当于先求单位圆上两点的距, 最后会再将这个距离放大 R 倍
        return {x: cos(n)*cos(e), y: cos(n)*sin(e), z: sin(n)}
      }

      let a = getPoint(e1, n1)
      let b = getPoint(e2, n2)
      let c = hypot(a.x - b.x, a.y - b.y, a.z - b.z)
      let r = asin(c/2)*2*R
      return r;
    }
  } ,// end of methods()

};
</script>

<style>

.map {
  width: 100%;
  height: 600px;
}

.addButton {
  width: 100%;
  height: 50px;
  font-size: large;
}

</style>
