package com.ruoyi.flyrecord.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.flyrecord.mapper.FlyRecordMapper;
import com.ruoyi.flyrecord.domain.FlyRecord;
import com.ruoyi.flyrecord.service.IFlyRecordService;

/**
 * 飞行记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-18
 */
@Service
public class FlyRecordServiceImpl implements IFlyRecordService 
{
    @Autowired
    private FlyRecordMapper flyRecordMapper;

    /**
     * 查询飞行记录
     * 
     * @param id 飞行记录主键
     * @return 飞行记录
     */
    @Override
    public FlyRecord selectFlyRecordById(Long id)
    {
        return flyRecordMapper.selectFlyRecordById(id);
    }

    /**
     * 查询飞行记录列表
     * 
     * @param flyRecord 飞行记录
     * @return 飞行记录
     */
    @Override
    public List<FlyRecord> selectFlyRecordList(FlyRecord flyRecord)
    {
        return flyRecordMapper.selectFlyRecordList(flyRecord);
    }

    /**
     * 新增飞行记录
     * 
     * @param flyRecord 飞行记录
     * @return 结果
     */
    @Override
    public int insertFlyRecord(FlyRecord flyRecord)
    {
        return flyRecordMapper.insertFlyRecord(flyRecord);
    }

    /**
     * 修改飞行记录
     * 
     * @param flyRecord 飞行记录
     * @return 结果
     */
    @Override
    public int updateFlyRecord(FlyRecord flyRecord)
    {
        return flyRecordMapper.updateFlyRecord(flyRecord);
    }

    /**
     * 批量删除飞行记录
     * 
     * @param ids 需要删除的飞行记录主键
     * @return 结果
     */
    @Override
    public int deleteFlyRecordByIds(Long[] ids)
    {
        return flyRecordMapper.deleteFlyRecordByIds(ids);
    }

    /**
     * 删除飞行记录信息
     * 
     * @param id 飞行记录主键
     * @return 结果
     */
    @Override
    public int deleteFlyRecordById(Long id)
    {
        return flyRecordMapper.deleteFlyRecordById(id);
    }
}
