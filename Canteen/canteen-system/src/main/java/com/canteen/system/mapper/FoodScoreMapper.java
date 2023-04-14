package com.canteen.system.mapper;

import java.util.List;
import com.canteen.system.domain.FoodScore;

/**
 * 菜品评分信息Mapper接口
 * 
 * @author xx
 * @date 2023-04-14
 */
public interface FoodScoreMapper 
{
    /**
     * 查询菜品评分信息
     * 
     * @param ID 菜品评分信息主键
     * @return 菜品评分信息
     */
    public FoodScore selectFoodScoreByID(Long ID);

    /**
     * 查询菜品评分信息列表
     * 
     * @param foodScore 菜品评分信息
     * @return 菜品评分信息集合
     */
    public List<FoodScore> selectFoodScoreList(FoodScore foodScore);

    /**
     * 新增菜品评分信息
     * 
     * @param foodScore 菜品评分信息
     * @return 结果
     */
    public int insertFoodScore(FoodScore foodScore);

    /**
     * 修改菜品评分信息
     * 
     * @param foodScore 菜品评分信息
     * @return 结果
     */
    public int updateFoodScore(FoodScore foodScore);

    /**
     * 删除菜品评分信息
     * 
     * @param ID 菜品评分信息主键
     * @return 结果
     */
    public int deleteFoodScoreByID(Long ID);

    /**
     * 批量删除菜品评分信息
     * 
     * @param IDs 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFoodScoreByIDs(Long[] IDs);
}
