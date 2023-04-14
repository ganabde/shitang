package com.canteen.system.service;

import java.util.List;
import com.canteen.system.domain.Business;

/**
 * 商家信息Service接口
 * 
 * @author xx
 * @date 2023-04-09
 */
public interface IBusinessService 
{
    /**
     * 查询商家信息
     * 
     * @param businessId 商家信息主键
     * @return 商家信息
     */
    public Business selectBusinessByBusinessId(Long businessId);

    /**
     * 查询商家信息列表
     * 
     * @param business 商家信息
     * @return 商家信息集合
     */
    public List<Business> selectBusinessList(Business business);

    /**
     * 新增商家信息
     * 
     * @param business 商家信息
     * @return 结果
     */
    public int insertBusiness(Business business);

    /**
     * 修改商家信息
     * 
     * @param business 商家信息
     * @return 结果
     */
    public int updateBusiness(Business business);

    /**
     * 批量删除商家信息
     * 
     * @param businessIds 需要删除的商家信息主键集合
     * @return 结果
     */
    public int deleteBusinessByBusinessIds(Long[] businessIds);

    /**
     * 删除商家信息信息
     * 
     * @param businessId 商家信息主键
     * @return 结果
     */
    public int deleteBusinessByBusinessId(Long businessId);
}
