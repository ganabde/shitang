package com.canteen.web.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.canteen.system.mapper.BusinessMapper;
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
import com.canteen.system.domain.Business;
import com.canteen.system.service.IBusinessService;
import com.canteen.common.utils.poi.ExcelUtil;
import com.canteen.common.core.page.TableDataInfo;

/**
 * 商家信息Controller
 * 
 * @author xx
 * @date 2023-04-09
 */
@RestController
@RequestMapping("/system/business")
public class BusinessController extends BaseController
{
    @Autowired
    private IBusinessService businessService;

    @Autowired
    private BusinessMapper mapper;

    /**
     * 查询商家信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:business:list')")
    @GetMapping("/list")
    public TableDataInfo list(Business business)
    {
        startPage();
        List<Business> list = businessService.selectBusinessList(business);
        return getDataTable(list);
    }

    @GetMapping("/getList")
    public TableDataInfo getList(Business business)
    {
        startPage();
        List<Business> list = mapper.getList(business);
        return getDataTable(list);
    }

    /**
     * 导出商家信息列表
     */
    @PreAuthorize("@ss.hasPermi('system:business:export')")
    @Log(title = "商家信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Business business)
    {
        List<Business> list = businessService.selectBusinessList(business);
        ExcelUtil<Business> util = new ExcelUtil<Business>(Business.class);
        util.exportExcel(response, list, "商家信息数据");
    }

    /**
     * 获取商家信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:business:query')")
    @GetMapping(value = "/{businessId}")
    public AjaxResult getInfo(@PathVariable("businessId") Long businessId)
    {
        return success(businessService.selectBusinessByBusinessId(businessId));
    }

    /**
     * 新增商家信息
     */
    @PreAuthorize("@ss.hasPermi('system:business:add')")
    @Log(title = "商家信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Business business)
    {
        return toAjax(businessService.insertBusiness(business));
    }

    /**
     * 修改商家信息
     */
    @PreAuthorize("@ss.hasPermi('system:business:edit')")
    @Log(title = "商家信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Business business)
    {
        return toAjax(businessService.updateBusiness(business));
    }

    /**
     * 删除商家信息
     */
    @PreAuthorize("@ss.hasPermi('system:business:remove')")
    @Log(title = "商家信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{businessIds}")
    public AjaxResult remove(@PathVariable Long[] businessIds)
    {
        return toAjax(businessService.deleteBusinessByBusinessIds(businessIds));
    }
}
