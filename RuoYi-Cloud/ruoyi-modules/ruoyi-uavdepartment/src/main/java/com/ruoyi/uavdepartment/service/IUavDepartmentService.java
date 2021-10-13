package com.ruoyi.uavdepartment.service;

import java.util.List;
import com.ruoyi.uavdepartment.domain.UavDepartment;

/**
 * 无人机归口部门Service接口
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
public interface IUavDepartmentService 
{
    /**
     * 查询无人机归口部门
     * 
     * @param id 无人机归口部门主键
     * @return 无人机归口部门
     */
    public UavDepartment selectUavDepartmentById(Long id);

    /**
     * 查询无人机归口部门列表
     * 
     * @param uavDepartment 无人机归口部门
     * @return 无人机归口部门集合
     */
    public List<UavDepartment> selectUavDepartmentList(UavDepartment uavDepartment);

    /**
     * 新增无人机归口部门
     * 
     * @param uavDepartment 无人机归口部门
     * @return 结果
     */
    public int insertUavDepartment(UavDepartment uavDepartment);

    /**
     * 修改无人机归口部门
     * 
     * @param uavDepartment 无人机归口部门
     * @return 结果
     */
    public int updateUavDepartment(UavDepartment uavDepartment);

    /**
     * 批量删除无人机归口部门
     * 
     * @param ids 需要删除的无人机归口部门主键集合
     * @return 结果
     */
    public int deleteUavDepartmentByIds(Long[] ids);

    /**
     * 删除无人机归口部门信息
     * 
     * @param id 无人机归口部门主键
     * @return 结果
     */
    public int deleteUavDepartmentById(Long id);
}
