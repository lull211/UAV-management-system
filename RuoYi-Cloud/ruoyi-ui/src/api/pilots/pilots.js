import request from '@/utils/request'

// 查询驾驶员管理列表
export function listPilots(query) {
  return request({
    url: '/pilots/pilots/list',
    method: 'get',
    params: query
  })
}

// 查询驾驶员管理详细
export function getPilots(id) {
  return request({
    url: '/pilots/pilots/' + id,
    method: 'get'
  })
}

// 通过姓名精准查询驾驶员管理详细
export function getPilotsByName(driverName) {
  return request({
    url: '/pilots/pilots/name/' + driverName,
    method: 'get',
  })
}

//通过姓名模糊查询
// 通过姓名查询驾驶员管理详细
export function getPilotsByNameLikely(driverName) {
  return request({
    url: '/pilots/pilots/namelike/' + driverName,
    method: 'get',
  })
}


// 新增驾驶员管理
export function addPilots(data) {
  return request({
    url: '/pilots/pilots',
    method: 'post',
    data: data
  })
}

// 修改驾驶员管理
export function updatePilots(data) {
  return request({
    url: '/pilots/pilots',
    method: 'put',
    data: data
  })
}

// 删除驾驶员管理
export function delPilots(id) {
  return request({
    url: '/pilots/pilots/' + id,
    method: 'delete'
  })
}

// 查询任务列表中的驾驶员
export function getMissionlistByDriverId(driverId) {
  return request({
    url: '/missionlist/missionlist/pilots/' + driverId,
    method: 'get'
  })
}

