import request from '@/utils/request'

// 查询教室借用列表
export function listBookings(query) {
  return request({
    url: '/manage/bookings/list',
    method: 'get',
    params: query
  })
}

// 查询教室借用详细
export function getBookings(id) {
  return request({
    url: '/manage/bookings/' + id,
    method: 'get'
  })
}

// 新增教室借用
export function addBookings(data) {
  return request({
    url: '/manage/bookings',
    method: 'post',
    data: data
  })
}

// 修改教室借用
export function updateBookings(data) {
  return request({
    url: '/manage/bookings',
    method: 'put',
    data: data
  })
}

// 删除教室借用
export function delBookings(id) {
  return request({
    url: '/manage/bookings/' + id,
    method: 'delete'
  })
}
