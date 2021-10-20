package com.ruoyi.myflyrecord.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 我的飞行记录对象 fly_record
 * 
 * @author ruoyi
 * @date 2021-10-20
 */
public class MyFlyRecord extends BaseEntity
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

    /** 终点纬度 */
    @Excel(name = "终点纬度")
    private String endLatittude;

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

    /** 驾驶员ID */
    @Excel(name = "驾驶员ID")
    private Long driverId;

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
    public void setEndLatittude(String endLatittude) 
    {
        this.endLatittude = endLatittude;
    }

    public String getEndLatittude() 
    {
        return endLatittude;
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
    public void setDriverId(Long driverId) 
    {
        this.driverId = driverId;
    }

    public Long getDriverId() 
    {
        return driverId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("taskId", getTaskId())
            .append("homeLongtitude", getHomeLongtitude())
            .append("homeLatittude", getHomeLatittude())
            .append("sumDistance", getSumDistance())
            .append("endLatittude", getEndLatittude())
            .append("endLongtitude", getEndLongtitude())
            .append("altitude", getAltitude())
            .append("velocity", getVelocity())
            .append("verticalSpeed", getVerticalSpeed())
            .append("taskReplay", getTaskReplay())
            .append("flyDoc", getFlyDoc())
            .append("taskLine", getTaskLine())
            .append("flyVideo", getFlyVideo())
            .append("driverId", getDriverId())
            .toString();
    }
}
