package com.ruoyi.uavdepartment.controller;

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
import com.ruoyi.uavdepartment.domain.UavDepartment;
import com.ruoyi.uavdepartment.service.IUavDepartmentService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 无人机归口部门Controller
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
@RestController
@RequestMapping("/uavdepartment")
public class UavDepartmentController extends BaseController
{
    @Autowired
    private IUavDepartmentService uavDepartmentService;

    /**
     * 查询无人机归口部门列表
     */
    @PreAuthorize(hasPermi = "uavdepartment:uavdepartment:list")
    @GetMapping("/list")
    public TableDataInfo list(UavDepartment uavDepartment)
    {
        startPage();
        List<UavDepartment> list = uavDepartmentService.selectUavDepartmentList(uavDepartment);
        return getDataTable(list);
    }

    /**
     * 导出无人机归口部门列表
     */
    @PreAuthorize(hasPermi = "uavdepartment:uavdepartment:export")
    @Log(title = "无人机归口部门", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UavDepartment uavDepartment) throws IOException
    {
        List<UavDepartment> list = uavDepartmentService.selectUavDepartmentList(uavDepartment);
        ExcelUtil<UavDepartment> util = new ExcelUtil<UavDepartment>(UavDepartment.class);
        util.exportExcel(response, list, "无人机归口部门数据");
    }

    /**
     * 获取无人机归口部门详细信息
     */
    @PreAuthorize(hasPermi = "uavdepartment:uavdepartment:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(uavDepartmentService.selectUavDepartmentById(id));
    }

    /**
     * 新增无人机归口部门
     */
    @PreAuthorize(hasPermi = "uavdepartment:uavdepartment:add")
    @Log(title = "无人机归口部门", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UavDepartment uavDepartment)
    {
        return toAjax(uavDepartmentService.insertUavDepartment(uavDepartment));
    }

    /**
     * 修改无人机归口部门
     */
    @PreAuthorize(hasPermi = "uavdepartment:uavdepartment:edit")
    @Log(title = "无人机归口部门", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UavDepartment uavDepartment)
    {
        return toAjax(uavDepartmentService.updateUavDepartment(uavDepartment));
    }

    /**
     * 删除无人机归口部门
     */
    @PreAuthorize(hasPermi = "uavdepartment:uavdepartment:remove")
    @Log(title = "无人机归口部门", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uavDepartmentService.deleteUavDepartmentByIds(ids));
    }
}
