package com.ruoyi.airline.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 航线管理对象 airline_table
 *
 * @author ruoyi
 * @date 2021-10-03
 */
public class AirlineTable extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 航线名词 */
    @Excel(name = "航线名词")
    private String airlineName;

    /** 航线距离 */
    @Excel(name = "航线距离")
    private Long airlineDistance;

    /** 航线说明 */
    @Excel(name = "航线说明")
    private String airlineExplain;

    /** 航线节点 */
    @Excel(name = "航线节点")
    private String airlinePoints;

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId()
    {
        return id;
    }
    public void setAirlineName(String airlineName)
    {
        this.airlineName = airlineName;
    }

    public String getAirlineName()
    {
        return airlineName;
    }
    public void setAirlineDistance(Long airlineDistance)
    {
        this.airlineDistance = airlineDistance;
    }

    public Long getAirlineDistance()
    {
        return airlineDistance;
    }
    public void setAirlineExplain(String airlineExplain)
    {
        this.airlineExplain = airlineExplain;
    }

    public String getAirlineExplain()
    {
        return airlineExplain;
    }
    public void setAirlinePoints(String airlinePoints)
    {
        this.airlinePoints = airlinePoints;
    }

    public String getAirlinePoints()
    {
        return airlinePoints;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("airlineName", getAirlineName())
                .append("airlineDistance", getAirlineDistance())
                .append("airlineExplain", getAirlineExplain())
                .append("airlinePoints", getAirlinePoints())
                .append("createTime", getCreateTime())
                .toString();
    }
}