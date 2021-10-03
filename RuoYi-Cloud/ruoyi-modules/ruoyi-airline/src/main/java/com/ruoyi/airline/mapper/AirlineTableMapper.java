package com.ruoyi.airline.mapper;

import java.util.List;
import com.ruoyi.airline.domain.AirlineTable;

/**
 * 航线管理Mapper接口
 *
 * @author ruoyi
 * @date 2021-10-03
 */
public interface AirlineTableMapper
{
    /**
     * 查询航线管理
     *
     * @param id 航线管理主键
     * @return 航线管理
     */
    public AirlineTable selectAirlineTableById(Long id);

    /**
     * 查询航线管理列表
     *
     * @param airlineTable 航线管理
     * @return 航线管理集合
     */
    public List<AirlineTable> selectAirlineTableList(AirlineTable airlineTable);

    /**
     * 新增航线管理
     *
     * @param airlineTable 航线管理
     * @return 结果
     */
    public int insertAirlineTable(AirlineTable airlineTable);

    /**
     * 修改航线管理
     *
     * @param airlineTable 航线管理
     * @return 结果
     */
    public int updateAirlineTable(AirlineTable airlineTable);

    /**
     * 删除航线管理
     *
     * @param id 航线管理主键
     * @return 结果
     */
    public int deleteAirlineTableById(Long id);

    /**
     * 批量删除航线管理
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteAirlineTableByIds(Long[] ids);
}