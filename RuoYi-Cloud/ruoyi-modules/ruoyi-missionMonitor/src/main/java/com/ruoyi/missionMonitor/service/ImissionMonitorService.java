package com.ruoyi.missionMonitor.service;

import java.util.List;
import com.ruoyi.missionMonitor.domain.missionMonitor;

/**
 * 无人机信息管理Service接口
 * 
 * @author ruoyi
 * @date 2021-10-20
 */
public interface ImissionMonitorService 
{
    /**
     * 查询无人机信息管理
     * 
     * @param id 无人机信息管理主键
     * @return 无人机信息管理
     */
    public missionMonitor selectmissionMonitorById(Long id);

    /**
     * 查询无人机信息管理列表
     * 
     * @param missionMonitor 无人机信息管理
     * @return 无人机信息管理集合
     */
    public List<missionMonitor> selectmissionMonitorList(missionMonitor missionMonitor);

    /**
     * 新增无人机信息管理
     * 
     * @param missionMonitor 无人机信息管理
     * @return 结果
     */
    public int insertmissionMonitor(missionMonitor missionMonitor);

    /**
     * 修改无人机信息管理
     * 
     * @param missionMonitor 无人机信息管理
     * @return 结果
     */
    public int updatemissionMonitor(missionMonitor missionMonitor);

    /**
     * 批量删除无人机信息管理
     * 
     * @param ids 需要删除的无人机信息管理主键集合
     * @return 结果
     */
    public int deletemissionMonitorByIds(Long[] ids);

    /**
     * 删除无人机信息管理信息
     * 
     * @param id 无人机信息管理主键
     * @return 结果
     */
    public int deletemissionMonitorById(Long id);
}
