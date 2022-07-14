import request from '@/utils/request'

export function joinUserClub() {
  return request({
    url: '/system/userClub/join',
    method: 'get',
  })
}

// 查询用户社团列表
export function listUserClub(query) {
  return request({
    url: '/system/userClub/list',
    method: 'get',
    params: query
  })
}

// 查询用户社团详细
export function getUserClub(id) {
  return request({
    url: '/system/userClub/' + id,
    method: 'get'
  })
}

// 新增用户社团
export function addUserClub(data) {
  return request({
    url: '/system/userClub',
    method: 'post',
    data: data
  })
}

// 修改用户社团
export function updateUserClub(data) {
  return request({
    url: '/system/userClub',
    method: 'put',
    data: data
  })
}

// 删除用户社团
export function delUserClub(id) {
  return request({
    url: '/system/userClub/' + id,
    method: 'delete'
  })
}
