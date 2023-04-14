import request from '@/utils/request'

// 查询菜品评分信息列表
export function listFoodscore(query) {
  return request({
    url: '/system/foodscore/list',
    method: 'get',
    params: query
  })
}

// 查询菜品评分信息详细
export function getFoodscore(ID) {
  return request({
    url: '/system/foodscore/' + ID,
    method: 'get'
  })
}

// 新增菜品评分信息
export function addFoodscore(data) {
  return request({
    url: '/system/foodscore',
    method: 'post',
    data: data
  })
}

// 修改菜品评分信息
export function updateFoodscore(data) {
  return request({
    url: '/system/foodscore',
    method: 'put',
    data: data
  })
}

// 删除菜品评分信息
export function delFoodscore(ID) {
  return request({
    url: '/system/foodscore/' + ID,
    method: 'delete'
  })
}
