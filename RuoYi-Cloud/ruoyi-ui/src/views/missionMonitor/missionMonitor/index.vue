<template>

  <div>
    <el-container style="height: 800px; border: 1px solid #eee">

      <el-aside width="25%" style="background-color: rgb(238, 241, 246)">

        <el-menu :default-openeds="['1',]">
          <el-submenu index="1">
            <template slot="title"><i class="el-icon-menu"></i>飞行器列表</template>
            <div v-for="(item,index) in missionMonitorList" :key="item.id">
              <el-menu-item style="color:black;display: flex;justify-content: space-between;padding:0 20px ;height: 100px" @click="selectUav(item.uavFlightNumber)" >

                  <el-row style="width: 100%">
                    <el-col :span="6">
                        <el-image style="width: 100px; height: 100px; padding: 10px 20px 10px 0px" :src="item.uavImages" :fit="fits" ></el-image>

                    </el-col>

                    <el-col :span="15">
                      <div>编号：  {{item.uavFlightNumber}}</div>
                      <div>状态：  {{item.uavEnabled}}</div>
                    </el-col>

                    <el-col :span="3">
                      <div style="align-items: center; margin: auto; padding: 25px 100px 10px 0px">
                        <el-button
                          size="mini"
                          type="primary"
                          icon="el-icon-caret-right"
                          @click="jump_video(item)"
                          v-hasPermi="['airline:airline:remove']"
                        />
                      </div>

                    </el-col>

                  </el-row>

              </el-menu-item>
            </div>
          </el-submenu>
        </el-menu>
      </el-aside>

      <el-container>
        <el-main style="height: 1000px">
          <div>
            <baidu-map class="map" :center="map_center" :zoom="zoom" @ready="handler" :scroll-wheel-zoom="true" >
              <!--    比例尺-->
              <bm-scale anchor="BMAP_ANCHOR_TOP_RIGHT"></bm-scale>
              <!--    地图类型-->
              <bm-map-type :map-types="['BMAP_NORMAL_MAP','BMAP_SATELLITE_MAP','BMAP_HYBRID_MAP']" anchor="BMAP_ANCHOR_TOP_LEFT"></bm-map-type>
              <!--    定位到当前位置-->
              <bm-geolocation :showAddressBar="true" :autoLocation="true" anchor="BMAP_ANCHOR_BOTTOM_RIGHT"></bm-geolocation>
              <bm-context-menu>
                <bm-context-menu-item :callback="locate_uav" text="定位到无人机当前位置"></bm-context-menu-item>
              </bm-context-menu>
              <bm-polyline :path="airlinePath" stroke-color="red" :stroke-opacity="1" :stroke-weight="5" :editing="false"></bm-polyline>

              <bm-marker :position="uav_position" :dragging="false" :icon="{url: 'https://z3.ax1x.com/2021/10/21/5rXF61.png', size: {width: 50, height: 50}}"></bm-marker>
            </baidu-map>
          </div>

        </el-main>
<!--        <el-footer style="height: 200px">xixixi</el-footer>-->
      </el-container>

<!--      <el-dialog :title="title" :visible.sync="open" width="80%">-->
<!--        <addPath  style="width:100%" :dataForAddOrEditAirLinePath="dataForAddOrEditAirLinePath"></addPath>-->
<!--      </el-dialog>-->

    </el-container>

  </div>


</template>

<script>
import { listMissionMonitor, getMissionMonitor, delMissionMonitor, addMissionMonitor, updateMissionMonitor } from "@/api/missionMonitor/missionMonitor";
import BaiduMap from 'vue-baidu-map'
import Vue from "vue";
import {listMissionlist} from "@/api/missionlist/missionlist";
import {getAirline} from "@/api/airline/airline";
import {listUavposition} from "@/api/uavposition/uavposition";
Vue.use(BaiduMap, {
  // ak 是在百度地图开发者平台申请的密钥 详见 http://lbsyun.baidu.com/apiconsole/key */
  ak: 'webgl&ak=XAZzMQDbVhWrbevkjN0RmMR9XjCZnNHU'
})
export default {
  name: "MissionMonitor",
  dicts: ['sys_uav_department', 'sys_pilots_craft_sort', 'sys_uav_readylevel', 'sys_uav_state'],
  data() {
    return {
      fits:'fill',
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
      // 无人机信息管理表格数据
      missionMonitorList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        uavUnit: null,
        uavName: null,
        uavType: null,
        uavNumber: null,
        uavImages: null,
        uavSn: null,
        uavFlightNumber: null,
        uavBeiqinLevel: null,
        uavEnabled: null,
        uavInsurance: null,
        uavAssurance: null,
        uavMaintenance: null,
        uavKeeperId: null,
        uavPut: null,
        uavUsers: null,
        uavAttachment: null,
        deleteFlag: null
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        uavUnit: [
          { required: true, message: "无人机归口部门不能为空", trigger: "change" }
        ],
        uavName: [
          { required: true, message: "无人机命名不能为空", trigger: "blur" }
        ],
        uavType: [
          { required: true, message: "无人机类型不能为空", trigger: "change" }
        ],
        uavNumber: [
          { required: true, message: "无人机产品型号不能为空", trigger: "blur" }
        ],
        uavImages: [
          { required: true, message: "无人机图片不能为空", trigger: "blur" }
        ],
        uavSn: [
          { required: true, message: "无人机序列号不能为空", trigger: "blur" }
        ],
        uavFlightNumber: [
          { required: true, message: "无人机飞控编号不能为空", trigger: "blur" }
        ],
        uavEnabled: [
          { required: true, message: "无人机启用状态不能为空", trigger: "change" }
        ],
        uavUsers: [
          { required: true, message: "无人机录入人不能为空", trigger: "blur" }
        ],
        deleteFlag: [
          { required: true, message: "删除码不能为空", trigger: "blur" }
        ]
      },

      //map
      map_center: {lng: 113.280, lat: 23.126}, // 经纬度
      zoom: 8,
      airlinePath: [],
      uav_position:{lng:0,lat: 0},
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询无人机信息管理列表 */
    getList() {
      this.loading = true;
      listMissionMonitor(this.queryParams).then(response => {
        this.missionMonitorList = response.rows;
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
        uavUnit: null,
        uavName: null,
        uavType: null,
        uavNumber: null,
        uavImages: null,
        uavSn: null,
        uavFlightNumber: null,
        uavBeiqinLevel: null,
        uavEnabled: null,
        uavInsurance: null,
        uavAssurance: null,
        uavMaintenance: null,
        uavKeeperId: 0,
        uavPut: null,
        uavUsers: null,
        uavAttachment: null,
        deleteFlag: null
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
      this.title = "添加无人机信息管理";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const id = row.id || this.ids
      getMissionMonitor(id).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改无人机信息管理";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.id != null) {
            updateMissionMonitor(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addMissionMonitor(this.form).then(response => {
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
      this.$modal.confirm('是否确认删除无人机信息管理编号为"' + ids + '"的数据项？').then(function() {
        return delMissionMonitor(ids);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('missionMonitor/missionMonitor/export', {
        ...this.queryParams
      }, `missionMonitor_missionMonitor.xlsx`)
    },

    selectUav(e){

      let obj = {
        taskDrone: e
      }

      let obj2 = {
        uavFlightNumber: e
      }

      //任务列表
      listMissionlist(obj).then(res => {
        //获取航线
        getAirline(res.rows[0].taskAirline).then(res => {
          // 更新地图
          this.airlinePath = JSON.parse(res.data.airlinePoints);
          // this.map_center.lng = this.airlinePath[0].lng;
          // this.map_center.lat = this.airlinePath[0].lat;
          this.update_map_center_and_zoom(this.airlinePath);
        })
      })

      listUavposition(obj2).then(res => {
        console.log(res.rows[0]);
        if(!(res.rows[0])){
          console.log("无法获取无人机位置");
          this.uav_position.lng = 0;
          this.uav_position.lat = 0;
        }else{
          this.uav_position.lng = JSON.parse(res.rows[0].position).lng;
          this.uav_position.lat = JSON.parse(res.rows[0].position).lat;
        }

      })


    },

    //map
    handler ({BMap, map}) {
      this.map_center.lng = 106
      this.map_center.lat = 35
      this.zoom = 5
    },
    update_map_center_and_zoom(airlinePoints){

      this.map_center=airlinePoints[0];
      this.map_center={lng: 0, lat: 0};
      let maxLngLatZoom = {};
      let minLngLatZoom= {};
      maxLngLatZoom.lng=airlinePoints[0].lng;
      maxLngLatZoom.lat=airlinePoints[0].lat;
      minLngLatZoom.lng=airlinePoints[0].lng;
      minLngLatZoom.lat=airlinePoints[0].lat;
      for (let i=0;i<airlinePoints.length;i++){
        this.map_center.lng+=airlinePoints[i].lng;
        this.map_center.lat+=airlinePoints[i].lat;
        if(airlinePoints[i].lng>maxLngLatZoom.lng){maxLngLatZoom.lng=airlinePoints[i].lng};
        if(airlinePoints[i].lat>maxLngLatZoom.lat){maxLngLatZoom.lat=airlinePoints[i].lat};
        if(airlinePoints[i].lng<minLngLatZoom.lng){minLngLatZoom.lng=airlinePoints[i].lng};
        if(airlinePoints[i].lat<minLngLatZoom.lat){minLngLatZoom.lat=airlinePoints[i].lat};
      }
      this.map_center.lng=(this.map_center.lng/airlinePoints.length);
      this.map_center.lat=(this.map_center.lat/airlinePoints.length);

      let zoomDist=this.get_distance(maxLngLatZoom.lng,maxLngLatZoom.lat,minLngLatZoom.lng,minLngLatZoom.lat)

      this.zoom=this.get_zoom(zoomDist);
    },
    get_distance(e1, n1, e2, n2){
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
      return r*1000;
    },
    get_zoom(distance){
      if (distance < 5000){
        return  14;
      }else if(distance < 50000){
        return 13;
      } else if(distance < 100000){
        return 11;
      }else if(distance < 200000){
        return  9;
      }else{
        return 5;
      }
    },
    locate_uav(){
      console.log("uav in here");
      this.map_center.lng = this.uav_position.lng;
      this.map_center.lat = this.uav_position.lat;
    },

    jump_video(){
      //点击视频按钮触发此函数
      console.log("点击视频按钮触发此函数");
    },

  }
};
</script>

<style>

.map {
  display: block;
  width: 100%;
  height: 800px;
}



</style>
