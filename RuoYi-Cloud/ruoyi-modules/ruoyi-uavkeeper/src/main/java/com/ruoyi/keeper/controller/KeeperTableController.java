package com.ruoyi.keeper.controller;

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
import com.ruoyi.keeper.domain.KeeperTable;
import com.ruoyi.keeper.service.IKeeperTableService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 保管员管理Controller
 * 
 * @author ruoyi
 * @date 2021-10-08
 */
@RestController
@RequestMapping("/keeper")
public class KeeperTableController extends BaseController
{
    @Autowired
    private IKeeperTableService keeperTableService;

    /**
     * 查询保管员管理列表
     */
    @PreAuthorize(hasPermi = "keeper:keeper:list")
    @GetMapping("/list")
    public TableDataInfo list(KeeperTable keeperTable)
    {
        startPage();
        List<KeeperTable> list = keeperTableService.selectKeeperTableList(keeperTable);
        return getDataTable(list);
    }

    /**
     * 导出保管员管理列表
     */
    @PreAuthorize(hasPermi = "keeper:keeper:export")
    @Log(title = "保管员管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, KeeperTable keeperTable) throws IOException
    {
        List<KeeperTable> list = keeperTableService.selectKeeperTableList(keeperTable);
        ExcelUtil<KeeperTable> util = new ExcelUtil<KeeperTable>(KeeperTable.class);
        util.exportExcel(response, list, "保管员管理数据");
    }

    /**
     * 获取保管员管理详细信息
     */
    @PreAuthorize(hasPermi = "keeper:keeper:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(keeperTableService.selectKeeperTableById(id));
    }

    /**
     * 新增保管员管理
     */
    @PreAuthorize(hasPermi = "keeper:keeper:add")
    @Log(title = "保管员管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody KeeperTable keeperTable)
    {
        return toAjax(keeperTableService.insertKeeperTable(keeperTable));
    }

    /**
     * 修改保管员管理
     */
    @PreAuthorize(hasPermi = "keeper:keeper:edit")
    @Log(title = "保管员管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody KeeperTable keeperTable)
    {
        return toAjax(keeperTableService.updateKeeperTable(keeperTable));
    }

    /**
     * 删除保管员管理
     */
    @PreAuthorize(hasPermi = "keeper:keeper:remove")
    @Log(title = "保管员管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(keeperTableService.deleteKeeperTableByIds(ids));
    }
}
