package com.ruoyi.uav.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 无人机信息管理对象 uav_table
 * 
 * @author ruoyi
 * @date 2021-10-03
 */
public class UavTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 自增主键 */
    private Long id;

    /** 无人机归口部门 */
    @Excel(name = "无人机归口部门")
    private String uavUnit;

    /** 无人机命名 */
    @Excel(name = "无人机命名")
    private String uavName;

    /** 无人机类型 */
    @Excel(name = "无人机类型")
    private String uavType;

    /** 无人机产品型号 */
    @Excel(name = "无人机产品型号")
    private String uavNumber;

    /** 无人机图片 */
    @Excel(name = "无人机图片")
    private String uavImages;

    /** 无人机序列号 */
    @Excel(name = "无人机序列号")
    private String uavSn;

    /** 无人机飞控编号 */
    @Excel(name = "无人机飞控编号")
    private String uavFlightNumber;

    /** 无人机备勤等级 */
    @Excel(name = "无人机备勤等级")
    private String uavBeiqinLevel;

    /** 无人机启用状态 */
    @Excel(name = "无人机启用状态")
    private Long uavEnabled;

    /** 无人机保险到期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "无人机保险到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uavInsurance;

    /** 无人机质保到期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "无人机质保到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uavAssurance;

    /** 无人机保养到期时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "无人机保养到期时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date uavMaintenance;

    /** 无人机保管员 */
    @Excel(name = "无人机保管员")
    private String uavKeeper;

    /** 无人机入库时间 */
    private Date uavPut;

    /** 无人机录入人 */
    @Excel(name = "无人机录入人")
    private String uavUsers;

    /** 无人机相关附件 */
    @Excel(name = "无人机相关附件")
    private String uavAttachment;

    /** 删除码 */
    @Excel(name = "删除码")
    private Long deleteFlag;

    /** 无人机保管员电话 */
    @Excel(name = "无人机保管员电话")
    private String keeperPhone;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUavUnit(String uavUnit) 
    {
        this.uavUnit = uavUnit;
    }

    public String getUavUnit() 
    {
        return uavUnit;
    }
    public void setUavName(String uavName) 
    {
        this.uavName = uavName;
    }

    public String getUavName() 
    {
        return uavName;
    }
    public void setUavType(String uavType) 
    {
        this.uavType = uavType;
    }

    public String getUavType() 
    {
        return uavType;
    }
    public void setUavNumber(String uavNumber) 
    {
        this.uavNumber = uavNumber;
    }

    public String getUavNumber() 
    {
        return uavNumber;
    }
    public void setUavImages(String uavImages) 
    {
        this.uavImages = uavImages;
    }

    public String getUavImages() 
    {
        return uavImages;
    }
    public void setUavSn(String uavSn) 
    {
        this.uavSn = uavSn;
    }

    public String getUavSn() 
    {
        return uavSn;
    }
    public void setUavFlightNumber(String uavFlightNumber) 
    {
        this.uavFlightNumber = uavFlightNumber;
    }

    public String getUavFlightNumber() 
    {
        return uavFlightNumber;
    }
    public void setUavBeiqinLevel(String uavBeiqinLevel) 
    {
        this.uavBeiqinLevel = uavBeiqinLevel;
    }

    public String getUavBeiqinLevel() 
    {
        return uavBeiqinLevel;
    }
    public void setUavEnabled(Long uavEnabled) 
    {
        this.uavEnabled = uavEnabled;
    }

    public Long getUavEnabled() 
    {
        return uavEnabled;
    }
    public void setUavInsurance(Date uavInsurance) 
    {
        this.uavInsurance = uavInsurance;
    }

    public Date getUavInsurance() 
    {
        return uavInsurance;
    }
    public void setUavAssurance(Date uavAssurance) 
    {
        this.uavAssurance = uavAssurance;
    }

    public Date getUavAssurance() 
    {
        return uavAssurance;
    }
    public void setUavMaintenance(Date uavMaintenance) 
    {
        this.uavMaintenance = uavMaintenance;
    }

    public Date getUavMaintenance() 
    {
        return uavMaintenance;
    }
    public void setUavKeeper(String uavKeeper) 
    {
        this.uavKeeper = uavKeeper;
    }

    public String getUavKeeper() 
    {
        return uavKeeper;
    }
    public void setUavPut(Date uavPut) 
    {
        this.uavPut = uavPut;
    }

    public Date getUavPut() 
    {
        return uavPut;
    }
    public void setUavUsers(String uavUsers) 
    {
        this.uavUsers = uavUsers;
    }

    public String getUavUsers() 
    {
        return uavUsers;
    }
    public void setUavAttachment(String uavAttachment) 
    {
        this.uavAttachment = uavAttachment;
    }

    public String getUavAttachment() 
    {
        return uavAttachment;
    }
    public void setDeleteFlag(Long deleteFlag) 
    {
        this.deleteFlag = deleteFlag;
    }

    public Long getDeleteFlag() 
    {
        return deleteFlag;
    }
    public void setKeeperPhone(String keeperPhone) 
    {
        this.keeperPhone = keeperPhone;
    }

    public String getKeeperPhone() 
    {
        return keeperPhone;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uavUnit", getUavUnit())
            .append("uavName", getUavName())
            .append("uavType", getUavType())
            .append("uavNumber", getUavNumber())
            .append("uavImages", getUavImages())
            .append("uavSn", getUavSn())
            .append("uavFlightNumber", getUavFlightNumber())
            .append("uavBeiqinLevel", getUavBeiqinLevel())
            .append("uavEnabled", getUavEnabled())
            .append("uavInsurance", getUavInsurance())
            .append("uavAssurance", getUavAssurance())
            .append("uavMaintenance", getUavMaintenance())
            .append("uavKeeper", getUavKeeper())
            .append("uavPut", getUavPut())
            .append("uavUsers", getUavUsers())
            .append("uavAttachment", getUavAttachment())
            .append("deleteFlag", getDeleteFlag())
            .append("keeperPhone", getKeeperPhone())
            .toString();
    }
}
