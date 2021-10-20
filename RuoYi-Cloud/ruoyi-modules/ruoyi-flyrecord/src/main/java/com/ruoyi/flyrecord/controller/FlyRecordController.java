package com.ruoyi.flyrecord.controller;

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
import com.ruoyi.flyrecord.domain.FlyRecord;
import com.ruoyi.flyrecord.service.IFlyRecordService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 飞行记录Controller
 * 
 * @author ruoyi
 * @date 2021-10-14
 */
@RestController
@RequestMapping("/flyrecord")
public class FlyRecordController extends BaseController
{
    @Autowired
    private IFlyRecordService flyRecordService;

    /**
     * 查询飞行记录列表
     */
    @PreAuthorize(hasPermi = "flyrecord:flyrecord:list")
    @GetMapping("/list")
    public TableDataInfo list(FlyRecord flyRecord)
    {
        startPage();
        List<FlyRecord> list = flyRecordService.selectFlyRecordList(flyRecord);
        return getDataTable(list);
    }

    /**
     * 导出飞行记录列表
     */
    @PreAuthorize(hasPermi = "flyrecord:flyrecord:export")
    @Log(title = "飞行记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FlyRecord flyRecord) throws IOException
    {
        List<FlyRecord> list = flyRecordService.selectFlyRecordList(flyRecord);
        ExcelUtil<FlyRecord> util = new ExcelUtil<FlyRecord>(FlyRecord.class);
        util.exportExcel(response, list, "飞行记录数据");
    }

    /**
     * 获取飞行记录详细信息
     */
    @PreAuthorize(hasPermi = "flyrecord:flyrecord:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(flyRecordService.selectFlyRecordById(id));
    }

    /**
     * 新增飞行记录
     */
    @PreAuthorize(hasPermi = "flyrecord:flyrecord:add")
    @Log(title = "飞行记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FlyRecord flyRecord)
    {
        return toAjax(flyRecordService.insertFlyRecord(flyRecord));
    }

    /**
     * 修改飞行记录
     */
    @PreAuthorize(hasPermi = "flyrecord:flyrecord:edit")
    @Log(title = "飞行记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FlyRecord flyRecord)
    {
        return toAjax(flyRecordService.updateFlyRecord(flyRecord));
    }

    /**
     * 删除飞行记录
     */
    @PreAuthorize(hasPermi = "flyrecord:flyrecord:remove")
    @Log(title = "飞行记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(flyRecordService.deleteFlyRecordByIds(ids));
    }
}
