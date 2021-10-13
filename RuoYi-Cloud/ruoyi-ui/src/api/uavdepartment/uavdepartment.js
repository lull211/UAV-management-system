import request from '@/utils/request'

// 查询无人机归口部门列表
export function listUavdepartment(query) {
  return request({
    url: '/uavdepartment/uavdepartment/list',
    method: 'get',
    params: query
  })
}

// 查询无人机归口部门详细
export function getUavdepartment(id) {
  return request({
    url: '/uavdepartment/uavdepartment/' + id,
    method: 'get'
  })
}

// 新增无人机归口部门
export function addUavdepartment(data) {
  return request({
    url: '/uavdepartment/uavdepartment',
    method: 'post',
    data: data
  })
}

// 修改无人机归口部门
export function updateUavdepartment(data) {
  return request({
    url: '/uavdepartment/uavdepartment',
    method: 'put',
    data: data
  })
}

// 删除无人机归口部门
export function delUavdepartment(id) {
  return request({
    url: '/uavdepartment/uavdepartment/' + id,
    method: 'delete'
  })
}
