package com.ruoyi.missionMonitor.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.missionMonitor.mapper.missionMonitorMapper;
import com.ruoyi.missionMonitor.domain.missionMonitor;
import com.ruoyi.missionMonitor.service.ImissionMonitorService;

/**
 * 无人机信息管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-20
 */
@Service
public class missionMonitorServiceImpl implements ImissionMonitorService 
{
    @Autowired
    private missionMonitorMapper missionMonitorMapper;

    /**
     * 查询无人机信息管理
     * 
     * @param id 无人机信息管理主键
     * @return 无人机信息管理
     */
    @Override
    public missionMonitor selectmissionMonitorById(Long id)
    {
        return missionMonitorMapper.selectmissionMonitorById(id);
    }

    /**
     * 查询无人机信息管理列表
     * 
     * @param missionMonitor 无人机信息管理
     * @return 无人机信息管理
     */
    @Override
    public List<missionMonitor> selectmissionMonitorList(missionMonitor missionMonitor)
    {
        return missionMonitorMapper.selectmissionMonitorList(missionMonitor);
    }

    /**
     * 新增无人机信息管理
     * 
     * @param missionMonitor 无人机信息管理
     * @return 结果
     */
    @Override
    public int insertmissionMonitor(missionMonitor missionMonitor)
    {
        return missionMonitorMapper.insertmissionMonitor(missionMonitor);
    }

    /**
     * 修改无人机信息管理
     * 
     * @param missionMonitor 无人机信息管理
     * @return 结果
     */
    @Override
    public int updatemissionMonitor(missionMonitor missionMonitor)
    {
        return missionMonitorMapper.updatemissionMonitor(missionMonitor);
    }

    /**
     * 批量删除无人机信息管理
     * 
     * @param ids 需要删除的无人机信息管理主键
     * @return 结果
     */
    @Override
    public int deletemissionMonitorByIds(Long[] ids)
    {
        return missionMonitorMapper.deletemissionMonitorByIds(ids);
    }

    /**
     * 删除无人机信息管理信息
     * 
     * @param id 无人机信息管理主键
     * @return 结果
     */
    @Override
    public int deletemissionMonitorById(Long id)
    {
        return missionMonitorMapper.deletemissionMonitorById(id);
    }
}
