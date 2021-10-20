import request from '@/utils/request'

// 查询任务等级列表
export function listMissionlevel(query) {
  return request({
    url: '/missionlevel/missionlevel/list',
    method: 'get',
    params: query
  })
}

// 查询任务等级详细
export function getMissionlevel(id) {
  return request({
    url: '/missionlevel/missionlevel/' + id,
    method: 'get'
  })
}

// 新增任务等级
export function addMissionlevel(data) {
  return request({
    url: '/missionlevel/missionlevel',
    method: 'post',
    data: data
  })
}

// 修改任务等级
export function updateMissionlevel(data) {
  return request({
    url: '/missionlevel/missionlevel',
    method: 'put',
    data: data
  })
}

// 删除任务等级
export function delMissionlevel(id) {
  return request({
    url: '/missionlevel/missionlevel/' + id,
    method: 'delete'
  })
}
