package com.ruoyi.uavposition.controller;

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
import com.ruoyi.uavposition.domain.UavPosition;
import com.ruoyi.uavposition.service.IUavPositionService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 无人机实时位置测试Controller
 * 
 * @author ruoyi
 * @date 2021-10-21
 */
@RestController
@RequestMapping("/uavposition")
public class UavPositionController extends BaseController
{
    @Autowired
    private IUavPositionService uavPositionService;

    /**
     * 查询无人机实时位置测试列表
     */
    @PreAuthorize(hasPermi = "uavposition:uavposition:list")
    @GetMapping("/list")
    public TableDataInfo list(UavPosition uavPosition)
    {
        System.out.println(uavPosition);
        startPage();
        List<UavPosition> list = uavPositionService.selectUavPositionList(uavPosition);
        return getDataTable(list);
    }

    /**
     * 导出无人机实时位置测试列表
     */
    @PreAuthorize(hasPermi = "uavposition:uavposition:export")
    @Log(title = "无人机实时位置测试", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UavPosition uavPosition) throws IOException
    {
        List<UavPosition> list = uavPositionService.selectUavPositionList(uavPosition);
        ExcelUtil<UavPosition> util = new ExcelUtil<UavPosition>(UavPosition.class);
        util.exportExcel(response, list, "无人机实时位置测试数据");
    }

    /**
     * 获取无人机实时位置测试详细信息
     */
    @PreAuthorize(hasPermi = "uavposition:uavposition:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(uavPositionService.selectUavPositionById(id));
    }

    /**
     * 新增无人机实时位置测试
     */
    @PreAuthorize(hasPermi = "uavposition:uavposition:add")
    @Log(title = "无人机实时位置测试", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UavPosition uavPosition)
    {
        return toAjax(uavPositionService.insertUavPosition(uavPosition));
    }

    /**
     * 修改无人机实时位置测试
     */
    @PreAuthorize(hasPermi = "uavposition:uavposition:edit")
    @Log(title = "无人机实时位置测试", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UavPosition uavPosition)
    {
        return toAjax(uavPositionService.updateUavPosition(uavPosition));
    }

    /**
     * 删除无人机实时位置测试
     */
    @PreAuthorize(hasPermi = "uavposition:uavposition:remove")
    @Log(title = "无人机实时位置测试", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(uavPositionService.deleteUavPositionByIds(ids));
    }
}
