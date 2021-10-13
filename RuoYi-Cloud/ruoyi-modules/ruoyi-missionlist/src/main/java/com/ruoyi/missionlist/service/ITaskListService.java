package com.ruoyi.missionlist.service;

import java.util.List;
import com.ruoyi.missionlist.domain.TaskList;

/**
 * 任务列表Service接口
 * 
 * @author ruoyi
 * @date 2021-10-13
 */
public interface ITaskListService 
{
    /**
     * 查询任务列表
     * 
     * @param id 任务列表主键
     * @return 任务列表
     */
    public TaskList selectTaskListById(Long id);

    /**
     * 查询任务列表列表
     * 
     * @param taskList 任务列表
     * @return 任务列表集合
     */
    public List<TaskList> selectTaskListList(TaskList taskList);

    /**
     * 新增任务列表
     * 
     * @param taskList 任务列表
     * @return 结果
     */
    public int insertTaskList(TaskList taskList);

    /**
     * 修改任务列表
     * 
     * @param taskList 任务列表
     * @return 结果
     */
    public int updateTaskList(TaskList taskList);

    /**
     * 批量删除任务列表
     * 
     * @param ids 需要删除的任务列表主键集合
     * @return 结果
     */
    public int deleteTaskListByIds(Long[] ids);

    /**
     * 删除任务列表信息
     * 
     * @param id 任务列表主键
     * @return 结果
     */
    public int deleteTaskListById(Long id);
}
