package com.ruoyi.missionlist.controller;

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
import com.ruoyi.missionlist.domain.TaskList;
import com.ruoyi.missionlist.service.ITaskListService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 任务列表Controller
 * 
 * @author ruoyi
 * @date 2021-10-18
 */
@RestController
@RequestMapping("/missionlist")
public class TaskListController extends BaseController
{
    @Autowired
    private ITaskListService taskListService;

    /**
     * 查询任务列表列表
     */
    @PreAuthorize(hasPermi = "missionlist:missionlist:list")
    @GetMapping("/list")
    public TableDataInfo list(TaskList taskList)
    {
        startPage();
        List<TaskList> list = taskListService.selectTaskListList(taskList);
        return getDataTable(list);
    }

    /**
     * 导出任务列表列表
     */
    @PreAuthorize(hasPermi = "missionlist:missionlist:export")
    @Log(title = "任务列表", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, TaskList taskList) throws IOException
    {
        List<TaskList> list = taskListService.selectTaskListList(taskList);
        ExcelUtil<TaskList> util = new ExcelUtil<TaskList>(TaskList.class);
        util.exportExcel(response, list, "任务列表数据");
    }

    /**
     * 获取任务列表详细信息
     */
    @PreAuthorize(hasPermi = "missionlist:missionlist:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(taskListService.selectTaskListById(id));
    }

    /**
     * 新增任务列表
     */
    @PreAuthorize(hasPermi = "missionlist:missionlist:add")
    @Log(title = "任务列表", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TaskList taskList)
    {
        return toAjax(taskListService.insertTaskList(taskList));
    }

    /**
     * 修改任务列表
     */
    @PreAuthorize(hasPermi = "missionlist:missionlist:edit")
    @Log(title = "任务列表", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TaskList taskList)
    {
        return toAjax(taskListService.updateTaskList(taskList));
    }

    /**
     * 删除任务列表
     */
    @PreAuthorize(hasPermi = "missionlist:missionlist:remove")
    @Log(title = "任务列表", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(taskListService.deleteTaskListByIds(ids));
    }
}
