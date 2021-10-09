package com.ruoyi.missionlevel.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 任务等级对象 mission_level
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
public class MissionLevel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 任务等级 */
    @Excel(name = "任务等级")
    private String level;

    /** $column.columnComment */
    @Excel(name = "任务等级")
    private String Explain1;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setLevel(String level) 
    {
        this.level = level;
    }

    public String getLevel() 
    {
        return level;
    }
    public void setExplain1(String Explain1) 
    {
        this.Explain1 = Explain1;
    }

    public String getExplain1() 
    {
        return Explain1;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("level", getLevel())
            .append("Explain1", getExplain1())
            .toString();
    }
}
