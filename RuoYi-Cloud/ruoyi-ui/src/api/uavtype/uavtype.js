import request from '@/utils/request'

// 查询uavtype列表
export function listUavtype(query) {
  return request({
    url: '/uavtype/uavtype/list',
    method: 'get',
    params: query
  })
}

// 查询uavtype详细
export function getUavtype(id) {
  return request({
    url: '/uavtype/uavtype/' + id,
    method: 'get'
  })
}

// 新增uavtype
export function addUavtype(data) {
  return request({
    url: '/uavtype/uavtype',
    method: 'post',
    data: data
  })
}

// 修改uavtype
export function updateUavtype(data) {
  return request({
    url: '/uavtype/uavtype',
    method: 'put',
    data: data
  })
}

// 删除uavtype
export function delUavtype(id) {
  return request({
    url: '/uavtype/uavtype/' + id,
    method: 'delete'
  })
}
