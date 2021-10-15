package com.ruoyi.myflyrecord.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.myflyrecord.mapper.MyFlyRecordMapper;
import com.ruoyi.myflyrecord.domain.MyFlyRecord;
import com.ruoyi.myflyrecord.service.IMyFlyRecordService;

/**
 * 我的飞行记录Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-14
 */
@Service
public class MyFlyRecordServiceImpl implements IMyFlyRecordService 
{
    @Autowired
    private MyFlyRecordMapper myFlyRecordMapper;

    /**
     * 查询我的飞行记录
     * 
     * @param id 我的飞行记录主键
     * @return 我的飞行记录
     */
    @Override
    public MyFlyRecord selectMyFlyRecordById(Long id)
    {
        return myFlyRecordMapper.selectMyFlyRecordById(id);
    }

    /**
     * 查询我的飞行记录列表
     * 
     * @param myFlyRecord 我的飞行记录
     * @return 我的飞行记录
     */
    @Override
    public List<MyFlyRecord> selectMyFlyRecordList(MyFlyRecord myFlyRecord)
    {
        return myFlyRecordMapper.selectMyFlyRecordList(myFlyRecord);
    }

    /**
     * 新增我的飞行记录
     * 
     * @param myFlyRecord 我的飞行记录
     * @return 结果
     */
    @Override
    public int insertMyFlyRecord(MyFlyRecord myFlyRecord)
    {
        return myFlyRecordMapper.insertMyFlyRecord(myFlyRecord);
    }

    /**
     * 修改我的飞行记录
     * 
     * @param myFlyRecord 我的飞行记录
     * @return 结果
     */
    @Override
    public int updateMyFlyRecord(MyFlyRecord myFlyRecord)
    {
        return myFlyRecordMapper.updateMyFlyRecord(myFlyRecord);
    }

    /**
     * 批量删除我的飞行记录
     * 
     * @param ids 需要删除的我的飞行记录主键
     * @return 结果
     */
    @Override
    public int deleteMyFlyRecordByIds(Long[] ids)
    {
        return myFlyRecordMapper.deleteMyFlyRecordByIds(ids);
    }

    /**
     * 删除我的飞行记录信息
     * 
     * @param id 我的飞行记录主键
     * @return 结果
     */
    @Override
    public int deleteMyFlyRecordById(Long id)
    {
        return myFlyRecordMapper.deleteMyFlyRecordById(id);
    }
}
