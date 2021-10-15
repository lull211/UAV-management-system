import request from '@/utils/request'

// 查询我的飞行记录列表
export function listMyflyrecord(query) {
  return request({
    url: '/myflyrecord/myflyrecord/list',
    method: 'get',
    params: query
  })
}

// 查询我的飞行记录详细
export function getMyflyrecord(id) {
  return request({
    url: '/myflyrecord/myflyrecord/' + id,
    method: 'get'
  })
}

// 新增我的飞行记录
export function addMyflyrecord(data) {
  return request({
    url: '/myflyrecord/myflyrecord',
    method: 'post',
    data: data
  })
}

// 修改我的飞行记录
export function updateMyflyrecord(data) {
  return request({
    url: '/myflyrecord/myflyrecord',
    method: 'put',
    data: data
  })
}

// 删除我的飞行记录
export function delMyflyrecord(id) {
  return request({
    url: '/myflyrecord/myflyrecord/' + id,
    method: 'delete'
  })
}
