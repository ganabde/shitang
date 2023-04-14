package com.canteen.system.service.impl;

import java.util.List;
import com.canteen.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.canteen.system.mapper.BusinessScoreMapper;
import com.canteen.system.domain.BusinessScore;
import com.canteen.system.service.IBusinessScoreService;

/**
 * 食堂评分信息Service业务层处理
 * 
 * @author xx
 * @date 2023-04-10
 */
@Service
public class BusinessScoreServiceImpl implements IBusinessScoreService 
{
    @Autowired
    private BusinessScoreMapper businessScoreMapper;

    /**
     * 查询食堂评分信息
     * 
     * @param ID 食堂评分信息主键
     * @return 食堂评分信息
     */
    @Override
    public BusinessScore selectBusinessScoreByID(Long ID)
    {
        return businessScoreMapper.selectBusinessScoreByID(ID);
    }

    /**
     * 查询食堂评分信息列表
     * 
     * @param businessScore 食堂评分信息
     * @return 食堂评分信息
     */
    @Override
    public List<BusinessScore> selectBusinessScoreList(BusinessScore businessScore)
    {
        return businessScoreMapper.selectBusinessScoreList(businessScore);
    }

    /**
     * 新增食堂评分信息
     * 
     * @param businessScore 食堂评分信息
     * @return 结果
     */
    @Override
    public int insertBusinessScore(BusinessScore businessScore)
    {
        businessScore.setCreateTime(DateUtils.getNowDate());
        return businessScoreMapper.insertBusinessScore(businessScore);
    }

    /**
     * 修改食堂评分信息
     * 
     * @param businessScore 食堂评分信息
     * @return 结果
     */
    @Override
    public int updateBusinessScore(BusinessScore businessScore)
    {
        return businessScoreMapper.updateBusinessScore(businessScore);
    }

    /**
     * 批量删除食堂评分信息
     * 
     * @param IDs 需要删除的食堂评分信息主键
     * @return 结果
     */
    @Override
    public int deleteBusinessScoreByIDs(Long[] IDs)
    {
        return businessScoreMapper.deleteBusinessScoreByIDs(IDs);
    }

    /**
     * 删除食堂评分信息信息
     * 
     * @param ID 食堂评分信息主键
     * @return 结果
     */
    @Override
    public int deleteBusinessScoreByID(Long ID)
    {
        return businessScoreMapper.deleteBusinessScoreByID(ID);
    }
}
