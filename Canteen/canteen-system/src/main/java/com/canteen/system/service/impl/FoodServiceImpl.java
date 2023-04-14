package com.canteen.system.service.impl;

import java.util.List;

import com.canteen.common.annotation.DataScope;
import com.canteen.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.canteen.system.mapper.FoodMapper;
import com.canteen.system.domain.Food;
import com.canteen.system.service.IFoodService;

/**
 * 菜品信息Service业务层处理
 * 
 * @author xx
 * @date 2023-04-08
 */
@Service
public class FoodServiceImpl implements IFoodService 
{
    @Autowired
    private FoodMapper foodMapper;

    /**
     * 查询菜品信息
     * 
     * @param foodId 菜品信息主键
     * @return 菜品信息
     */
    @Override
    public Food selectFoodByFoodId(Long foodId)
    {
        return foodMapper.selectFoodByFoodId(foodId);
    }

    @Override
    public List<Food> getFoodList(Food food) {
        return foodMapper.getFoodList(food);
    }

    /**
     * 查询菜品信息列表
     * 
     * @param food 菜品信息
     * @return 菜品信息
     */
    @Override
    @DataScope(userAlias = "u")
    public List<Food> selectFoodList(Food food)
    {
        return foodMapper.selectFoodList(food);
    }

    /**
     * 新增菜品信息
     * 
     * @param food 菜品信息
     * @return 结果
     */
    @Override
    public int insertFood(Food food)
    {
        food.setCreateTime(DateUtils.getNowDate());
        return foodMapper.insertFood(food);
    }

    /**
     * 修改菜品信息
     * 
     * @param food 菜品信息
     * @return 结果
     */
    @Override
    public int updateFood(Food food)
    {
        food.setUpdateTime(DateUtils.getNowDate());
        return foodMapper.updateFood(food);
    }

    /**
     * 批量删除菜品信息
     * 
     * @param foodIds 需要删除的菜品信息主键
     * @return 结果
     */
    @Override
    public int deleteFoodByFoodIds(Long[] foodIds)
    {
        return foodMapper.deleteFoodByFoodIds(foodIds);
    }

    @Override
    public int updateStatus(Long[] foodIds) {
        return foodMapper.updateStatus(foodIds);
    }

    /**
     * 删除菜品信息信息
     * 
     * @param foodId 菜品信息主键
     * @return 结果
     */
    @Override
    public int deleteFoodByFoodId(Long foodId)
    {
        return foodMapper.deleteFoodByFoodId(foodId);
    }


}
