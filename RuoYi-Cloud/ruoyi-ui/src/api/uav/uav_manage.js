import request from '@/utils/request'

// 查询无人机信息管理列表
export function listUav_manage(query) {
  return request({
    url: '/uav/uav_manage/list',
    method: 'get',
    params: query
  })
}

// 查询无人机信息管理详细
export function getUav_manage(id) {
  return request({
    url: '/uav/uav_manage/' + id,
    method: 'get'
  })
}

// 通过命名模糊查询无人机
export function getUav_manageByName(name) {
  return request({
    url: '/uav/uav_manage/uavName/' + name,
    method: 'get'
  })
}

// 通过命名精确查询无人机
export function getUav_manageByNameAcc(name) {
  return request({
    url: '/uav/uav_manage/uavNameAcc/' + name,
    method: 'get'
  })
}

// 查询无人机信息管理详细
export function getUav_manage_by_flightNumber(uavFlightNumber) {
  return request({
    url: '/uav/uav_manage/FlightNumber/' + uavFlightNumber,
    method: 'get'
  })
}

// 新增无人机信息管理
export function addUav_manage(data) {
  return request({
    url: '/uav/uav_manage',
    method: 'post',
    data: data
  })
}

// 修改无人机信息管理
export function updateUav_manage(data) {
  return request({
    url: '/uav/uav_manage',
    method: 'put',
    data: data
  })
}

// 删除无人机信息管理
export function delUav_manage(id) {
  return request({
    url: '/uav/uav_manage/' + id,
    method: 'delete'
  })

}
