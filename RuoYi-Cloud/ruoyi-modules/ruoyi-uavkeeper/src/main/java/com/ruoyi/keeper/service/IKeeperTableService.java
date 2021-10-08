package com.ruoyi.keeper.service;

import java.util.List;
import com.ruoyi.keeper.domain.KeeperTable;

/**
 * 保管员管理Service接口
 * 
 * @author ruoyi
 * @date 2021-10-08
 */
public interface IKeeperTableService 
{
    /**
     * 查询保管员管理
     * 
     * @param id 保管员管理主键
     * @return 保管员管理
     */
    public KeeperTable selectKeeperTableById(Long id);

    /**
     * 查询保管员管理列表
     * 
     * @param keeperTable 保管员管理
     * @return 保管员管理集合
     */
    public List<KeeperTable> selectKeeperTableList(KeeperTable keeperTable);

    /**
     * 新增保管员管理
     * 
     * @param keeperTable 保管员管理
     * @return 结果
     */
    public int insertKeeperTable(KeeperTable keeperTable);

    /**
     * 修改保管员管理
     * 
     * @param keeperTable 保管员管理
     * @return 结果
     */
    public int updateKeeperTable(KeeperTable keeperTable);

    /**
     * 批量删除保管员管理
     * 
     * @param ids 需要删除的保管员管理主键集合
     * @return 结果
     */
    public int deleteKeeperTableByIds(Long[] ids);

    /**
     * 删除保管员管理信息
     * 
     * @param id 保管员管理主键
     * @return 结果
     */
    public int deleteKeeperTableById(Long id);
}
