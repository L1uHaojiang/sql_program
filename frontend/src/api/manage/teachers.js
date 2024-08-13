import request from '@/utils/request'

// 查询教师信息列表
export function listTeachers(query) {
  return request({
    url: '/manage/teachers/list',
    method: 'get',
    params: query
  })
}

// 查询教师信息详细
export function getTeachers(id) {
  return request({
    url: '/manage/teachers/' + id,
    method: 'get'
  })
}

// 新增教师信息
export function addTeachers(data) {
  return request({
    url: '/manage/teachers',
    method: 'post',
    data: data
  })
}

// 修改教师信息
export function updateTeachers(data) {
  return request({
    url: '/manage/teachers',
    method: 'put',
    data: data
  })
}

// 删除教师信息
export function delTeachers(id) {
  return request({
    url: '/manage/teachers/' + id,
    method: 'delete'
  })
}
