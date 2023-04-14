package com.canteen.system.service.impl;

import java.util.List;

import com.canteen.common.core.domain.entity.SysUser;
import com.canteen.common.utils.SecurityUtils;
import com.canteen.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.canteen.system.mapper.BusinessMapper;
import com.canteen.system.domain.Business;
import com.canteen.system.service.IBusinessService;

/**
 * 商家信息Service业务层处理
 * 
 * @author xx
 * @date 2023-04-09
 */
@Service
public class BusinessServiceImpl implements IBusinessService 
{
    @Autowired
    private BusinessMapper businessMapper;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询商家信息
     * 
     * @param businessId 商家信息主键
     * @return 商家信息
     */
    @Override
    public Business selectBusinessByBusinessId(Long businessId)
    {
        return businessMapper.selectBusinessByBusinessId(businessId);
    }

    /**
     * 查询商家信息列表
     * 
     * @param business 商家信息
     * @return 商家信息
     */
    @Override
    public List<Business> selectBusinessList(Business business)
    {
        return businessMapper.selectBusinessList(business);
    }

    /**
     * 新增商家信息
     * 
     * @param business 商家信息
     * @return 结果
     */
    @Override
    public int insertBusiness(Business business)
    {
        SysUser user = new SysUser();
        user.setUserName(business.getPhonenumber());
        user.setNickName(business.getBusinessName());
        user.setPhonenumber(business.getPhonenumber());
        user.setDeptId(105L);
        user.setPassword(SecurityUtils.encryptPassword("123456"));
        user.setRoleIds(new Long[]{100L});
        userService.insertUser(user);
        business.setBusinessId(user.getUserId());
        return businessMapper.insertBusiness(business);
    }

    /**
     * 修改商家信息
     * 
     * @param business 商家信息
     * @return 结果
     */
    @Override
    public int updateBusiness(Business business)
    {
        return businessMapper.updateBusiness(business);
    }

    /**
     * 批量删除商家信息
     * 
     * @param businessIds 需要删除的商家信息主键
     * @return 结果
     */
    @Override
    public int deleteBusinessByBusinessIds(Long[] businessIds)
    {
        return businessMapper.deleteBusinessByBusinessIds(businessIds);
    }

    /**
     * 删除商家信息信息
     * 
     * @param businessId 商家信息主键
     * @return 结果
     */
    @Override
    public int deleteBusinessByBusinessId(Long businessId)
    {
        return businessMapper.deleteBusinessByBusinessId(businessId);
    }
}
