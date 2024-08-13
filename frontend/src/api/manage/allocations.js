import request from '@/utils/request'

// 查询教室分配列表
export function listAllocations(query) {
  return request({
    url: '/manage/allocations/list',
    method: 'get',
    params: query
  })
}

// 查询教室分配详细
export function getAllocations(id) {
  return request({
    url: '/manage/allocations/' + id,
    method: 'get'
  })
}

// 新增教室分配
export function addAllocations(data) {
  return request({
    url: '/manage/allocations',
    method: 'post',
    data: data
  })
}

// 修改教室分配
export function updateAllocations(data) {
  return request({
    url: '/manage/allocations',
    method: 'put',
    data: data
  })
}

// 删除教室分配
export function delAllocations(id) {
  return request({
    url: '/manage/allocations/' + id,
    method: 'delete'
  })
}
