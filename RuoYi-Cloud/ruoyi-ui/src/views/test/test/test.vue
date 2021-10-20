<template>
  <div style="width: 100%;height: 100%">
    <input type="text" placeholder="出发地" style="width: 10em" id="startAddress">
    <input type="text" placeholder="目的地" style="width: 10em" id="endAddress">
    <input type='button' value='开始' @click='searchByStationName1()'/>
    <p></p>
    <div style="width:1020px;height:500px;border:1px solid gray;margin-left: 25%" id="container"></div>
    <p></p>
  </div>
</template>

<script>
var map
export default {
  name: 'search',
  data: function () {
    return {
      from: null,
      to: null
    }
  },
  mounted () {
    // eslint-disable
    var _this = this;
    map = new BMap.Map('container')
    map.centerAndZoom(new BMap.Point(112.89996, 28.198), 13)
    map.enableScrollWheelZoom(true) // 开启鼠标滚轮缩放
    map.addControl(new BMap.NavigationControl()) // 添加平移缩放控件
    map.addControl(new BMap.ScaleControl()) // 添加比例尺控件
    map.addControl(new BMap.OverviewMapControl()) // 添加缩略地图控件

    var localSearch = new BMap.LocalSearch(map);
    localSearch.enableAutoViewport(); //允许自动调节窗体大小
  },
  methods: {//定义方法
    searchByStationName1: function () {
      var _this = this;
      var startAddrr = document.getElementById("startAddress").value;//获得起点地名
      var localSearch = new BMap.LocalSearch(map);
      localSearch.setSearchCompleteCallback(function (searchResult) {
        var poi = searchResult.getPoi(0);//获得起点经纬度坐标
        if (poi != null) { //判断地名是否存在
          console.log('from poi', poi);
          _this.from = poi.point;
          console.log('from', _this.from);
          _this.searchByStationName2();
        }
        else{
          alert("请输入正确的地名！")
        }
      });
      localSearch.search(startAddrr);
    },
    searchByStationName2: function () {
      var _this = this;
      var endAddrr = document.getElementById("endAddress").value; //获得目的地地名
      var localSearch = new BMap.LocalSearch(map);
      localSearch.setSearchCompleteCallback(function (searchResult) {
        var poi = searchResult.getPoi(0); //获得目的地经纬度坐标
        if (poi != null) { //判断目的地是否存在
          _this.to = poi.point;
          _this.run();
        }
        else{
          alert("请输入正确的地名！")
        }

      });
      localSearch.search(endAddrr);
    },
    run: function () {
      map.clearOverlays() // 清除地图上所有的覆盖物
      var walking = new BMap.WalkingRoute(map) // 创建步行实例
      walking.search(this.from, this.to) // 第一个步行搜索
      let that = this;
      walking.setSearchCompleteCallback(function () {
        console.log('completeCallback start!');
        var pts = walking.getResults().getPlan(0).getRoute(0).getPath() // 通过步行实例，获得一系列点的数组

        var polyline = new BMap.Polyline(pts)
        map.addOverlay(polyline)
        console.log('pollyline!', polyline);
        var m1 = new BMap.Marker(that.from) // 创建2个marker
        var m2 = new BMap.Marker(that.to)
        map.addOverlay(m1)
        map.addOverlay(m2)

        var lab1 = new BMap.Label('起点', {position: that.from}) // 创建2个label
        var lab2 = new BMap.Label('终点', {position: that.to})
        map.addOverlay(lab1)
        map.addOverlay(lab2)
        console.log('setTimeout!');
        setTimeout(function () {
          map.setViewport([that.from, that.to]) // 调整到最佳视野
        }, 1000)
      })
    }
  }
}

</script>

<style scoped>


</style>
