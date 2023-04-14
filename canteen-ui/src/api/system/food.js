import request from '@/utils/request'

// 查询菜品信息列表
export function listFood(query) {
  return request({
    url: '/system/food/list',
    method: 'get',
    params: query
  })
}

// 查询菜品信息详细
export function getFood(foodId) {
  return request({
    url: '/system/food/' + foodId,
    method: 'get'
  })
}

// 新增菜品信息
export function addFood(data) {
  return request({
    url: '/system/food',
    method: 'post',
    data: data
  })
}

// 修改菜品信息
export function updateFood(data) {
  return request({
    url: '/system/food',
    method: 'put',
    data: data
  })
}

// 删除菜品信息
export function delFood(foodId) {
  return request({
    url: '/system/food/' + foodId,
    method: 'delete'
  })
}

export function updateStatus(foodId) {
  return request({
    url: '/system/food/' + foodId,
    method: 'put'
  })
}
