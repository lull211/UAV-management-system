<template>
  <div>
    <div v-show="true">
<!--      <baidu-map class="map" :center="center" :zoom="zoom" @ready="handler" :scroll-wheel-zoom="true" :double-click-zoom="false">-->
      <baidu-map class="map" :center="dataForAddOrEditAirLinePath.map_center" :zoom="dataForAddOrEditAirLinePath.zoom" @ready="handler" :scroll-wheel-zoom="true" :double-click-zoom="false">
        <bm-scale anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-scale>
        <bm-map-type :map-types="['BMAP_NORMAL_MAP','BMAP_SATELLITE_MAP','BMAP_HYBRID_MAP']" anchor="BMAP_ANCHOR_TOP_LEFT"></bm-map-type>
        <bm-geolocation :showAddressBar="true" :autoLocation="true" anchor="BMAP_ANCHOR_BOTTOM_RIGHT"></bm-geolocation>

        <bm-polyline :path="dataForAddOrEditAirLinePath.airlinePoints" stroke-color="red" :stroke-opacity="1" :stroke-weight="5" :editing="true" @lineupdate="updatePolylinePath"></bm-polyline>

        <div v-for="item in dataForAddOrEditAirLinePath.airlinePoints">
          <bm-marker :position="item" :dragging="true" @dragstart="dragstartCB" @dragend="dragendCB" >
            <bm-context-menu>
              <bm-context-menu-item :callback="delete_a_point" text="删除该点"></bm-context-menu-item>
            </bm-context-menu>
          </bm-marker>
        </div>

        <bm-context-menu>
          <bm-context-menu-item :callback="set_start_point" text="放置起始点"></bm-context-menu-item>
          <bm-context-menu-item :callback="set_end_point" text="放置目标点"></bm-context-menu-item>
        </bm-context-menu>

      </baidu-map>

    </div>


    <el-form ref="form" :model="form" :rules="rules" label-width="80px">
      <el-form-item label="航线名称" prop="airlineName">
        <el-input v-model="dataForAddOrEditAirLinePath.airlineName" placeholder="请输入航线名词" />
      </el-form-item>

      <el-form-item label="航线说明" prop="airlineExplain">
        <el-input v-model="dataForAddOrEditAirLinePath.airlineExplain" placeholder="请输入航线说明" />
      </el-form-item>
      <el-form-item label="航线距离" prop="airlineDistance">
        <el-input v-model="dataForAddOrEditAirLinePath.airlineDistance" :disabled="true" placeholder="航线距离" />
      </el-form-item>
<!--      <el-form-item label="航线节点" prop="airlinePoints" >-->
<!--        <el-input v-model="dataForAddOrEditAirLinePath.airlinePoints" :disabled="true" placeholder="航线节点数据" />-->
<!--      </el-form-item>-->
    </el-form>
    <div slot="footer" class="dialog-footer" style="text-align:center;">
      <el-button  type="primary" @click="submitForm">确 定</el-button>
      <el-button  type="primary" @click="click">log</el-button>
    </div>



  </div>
</template>


<script>
import BaiduMap from 'vue-baidu-map'
import Vue from "vue";
import {addAirline, updateAirline} from "@/api/airline/airline";

Vue.use(BaiduMap, {
  // ak 是在百度地图开发者平台申请的密钥 详见 http://lbsyun.baidu.com/apiconsole/key */
  ak: 'webgl&ak=XAZzMQDbVhWrbevkjN0RmMR9XjCZnNHU'
})


export default {
  name: "addPath",
  props:{
    dataForAddOrEditAirLinePath:Object,
  },
  data () {
    return {
      center: {lng: 0, lat: 0}, // 经纬度
      zoom: 0,
      startPoint:{lng: 0, lat: 0},
      endPoint:{lng: 0, lat: 0},

      polylinePath: [],

      dragPoint: {},
      dragPointIndex:null,

      deletePoint:{},

      // airlineDistance:0,
      // airLinePath:[],
      pointList:[],
      isSetStartPoint: false,
      isSetEndPoint: false,
      // 表单参数
      form: {
        id: null,
        airlineName: null,
        airlineDistance: null,
        airlineExplain: null,
        airlinePoints: [],
        createTime: null
      },
      // 表单校验
      rules: {
        airlineName: [
          { required: true, message: "航线名词不能为空", trigger: "blur" }
        ],
        airlineDistance: [
          { required: false, message: "航线距离不能为空", trigger: "blur" }
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
  }, //end of data

  methods: {
    // 取消按钮
    handler ({BMap, map}) {
      this.center.lng = 113.280
      this.center.lat = 23.125
      this.zoom = 15
    },
    updatePolylinePath (e) {
      this.dataForAddOrEditAirLinePath.airlinePoints = e.target.getPath();
      this.dataForAddOrEditAirLinePath.airlineDistance=this.get_airline_distance(this.dataForAddOrEditAirLinePath.airlinePoints);
      // this.form.airlinePoints=JSON.stringify(this.dataForAddOrEditAirLinePath.airlinePoints);
      // this.form.airlineDistance=this.get_airline_distance(this.dataForAddOrEditAirLinePath.airlinePoints);
      // this.form.airlinePoints=JSON.stringify(this.dataForAddOrEditAirLinePath.airlinePoints);
    },
    click(){
      // console.log(this.airLinePath)
      console.log(this.form.airlineExplain)
    },

    delete_a_point(e){
      this.deletePoint.lat=e.target.point.lat;
      this.deletePoint.lng=e.target.point.lng;

      // console.log(this.airLinePath.findIndex(this.findIndexF1));
      var deletePointIndex = this.dataForAddOrEditAirLinePath.airlinePoints.findIndex(this.findIndexF1);
      this.dataForAddOrEditAirLinePath.airlinePoints.splice(deletePointIndex,1)
    },

    findIndexF1(airLinePathPoint)
    {
      return(airLinePathPoint.lat==this.deletePoint.lat && airLinePathPoint.lng==this.deletePoint.lng);
    },

    findIndexF2(airLinePathPoint)
    {
      return(airLinePathPoint.lat==this.dragPoint.lat || airLinePathPoint.lng==this.dragPoint.lng);
    },

    dragstartCB(e){
      this.dragPoint.lat=e.target.point.lat;
      this.dragPoint.lng=e.target.point.lng;
      this.dragPointIndex = this.dataForAddOrEditAirLinePath.airlinePoints.findIndex(this.findIndexF2);
    },
    dragendCB(e){
      this.dataForAddOrEditAirLinePath.airlinePoints[this.dragPointIndex].lat=e.point.lat;
      this.dataForAddOrEditAirLinePath.airlinePoints[this.dragPointIndex].lng=e.point.lng;
      this.form.airlineDistance=this.get_airline_distance(this.dataForAddOrEditAirLinePath.airlinePoints);
    },
    set_start_point(e){
      this.dataForAddOrEditAirLinePath.airlinePoints.splice(0, 0, e.point);
    },
    set_end_point(e){
      this.dataForAddOrEditAirLinePath.airlinePoints.push(e.point);
      this.dataForAddOrEditAirLinePath.airlineDistance=this.get_airline_distance(this.dataForAddOrEditAirLinePath.airlinePoints);

      // this.form.airlineDistance=this.get_airline_distance(this.dataForAddOrEditAirLinePath.airlinePoints);
      // this.form.airlinePoints=JSON.stringify(this.dataForAddOrEditAirLinePath.airlinePoints);
    },


    submitForm() {
      this.form.id=this.dataForAddOrEditAirLinePath.id;
      this.form.airlineName=this.dataForAddOrEditAirLinePath.airlineName;
      this.form.airlinePoints=JSON.stringify(this.dataForAddOrEditAirLinePath.airlinePoints);
      this.form.airlineExplain=this.dataForAddOrEditAirLinePath.airlineExplain;
      this.form.airlineDistance=this.dataForAddOrEditAirLinePath.airlineDistance;
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateAirline(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.$emit('show',false)
              this.getList();
            });
          } else {
            addAirline(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.$emit('show',false)
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },

    /**
     * 获取两经纬度之间的距离
     * @param {number} e1 点1的东经, 单位:角度, 如果是西经则为负
     * @param {number} n1 点1的北纬, 单位:角度, 如果是南纬则为负
     * @param {number} e2
     * @param {number} n2
     */
    get_2p_distance(e1, n1, e2, n2){
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
    },

    /**
     * 获取航线的长度
     * @param {list} polyline 航线上的离散点
     */
    get_airline_distance(polyline){
      let distance = 0;
      for(let i=0;i<polyline.length-1;i++){
        distance += this.get_2p_distance(polyline[i].lng,polyline[i].lat,polyline[i+1].lng,polyline[i+1].lat)*1000;
      }
      return distance
    }

  }, //end of methods
}
</script>

<style scoped>

</style>


<style>

.map {
  width: 100%;
  height: 600px;
}

</style>
