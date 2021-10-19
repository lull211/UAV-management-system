import request from '@/utils/request'

// 查询我的任务列表列表
export function listMymissionlist(query) {
  return request({
    url: '/mymissionlist/mymissionlist/list',
    method: 'get',
    params: query
  })
}

// 查询我的任务列表详细
export function getMymissionlist(id) {
  return request({
    url: '/mymissionlist/mymissionlist/' + id,
    method: 'get'
  })
}

// 新增我的任务列表
export function addMymissionlist(data) {
  return request({
    url: '/mymissionlist/mymissionlist',
    method: 'post',
    data: data
  })
}

// 修改我的任务列表
export function updateMymissionlist(data) {
  return request({
    url: '/mymissionlist/mymissionlist',
    method: 'put',
    data: data
  })
}

// 删除我的任务列表
export function delMymissionlist(id) {
  return request({
    url: '/mymissionlist/mymissionlist/' + id,
    method: 'delete'
  })
}
