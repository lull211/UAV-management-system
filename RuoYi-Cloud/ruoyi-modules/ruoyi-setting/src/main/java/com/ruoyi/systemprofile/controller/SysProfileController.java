package com.ruoyi.systemprofile.controller;

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
import com.ruoyi.systemprofile.domain.SysProfile;
import com.ruoyi.systemprofile.service.ISysProfileService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 系统设置Controller
 * 
 * @author ruoyi
 * @date 2021-10-11
 */
@RestController
@RequestMapping("/systemprofile")
public class SysProfileController extends BaseController
{
    @Autowired
    private ISysProfileService sysProfileService;

    /**
     * 查询系统设置列表
     */
    @PreAuthorize(hasPermi = "systemprofile:systemprofile:list")
    @GetMapping("/list")
    public TableDataInfo list(SysProfile sysProfile)
    {
        startPage();
        List<SysProfile> list = sysProfileService.selectSysProfileList(sysProfile);
        return getDataTable(list);
    }

    /**
     * 导出系统设置列表
     */
    @PreAuthorize(hasPermi = "systemprofile:systemprofile:export")
    @Log(title = "系统设置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysProfile sysProfile) throws IOException
    {
        List<SysProfile> list = sysProfileService.selectSysProfileList(sysProfile);
        ExcelUtil<SysProfile> util = new ExcelUtil<SysProfile>(SysProfile.class);
        util.exportExcel(response, list, "系统设置数据");
    }

    /**
     * 获取系统设置详细信息
     */
    @PreAuthorize(hasPermi = "systemprofile:systemprofile:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysProfileService.selectSysProfileById(id));
    }

    /**
     * 新增系统设置
     */
    @PreAuthorize(hasPermi = "systemprofile:systemprofile:add")
    @Log(title = "系统设置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysProfile sysProfile)
    {
        return toAjax(sysProfileService.insertSysProfile(sysProfile));
    }

    /**
     * 修改系统设置
     */
    @PreAuthorize(hasPermi = "systemprofile:systemprofile:edit")
    @Log(title = "系统设置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysProfile sysProfile)
    {
        return toAjax(sysProfileService.updateSysProfile(sysProfile));
    }

    /**
     * 删除系统设置
     */
    @PreAuthorize(hasPermi = "systemprofile:systemprofile:remove")
    @Log(title = "系统设置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysProfileService.deleteSysProfileByIds(ids));
    }
}
