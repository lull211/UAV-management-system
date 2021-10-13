package com.ruoyi.systemprofile.mapper;

import java.util.List;
import com.ruoyi.systemprofile.domain.SysProfile;

/**
 * 系统设置Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-11
 */
public interface SysProfileMapper 
{
    /**
     * 查询系统设置
     * 
     * @param id 系统设置主键
     * @return 系统设置
     */
    public SysProfile selectSysProfileById(Long id);

    /**
     * 查询系统设置列表
     * 
     * @param sysProfile 系统设置
     * @return 系统设置集合
     */
    public List<SysProfile> selectSysProfileList(SysProfile sysProfile);

    /**
     * 新增系统设置
     * 
     * @param sysProfile 系统设置
     * @return 结果
     */
    public int insertSysProfile(SysProfile sysProfile);

    /**
     * 修改系统设置
     * 
     * @param sysProfile 系统设置
     * @return 结果
     */
    public int updateSysProfile(SysProfile sysProfile);

    /**
     * 删除系统设置
     * 
     * @param id 系统设置主键
     * @return 结果
     */
    public int deleteSysProfileById(Long id);

    /**
     * 批量删除系统设置
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteSysProfileByIds(Long[] ids);
}
