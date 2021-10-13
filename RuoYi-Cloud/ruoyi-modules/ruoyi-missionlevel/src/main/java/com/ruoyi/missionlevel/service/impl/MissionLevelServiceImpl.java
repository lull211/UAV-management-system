package com.ruoyi.missionlevel.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.missionlevel.mapper.MissionLevelMapper;
import com.ruoyi.missionlevel.domain.MissionLevel;
import com.ruoyi.missionlevel.service.IMissionLevelService;

/**
 * 任务等级Service业务层处理
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
@Service
public class MissionLevelServiceImpl implements IMissionLevelService 
{
    @Autowired
    private MissionLevelMapper missionLevelMapper;

    /**
     * 查询任务等级
     * 
     * @param id 任务等级主键
     * @return 任务等级
     */
    @Override
    public MissionLevel selectMissionLevelById(Long id)
    {
        return missionLevelMapper.selectMissionLevelById(id);
    }

    /**
     * 查询任务等级列表
     * 
     * @param missionLevel 任务等级
     * @return 任务等级
     */
    @Override
    public List<MissionLevel> selectMissionLevelList(MissionLevel missionLevel)
    {
        return missionLevelMapper.selectMissionLevelList(missionLevel);
    }

    /**
     * 新增任务等级
     * 
     * @param missionLevel 任务等级
     * @return 结果
     */
    @Override
    public int insertMissionLevel(MissionLevel missionLevel)
    {
        return missionLevelMapper.insertMissionLevel(missionLevel);
    }

    /**
     * 修改任务等级
     * 
     * @param missionLevel 任务等级
     * @return 结果
     */
    @Override
    public int updateMissionLevel(MissionLevel missionLevel)
    {
        return missionLevelMapper.updateMissionLevel(missionLevel);
    }

    /**
     * 批量删除任务等级
     * 
     * @param ids 需要删除的任务等级主键
     * @return 结果
     */
    @Override
    public int deleteMissionLevelByIds(Long[] ids)
    {
        return missionLevelMapper.deleteMissionLevelByIds(ids);
    }

    /**
     * 删除任务等级信息
     * 
     * @param id 任务等级主键
     * @return 结果
     */
    @Override
    public int deleteMissionLevelById(Long id)
    {
        return missionLevelMapper.deleteMissionLevelById(id);
    }
}
