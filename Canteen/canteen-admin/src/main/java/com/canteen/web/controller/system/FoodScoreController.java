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
import com.canteen.system.domain.FoodScore;
import com.canteen.system.service.IFoodScoreService;
import com.canteen.common.utils.poi.ExcelUtil;
import com.canteen.common.core.page.TableDataInfo;

/**
 * 菜品评分信息Controller
 * 
 * @author xx
 * @date 2023-04-14
 */
@RestController
@RequestMapping("/system/foodscore")
public class FoodScoreController extends BaseController
{
    @Autowired
    private IFoodScoreService foodScoreService;

    /**
     * 查询菜品评分信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:foodscore:list')")
    @GetMapping("/list")
    public TableDataInfo list(FoodScore foodScore)
    {
        startPage();
        List<FoodScore> list = foodScoreService.selectFoodScoreList(foodScore);
        return getDataTable(list);
    }

    /**
     * 导出菜品评分信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:foodscore:export')")
    @Log(title = "菜品评分信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FoodScore foodScore)
    {
        List<FoodScore> list = foodScoreService.selectFoodScoreList(foodScore);
        ExcelUtil<FoodScore> util = new ExcelUtil<FoodScore>(FoodScore.class);
        util.exportExcel(response, list, "菜品评分信息数据");
    }

    /**
     * 获取菜品评分信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:foodscore:query')")
    @GetMapping(value = "/{ID}")
    public AjaxResult getInfo(@PathVariable("ID") Long ID)
    {
        return success(foodScoreService.selectFoodScoreByID(ID));
    }

    /**
     * 新增菜品评分信息
     */
    @PreAuthorize("@ss.hasPermi('system:foodscore:add')")
    @Log(title = "菜品评分信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FoodScore foodScore)
    {
        return toAjax(foodScoreService.insertFoodScore(foodScore));
    }

    /**
     * 修改菜品评分信息
     */
    @PreAuthorize("@ss.hasPermi('system:foodscore:edit')")
    @Log(title = "菜品评分信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FoodScore foodScore)
    {
        return toAjax(foodScoreService.updateFoodScore(foodScore));
    }

    /**
     * 删除菜品评分信息
     */
    @PreAuthorize("@ss.hasPermi('system:foodscore:remove')")
    @Log(title = "菜品评分信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{IDs}")
    public AjaxResult remove(@PathVariable Long[] IDs)
    {
        return toAjax(foodScoreService.deleteFoodScoreByIDs(IDs));
    }
}
