import request from '@/utils/request'

// 查询保管员管理列表
export function listKeeper(query) {
  return request({
    url: '/keeper/keeper/list',
    method: 'get',
    params: query
  })
}

// 查询保管员管理详细
export function getKeeper(id) {
  return request({
    url: '/keeper/keeper/' + id,
    method: 'get'
  })
}

// 新增保管员管理
export function addKeeper(data) {
  return request({
    url: '/keeper/keeper',
    method: 'post',
    data: data
  })
}

// 修改保管员管理
export function updateKeeper(data) {
  return request({
    url: '/keeper/keeper',
    method: 'put',
    data: data
  })
}

// 删除保管员管理
export function delKeeper(id) {
  return request({
    url: '/keeper/keeper/' + id,
    method: 'delete'
  })
}
