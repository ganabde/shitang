package com.canteen.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.canteen.common.annotation.Log;
import com.canteen.common.core.controller.BaseController;
import com.canteen.common.core.domain.AjaxResult;
import com.canteen.common.enums.BusinessType;
import com.canteen.system.domain.Food;
import com.canteen.system.service.IFoodService;
import com.canteen.common.utils.poi.ExcelUtil;
import com.canteen.common.core.page.TableDataInfo;

/**
 * 菜品信息Controller
 * 
 * @author xx
 * @date 2023-04-08
 */
@RestController
@RequestMapping("/system/food")
public class FoodController extends BaseController
{
    @Autowired
    private IFoodService foodService;

    /**
     * 查询菜品信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:food:list')")
    @GetMapping("/list")
    public TableDataInfo list(Food food)
    {
        startPage();
        List<Food> list = foodService.selectFoodList(food);
        return getDataTable(list);
    }

    /**
     * 前台获取list
     * @return
     */
    @GetMapping("/getList")
    public TableDataInfo getList(Food food)
    {
        startPage();
        return getDataTable(foodService.getFoodList(food));
    }

    /**
     * 导出菜品信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:food:export')")
    @Log(title = "菜品信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Food food)
    {
        List<Food> list = foodService.selectFoodList(food);
        ExcelUtil<Food> util = new ExcelUtil<Food>(Food.class);
        util.exportExcel(response, list, "菜品信息数据");
    }

    /**
     * 获取菜品信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:food:query')")
    @GetMapping(value = "/{foodId}")
    public AjaxResult getInfo(@PathVariable("foodId") Long foodId)
    {
        return success(foodService.selectFoodByFoodId(foodId));
    }

    /**
     * 新增菜品信息
     */
    @PreAuthorize("@ss.hasPermi('system:food:add')")
    @Log(title = "菜品信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Food food)
    {
        food.setBusinessName(getUsername());
        food.setBusinessId(getUserId());
        food.setFoodStatus("0");
        return toAjax(foodService.insertFood(food));
    }

    /**
     * 修改菜品信息
     */
    @PreAuthorize("@ss.hasPermi('system:food:edit')")
    @Log(title = "菜品信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Food food)
    {
        return toAjax(foodService.updateFood(food));
    }

    /**
     * 删除菜品信息
     */
    @PreAuthorize("@ss.hasPermi('system:food:remove')")
    @Log(title = "菜品信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{foodIds}")
    public AjaxResult remove(@PathVariable Long[] foodIds)
    {
        return toAjax(foodService.deleteFoodByFoodIds(foodIds));
    }

    /**
     * 菜品信息审核
     */
    @PreAuthorize("@ss.hasPermi('system:food:check')")
    @Log(title = "菜品信息", businessType = BusinessType.UPDATE)
    @PutMapping("/{foodIds}")
    public AjaxResult check(@PathVariable Long[] foodIds)
    {
        return toAjax(foodService.updateStatus(foodIds));
    }


}
