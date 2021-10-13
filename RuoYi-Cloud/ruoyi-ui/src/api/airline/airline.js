import request from '@/utils/request'

// 查询航线管理列表
export function listAirline(query) {
  return request({
    url: '/airline/airline/list',
    method: 'get',
    params: query
  })
}

// 查询航线管理详细
export function getAirline(id) {
  return request({
    url: '/airline/airline/' + id,
    method: 'get'
  })
}

// 新增航线管理
export function addAirline(data) {
  return request({
    url: '/airline/airline',
    method: 'post',
    data: data
  })
}

// 修改航线管理
export function updateAirline(data) {
  return request({
    url: '/airline/airline',
    method: 'put',
    data: data
  })
}

// 删除航线管理
export function delAirline(id) {
  return request({
    url: '/airline/airline/' + id,
    method: 'delete'
  })
}
