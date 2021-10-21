package com.ruoyi.uavposition.service;

import java.util.List;
import com.ruoyi.uavposition.domain.UavPosition;

/**
 * 无人机实时位置测试Service接口
 * 
 * @author ruoyi
 * @date 2021-10-21
 */
public interface IUavPositionService 
{
    /**
     * 查询无人机实时位置测试
     * 
     * @param id 无人机实时位置测试主键
     * @return 无人机实时位置测试
     */
    public UavPosition selectUavPositionById(Long id);

    /**
     * 查询无人机实时位置测试列表
     * 
     * @param uavPosition 无人机实时位置测试
     * @return 无人机实时位置测试集合
     */
    public List<UavPosition> selectUavPositionList(UavPosition uavPosition);

    /**
     * 新增无人机实时位置测试
     * 
     * @param uavPosition 无人机实时位置测试
     * @return 结果
     */
    public int insertUavPosition(UavPosition uavPosition);

    /**
     * 修改无人机实时位置测试
     * 
     * @param uavPosition 无人机实时位置测试
     * @return 结果
     */
    public int updateUavPosition(UavPosition uavPosition);

    /**
     * 批量删除无人机实时位置测试
     * 
     * @param ids 需要删除的无人机实时位置测试主键集合
     * @return 结果
     */
    public int deleteUavPositionByIds(Long[] ids);

    /**
     * 删除无人机实时位置测试信息
     * 
     * @param id 无人机实时位置测试主键
     * @return 结果
     */
    public int deleteUavPositionById(Long id);
}
