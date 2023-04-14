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
import com.canteen.system.domain.BusinessScore;
import com.canteen.system.service.IBusinessScoreService;
import com.canteen.common.utils.poi.ExcelUtil;
import com.canteen.common.core.page.TableDataInfo;

/**
 * 食堂评分信息Controller
 * 
 * @author xx
 * @date 2023-04-10
 */
@RestController
@RequestMapping("/system/score")
public class BusinessScoreController extends BaseController
{
    @Autowired
    private IBusinessScoreService businessScoreService;

    /**
     * 查询食堂评分信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:score:list')")
    @GetMapping("/list")
    public TableDataInfo list(BusinessScore businessScore)
    {
        startPage();
        List<BusinessScore> list = businessScoreService.selectBusinessScoreList(businessScore);
        return getDataTable(list);
    }

    /**
     * 导出食堂评分信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:score:export')")
    @Log(title = "食堂评分信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BusinessScore businessScore)
    {
        List<BusinessScore> list = businessScoreService.selectBusinessScoreList(businessScore);
        ExcelUtil<BusinessScore> util = new ExcelUtil<BusinessScore>(BusinessScore.class);
        util.exportExcel(response, list, "食堂评分信息数据");
    }

    /**
     * 获取食堂评分信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:score:query')")
    @GetMapping(value = "/{ID}")
    public AjaxResult getInfo(@PathVariable("ID") Long ID)
    {
        return success(businessScoreService.selectBusinessScoreByID(ID));
    }

    /**
     * 新增食堂评分信息
     */
    @PreAuthorize("@ss.hasPermi('system:score:add')")
    @Log(title = "食堂评分信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BusinessScore businessScore)
    {
        return toAjax(businessScoreService.insertBusinessScore(businessScore));
    }

    /**
     * 修改食堂评分信息
     */
    @PreAuthorize("@ss.hasPermi('system:score:edit')")
    @Log(title = "食堂评分信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BusinessScore businessScore)
    {
        return toAjax(businessScoreService.updateBusinessScore(businessScore));
    }

    /**
     * 删除食堂评分信息
     */
    @PreAuthorize("@ss.hasPermi('system:score:remove')")
    @Log(title = "食堂评分信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{IDs}")
    public AjaxResult remove(@PathVariable Long[] IDs)
    {
        return toAjax(businessScoreService.deleteBusinessScoreByIDs(IDs));
    }
}
