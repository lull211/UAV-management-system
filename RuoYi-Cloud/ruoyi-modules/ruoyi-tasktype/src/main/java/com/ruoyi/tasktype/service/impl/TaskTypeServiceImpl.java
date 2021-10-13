package com.ruoyi.tasktype.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.tasktype.mapper.TaskTypeMapper;
import com.ruoyi.tasktype.domain.TaskType;
import com.ruoyi.tasktype.service.ITaskTypeService;

/**
 * 任务类型Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-13
 */
@Service
public class TaskTypeServiceImpl implements ITaskTypeService 
{
    @Autowired
    private TaskTypeMapper taskTypeMapper;

    /**
     * 查询任务类型
     * 
     * @param id 任务类型主键
     * @return 任务类型
     */
    @Override
    public TaskType selectTaskTypeById(Long id)
    {
        return taskTypeMapper.selectTaskTypeById(id);
    }

    /**
     * 查询任务类型列表
     * 
     * @param taskType 任务类型
     * @return 任务类型
     */
    @Override
    public List<TaskType> selectTaskTypeList(TaskType taskType)
    {
        return taskTypeMapper.selectTaskTypeList(taskType);
    }

    /**
     * 新增任务类型
     * 
     * @param taskType 任务类型
     * @return 结果
     */
    @Override
    public int insertTaskType(TaskType taskType)
    {
        return taskTypeMapper.insertTaskType(taskType);
    }

    /**
     * 修改任务类型
     * 
     * @param taskType 任务类型
     * @return 结果
     */
    @Override
    public int updateTaskType(TaskType taskType)
    {
        return taskTypeMapper.updateTaskType(taskType);
    }

    /**
     * 批量删除任务类型
     * 
     * @param ids 需要删除的任务类型主键
     * @return 结果
     */
    @Override
    public int deleteTaskTypeByIds(Long[] ids)
    {
        return taskTypeMapper.deleteTaskTypeByIds(ids);
    }

    /**
     * 删除任务类型信息
     * 
     * @param id 任务类型主键
     * @return 结果
     */
    @Override
    public int deleteTaskTypeById(Long id)
    {
        return taskTypeMapper.deleteTaskTypeById(id);
    }
}
