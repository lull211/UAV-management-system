package com.ruoyi.flyrecord.mapper;

import java.util.List;
import com.ruoyi.flyrecord.domain.FlyRecord;

/**
 * 飞行记录Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-14
 */
public interface FlyRecordMapper 
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
     * 删除飞行记录
     * 
     * @param id 飞行记录主键
     * @return 结果
     */
    public int deleteFlyRecordById(Long id);

    /**
     * 批量删除飞行记录
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFlyRecordByIds(Long[] ids);
}
