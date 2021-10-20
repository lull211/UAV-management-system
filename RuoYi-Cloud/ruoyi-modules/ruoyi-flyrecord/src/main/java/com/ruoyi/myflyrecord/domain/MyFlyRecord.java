package com.ruoyi.myflyrecord.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 我的飞行记录对象 fly_record
 * 
 * @author ruoyi
 * @date 2021-10-14
 */
public class MyFlyRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 飞行记录 */
    private Long id;

    /** 任务状态 */
    @Excel(name = "任务状态")
    private String taskState;

    /** 起始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "起始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 驾驶员ID */
    @Excel(name = "驾驶员ID")
    private String driverId;

    /** 无人机ID */
    @Excel(name = "无人机ID")
    private Long uavId;

    /** 任务类型 */
    @Excel(name = "任务类型")
    private String taskType;

    /** 飞行距离 */
    @Excel(name = "飞行距离")
    private Long sumDistance;

    /** 任务描述 */
    @Excel(name = "任务描述")
    private String taskDescription;

    /** 航线id */
    @Excel(name = "航线id")
    private String airlineId;

    /** 所属部门 */
    @Excel(name = "所属部门")
    private String department;

    /** 任务回放 */
    @Excel(name = "任务回放")
    private String taskReplay;

    /** 飞行路线 */
    @Excel(name = "飞行路线")
    private String taskLine;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTaskState(String taskState) 
    {
        this.taskState = taskState;
    }

    public String getTaskState() 
    {
        return taskState;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setDriverId(String driverId) 
    {
        this.driverId = driverId;
    }

    public String getDriverId() 
    {
        return driverId;
    }
    public void setUavId(Long uavId) 
    {
        this.uavId = uavId;
    }

    public Long getUavId() 
    {
        return uavId;
    }
    public void setTaskType(String taskType) 
    {
        this.taskType = taskType;
    }

    public String getTaskType() 
    {
        return taskType;
    }
    public void setSumDistance(Long sumDistance) 
    {
        this.sumDistance = sumDistance;
    }

    public Long getSumDistance() 
    {
        return sumDistance;
    }
    public void setTaskDescription(String taskDescription) 
    {
        this.taskDescription = taskDescription;
    }

    public String getTaskDescription() 
    {
        return taskDescription;
    }
    public void setAirlineId(String airlineId) 
    {
        this.airlineId = airlineId;
    }

    public String getAirlineId() 
    {
        return airlineId;
    }
    public void setDepartment(String department) 
    {
        this.department = department;
    }

    public String getDepartment() 
    {
        return department;
    }
    public void setTaskReplay(String taskReplay) 
    {
        this.taskReplay = taskReplay;
    }

    public String getTaskReplay() 
    {
        return taskReplay;
    }
    public void setTaskLine(String taskLine) 
    {
        this.taskLine = taskLine;
    }

    public String getTaskLine() 
    {
        return taskLine;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("taskState", getTaskState())
            .append("startTime", getStartTime())
            .append("driverId", getDriverId())
            .append("uavId", getUavId())
            .append("taskType", getTaskType())
            .append("sumDistance", getSumDistance())
            .append("taskDescription", getTaskDescription())
            .append("airlineId", getAirlineId())
            .append("department", getDepartment())
            .append("taskReplay", getTaskReplay())
            .append("taskLine", getTaskLine())
            .toString();
    }
}
