package com.ruoyi.pilots.mapper;

import java.util.List;
import com.ruoyi.pilots.domain.PilotsTable;

/**
 * 驾驶员管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-09-28
 */
public interface PilotsTableMapper 
{
    /**
     * 查询驾驶员管理
     * 
     * @param id 驾驶员管理主键
     * @return 驾驶员管理
     */
    public PilotsTable selectPilotsTableById(Long id);

    /**
     * 查询驾驶员管理列表
     * 
     * @param pilotsTable 驾驶员管理
     * @return 驾驶员管理集合
     */
    public List<PilotsTable> selectPilotsTableList(PilotsTable pilotsTable);

    /**
     * 新增驾驶员管理
     * 
     * @param pilotsTable 驾驶员管理
     * @return 结果
     */
    public int insertPilotsTable(PilotsTable pilotsTable);

    /**
     * 修改驾驶员管理
     * 
     * @param pilotsTable 驾驶员管理
     * @return 结果
     */
    public int updatePilotsTable(PilotsTable pilotsTable);

    /**
     * 删除驾驶员管理
     * 
     * @param id 驾驶员管理主键
     * @return 结果
     */
    public int deletePilotsTableById(Long id);

    /**
     * 批量删除驾驶员管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deletePilotsTableByIds(Long[] ids);
}
