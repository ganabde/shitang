package com.canteen.system.service;

import java.util.List;
import com.canteen.system.domain.Food;

/**
 * 菜品信息Service接口
 * 
 * @author xx
 * @date 2023-04-08
 */
public interface IFoodService 
{
    /**
     * 查询菜品信息
     * 
     * @param foodId 菜品信息主键
     * @return 菜品信息
     */
    public Food selectFoodByFoodId(Long foodId);

    List<Food> getFoodList(Food food);

    /**
     * 查询菜品信息列表
     * 
     * @param food 菜品信息
     * @return 菜品信息集合
     */
    public List<Food> selectFoodList(Food food);

    /**
     * 新增菜品信息
     * 
     * @param food 菜品信息
     * @return 结果
     */
    public int insertFood(Food food);

    /**
     * 修改菜品信息
     * 
     * @param food 菜品信息
     * @return 结果
     */
    public int updateFood(Food food);

    /**
     * 批量删除菜品信息
     * 
     * @param foodIds 需要删除的菜品信息主键集合
     * @return 结果
     */
    public int deleteFoodByFoodIds(Long[] foodIds);

    /**
     *  审核
     * @param foodIds
     * @return
     */
    int updateStatus(Long[] foodIds);

    /**
     * 删除菜品信息信息
     * 
     * @param foodId 菜品信息主键
     * @return 结果
     */
    public int deleteFoodByFoodId(Long foodId);
}
