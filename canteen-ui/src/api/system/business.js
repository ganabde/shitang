import request from '@/utils/request'

// 查询商家信息列表
export function listBusiness(query) {
  return request({
    url: '/system/business/list',
    method: 'get',
    params: query
  })
}

// 查询商家信息详细
export function getBusiness(businessId) {
  return request({
    url: '/system/business/' + businessId,
    method: 'get'
  })
}

// 新增商家信息
export function addBusiness(data) {
  return request({
    url: '/system/business',
    method: 'post',
    data: data
  })
}

// 修改商家信息
export function updateBusiness(data) {
  return request({
    url: '/system/business',
    method: 'put',
    data: data
  })
}

// 删除商家信息
export function delBusiness(businessId) {
  return request({
    url: '/system/business/' + businessId,
    method: 'delete'
  })
}
