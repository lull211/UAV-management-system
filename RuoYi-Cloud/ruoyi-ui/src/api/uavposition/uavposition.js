import request from '@/utils/request'

// 查询无人机实时位置测试列表
export function listUavposition(query) {
  return request({
    url: '/uavposition/uavposition/list',
    method: 'get',
    params: query
  })
}

// 查询无人机实时位置测试详细
export function getUavposition(id) {
  return request({
    url: '/uavposition/uavposition/' + id,
    method: 'get'
  })
}

// 新增无人机实时位置测试
export function addUavposition(data) {
  return request({
    url: '/uavposition/uavposition',
    method: 'post',
    data: data
  })
}

// 修改无人机实时位置测试
export function updateUavposition(data) {
  return request({
    url: '/uavposition/uavposition',
    method: 'put',
    data: data
  })
}

// 删除无人机实时位置测试
export function delUavposition(id) {
  return request({
    url: '/uavposition/uavposition/' + id,
    method: 'delete'
  })
}
