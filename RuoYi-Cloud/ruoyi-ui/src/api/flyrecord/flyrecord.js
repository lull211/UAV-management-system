import request from '@/utils/request'

// 查询飞行记录列表
export function listFlyrecord(query) {
  return request({
    url: '/flyrecord/flyrecord/list',
    method: 'get',
    params: query
  })
}

// 查询飞行记录详细
export function getFlyrecord(id) {
  return request({
    url: '/flyrecord/flyrecord/' + id,
    method: 'get'
  })
}

// 新增飞行记录
export function addFlyrecord(data) {
  return request({
    url: '/flyrecord/flyrecord',
    method: 'post',
    data: data
  })
}

// 修改飞行记录
export function updateFlyrecord(data) {
  return request({
    url: '/flyrecord/flyrecord',
    method: 'put',
    data: data
  })
}

// 删除飞行记录
export function delFlyrecord(id) {
  return request({
    url: '/flyrecord/flyrecord/' + id,
    method: 'delete'
  })
}
