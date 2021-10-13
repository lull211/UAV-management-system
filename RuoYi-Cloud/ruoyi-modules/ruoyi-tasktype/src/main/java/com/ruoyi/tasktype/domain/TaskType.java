package com.ruoyi.tasktype.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 任务类型对象 task_type
 * 
 * @author ruoyi
 * @date 2021-10-13
 */
public class TaskType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 任务类型 */
    @Excel(name = "任务类型")
    private String taskType;

    /** 备注 */
    @Excel(name = "备注")
    private String description;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTaskType(String taskType) 
    {
        this.taskType = taskType;
    }

    public String getTaskType() 
    {
        return taskType;
    }
    public void setDescription(String description) 
    {
        this.description = description;
    }

    public String getDescription() 
    {
        return description;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("taskType", getTaskType())
            .append("description", getDescription())
            .toString();
    }
}
