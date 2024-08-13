import request from '@/utils/request'

// 查询学院信息列表
export function listDepartments(query) {
  return request({
    url: '/manage/departments/list',
    method: 'get',
    params: query
  })
}

// 查询学院信息详细
export function getDepartments(id) {
  return request({
    url: '/manage/departments/' + id,
    method: 'get'
  })
}

// 新增学院信息
export function addDepartments(data) {
  return request({
    url: '/manage/departments',
    method: 'post',
    data: data
  })
}

// 修改学院信息
export function updateDepartments(data) {
  return request({
    url: '/manage/departments',
    method: 'put',
    data: data
  })
}

// 删除学院信息
export function delDepartments(id) {
  return request({
    url: '/manage/departments/' + id,
    method: 'delete'
  })
}
