package com.ruoyi.uavtype.controller;

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
import com.ruoyi.uavtype.domain.UavType;
import com.ruoyi.uavtype.service.IUavTypeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * uavtypeController
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
@RestController
@RequestMapping("/uavtype")
public class UavTypeController extends BaseController
{
    @Autowired
    private IUavTypeService uavTypeService;

    /**
     * 查询uavtype列表
     */
    @PreAuthorize(hasPermi = "uavtype:uavtype:list")
    @GetMapping("/list")
    public TableDataInfo list(UavType uavType)
    {
        startPage();
        List<UavType> list = uavTypeService.selectUavTypeList(uavType);
        return getDataTable(list);
    }

    /**
     * 导出uavtype列表
     */
    @PreAuthorize(hasPermi = "uavtype:uavtype:export")
    @Log(title = "uavtype", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UavType uavType) throws IOException
    {
        List<UavType> list = uavTypeService.selectUavTypeList(uavType);
        ExcelUtil<UavType> util = new ExcelUtil<UavType>(UavType.class);
        util.exportExcel(response, list, "uavtype数据");
    }

    /**
     * 获取uavtype详细信息
     */
    @PreAuthorize(hasPermi = "uavtype:uavtype:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(uavTypeService.selectUavTypeById(id));
    }

    /**
     * 新增uavtype
     */
    @PreAuthorize(hasPermi = "uavtype:uavtype:add")
    @Log(title = "uavtype", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UavType uavType)
    {
        return toAjax(uavTypeService.insertUavType(uavType));
    }

    /**
     * 修改uavtype
     */
    @PreAuthorize(hasPermi = "uavtype:uavtype:edit")
    @Log(title = "uavtype", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UavType uavType)
    {
        return toAjax(uavTypeService.updateUavType(uavType));
    }

    /**
     * 删除uavtype
     */
    @PreAuthorize(hasPermi = "uavtype:uavtype:remove")
    @Log(title = "uavtype", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uavTypeService.deleteUavTypeByIds(ids));
    }
}
