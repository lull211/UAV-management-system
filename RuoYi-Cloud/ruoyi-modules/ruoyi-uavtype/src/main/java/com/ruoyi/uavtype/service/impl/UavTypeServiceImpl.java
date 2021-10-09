package com.ruoyi.uavtype.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.uavtype.mapper.UavTypeMapper;
import com.ruoyi.uavtype.domain.UavType;
import com.ruoyi.uavtype.service.IUavTypeService;

/**
 * uavtypeService业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
@Service
public class UavTypeServiceImpl implements IUavTypeService 
{
    @Autowired
    private UavTypeMapper uavTypeMapper;

    /**
     * 查询uavtype
     * 
     * @param id uavtype主键
     * @return uavtype
     */
    @Override
    public UavType selectUavTypeById(Long id)
    {
        return uavTypeMapper.selectUavTypeById(id);
    }

    /**
     * 查询uavtype列表
     * 
     * @param uavType uavtype
     * @return uavtype
     */
    @Override
    public List<UavType> selectUavTypeList(UavType uavType)
    {
        return uavTypeMapper.selectUavTypeList(uavType);
    }

    /**
     * 新增uavtype
     * 
     * @param uavType uavtype
     * @return 结果
     */
    @Override
    public int insertUavType(UavType uavType)
    {
        return uavTypeMapper.insertUavType(uavType);
    }

    /**
     * 修改uavtype
     * 
     * @param uavType uavtype
     * @return 结果
     */
    @Override
    public int updateUavType(UavType uavType)
    {
        return uavTypeMapper.updateUavType(uavType);
    }

    /**
     * 批量删除uavtype
     * 
     * @param ids 需要删除的uavtype主键
     * @return 结果
     */
    @Override
    public int deleteUavTypeByIds(Long[] ids)
    {
        return uavTypeMapper.deleteUavTypeByIds(ids);
    }

    /**
     * 删除uavtype信息
     * 
     * @param id uavtype主键
     * @return 结果
     */
    @Override
    public int deleteUavTypeById(Long id)
    {
        return uavTypeMapper.deleteUavTypeById(id);
    }
}
