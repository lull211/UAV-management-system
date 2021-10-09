<template>
  <div>
    <div v-show="true">
      <baidu-map class="map" :center="center" :zoom="zoom" @ready="handler" :scroll-wheel-zoom="true" :double-click-zoom="false">
        <bm-scale anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-scale>
        <bm-map-type :map-types="['BMAP_NORMAL_MAP','BMAP_SATELLITE_MAP','BMAP_HYBRID_MAP']" anchor="BMAP_ANCHOR_TOP_LEFT"></bm-map-type>
        <bm-geolocation :showAddressBar="true" :autoLocation="true" anchor="BMAP_ANCHOR_BOTTOM_RIGHT"></bm-geolocation>
        <bm-polyline :path="polylinePath" stroke-color="red" :stroke-opacity="1" :stroke-weight="5" :editing="true" @lineupdate="updatePolylinePath" @click="click"></bm-polyline>

        <bm-marker :position="startPoint" :dragging="true" animation="BMAP_ANIMATION_BOUNCE"></bm-marker>
        <bm-marker :position="endPoint" :dragging="true" animation="BMAP_ANIMATION_BOUNCE"></bm-marker>

        <bm-context-menu>
          <bm-context-menu-item :callback="set_start_point" text="放置起始点"></bm-context-menu-item>
          <bm-context-menu-item :callback="set_end_point" text="放置目标点"></bm-context-menu-item>
          <bm-context-menu-item :callback="build_airLine" text="生成航线"></bm-context-menu-item>
        </bm-context-menu>

      </baidu-map>

    </div>

    <el-row :gutter="20">
      <el-col :span="3">起始点</el-col>
      <el-col :span="6">
        <el-input
          placeholder="经度"
          v-model="startPoint.lng"
          clearable>
        </el-input>
      </el-col>
      <el-col :span="6">
        <el-input
          placeholder="纬度"
          v-model="startPoint.lat"
          clearable>
        </el-input>
      </el-col>

    </el-row>

    <el-row :gutter="20">
      <el-col :span="3">目标点</el-col>
      <el-col :span="6">
        <el-input
          placeholder="经度"
          v-model="endPoint.lng"
          clearable>
        </el-input>
      </el-col>
      <el-col :span="6">
        <el-input
          placeholder="纬度"
          v-model="endPoint.lat"
          clearable>
        </el-input>
      </el-col>

    </el-row>


    <el-form ref="form" :model="form" :rules="rules" label-width="80px">
      <el-form-item label="航线名称" prop="airlineName">
        <el-input v-model="form.airlineName" placeholder="请输入航线名词" />
      </el-form-item>

      <el-form-item label="航线说明" prop="airlineExplain">
        <el-input v-model="form.airlineExplain" placeholder="请输入航线说明" />
      </el-form-item>
      <el-form-item label="航线距离" prop="airlineDistance">
        <el-input v-model="form.airlineDistance" :disabled="true" placeholder="航线距离" />
      </el-form-item>
      <el-form-item label="航线节点" prop="airlinePoints" >
<!--        <el-input v-model="polylinePath" :disabled="true" placeholder="请输入航线节点" />-->
        <el-input v-model="form.airlinePoints" :disabled="true" placeholder="航线节点数据" />
      </el-form-item>
    </el-form>
    <div slot="footer" class="dialog-footer" style="text-align:center;">
      <el-button  type="primary" @click="submitForm">确 定</el-button>
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
  data () {
    return {
      center: {lng: 0, lat: 0}, // 经纬度
      zoom: 0,
      startPoint:{lng: 0, lat: 0},
      endPoint:{lng: 0, lat: 0},

      polylinePath: [],
      airlineDistance:0,
      airLinePath:[],

      isSetStartPoint: false,
      isSetEndPoint: false,
      // 表单参数
      form: {
        id: null,
        airlineName: null,
        airlineDistance: 0,
        airlineExplain: null,
        airlinePoints: null,
        createTime: null
      },
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
  }, //end of data

  methods: {
    handler ({BMap, map}) {
      console.log(BMap, map)
      this.center.lng = 113.280
      this.center.lat = 23.125
      this.zoom = 15
    },
    click(point){
      console.log(point)
    },
    updatePolylinePath (e) {
      this.polylinePath = e.target.getPath()
      this.form.airlinePoints=JSON.stringify(this.polylinePath);
      this.form.airlineDistance=this.get_airline_distance(this.polylinePath);
    },

    addPolylinePoint () {
      this.polylinePath.push({lng: 116.404, lat: 39.915})

    },

    clickHandler (e) {
      alert(`该无人机的坐标为 经度：${e.point.lng}   纬度：${e.point.lat}`);
    },

    set_path () {
      this.polylinePath = [this.startPoint,this.endPoint]
    },

    set_start_point (e) {
      this.startPoint=e.point;
    },

    set_end_point (e) {
      this.endPoint=e.point;
    },

    build_airLine () {
      // this.polylinePath = [this.startPoint,this.endPoint]
      this.polylinePath = [this.startPoint, this.endPoint]
      this.form.airlinePoints=JSON.stringify(this.polylinePath);
      this.form.airlineDistance=this.get_airline_distance(this.polylinePath);
      // this.form.airlineDistance=JSON.stringify(this.airlineDistance);
    },

    submitForm() {
      // this.form.airlinePoints=this.polylinePath;
      this.form.airlinePoints=JSON.stringify(this.polylinePath);
      this.form.airlineDistance=this.airlineDistance;
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

    /**
     * 获取两经纬度之间的距离
     * @param {number} e1 点1的东经, 单位:角度, 如果是西经则为负
     * @param {number} n1 点1的北纬, 单位:角度, 如果是南纬则为负
     * @param {number} e2
     * @param {number} n2
     */
    get_2p_pistance(e1, n1, e2, n2){
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
      var distance = 0;
      for(var i=0;i<polyline.length-1;i++){
        distance += this.get_2p_pistance(polyline[i].lng,polyline[i].lat,polyline[i+1].lng,polyline[i+1].lat);
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

.bg-purple {
  background: #d3dce6;
}

.grid-content {
  border-radius: 4px;
  min-height: 36px;
}


</style>
