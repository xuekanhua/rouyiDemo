import request from '@/utils/request'

// 查询用户活动列表
export function listUserActivity(query) {
  return request({
    url: '/system/userActivity/list',
    method: 'get',
    params: query
  })
}

// 查询用户活动详细
export function getUserActivity(id) {
  return request({
    url: '/system/userActivity/' + id,
    method: 'get'
  })
}

// 新增用户活动
export function addUserActivity(data) {
  return request({
    url: '/system/userActivity',
    method: 'post',
    data: data
  })
}

// 修改用户活动
export function updateUserActivity(data) {
  return request({
    url: '/system/userActivity',
    method: 'put',
    data: data
  })
}

// 删除用户活动
export function delUserActivity(id) {
  return request({
    url: '/system/userActivity/' + id,
    method: 'delete'
  })
}
