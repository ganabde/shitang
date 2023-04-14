package com.canteen.system.service;

import java.util.List;
import com.canteen.system.domain.BusinessScore;

/**
 * 食堂评分信息Service接口
 * 
 * @author xx
 * @date 2023-04-10
 */
public interface IBusinessScoreService 
{
    /**
     * 查询食堂评分信息
     * 
     * @param ID 食堂评分信息主键
     * @return 食堂评分信息
     */
    public BusinessScore selectBusinessScoreByID(Long ID);

    /**
     * 查询食堂评分信息列表
     * 
     * @param businessScore 食堂评分信息
     * @return 食堂评分信息集合
     */
    public List<BusinessScore> selectBusinessScoreList(BusinessScore businessScore);

    /**
     * 新增食堂评分信息
     * 
     * @param businessScore 食堂评分信息
     * @return 结果
     */
    public int insertBusinessScore(BusinessScore businessScore);

    /**
     * 修改食堂评分信息
     * 
     * @param businessScore 食堂评分信息
     * @return 结果
     */
    public int updateBusinessScore(BusinessScore businessScore);

    /**
     * 批量删除食堂评分信息
     * 
     * @param IDs 需要删除的食堂评分信息主键集合
     * @return 结果
     */
    public int deleteBusinessScoreByIDs(Long[] IDs);

    /**
     * 删除食堂评分信息信息
     * 
     * @param ID 食堂评分信息主键
     * @return 结果
     */
    public int deleteBusinessScoreByID(Long ID);
}
