package com.ruoyi.uavdepartment.mapper;

import java.util.List;
import com.ruoyi.uavdepartment.domain.UavDepartment;

/**
 * 无人机归口部门Mapper接口
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
public interface UavDepartmentMapper 
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
     * 删除无人机归口部门
     * 
     * @param id 无人机归口部门主键
     * @return 结果
     */
    public int deleteUavDepartmentById(Long id);

    /**
     * 批量删除无人机归口部门
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUavDepartmentByIds(Long[] ids);
}
