package com.ruoyi.tasktype.controller;

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
import com.ruoyi.tasktype.domain.TaskType;
import com.ruoyi.tasktype.service.ITaskTypeService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 任务类型Controller
 * 
 * @author ruoyi
 * @date 2021-10-13
 */
@RestController
@RequestMapping("/tasktype")
public class TaskTypeController extends BaseController
{
    @Autowired
    private ITaskTypeService taskTypeService;

    /**
     * 查询任务类型列表
     */
    @PreAuthorize(hasPermi = "tasktype:tasktype:list")
    @GetMapping("/list")
    public TableDataInfo list(TaskType taskType)
    {
        startPage();
        List<TaskType> list = taskTypeService.selectTaskTypeList(taskType);
        return getDataTable(list);
    }

    /**
     * 导出任务类型列表
     */
    @PreAuthorize(hasPermi = "tasktype:tasktype:export")
    @Log(title = "任务类型", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaskType taskType) throws IOException
    {
        List<TaskType> list = taskTypeService.selectTaskTypeList(taskType);
        ExcelUtil<TaskType> util = new ExcelUtil<TaskType>(TaskType.class);
        util.exportExcel(response, list, "任务类型数据");
    }

    /**
     * 获取任务类型详细信息
     */
    @PreAuthorize(hasPermi = "tasktype:tasktype:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(taskTypeService.selectTaskTypeById(id));
    }

    /**
     * 新增任务类型
     */
    @PreAuthorize(hasPermi = "tasktype:tasktype:add")
    @Log(title = "任务类型", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TaskType taskType)
    {
        return toAjax(taskTypeService.insertTaskType(taskType));
    }

    /**
     * 修改任务类型
     */
    @PreAuthorize(hasPermi = "tasktype:tasktype:edit")
    @Log(title = "任务类型", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TaskType taskType)
    {
        return toAjax(taskTypeService.updateTaskType(taskType));
    }

    /**
     * 删除任务类型
     */
    @PreAuthorize(hasPermi = "tasktype:tasktype:remove")
    @Log(title = "任务类型", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(taskTypeService.deleteTaskTypeByIds(ids));
    }
}
