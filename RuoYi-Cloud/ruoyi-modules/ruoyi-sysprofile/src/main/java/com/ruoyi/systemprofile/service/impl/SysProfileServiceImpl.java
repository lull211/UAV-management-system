package com.ruoyi.systemprofile.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.systemprofile.mapper.SysProfileMapper;
import com.ruoyi.systemprofile.domain.SysProfile;
import com.ruoyi.systemprofile.service.ISysProfileService;

/**
 * 系统设置Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-11
 */
@Service
public class SysProfileServiceImpl implements ISysProfileService 
{
    @Autowired
    private SysProfileMapper sysProfileMapper;

    /**
     * 查询系统设置
     * 
     * @param id 系统设置主键
     * @return 系统设置
     */
    @Override
    public SysProfile selectSysProfileById(Long id)
    {
        return sysProfileMapper.selectSysProfileById(id);
    }

    /**
     * 查询系统设置列表
     * 
     * @param sysProfile 系统设置
     * @return 系统设置
     */
    @Override
    public List<SysProfile> selectSysProfileList(SysProfile sysProfile)
    {
        return sysProfileMapper.selectSysProfileList(sysProfile);
    }

    /**
     * 新增系统设置
     * 
     * @param sysProfile 系统设置
     * @return 结果
     */
    @Override
    public int insertSysProfile(SysProfile sysProfile)
    {
        return sysProfileMapper.insertSysProfile(sysProfile);
    }

    /**
     * 修改系统设置
     * 
     * @param sysProfile 系统设置
     * @return 结果
     */
    @Override
    public int updateSysProfile(SysProfile sysProfile)
    {
        return sysProfileMapper.updateSysProfile(sysProfile);
    }

    /**
     * 批量删除系统设置
     * 
     * @param ids 需要删除的系统设置主键
     * @return 结果
     */
    @Override
    public int deleteSysProfileByIds(Long[] ids)
    {
        return sysProfileMapper.deleteSysProfileByIds(ids);
    }

    /**
     * 删除系统设置信息
     * 
     * @param id 系统设置主键
     * @return 结果
     */
    @Override
    public int deleteSysProfileById(Long id)
    {
        return sysProfileMapper.deleteSysProfileById(id);
    }
}
