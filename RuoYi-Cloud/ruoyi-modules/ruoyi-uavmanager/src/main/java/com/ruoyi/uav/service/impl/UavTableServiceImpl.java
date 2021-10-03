package com.ruoyi.uav.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.uav.mapper.UavTableMapper;
import com.ruoyi.uav.domain.UavTable;
import com.ruoyi.uav.service.IUavTableService;

/**
 * 无人机信息管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-03
 */
@Service
public class UavTableServiceImpl implements IUavTableService 
{
    @Autowired
    private UavTableMapper uavTableMapper;

    /**
     * 查询无人机信息管理
     * 
     * @param id 无人机信息管理主键
     * @return 无人机信息管理
     */
    @Override
    public UavTable selectUavTableById(Long id)
    {
        return uavTableMapper.selectUavTableById(id);
    }

    /**
     * 查询无人机信息管理列表
     * 
     * @param uavTable 无人机信息管理
     * @return 无人机信息管理
     */
    @Override
    public List<UavTable> selectUavTableList(UavTable uavTable)
    {
        return uavTableMapper.selectUavTableList(uavTable);
    }

    /**
     * 新增无人机信息管理
     * 
     * @param uavTable 无人机信息管理
     * @return 结果
     */
    @Override
    public int insertUavTable(UavTable uavTable)
    {
        return uavTableMapper.insertUavTable(uavTable);
    }

    /**
     * 修改无人机信息管理
     * 
     * @param uavTable 无人机信息管理
     * @return 结果
     */
    @Override
    public int updateUavTable(UavTable uavTable)
    {
        return uavTableMapper.updateUavTable(uavTable);
    }

    /**
     * 批量删除无人机信息管理
     * 
     * @param ids 需要删除的无人机信息管理主键
     * @return 结果
     */
    @Override
    public int deleteUavTableByIds(Long[] ids)
    {
        return uavTableMapper.deleteUavTableByIds(ids);
    }

    /**
     * 删除无人机信息管理信息
     * 
     * @param id 无人机信息管理主键
     * @return 结果
     */
    @Override
    public int deleteUavTableById(Long id)
    {
        return uavTableMapper.deleteUavTableById(id);
    }
}
