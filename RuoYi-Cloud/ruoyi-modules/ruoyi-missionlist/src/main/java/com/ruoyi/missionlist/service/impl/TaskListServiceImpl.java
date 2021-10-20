package com.ruoyi.missionlist.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.missionlist.mapper.TaskListMapper;
import com.ruoyi.missionlist.domain.TaskList;
import com.ruoyi.missionlist.service.ITaskListService;

/**
 * 任务列表Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-13
 */
@Service
public class TaskListServiceImpl implements ITaskListService 
{
    @Autowired
    private TaskListMapper taskListMapper;

    /**
     * 查询任务列表
     * 
     * @param id 任务列表主键
     * @return 任务列表
     */
    @Override
    public TaskList selectTaskListById(Long id)
    {
        return taskListMapper.selectTaskListById(id);
    }

    /**
     * 查询任务列表列表
     * 
     * @param taskList 任务列表
     * @return 任务列表
     */
    @Override
    public List<TaskList> selectTaskListList(TaskList taskList)
    {
        return taskListMapper.selectTaskListList(taskList);
    }

    /**
     * 新增任务列表
     * 
     * @param taskList 任务列表
     * @return 结果
     */
    @Override
    public int insertTaskList(TaskList taskList)
    {
        return taskListMapper.insertTaskList(taskList);
    }

    /**
     * 修改任务列表
     * 
     * @param taskList 任务列表
     * @return 结果
     */
    @Override
    public int updateTaskList(TaskList taskList)
    {
        return taskListMapper.updateTaskList(taskList);
    }

    /**
     * 批量删除任务列表
     * 
     * @param ids 需要删除的任务列表主键
     * @return 结果
     */
    @Override
    public int deleteTaskListByIds(Long[] ids)
    {
        return taskListMapper.deleteTaskListByIds(ids);
    }

    /**
     * 删除任务列表信息
     * 
     * @param id 任务列表主键
     * @return 结果
     */
    @Override
    public int deleteTaskListById(Long id)
    {
        return taskListMapper.deleteTaskListById(id);
    }
}
