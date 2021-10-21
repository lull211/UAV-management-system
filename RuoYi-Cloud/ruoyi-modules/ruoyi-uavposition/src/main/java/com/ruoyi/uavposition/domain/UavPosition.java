package com.ruoyi.uavposition.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 无人机实时位置测试对象 uav_position
 * 
 * @author ruoyi
 * @date 2021-10-21
 */
public class UavPosition extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** uav编号 */
    private String uavFlightNumber;

    /** 位置 */
    @Excel(name = "位置")
    private String position;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUavFlightNumber(String uavFlightNumber) 
    {
        this.uavFlightNumber = uavFlightNumber;
    }

    public String getUavFlightNumber() 
    {
        return uavFlightNumber;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uavFlightNumber", getUavFlightNumber())
            .append("position", getPosition())
            .toString();
    }
}
