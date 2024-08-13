package com.ruoyi.manage.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.manage.domain.Classrooms;
import com.ruoyi.manage.service.IClassroomsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教室信息Controller
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
@RestController
@RequestMapping("/manage/classrooms")
public class ClassroomsController extends BaseController
{
    @Autowired
    private IClassroomsService classroomsService;

    /**
     * 查询教室信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:classrooms:list')")
    @GetMapping("/list")
    public TableDataInfo list(Classrooms classrooms)
    {
        startPage();
        List<Classrooms> list = classroomsService.selectClassroomsList(classrooms);
        return getDataTable(list);
    }

    /**
     * 导出教室信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:classrooms:export')")
    @Log(title = "教室信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Classrooms classrooms)
    {
        List<Classrooms> list = classroomsService.selectClassroomsList(classrooms);
        ExcelUtil<Classrooms> util = new ExcelUtil<Classrooms>(Classrooms.class);
        util.exportExcel(response, list, "教室信息数据");
    }

    /**
     * 获取教室信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:classrooms:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(classroomsService.selectClassroomsById(id));
    }

    /**
     * 新增教室信息
     */
    @PreAuthorize("@ss.hasPermi('manage:classrooms:add')")
    @Log(title = "教室信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Classrooms classrooms)
    {
        return toAjax(classroomsService.insertClassrooms(classrooms));
    }

    /**
     * 修改教室信息
     */
    @PreAuthorize("@ss.hasPermi('manage:classrooms:edit')")
    @Log(title = "教室信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Classrooms classrooms)
    {
        return toAjax(classroomsService.updateClassrooms(classrooms));
    }

    /**
     * 删除教室信息
     */
    @PreAuthorize("@ss.hasPermi('manage:classrooms:remove')")
    @Log(title = "教室信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(classroomsService.deleteClassroomsByIds(ids));
    }
}
