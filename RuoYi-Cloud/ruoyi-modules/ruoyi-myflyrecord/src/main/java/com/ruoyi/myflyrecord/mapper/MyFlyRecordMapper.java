package com.ruoyi.myflyrecord.mapper;

import java.util.List;
import com.ruoyi.myflyrecord.domain.MyFlyRecord;

/**
 * 我的飞行记录Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-18
 */
public interface MyFlyRecordMapper 
{
    /**
     * 查询我的飞行记录
     * 
     * @param id 我的飞行记录主键
     * @return 我的飞行记录
     */
    public MyFlyRecord selectMyFlyRecordById(Long id);

    /**
     * 查询我的飞行记录列表
     * 
     * @param myFlyRecord 我的飞行记录
     * @return 我的飞行记录集合
     */
    public List<MyFlyRecord> selectMyFlyRecordList(MyFlyRecord myFlyRecord);

    /**
     * 新增我的飞行记录
     * 
     * @param myFlyRecord 我的飞行记录
     * @return 结果
     */
    public int insertMyFlyRecord(MyFlyRecord myFlyRecord);

    /**
     * 修改我的飞行记录
     * 
     * @param myFlyRecord 我的飞行记录
     * @return 结果
     */
    public int updateMyFlyRecord(MyFlyRecord myFlyRecord);

    /**
     * 删除我的飞行记录
     * 
     * @param id 我的飞行记录主键
     * @return 结果
     */
    public int deleteMyFlyRecordById(Long id);

    /**
     * 批量删除我的飞行记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMyFlyRecordByIds(Long[] ids);
}
