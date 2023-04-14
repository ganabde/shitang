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
import com.canteen.system.domain.Msg;
import com.canteen.system.service.IMsgService;
import com.canteen.common.utils.poi.ExcelUtil;
import com.canteen.common.core.page.TableDataInfo;

/**
 * 留言Controller
 * 
 * @author xx
 * @date 2023-04-09
 */
@RestController
@RequestMapping("/system/msg")
public class MsgController extends BaseController
{
    @Autowired
    private IMsgService msgService;

    /**
     * 查询留言列表
     */
    @PreAuthorize("@ss.hasPermi('system:msg:list')")
    @GetMapping("/list")
    public TableDataInfo list(Msg msg)
    {
        startPage();
        List<Msg> list = msgService.selectMsgList(msg);
        return getDataTable(list);
    }

    /**
     * 导出留言列表
     */
    @PreAuthorize("@ss.hasPermi('system:msg:export')")
    @Log(title = "留言", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Msg msg)
    {
        List<Msg> list = msgService.selectMsgList(msg);
        ExcelUtil<Msg> util = new ExcelUtil<Msg>(Msg.class);
        util.exportExcel(response, list, "留言数据");
    }

    /**
     * 获取留言详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:msg:query')")
    @GetMapping(value = "/{msgId}")
    public AjaxResult getInfo(@PathVariable("msgId") Long msgId)
    {
        return success(msgService.selectMsgByMsgId(msgId));
    }

    /**
     * 新增留言
     */
    @PreAuthorize("@ss.hasPermi('system:msg:add')")
    @Log(title = "留言", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Msg msg)
    {
        return toAjax(msgService.insertMsg(msg));
    }

    /**
     * 修改留言
     */
    @PreAuthorize("@ss.hasPermi('system:msg:edit')")
    @Log(title = "留言", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Msg msg)
    {
        return toAjax(msgService.updateMsg(msg));
    }

    /**
     * 删除留言
     */
    @PreAuthorize("@ss.hasPermi('system:msg:remove')")
    @Log(title = "留言", businessType = BusinessType.DELETE)
	@DeleteMapping("/{msgIds}")
    public AjaxResult remove(@PathVariable Long[] msgIds)
    {
        return toAjax(msgService.deleteMsgByMsgIds(msgIds));
    }
}
