package com.ruoyi.missionlist.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 任务列表对象 task_list
 * 
 * @author ruoyi
 * @date 2021-10-13
 */
public class TaskList extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 任务名称 */
    @Excel(name = "任务名称")
    private String taskName;

    /** 任务类型 */
    @Excel(name = "任务类型")
    private String taskType;

    /** 任务时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "任务时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date taskTime;

    /** 无人机编号 */
    @Excel(name = "无人机编号")
    private String taskDrone;

    /** 驾驶员 */
    @Excel(name = "驾驶员")
    private String taskDriver;

    /** 驾驶员手机号码 */
    @Excel(name = "驾驶员手机号码")
    private String driverPhone;

    /** 主键id */
    private Long id;

    /** 航线 */
    @Excel(name = "航线")
    private String taskAirline;

    /** 任务封面图片 */
    @Excel(name = "任务封面图片")
    private String taskImages;

    /** 任务地点 */
    @Excel(name = "任务地点")
    private String taskAddress;

    /** 删除码 */
    @Excel(name = "删除码")
    private Long deleteCode;

    /** 描述 */
    @Excel(name = "描述")
    private String extraExplain;

    public void setTaskName(String taskName) 
    {
        this.taskName = taskName;
    }

    public String getTaskName() 
    {
        return taskName;
    }
    public void setTaskType(String taskType) 
    {
        this.taskType = taskType;
    }

    public String getTaskType() 
    {
        return taskType;
    }
    public void setTaskTime(Date taskTime) 
    {
        this.taskTime = taskTime;
    }

    public Date getTaskTime() 
    {
        return taskTime;
    }
    public void setTaskDrone(String taskDrone) 
    {
        this.taskDrone = taskDrone;
    }

    public String getTaskDrone() 
    {
        return taskDrone;
    }
    public void setTaskDriver(String taskDriver) 
    {
        this.taskDriver = taskDriver;
    }

    public String getTaskDriver() 
    {
        return taskDriver;
    }
    public void setDriverPhone(String driverPhone) 
    {
        this.driverPhone = driverPhone;
    }

    public String getDriverPhone() 
    {
        return driverPhone;
    }
    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTaskAirline(String taskAirline) 
    {
        this.taskAirline = taskAirline;
    }

    public String getTaskAirline() 
    {
        return taskAirline;
    }
    public void setTaskImages(String taskImages) 
    {
        this.taskImages = taskImages;
    }

    public String getTaskImages() 
    {
        return taskImages;
    }
    public void setTaskAddress(String taskAddress) 
    {
        this.taskAddress = taskAddress;
    }

    public String getTaskAddress() 
    {
        return taskAddress;
    }
    public void setDeleteCode(Long deleteCode) 
    {
        this.deleteCode = deleteCode;
    }

    public Long getDeleteCode() 
    {
        return deleteCode;
    }
    public void setExtraExplain(String extraExplain) 
    {
        this.extraExplain = extraExplain;
    }

    public String getExtraExplain() 
    {
        return extraExplain;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("taskName", getTaskName())
            .append("taskType", getTaskType())
            .append("taskTime", getTaskTime())
            .append("taskDrone", getTaskDrone())
            .append("taskDriver", getTaskDriver())
            .append("driverPhone", getDriverPhone())
            .append("id", getId())
            .append("taskAirline", getTaskAirline())
            .append("taskImages", getTaskImages())
            .append("taskAddress", getTaskAddress())
            .append("deleteCode", getDeleteCode())
            .append("extraExplain", getExtraExplain())
            .toString();
    }
}
