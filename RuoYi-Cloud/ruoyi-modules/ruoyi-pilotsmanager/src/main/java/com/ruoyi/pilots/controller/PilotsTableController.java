package com.ruoyi.pilots.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.PreAuthorize;
import com.ruoyi.pilots.domain.PilotsTable;
import com.ruoyi.pilots.service.IPilotsTableService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 驾驶员管理Controller
 * 
 * @author ruoyi
 * @date 2021-10-14
 */
@RestController
@RequestMapping("/pilots")
public class PilotsTableController extends BaseController
{
    @Autowired
    private IPilotsTableService pilotsTableService;

    /**
     * 查询驾驶员管理列表
     */
    @PreAuthorize(hasPermi = "pilots:pilots:query")
    @GetMapping("/list")
    public TableDataInfo list(PilotsTable pilotsTable)
    {
        startPage();
        List<PilotsTable> list = pilotsTableService.selectPilotsTableList(pilotsTable);
        return getDataTable(list);
    }

    /**
     * 导出驾驶员管理列表
     */
    @PreAuthorize(hasPermi = "pilots:pilots:export")
    @Log(title = "驾驶员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, PilotsTable pilotsTable) throws IOException
    {
        List<PilotsTable> list = pilotsTableService.selectPilotsTableList(pilotsTable);
        ExcelUtil<PilotsTable> util = new ExcelUtil<PilotsTable>(PilotsTable.class);
        util.exportExcel(response, list, "驾驶员管理数据");
    }

    /**
     * 获取驾驶员管理详细信息
     */
    @PreAuthorize(hasPermi = "pilots:pilots:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pilotsTableService.selectPilotsTableById(id));
    }

    /**
     * 用名字查询驾驶员管理详细信息
     */
    @PreAuthorize(hasPermi = "mymissionlist:mymissionlist:list")
    @GetMapping(value = "/name/{driverName}")
    public AjaxResult getInfoByName(@PathVariable("driverName") String driverName)
    {
        return AjaxResult.success(pilotsTableService.selectPilotsByName(driverName));
    }

    /**
     * 用名字模糊查询驾驶员管理详细信息
     */
    @PreAuthorize(hasPermi = "mymissionlist:mymissionlist:list")
    @GetMapping(value = "/namelike/{driverName}")
    public AjaxResult getInfoByNameLikely(@PathVariable("driverName") String driverName)
    {
        return AjaxResult.success(pilotsTableService.selectPilotsByNameLikely(driverName));
    }

    /**
     * 新增驾驶员管理
     */
    @PreAuthorize(hasPermi = "pilots:pilots:add")
    @Log(title = "驾驶员管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody PilotsTable pilotsTable)
    {
        return toAjax(pilotsTableService.insertPilotsTable(pilotsTable));
    }

    /**
     * 修改驾驶员管理
     */
    @PreAuthorize(hasPermi = "pilots:pilots:edit")
    @Log(title = "驾驶员管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody PilotsTable pilotsTable)
    {
        return toAjax(pilotsTableService.updatePilotsTable(pilotsTable));
    }

    /**
     * 删除驾驶员管理
     */
    @PreAuthorize(hasPermi = "pilots:pilots:remove")
    @Log(title = "驾驶员管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pilotsTableService.deletePilotsTableByIds(ids));
    }
}
