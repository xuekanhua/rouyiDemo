import request from '@/utils/request'

// 查询社团用户列表
export function listUsers(query) {
  return request({
    url: '/system/users/list',
    method: 'get',
    params: query
  })
}

// 查询社团用户详细
export function getUsers(id) {
  return request({
    url: '/system/users/' + id,
    method: 'get'
  })
}

// 新增社团用户
export function addUsers(data) {
  return request({
    url: '/system/users',
    method: 'post',
    data: data
  })
}

// 修改社团用户
export function updateUsers(data) {
  return request({
    url: '/system/users',
    method: 'put',
    data: data
  })
}

// 删除社团用户
export function delUsers(id) {
  return request({
    url: '/system/users/' + id,
    method: 'delete'
  })
}
