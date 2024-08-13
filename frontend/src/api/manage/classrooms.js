import request from '@/utils/request'

// 查询教室信息列表
export function listClassrooms(query) {
  return request({
    url: '/manage/classrooms/list',
    method: 'get',
    params: query
  })
}

// 查询教室信息详细
export function getClassrooms(id) {
  return request({
    url: '/manage/classrooms/' + id,
    method: 'get'
  })
}

// 新增教室信息
export function addClassrooms(data) {
  return request({
    url: '/manage/classrooms',
    method: 'post',
    data: data
  })
}

// 修改教室信息
export function updateClassrooms(data) {
  return request({
    url: '/manage/classrooms',
    method: 'put',
    data: data
  })
}

// 删除教室信息
export function delClassrooms(id) {
  return request({
    url: '/manage/classrooms/' + id,
    method: 'delete'
  })
}
