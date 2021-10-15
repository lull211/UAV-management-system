package com.ruoyi.pilots.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 驾驶员管理对象 pilots_table
 * 
 * @author ruoyi
 * @date 2021-10-14
 */
public class PilotsTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private Long id;

    /** 驾驶员姓名 */
    @Excel(name = "驾驶员姓名")
    private String driverName;

    /** 驾驶员单位 */
    @Excel(name = "驾驶员单位")
    private String driverDepartment;

    /** 驾驶员身份证号 */
    @Excel(name = "驾驶员身份证号")
    private String driverIdcard;

    /** 驾驶员手机号码 */
    @Excel(name = "驾驶员手机号码")
    private String driverPhone;

    /** 驾驶员准驾机型 */
    @Excel(name = "驾驶员准驾机型")
    private String driverAircraftSoft;

    /** 驾驶员状态 */
    @Excel(name = "驾驶员状态")
    private Long driverState;

    /** 驾驶员照片 */
    @Excel(name = "驾驶员照片")
    private String driverPhoto;

    /** 驾驶员附件 */
    @Excel(name = "驾驶员附件")
    private String driverExtral;

    /** 驾驶员训练时间 */
    @Excel(name = "驾驶员训练时间")
    private Long trainingTime;

    /** 驾驶员飞行时间 */
    @Excel(name = "驾驶员飞行时间")
    private Long flyingTime;

    /** 驾驶员总时间 */
    @Excel(name = "驾驶员总时间")
    private Long sumTime;

    /** 删除码 */
    @Excel(name = "删除码")
    private Long deleteFlag;

    /** 驾驶员性别 */
    @Excel(name = "驾驶员性别")
    private Long driverGender;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDriverName(String driverName) 
    {
        this.driverName = driverName;
    }

    public String getDriverName() 
    {
        return driverName;
    }
    public void setDriverDepartment(String driverDepartment) 
    {
        this.driverDepartment = driverDepartment;
    }

    public String getDriverDepartment() 
    {
        return driverDepartment;
    }
    public void setDriverIdcard(String driverIdcard) 
    {
        this.driverIdcard = driverIdcard;
    }

    public String getDriverIdcard() 
    {
        return driverIdcard;
    }
    public void setDriverPhone(String driverPhone) 
    {
        this.driverPhone = driverPhone;
    }

    public String getDriverPhone() 
    {
        return driverPhone;
    }
    public void setDriverAircraftSoft(String driverAircraftSoft) 
    {
        this.driverAircraftSoft = driverAircraftSoft;
    }

    public String getDriverAircraftSoft() 
    {
        return driverAircraftSoft;
    }
    public void setDriverState(Long driverState) 
    {
        this.driverState = driverState;
    }

    public Long getDriverState() 
    {
        return driverState;
    }
    public void setDriverPhoto(String driverPhoto) 
    {
        this.driverPhoto = driverPhoto;
    }

    public String getDriverPhoto() 
    {
        return driverPhoto;
    }
    public void setDriverExtral(String driverExtral) 
    {
        this.driverExtral = driverExtral;
    }

    public String getDriverExtral() 
    {
        return driverExtral;
    }
    public void setTrainingTime(Long trainingTime) 
    {
        this.trainingTime = trainingTime;
    }

    public Long getTrainingTime() 
    {
        return trainingTime;
    }
    public void setFlyingTime(Long flyingTime) 
    {
        this.flyingTime = flyingTime;
    }

    public Long getFlyingTime() 
    {
        return flyingTime;
    }
    public void setSumTime(Long sumTime) 
    {
        this.sumTime = sumTime;
    }

    public Long getSumTime() 
    {
        return sumTime;
    }
    public void setDeleteFlag(Long deleteFlag) 
    {
        this.deleteFlag = deleteFlag;
    }

    public Long getDeleteFlag() 
    {
        return deleteFlag;
    }
    public void setDriverGender(Long driverGender) 
    {
        this.driverGender = driverGender;
    }

    public Long getDriverGender() 
    {
        return driverGender;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("driverName", getDriverName())
            .append("driverDepartment", getDriverDepartment())
            .append("driverIdcard", getDriverIdcard())
            .append("driverPhone", getDriverPhone())
            .append("driverAircraftSoft", getDriverAircraftSoft())
            .append("driverState", getDriverState())
            .append("driverPhoto", getDriverPhoto())
            .append("driverExtral", getDriverExtral())
            .append("trainingTime", getTrainingTime())
            .append("flyingTime", getFlyingTime())
            .append("sumTime", getSumTime())
            .append("createTime", getCreateTime())
            .append("deleteFlag", getDeleteFlag())
            .append("driverGender", getDriverGender())
            .toString();
    }
}
