import request from '@/utils/request'

// 查询系统设置列表
export function listSystemprofile(query) {
  return request({
    url: '/systemprofile/systemprofile/list',
    method: 'get',
    params: query
  })
}

// 查询系统设置详细
export function getSystemprofile(id) {
  return request({
    url: '/systemprofile/systemprofile/' + id,
    method: 'get'
  })
}

// 新增系统设置
export function addSystemprofile(data) {
  return request({
    url: '/systemprofile/systemprofile',
    method: 'post',
    data: data
  })
}

// 修改系统设置
export function updateSystemprofile(data) {
  return request({
    url: '/systemprofile/systemprofile',
    method: 'put',
    data: data
  })
}

// 删除系统设置
export function delSystemprofile(id) {
  return request({
    url: '/systemprofile/systemprofile/' + id,
    method: 'delete'
  })
}
