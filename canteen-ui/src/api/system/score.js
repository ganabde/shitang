import request from '@/utils/request'

// 查询食堂评分信息列表
export function listScore(query) {
  return request({
    url: '/system/score/list',
    method: 'get',
    params: query
  })
}

// 查询食堂评分信息详细
export function getScore(ID) {
  return request({
    url: '/system/score/' + ID,
    method: 'get'
  })
}

// 新增食堂评分信息
export function addScore(data) {
  return request({
    url: '/system/score',
    method: 'post',
    data: data
  })
}

// 修改食堂评分信息
export function updateScore(data) {
  return request({
    url: '/system/score',
    method: 'put',
    data: data
  })
}

// 删除食堂评分信息
export function delScore(ID) {
  return request({
    url: '/system/score/' + ID,
    method: 'delete'
  })
}
