package com.ruoyi.uav.mapper;

import java.util.List;
import com.ruoyi.uav.domain.UavTable;

/**
 * 无人机信息管理Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-08
 */
public interface UavTableMapper 
{
    /**
     * 查询无人机信息管理
     * 
     * @param id 无人机信息管理主键
     * @return 无人机信息管理
     */
    public UavTable selectUavTableById(Long id);


    /**
     * 通过无人机名字模糊获取
     * @param Name
     * @return
     */
    public Long selectUavTableByuavName(String Name);

    /**
     * 通过无人机名字精确获取
     * @param Name
     * @return
     */
    public UavTable selectUavTableByuavNameAcc(String Name);

    /**
     * 通过飞控编号查询无人机信息
     */
    public UavTable selectUavTableByuavFlightNumber(String uavFlightNumber);


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
     * 删除无人机信息管理
     * 
     * @param id 无人机信息管理主键
     * @return 结果
     */
    public int deleteUavTableById(Long id);

    /**
     * 批量删除无人机信息管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUavTableByIds(Long[] ids);
}
