package com.ruoyi.myflyrecord.controller;

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
import com.ruoyi.myflyrecord.domain.MyFlyRecord;
import com.ruoyi.myflyrecord.service.IMyFlyRecordService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 我的飞行记录Controller
 * 
 * @author ruoyi
 * @date 2021-10-18
 */
@RestController
@RequestMapping("/myflyrecord")
public class MyFlyRecordController extends BaseController
{
    @Autowired
    private IMyFlyRecordService myFlyRecordService;

    /**
     * 查询我的飞行记录列表
     */
    @PreAuthorize(hasPermi = "myflyrecord:myflyrecord:list")
    @GetMapping("/list")
    public TableDataInfo list(MyFlyRecord myFlyRecord)
    {
        startPage();
        List<MyFlyRecord> list = myFlyRecordService.selectMyFlyRecordList(myFlyRecord);
        return getDataTable(list);
    }

    /**
     * 导出我的飞行记录列表
     */
    @PreAuthorize(hasPermi = "myflyrecord:myflyrecord:export")
    @Log(title = "我的飞行记录", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MyFlyRecord myFlyRecord) throws IOException
    {
        List<MyFlyRecord> list = myFlyRecordService.selectMyFlyRecordList(myFlyRecord);
        ExcelUtil<MyFlyRecord> util = new ExcelUtil<MyFlyRecord>(MyFlyRecord.class);
        util.exportExcel(response, list, "我的飞行记录数据");
    }

    /**
     * 获取我的飞行记录详细信息
     */
    @PreAuthorize(hasPermi = "myflyrecord:myflyrecord:query")
    @GetMapping(value = "/{taskId}")
    public AjaxResult getInfo(@PathVariable("taskId") Long taskId)
    {
        return AjaxResult.success(myFlyRecordService.selectMyFlyRecordById(taskId));
    }

    /**
     * 新增我的飞行记录
     */
    @PreAuthorize(hasPermi = "myflyrecord:myflyrecord:add")
    @Log(title = "我的飞行记录", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MyFlyRecord myFlyRecord)
    {
        return toAjax(myFlyRecordService.insertMyFlyRecord(myFlyRecord));
    }

    /**
     * 修改我的飞行记录
     */
    @PreAuthorize(hasPermi = "myflyrecord:myflyrecord:edit")
    @Log(title = "我的飞行记录", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MyFlyRecord myFlyRecord)
    {
        return toAjax(myFlyRecordService.updateMyFlyRecord(myFlyRecord));
    }

    /**
     * 删除我的飞行记录
     */
    @PreAuthorize(hasPermi = "myflyrecord:myflyrecord:remove")
    @Log(title = "我的飞行记录", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(myFlyRecordService.deleteMyFlyRecordByIds(ids));
    }
}
