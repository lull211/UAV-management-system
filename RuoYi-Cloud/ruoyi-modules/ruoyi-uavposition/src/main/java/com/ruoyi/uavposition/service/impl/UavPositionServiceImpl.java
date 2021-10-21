package com.ruoyi.uavposition.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.uavposition.mapper.UavPositionMapper;
import com.ruoyi.uavposition.domain.UavPosition;
import com.ruoyi.uavposition.service.IUavPositionService;

/**
 * 无人机实时位置测试Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-21
 */
@Service
public class UavPositionServiceImpl implements IUavPositionService 
{
    @Autowired
    private UavPositionMapper uavPositionMapper;

    /**
     * 查询无人机实时位置测试
     * 
     * @param id 无人机实时位置测试主键
     * @return 无人机实时位置测试
     */
    @Override
    public UavPosition selectUavPositionById(Long id)
    {
        return uavPositionMapper.selectUavPositionById(id);
    }

    /**
     * 查询无人机实时位置测试列表
     * 
     * @param uavPosition 无人机实时位置测试
     * @return 无人机实时位置测试
     */
    @Override
    public List<UavPosition> selectUavPositionList(UavPosition uavPosition)
    {
        return uavPositionMapper.selectUavPositionList(uavPosition);
    }

    /**
     * 新增无人机实时位置测试
     * 
     * @param uavPosition 无人机实时位置测试
     * @return 结果
     */
    @Override
    public int insertUavPosition(UavPosition uavPosition)
    {
        return uavPositionMapper.insertUavPosition(uavPosition);
    }

    /**
     * 修改无人机实时位置测试
     * 
     * @param uavPosition 无人机实时位置测试
     * @return 结果
     */
    @Override
    public int updateUavPosition(UavPosition uavPosition)
    {
        return uavPositionMapper.updateUavPosition(uavPosition);
    }

    /**
     * 批量删除无人机实时位置测试
     * 
     * @param ids 需要删除的无人机实时位置测试主键
     * @return 结果
     */
    @Override
    public int deleteUavPositionByIds(Long[] ids)
    {
        return uavPositionMapper.deleteUavPositionByIds(ids);
    }

    /**
     * 删除无人机实时位置测试信息
     * 
     * @param id 无人机实时位置测试主键
     * @return 结果
     */
    @Override
    public int deleteUavPositionById(Long id)
    {
        return uavPositionMapper.deleteUavPositionById(id);
    }
}
