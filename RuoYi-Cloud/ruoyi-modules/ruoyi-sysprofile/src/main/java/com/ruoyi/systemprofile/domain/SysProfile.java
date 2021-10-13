package com.ruoyi.systemprofile.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 系统设置对象 sys_profile
 * 
 * @author ruoyi
 * @date 2021-10-11
 */
public class SysProfile extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** logo图片地址 */
    @Excel(name = "logo图片地址")
    private String sysLogo;

    /** 系统名 */
    @Excel(name = "系统名")
    private String sysTitle;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSysLogo(String sysLogo) 
    {
        this.sysLogo = sysLogo;
    }

    public String getSysLogo() 
    {
        return sysLogo;
    }
    public void setSysTitle(String sysTitle) 
    {
        this.sysTitle = sysTitle;
    }

    public String getSysTitle() 
    {
        return sysTitle;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("sysLogo", getSysLogo())
            .append("sysTitle", getSysTitle())
            .toString();
    }
}
