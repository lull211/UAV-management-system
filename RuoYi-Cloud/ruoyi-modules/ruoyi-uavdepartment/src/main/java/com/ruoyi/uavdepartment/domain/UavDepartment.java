package com.ruoyi.uavdepartment.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 无人机归口部门对象 uav_department
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
public class UavDepartment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 无人机归口部门 */
    @Excel(name = "无人机归口部门")
    private String uavDepartment;

    /** 备注 */
    @Excel(name = "备注")
    private String extraExplain;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUavDepartment(String uavDepartment) 
    {
        this.uavDepartment = uavDepartment;
    }

    public String getUavDepartment() 
    {
        return uavDepartment;
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
            .append("id", getId())
            .append("uavDepartment", getUavDepartment())
            .append("extraExplain", getExtraExplain())
            .toString();
    }
}
