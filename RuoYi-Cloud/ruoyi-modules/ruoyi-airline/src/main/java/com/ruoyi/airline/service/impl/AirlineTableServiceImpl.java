package com.ruoyi.airline.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.airline.mapper.AirlineTableMapper;
import com.ruoyi.airline.domain.AirlineTable;
import com.ruoyi.airline.service.IAirlineTableService;

/**
 * 航线管理Service业务层处理
 *
 * @author ruoyi
 * @date 2021-10-03
 */
@Service
public class AirlineTableServiceImpl implements IAirlineTableService
{
    @Autowired
    private AirlineTableMapper airlineTableMapper;

    /**
     * 查询航线管理
     *
     * @param id 航线管理主键
     * @return 航线管理
     */
    @Override
    public AirlineTable selectAirlineTableById(Long id)
    {
        return airlineTableMapper.selectAirlineTableById(id);
    }

    /**
     * 查询航线管理列表
     *
     * @param airlineTable 航线管理
     * @return 航线管理
     */
    @Override
    public List<AirlineTable> selectAirlineTableList(AirlineTable airlineTable)
    {
        return airlineTableMapper.selectAirlineTableList(airlineTable);
    }

    /**
     * 新增航线管理
     *
     * @param airlineTable 航线管理
     * @return 结果
     */
    @Override
    public int insertAirlineTable(AirlineTable airlineTable)
    {
        airlineTable.setCreateTime(DateUtils.getNowDate());
        return airlineTableMapper.insertAirlineTable(airlineTable);
    }

    /**
     * 修改航线管理
     *
     * @param airlineTable 航线管理
     * @return 结果
     */
    @Override
    public int updateAirlineTable(AirlineTable airlineTable)
    {
        return airlineTableMapper.updateAirlineTable(airlineTable);
    }

    /**
     * 批量删除航线管理
     *
     * @param ids 需要删除的航线管理主键
     * @return 结果
     */
    @Override
    public int deleteAirlineTableByIds(Long[] ids)
    {
        return airlineTableMapper.deleteAirlineTableByIds(ids);
    }

    /**
     * 删除航线管理信息
     *
     * @param id 航线管理主键
     * @return 结果
     */
    @Override
    public int deleteAirlineTableById(Long id)
    {
        return airlineTableMapper.deleteAirlineTableById(id);
    }
}