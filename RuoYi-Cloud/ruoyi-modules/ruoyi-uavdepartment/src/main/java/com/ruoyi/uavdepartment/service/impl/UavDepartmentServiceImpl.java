package com.ruoyi.uavdepartment.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.uavdepartment.mapper.UavDepartmentMapper;
import com.ruoyi.uavdepartment.domain.UavDepartment;
import com.ruoyi.uavdepartment.service.IUavDepartmentService;

/**
 * 无人机归口部门Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
@Service
public class UavDepartmentServiceImpl implements IUavDepartmentService 
{
    @Autowired
    private UavDepartmentMapper uavDepartmentMapper;

    /**
     * 查询无人机归口部门
     * 
     * @param id 无人机归口部门主键
     * @return 无人机归口部门
     */
    @Override
    public UavDepartment selectUavDepartmentById(Long id)
    {
        return uavDepartmentMapper.selectUavDepartmentById(id);
    }

    /**
     * 查询无人机归口部门列表
     * 
     * @param uavDepartment 无人机归口部门
     * @return 无人机归口部门
     */
    @Override
    public List<UavDepartment> selectUavDepartmentList(UavDepartment uavDepartment)
    {
        return uavDepartmentMapper.selectUavDepartmentList(uavDepartment);
    }

    /**
     * 新增无人机归口部门
     * 
     * @param uavDepartment 无人机归口部门
     * @return 结果
     */
    @Override
    public int insertUavDepartment(UavDepartment uavDepartment)
    {
        return uavDepartmentMapper.insertUavDepartment(uavDepartment);
    }

    /**
     * 修改无人机归口部门
     * 
     * @param uavDepartment 无人机归口部门
     * @return 结果
     */
    @Override
    public int updateUavDepartment(UavDepartment uavDepartment)
    {
        return uavDepartmentMapper.updateUavDepartment(uavDepartment);
    }

    /**
     * 批量删除无人机归口部门
     * 
     * @param ids 需要删除的无人机归口部门主键
     * @return 结果
     */
    @Override
    public int deleteUavDepartmentByIds(Long[] ids)
    {
        return uavDepartmentMapper.deleteUavDepartmentByIds(ids);
    }

    /**
     * 删除无人机归口部门信息
     * 
     * @param id 无人机归口部门主键
     * @return 结果
     */
    @Override
    public int deleteUavDepartmentById(Long id)
    {
        return uavDepartmentMapper.deleteUavDepartmentById(id);
    }
}
