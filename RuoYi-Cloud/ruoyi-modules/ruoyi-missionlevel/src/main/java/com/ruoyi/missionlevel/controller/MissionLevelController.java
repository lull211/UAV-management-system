package com.ruoyi.missionlevel.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.PreAuthorize;
import com.ruoyi.missionlevel.domain.MissionLevel;
import com.ruoyi.missionlevel.service.IMissionLevelService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 任务等级Controller
 * 
 * @author ruoyi
 * @date 2021-10-09
 */
@RestController
@RequestMapping("/missionlevel")
public class MissionLevelController extends BaseController
{
    @Autowired
    private IMissionLevelService missionLevelService;

    /**
     * 查询任务等级列表
     */
    @PreAuthorize(hasPermi = "missionlevel:missionlevel:list")
    @GetMapping("/list")
    public TableDataInfo list(MissionLevel missionLevel)
    {
        startPage();
        List<MissionLevel> list = missionLevelService.selectMissionLevelList(missionLevel);
        return getDataTable(list);
    }

    /**
     * 导出任务等级列表
     */
    @PreAuthorize(hasPermi = "missionlevel:missionlevel:export")
    @Log(title = "任务等级", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MissionLevel missionLevel) throws IOException
    {
        List<MissionLevel> list = missionLevelService.selectMissionLevelList(missionLevel);
        ExcelUtil<MissionLevel> util = new ExcelUtil<MissionLevel>(MissionLevel.class);
        util.exportExcel(response, list, "任务等级数据");
    }

    /**
     * 获取任务等级详细信息
     */
    @PreAuthorize(hasPermi = "missionlevel:missionlevel:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(missionLevelService.selectMissionLevelById(id));
    }

    /**
     * 新增任务等级
     */
    @PreAuthorize(hasPermi = "missionlevel:missionlevel:add")
    @Log(title = "任务等级", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MissionLevel missionLevel)
    {
        return toAjax(missionLevelService.insertMissionLevel(missionLevel));
    }

    /**
     * 修改任务等级
     */
    @PreAuthorize(hasPermi = "missionlevel:missionlevel:edit")
    @Log(title = "任务等级", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MissionLevel missionLevel)
    {
        return toAjax(missionLevelService.updateMissionLevel(missionLevel));
    }

    /**
     * 删除任务等级
     */
    @PreAuthorize(hasPermi = "missionlevel:missionlevel:remove")
    @Log(title = "任务等级", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(missionLevelService.deleteMissionLevelByIds(ids));
    }
}
