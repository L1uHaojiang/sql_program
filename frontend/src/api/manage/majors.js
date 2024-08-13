import request from '@/utils/request'

// 查询专业信息列表
export function listMajors(query) {
  return request({
    url: '/manage/majors/list',
    method: 'get',
    params: query
  })
}

// 查询专业信息详细
export function getMajors(id) {
  return request({
    url: '/manage/majors/' + id,
    method: 'get'
  })
}

// 新增专业信息
export function addMajors(data) {
  return request({
    url: '/manage/majors',
    method: 'post',
    data: data
  })
}

// 修改专业信息
export function updateMajors(data) {
  return request({
    url: '/manage/majors',
    method: 'put',
    data: data
  })
}

// 删除专业信息
export function delMajors(id) {
  return request({
    url: '/manage/majors/' + id,
    method: 'delete'
  })
}
