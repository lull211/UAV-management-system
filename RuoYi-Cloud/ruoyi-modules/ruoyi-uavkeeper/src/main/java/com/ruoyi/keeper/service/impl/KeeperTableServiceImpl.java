package com.ruoyi.keeper.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.keeper.mapper.KeeperTableMapper;
import com.ruoyi.keeper.domain.KeeperTable;
import com.ruoyi.keeper.service.IKeeperTableService;

/**
 * 保管员管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-08
 */
@Service
public class KeeperTableServiceImpl implements IKeeperTableService 
{
    @Autowired
    private KeeperTableMapper keeperTableMapper;

    /**
     * 查询保管员管理
     * 
     * @param id 保管员管理主键
     * @return 保管员管理
     */
    @Override
    public KeeperTable selectKeeperTableById(Long id)
    {
        return keeperTableMapper.selectKeeperTableById(id);
    }

    /**
     * 查询保管员管理列表
     * 
     * @param keeperTable 保管员管理
     * @return 保管员管理
     */
    @Override
    public List<KeeperTable> selectKeeperTableList(KeeperTable keeperTable)
    {
        return keeperTableMapper.selectKeeperTableList(keeperTable);
    }

    /**
     * 新增保管员管理
     * 
     * @param keeperTable 保管员管理
     * @return 结果
     */
    @Override
    public int insertKeeperTable(KeeperTable keeperTable)
    {
        return keeperTableMapper.insertKeeperTable(keeperTable);
    }

    /**
     * 修改保管员管理
     * 
     * @param keeperTable 保管员管理
     * @return 结果
     */
    @Override
    public int updateKeeperTable(KeeperTable keeperTable)
    {
        return keeperTableMapper.updateKeeperTable(keeperTable);
    }

    /**
     * 批量删除保管员管理
     * 
     * @param ids 需要删除的保管员管理主键
     * @return 结果
     */
    @Override
    public int deleteKeeperTableByIds(Long[] ids)
    {
        return keeperTableMapper.deleteKeeperTableByIds(ids);
    }

    /**
     * 删除保管员管理信息
     * 
     * @param id 保管员管理主键
     * @return 结果
     */
    @Override
    public int deleteKeeperTableById(Long id)
    {
        return keeperTableMapper.deleteKeeperTableById(id);
    }
}
