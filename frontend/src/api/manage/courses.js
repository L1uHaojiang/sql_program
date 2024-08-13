import request from '@/utils/request'

// 查询课程信息列表
export function listCourses(query) {
  return request({
    url: '/manage/courses/list',
    method: 'get',
    params: query
  })
}

// 查询课程信息详细
export function getCourses(id) {
  return request({
    url: '/manage/courses/' + id,
    method: 'get'
  })
}

// 新增课程信息
export function addCourses(data) {
  return request({
    url: '/manage/courses',
    method: 'post',
    data: data
  })
}

// 修改课程信息
export function updateCourses(data) {
  return request({
    url: '/manage/courses',
    method: 'put',
    data: data
  })
}

// 删除课程信息
export function delCourses(id) {
  return request({
    url: '/manage/courses/' + id,
    method: 'delete'
  })
}
