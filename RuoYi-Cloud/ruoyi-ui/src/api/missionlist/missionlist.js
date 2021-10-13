import request from '@/utils/request'

// 查询任务列表列表
export function listMissionlist(query) {
  return request({
    url: '/missionlist/missionlist/list',
    method: 'get',
    params: query
  })
}

// 查询任务列表详细
export function getMissionlist(id) {
  return request({
    url: '/missionlist/missionlist/' + id,
    method: 'get'
  })
}

// 新增任务列表
export function addMissionlist(data) {
  return request({
    url: '/missionlist/missionlist',
    method: 'post',
    data: data
  })
}

// 修改任务列表
export function updateMissionlist(data) {
  return request({
    url: '/missionlist/missionlist',
    method: 'put',
    data: data
  })
}

// 删除任务列表
export function delMissionlist(id) {
  return request({
    url: '/missionlist/missionlist/' + id,
    method: 'delete'
  })
}
