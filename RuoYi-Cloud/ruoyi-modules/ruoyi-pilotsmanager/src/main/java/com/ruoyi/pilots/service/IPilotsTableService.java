package com.ruoyi.pilots.service;

import java.util.List;
import com.ruoyi.pilots.domain.PilotsTable;

/**
 * 驾驶员管理Service接口
 * 
 * @author ruoyi
 * @date 2021-10-14
 */
public interface IPilotsTableService 
{
    /**
     * 查询驾驶员管理
     * 
     * @param id 驾驶员管理主键
     * @return 驾驶员管理
     */
    public PilotsTable selectPilotsTableById(Long id);

    public long selectPilotsByNameLikely(String Name);

    /**
     * 用名字查询驾驶员
     */
    public PilotsTable selectPilotsByName(String Name);

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
     * 批量删除驾驶员管理
     * 
     * @param ids 需要删除的驾驶员管理主键集合
     * @return 结果
     */
    public int deletePilotsTableByIds(Long[] ids);

    /**
     * 删除驾驶员管理信息
     * 
     * @param id 驾驶员管理主键
     * @return 结果
     */
    public int deletePilotsTableById(Long id);
}
