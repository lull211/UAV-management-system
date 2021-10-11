<template>
<div>
  <el-container style="height: 800px; border: 1px solid #eee">

    <el-aside width="25%" style="background-color: rgb(238, 241, 246)">
      <button class="addButton" @click="handleAdd">添加航线</button>

      <el-menu :default-openeds="['1',]">
        <el-submenu index="1">
          <template slot="title"><i class="el-icon-menu"></i>航线列表</template>
            <div v-for="(item,index) in airlineList" :key="item.id">
              <el-menu-item style="color:black;display: flex;justify-content: space-between;padding:0 20px " @click="selecteAirline(item)" >
              <span style="min-width: 150px">  {{ item.airlineName }}</span>
               <div >
                 <el-button
                   size="mini"
                   type="primary"
                   icon="el-icon-edit"
                   @click="handleUpdate(item)"
                   v-hasPermi="['airline:airline:edit']"
                 />
                 <el-button
                   size="mini"
                   type="primary"
                   icon="el-icon-delete"
                   @click="handleDelete(item)"
                   v-hasPermi="['airline:airline:remove']"
                 />
               </div>
              </el-menu-item>
            </div>
        </el-submenu>
      </el-menu>
    </el-aside>

    <el-container>

    <el-main style="height: 600px" :v-show="!show">
      <div :v-show="!show">
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

    <el-dialog
      :title="form.id?'修改航线':'添加航线'"
      :visible.sync="show"
      width="80%">
      <addPath  style="width:100%" v-on:show="ifShow" :form="form"></addPath>
    </el-dialog>



  </el-container>

</div>
</template>
<style  scoped>
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
import addPath from "../addPath/index.vue";
Vue.use(BaiduMap, {
  // ak 是在百度地图开发者平台申请的密钥 详见 http://lbsyun.baidu.com/apiconsole/key */
  ak: 'webgl&ak=XAZzMQDbVhWrbevkjN0RmMR9XjCZnNHU'
})

export default {
  name: "Airline",
  components:{
    addPath,
  },
  data() {

    return {
      map_center: {lng: 0, lat: 0}, // 经纬度
      zoom: 0,
      uavList: [{lng: 113.280, lat: 23.126}, {lng: 113.281, lat: 23.127}, {lng: 113.282, lat: 23.128}],
      polylinePath: [],

      show:false,//是否显示添加航线
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
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        airlineName: [
          { required: true, message: "航线名词不能为空", trigger: "blur" }
        ],
        airlineDistance: [
          { required: true, message: "航线距离不能为空", trigger: "blur" }
        ],
        airlineExplain: [
          { required: true, message: "航线说明不能为空", trigger: "blur" }
        ],
        airlinePoints: [
          { required: true, message: "航线节点不能为空", trigger: "blur" }
        ],
        createTime: [
          { required: true, message: "创建时间不能为空", trigger: "blur" }
        ]
      },

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

    ifShow(value){
      this.show=value;
    },

    clickHandler (e) {
      alert(`该无人机的坐标为 经度：${e.point.lng}   纬度：${e.point.lat}`);
    },

    test () {
      alert("hello");
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
        airlinePoints: [],
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
      this.show=true;
    },
    /** 修改按钮操作 */
    handleUpdate(item) {
      this.reset();
      // console.log(index)
      // console.log(this.airlineList[index].airlinePoints);

      this.form.id=item.id;
      this.form.airlineName=item.airlineName;
      this.form.airlineDistance=item.airlineDistance;
      this.form.airlineExplain=item.airlineExplain;
      this.form.airlinePoints=item.airlinePoints;
      this.show=true;
      // const id = row.id || this.ids;
      // this.form = row;
      // this.show=true;
      getAirline(item.id).then(response => {
        this.form = response.data;
        console.log(this.form);

      });
    },

    /** 删除按钮操作 */
    handleDelete(row) {
      const ids = row.id || this.ids;
      this.$modal.confirm('是否确认删除航线名为"' + row.airlineName + '"的数据项？').then(function() {
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
      if (distance < 5000){
        this.zoom = 14;
      }else if(distance < 50000){
        this.zoom = 13;
      } else if(distance < 100000){
        this.zoom = 11;
      }else if(distance < 200000){
        this.zoom = 9;
      }else{
        this.zoom = 5;
      }
    },

  } ,// end of methods()

};
</script>

<style>

.map {
  display: block;
  width: 100%;
  height: 600px;
}

.addButton {
  width: 100%;
  height: 50px;
  font-size: large;
}

</style>
