package com.canteen.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.canteen.system.mapper.FoodScoreMapper;
import com.canteen.system.domain.FoodScore;
import com.canteen.system.service.IFoodScoreService;

/**
 * 菜品评分信息Service业务层处理
 * 
 * @author xx
 * @date 2023-04-14
 */
@Service
public class FoodScoreServiceImpl implements IFoodScoreService 
{
    @Autowired
    private FoodScoreMapper foodScoreMapper;

    /**
     * 查询菜品评分信息
     * 
     * @param ID 菜品评分信息主键
     * @return 菜品评分信息
     */
    @Override
    public FoodScore selectFoodScoreByID(Long ID)
    {
        return foodScoreMapper.selectFoodScoreByID(ID);
    }

    /**
     * 查询菜品评分信息列表
     * 
     * @param foodScore 菜品评分信息
     * @return 菜品评分信息
     */
    @Override
    public List<FoodScore> selectFoodScoreList(FoodScore foodScore)
    {
        return foodScoreMapper.selectFoodScoreList(foodScore);
    }

    /**
     * 新增菜品评分信息
     * 
     * @param foodScore 菜品评分信息
     * @return 结果
     */
    @Override
    public int insertFoodScore(FoodScore foodScore)
    {
        return foodScoreMapper.insertFoodScore(foodScore);
    }

    /**
     * 修改菜品评分信息
     * 
     * @param foodScore 菜品评分信息
     * @return 结果
     */
    @Override
    public int updateFoodScore(FoodScore foodScore)
    {
        return foodScoreMapper.updateFoodScore(foodScore);
    }

    /**
     * 批量删除菜品评分信息
     * 
     * @param IDs 需要删除的菜品评分信息主键
     * @return 结果
     */
    @Override
    public int deleteFoodScoreByIDs(Long[] IDs)
    {
        return foodScoreMapper.deleteFoodScoreByIDs(IDs);
    }

    /**
     * 删除菜品评分信息信息
     * 
     * @param ID 菜品评分信息主键
     * @return 结果
     */
    @Override
    public int deleteFoodScoreByID(Long ID)
    {
        return foodScoreMapper.deleteFoodScoreByID(ID);
    }
}
