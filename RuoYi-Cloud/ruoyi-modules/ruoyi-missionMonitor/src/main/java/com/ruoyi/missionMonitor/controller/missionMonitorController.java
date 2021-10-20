package com.ruoyi.missionMonitor.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.PreAuthorize;
import com.ruoyi.missionMonitor.domain.missionMonitor;
import com.ruoyi.missionMonitor.service.ImissionMonitorService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 无人机信息管理Controller
 * 
 * @author ruoyi
 * @date 2021-10-20
 */
@RestController
@RequestMapping("/missionMonitor")
public class missionMonitorController extends BaseController
{
    @Autowired
    private ImissionMonitorService missionMonitorService;

    /**
     * 查询无人机信息管理列表
     */
    @PreAuthorize(hasPermi = "missionMonitor:missionMonitor:list")
    @GetMapping("/list")
    public TableDataInfo list(missionMonitor missionMonitor)
    {
        startPage();
        List<missionMonitor> list = missionMonitorService.selectmissionMonitorList(missionMonitor);
        return getDataTable(list);
    }

    /**
     * 导出无人机信息管理列表
     */
    @PreAuthorize(hasPermi = "missionMonitor:missionMonitor:export")
    @Log(title = "无人机信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, missionMonitor missionMonitor) throws IOException
    {
        List<missionMonitor> list = missionMonitorService.selectmissionMonitorList(missionMonitor);
        ExcelUtil<missionMonitor> util = new ExcelUtil<missionMonitor>(missionMonitor.class);
        util.exportExcel(response, list, "无人机信息管理数据");
    }

    /**
     * 获取无人机信息管理详细信息
     */
    @PreAuthorize(hasPermi = "missionMonitor:missionMonitor:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(missionMonitorService.selectmissionMonitorById(id));
    }

    /**
     * 新增无人机信息管理
     */
    @PreAuthorize(hasPermi = "missionMonitor:missionMonitor:add")
    @Log(title = "无人机信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody missionMonitor missionMonitor)
    {
        return toAjax(missionMonitorService.insertmissionMonitor(missionMonitor));
    }

    /**
     * 修改无人机信息管理
     */
    @PreAuthorize(hasPermi = "missionMonitor:missionMonitor:edit")
    @Log(title = "无人机信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody missionMonitor missionMonitor)
    {
        return toAjax(missionMonitorService.updatemissionMonitor(missionMonitor));
    }

    /**
     * 删除无人机信息管理
     */
    @PreAuthorize(hasPermi = "missionMonitor:missionMonitor:remove")
    @Log(title = "无人机信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(missionMonitorService.deletemissionMonitorByIds(ids));
    }
}
