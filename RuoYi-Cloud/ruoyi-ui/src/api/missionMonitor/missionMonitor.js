import request from '@/utils/request'

// 查询无人机信息管理列表
export function listMissionMonitor(query) {
  return request({
    url: '/missionMonitor/missionMonitor/list',
    method: 'get',
    params: query
  })
}

// 查询无人机信息管理详细
export function getMissionMonitor(id) {
  return request({
    url: '/missionMonitor/missionMonitor/' + id,
    method: 'get'
  })
}

// 新增无人机信息管理
export function addMissionMonitor(data) {
  return request({
    url: '/missionMonitor/missionMonitor',
    method: 'post',
    data: data
  })
}

// 修改无人机信息管理
export function updateMissionMonitor(data) {
  return request({
    url: '/missionMonitor/missionMonitor',
    method: 'put',
    data: data
  })
}

// 删除无人机信息管理
export function delMissionMonitor(id) {
  return request({
    url: '/missionMonitor/missionMonitor/' + id,
    method: 'delete'
  })
}
