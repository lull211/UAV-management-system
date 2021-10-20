package com.ruoyi.missionlevel.service;

import java.util.List;
import com.ruoyi.missionlevel.domain.MissionLevel;

/**
 * 任务等级Service接口
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
public interface IMissionLevelService 
{
    /**
     * 查询任务等级
     * 
     * @param id 任务等级主键
     * @return 任务等级
     */
    public MissionLevel selectMissionLevelById(Long id);

    /**
     * 查询任务等级列表
     * 
     * @param missionLevel 任务等级
     * @return 任务等级集合
     */
    public List<MissionLevel> selectMissionLevelList(MissionLevel missionLevel);

    /**
     * 新增任务等级
     * 
     * @param missionLevel 任务等级
     * @return 结果
     */
    public int insertMissionLevel(MissionLevel missionLevel);

    /**
     * 修改任务等级
     * 
     * @param missionLevel 任务等级
     * @return 结果
     */
    public int updateMissionLevel(MissionLevel missionLevel);

    /**
     * 批量删除任务等级
     * 
     * @param ids 需要删除的任务等级主键集合
     * @return 结果
     */
    public int deleteMissionLevelByIds(Long[] ids);

    /**
     * 删除任务等级信息
     * 
     * @param id 任务等级主键
     * @return 结果
     */
    public int deleteMissionLevelById(Long id);
}
