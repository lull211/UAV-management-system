package com.ruoyi.airline.controller;

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
import com.ruoyi.airline.domain.AirlineTable;
import com.ruoyi.airline.service.IAirlineTableService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 航线管理Controller
 *
 * @author ruoyi
 * @date 2021-10-03
 */
@RestController
@RequestMapping("/airline")
public class AirlineTableController extends BaseController
{
    @Autowired
    private IAirlineTableService airlineTableService;

    /**
     * 查询航线管理列表
     */
    @PreAuthorize(hasPermi = "airline:airline:list")
    @GetMapping("/list")
    public TableDataInfo list(AirlineTable airlineTable)
    {
        startPage();
        List<AirlineTable> list = airlineTableService.selectAirlineTableList(airlineTable);
        return getDataTable(list);
    }

    /**
     * 导出航线管理列表
     */
    @PreAuthorize(hasPermi = "airline:airline:export")
    @Log(title = "航线管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AirlineTable airlineTable) throws IOException
    {
        List<AirlineTable> list = airlineTableService.selectAirlineTableList(airlineTable);
        ExcelUtil<AirlineTable> util = new ExcelUtil<AirlineTable>(AirlineTable.class);
        util.exportExcel(response, list, "航线管理数据");
    }

    /**
     * 获取航线管理详细信息
     */
    @PreAuthorize(hasPermi = "airline:airline:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(airlineTableService.selectAirlineTableById(id));
    }

    /**
     * 新增航线管理
     */
    @PreAuthorize(hasPermi = "airline:airline:add")
    @Log(title = "航线管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AirlineTable airlineTable)
    {
        return toAjax(airlineTableService.insertAirlineTable(airlineTable));
    }

    /**
     * 修改航线管理
     */
    @PreAuthorize(hasPermi = "airline:airline:edit")
    @Log(title = "航线管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AirlineTable airlineTable)
    {
        return toAjax(airlineTableService.updateAirlineTable(airlineTable));
    }

    /**
     * 删除航线管理
     */
    @PreAuthorize(hasPermi = "airline:airline:remove")
    @Log(title = "航线管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(airlineTableService.deleteAirlineTableByIds(ids));
    }
}