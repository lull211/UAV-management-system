package com.ruoyi.uav.controller;

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
import com.ruoyi.uav.domain.UavTable;
import com.ruoyi.uav.service.IUavTableService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 无人机信息管理Controller
 * 
 * @author ruoyi
 * @date 2021-10-08
 */
@RestController
@RequestMapping("/uav_manage")
public class UavTableController extends BaseController
{
    @Autowired
    private IUavTableService uavTableService;

    /**
     * 查询无人机信息管理列表
     */
    @PreAuthorize(hasPermi = "uav:uav_manage:list")
    @GetMapping("/list")
    public TableDataInfo list(UavTable uavTable)
    {
        startPage();
        List<UavTable> list = uavTableService.selectUavTableList(uavTable);
        return getDataTable(list);
    }

    /**
     * 导出无人机信息管理列表
     */
    @PreAuthorize(hasPermi = "uav:uav_manage:export")
    @Log(title = "无人机信息管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UavTable uavTable) throws IOException
    {
        List<UavTable> list = uavTableService.selectUavTableList(uavTable);
        ExcelUtil<UavTable> util = new ExcelUtil<UavTable>(UavTable.class);
        util.exportExcel(response, list, "无人机信息管理数据");
    }

    /**
     * 获取无人机信息管理详细信息
     */
    @PreAuthorize(hasPermi = "uav:uav_manage:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(uavTableService.selectUavTableById(id));
    }

    /**
     * 通过飞控编号获取无人机信息管理详细信息
     */
    @PreAuthorize(hasPermi = "uav:uav_manage:query")
    @GetMapping(value = "/FlightNumber/{uavFlightNumber}")
    public AjaxResult getInfoByFlightNumber(@PathVariable("uavFlightNumber") String uavFlightNumber)
    {
        return AjaxResult.success(uavTableService.selectUavTableByuavFlightNumber(uavFlightNumber));
    }

    /**
     * 新增无人机信息管理
     */
    @PreAuthorize(hasPermi = "uav:uav_manage:add")
    @Log(title = "无人机信息管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UavTable uavTable)
    {
        return toAjax(uavTableService.insertUavTable(uavTable));
    }

    /**
     * 修改无人机信息管理
     */
    @PreAuthorize(hasPermi = "uav:uav_manage:edit")
    @Log(title = "无人机信息管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UavTable uavTable)
    {
        return toAjax(uavTableService.updateUavTable(uavTable));
    }

    /**
     * 删除无人机信息管理
     */
    @PreAuthorize(hasPermi = "uav:uav_manage:remove")
    @Log(title = "无人机信息管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uavTableService.deleteUavTableByIds(ids));
    }
}
