package com.ruoyi.uavtype.mapper;

import java.util.List;
import com.ruoyi.uavtype.domain.UavType;

/**
 * uavtypeMapper接口
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
public interface UavTypeMapper 
{
    /**
     * 查询uavtype
     * 
     * @param id uavtype主键
     * @return uavtype
     */
    public UavType selectUavTypeById(Long id);

    /**
     * 查询uavtype列表
     * 
     * @param uavType uavtype
     * @return uavtype集合
     */
    public List<UavType> selectUavTypeList(UavType uavType);

    /**
     * 新增uavtype
     * 
     * @param uavType uavtype
     * @return 结果
     */
    public int insertUavType(UavType uavType);

    /**
     * 修改uavtype
     * 
     * @param uavType uavtype
     * @return 结果
     */
    public int updateUavType(UavType uavType);

    /**
     * 删除uavtype
     * 
     * @param id uavtype主键
     * @return 结果
     */
    public int deleteUavTypeById(Long id);

    /**
     * 批量删除uavtype
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUavTypeByIds(Long[] ids);
}
