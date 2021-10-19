package com.ruoyi.flyrecord.service;

import java.util.List;
import com.ruoyi.flyrecord.domain.FlyRecord;

/**
 * 飞行记录Service接口
 * 
 * @author ruoyi
 * @date 2021-10-18
 */
public interface IFlyRecordService 
{
    /**
     * 查询飞行记录
     * 
     * @param id 飞行记录主键
     * @return 飞行记录
     */
    public FlyRecord selectFlyRecordById(Long id);

    /**
     * 查询飞行记录列表
     * 
     * @param flyRecord 飞行记录
     * @return 飞行记录集合
     */
    public List<FlyRecord> selectFlyRecordList(FlyRecord flyRecord);

    /**
     * 新增飞行记录
     * 
     * @param flyRecord 飞行记录
     * @return 结果
     */
    public int insertFlyRecord(FlyRecord flyRecord);

    /**
     * 修改飞行记录
     * 
     * @param flyRecord 飞行记录
     * @return 结果
     */
    public int updateFlyRecord(FlyRecord flyRecord);

    /**
     * 批量删除飞行记录
     * 
     * @param ids 需要删除的飞行记录主键集合
     * @return 结果
     */
    public int deleteFlyRecordByIds(Long[] ids);

    /**
     * 删除飞行记录信息
     * 
     * @param id 飞行记录主键
     * @return 结果
     */
    public int deleteFlyRecordById(Long id);
}
