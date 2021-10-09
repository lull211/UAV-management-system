package com.ruoyi.uavtype.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * uavtype对象 uav_type
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
public class UavType extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 无人机类型 */
    @Excel(name = "无人机类型")
    private String uavType;

    /** 无人机类型描述 */
    @Excel(name = "无人机类型描述")
    private String typeExplain;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUavType(String uavType) 
    {
        this.uavType = uavType;
    }

    public String getUavType() 
    {
        return uavType;
    }
    public void setTypeExplain(String typeExplain) 
    {
        this.typeExplain = typeExplain;
    }

    public String getTypeExplain() 
    {
        return typeExplain;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("uavType", getUavType())
            .append("typeExplain", getTypeExplain())
            .toString();
    }
}
