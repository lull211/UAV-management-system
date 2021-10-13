package com.ruoyi.uav.service;

import java.util.List;
import com.ruoyi.uav.domain.UavTable;

/**
 * 无人机信息管理Service接口
 * 
 * @author ruoyi
 * @date 2021-10-08
 */
public interface IUavTableService 
{
    /**
     * 查询无人机信息管理
     * 
     * @param id 无人机信息管理主键
     * @return 无人机信息管理
     */
    public UavTable selectUavTableById(Long id);

    /**
     * 查询无人机信息管理列表
     * 
     * @param uavTable 无人机信息管理
     * @return 无人机信息管理集合
     */
    public List<UavTable> selectUavTableList(UavTable uavTable);

    /**
     * 新增无人机信息管理
     * 
     * @param uavTable 无人机信息管理
     * @return 结果
     */
    public int insertUavTable(UavTable uavTable);

    /**
     * 修改无人机信息管理
     * 
     * @param uavTable 无人机信息管理
     * @return 结果
     */
    public int updateUavTable(UavTable uavTable);

    /**
     * 批量删除无人机信息管理
     * 
     * @param ids 需要删除的无人机信息管理主键集合
     * @return 结果
     */
    public int deleteUavTableByIds(Long[] ids);

    /**
     * 删除无人机信息管理信息
     * 
     * @param id 无人机信息管理主键
     * @return 结果
     */
    public int deleteUavTableById(Long id);
}
