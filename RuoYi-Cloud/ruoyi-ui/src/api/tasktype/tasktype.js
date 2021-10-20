import request from '@/utils/request'

// 查询任务类型列表
export function listTasktype(query) {
  return request({
    url: '/tasktype/tasktype/list',
    method: 'get',
    params: query
  })
}

// 查询任务类型详细
export function getTasktype(id) {
  return request({
    url: '/tasktype/tasktype/' + id,
    method: 'get'
  })
}

// 新增任务类型
export function addTasktype(data) {
  return request({
    url: '/tasktype/tasktype',
    method: 'post',
    data: data
  })
}

// 修改任务类型
export function updateTasktype(data) {
  return request({
    url: '/tasktype/tasktype',
    method: 'put',
    data: data
  })
}

// 删除任务类型
export function delTasktype(id) {
  return request({
    url: '/tasktype/tasktype/' + id,
    method: 'delete'
  })
}
