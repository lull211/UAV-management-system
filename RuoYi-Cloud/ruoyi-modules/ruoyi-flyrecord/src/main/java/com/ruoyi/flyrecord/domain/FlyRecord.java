package com.ruoyi.flyrecord.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 飞行记录对象 fly_record
 * 
 * @author ruoyi
 * @date 2021-10-18
 */
public class FlyRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 飞行记录 */
    private Long id;

    /** 任务ID */
    private Long taskId;

    /** 起飞经度 */
    @Excel(name = "起飞经度")
    private String homeLongtitude;

    /** 起飞纬度 */
    @Excel(name = "起飞纬度")
    private String homeLatittude;

    /** 飞行距离 */
    @Excel(name = "飞行距离")
    private Long sumDistance;

    /** 终点经度 */
    @Excel(name = "终点经度")
    private String endLongtitude;

    /** 飞行高度 */
    @Excel(name = "飞行高度")
    private String altitude;

    /** 水平飞行速度 */
    @Excel(name = "水平飞行速度")
    private String velocity;

    /** 垂直飞行速度 */
    @Excel(name = "垂直飞行速度")
    private Long verticalSpeed;

    /** 任务回放 */
    @Excel(name = "任务回放")
    private String taskReplay;

    /** 记录附件 */
    @Excel(name = "记录附件")
    private String flyDoc;

    /** 飞行路线 */
    @Excel(name = "飞行路线")
    private String taskLine;

    /** 飞行录像 */
    @Excel(name = "飞行录像")
    private String flyVideo;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTaskId(Long taskId) 
    {
        this.taskId = taskId;
    }

    public Long getTaskId() 
    {
        return taskId;
    }
    public void setHomeLongtitude(String homeLongtitude) 
    {
        this.homeLongtitude = homeLongtitude;
    }

    public String getHomeLongtitude() 
    {
        return homeLongtitude;
    }
    public void setHomeLatittude(String homeLatittude) 
    {
        this.homeLatittude = homeLatittude;
    }

    public String getHomeLatittude() 
    {
        return homeLatittude;
    }
    public void setSumDistance(Long sumDistance) 
    {
        this.sumDistance = sumDistance;
    }

    public Long getSumDistance() 
    {
        return sumDistance;
    }
    public void setEndLongtitude(String endLongtitude) 
    {
        this.endLongtitude = endLongtitude;
    }

    public String getEndLongtitude() 
    {
        return endLongtitude;
    }
    public void setAltitude(String altitude) 
    {
        this.altitude = altitude;
    }

    public String getAltitude() 
    {
        return altitude;
    }
    public void setVelocity(String velocity) 
    {
        this.velocity = velocity;
    }

    public String getVelocity() 
    {
        return velocity;
    }
    public void setVerticalSpeed(Long verticalSpeed) 
    {
        this.verticalSpeed = verticalSpeed;
    }

    public Long getVerticalSpeed() 
    {
        return verticalSpeed;
    }
    public void setTaskReplay(String taskReplay) 
    {
        this.taskReplay = taskReplay;
    }

    public String getTaskReplay() 
    {
        return taskReplay;
    }
    public void setFlyDoc(String flyDoc) 
    {
        this.flyDoc = flyDoc;
    }

    public String getFlyDoc() 
    {
        return flyDoc;
    }
    public void setTaskLine(String taskLine) 
    {
        this.taskLine = taskLine;
    }

    public String getTaskLine() 
    {
        return taskLine;
    }
    public void setFlyVideo(String flyVideo) 
    {
        this.flyVideo = flyVideo;
    }

    public String getFlyVideo() 
    {
        return flyVideo;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("taskId", getTaskId())
            .append("homeLongtitude", getHomeLongtitude())
            .append("homeLatittude", getHomeLatittude())
            .append("sumDistance", getSumDistance())
            .append("endLongtitude", getEndLongtitude())
            .append("altitude", getAltitude())
            .append("velocity", getVelocity())
            .append("verticalSpeed", getVerticalSpeed())
            .append("taskReplay", getTaskReplay())
            .append("flyDoc", getFlyDoc())
            .append("taskLine", getTaskLine())
            .append("flyVideo", getFlyVideo())
            .toString();
    }
}
