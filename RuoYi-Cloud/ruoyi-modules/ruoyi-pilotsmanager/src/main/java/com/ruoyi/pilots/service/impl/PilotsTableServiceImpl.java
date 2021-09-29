package com.ruoyi.pilots.service.impl;

import java.util.List;
import com.ruoyi.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.pilots.mapper.PilotsTableMapper;
import com.ruoyi.pilots.domain.PilotsTable;
import com.ruoyi.pilots.service.IPilotsTableService;

/**
 * 驾驶员管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-09-28
 */
@Service
public class PilotsTableServiceImpl implements IPilotsTableService 
{
    @Autowired
    private PilotsTableMapper pilotsTableMapper;

    /**
     * 查询驾驶员管理
     * 
     * @param id 驾驶员管理主键
     * @return 驾驶员管理
     */
    @Override
    public PilotsTable selectPilotsTableById(Long id)
    {
        return pilotsTableMapper.selectPilotsTableById(id);
    }

    /**
     * 查询驾驶员管理列表
     * 
     * @param pilotsTable 驾驶员管理
     * @return 驾驶员管理
     */
    @Override
    public List<PilotsTable> selectPilotsTableList(PilotsTable pilotsTable)
    {
        return pilotsTableMapper.selectPilotsTableList(pilotsTable);
    }

    /**
     * 新增驾驶员管理
     * 
     * @param pilotsTable 驾驶员管理
     * @return 结果
     */
    @Override
    public int insertPilotsTable(PilotsTable pilotsTable)
    {
        pilotsTable.setCreateTime(DateUtils.getNowDate());
        return pilotsTableMapper.insertPilotsTable(pilotsTable);
    }

    /**
     * 修改驾驶员管理
     * 
     * @param pilotsTable 驾驶员管理
     * @return 结果
     */
    @Override
    public int updatePilotsTable(PilotsTable pilotsTable)
    {
        return pilotsTableMapper.updatePilotsTable(pilotsTable);
    }

    /**
     * 批量删除驾驶员管理
     * 
     * @param ids 需要删除的驾驶员管理主键
     * @return 结果
     */
    @Override
    public int deletePilotsTableByIds(Long[] ids)
    {
        return pilotsTableMapper.deletePilotsTableByIds(ids);
    }

    /**
     * 删除驾驶员管理信息
     * 
     * @param id 驾驶员管理主键
     * @return 结果
     */
    @Override
    public int deletePilotsTableById(Long id)
    {
        return pilotsTableMapper.deletePilotsTableById(id);
    }
}
