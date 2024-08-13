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
import com.ruoyi.manage.domain.ClassroomAllocations;
import com.ruoyi.manage.service.IClassroomAllocationsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教室分配Controller
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
@RestController
@RequestMapping("/manage/allocations")
public class ClassroomAllocationsController extends BaseController
{
    @Autowired
    private IClassroomAllocationsService classroomAllocationsService;

    /**
     * 查询教室分配列表
     */
    @PreAuthorize("@ss.hasPermi('manage:allocations:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClassroomAllocations classroomAllocations)
    {
        startPage();
        List<ClassroomAllocations> list = classroomAllocationsService.selectClassroomAllocationsList(classroomAllocations);
        return getDataTable(list);
    }

    /**
     * 导出教室分配列表
     */
    @PreAuthorize("@ss.hasPermi('manage:allocations:export')")
    @Log(title = "教室分配", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClassroomAllocations classroomAllocations)
    {
        List<ClassroomAllocations> list = classroomAllocationsService.selectClassroomAllocationsList(classroomAllocations);
        ExcelUtil<ClassroomAllocations> util = new ExcelUtil<ClassroomAllocations>(ClassroomAllocations.class);
        util.exportExcel(response, list, "教室分配数据");
    }

    /**
     * 获取教室分配详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:allocations:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(classroomAllocationsService.selectClassroomAllocationsById(id));
    }

    /**
     * 新增教室分配
     */
    @PreAuthorize("@ss.hasPermi('manage:allocations:add')")
    @Log(title = "教室分配", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClassroomAllocations classroomAllocations)
    {
        return toAjax(classroomAllocationsService.insertClassroomAllocations(classroomAllocations));
    }

    /**
     * 修改教室分配
     */
    @PreAuthorize("@ss.hasPermi('manage:allocations:edit')")
    @Log(title = "教室分配", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClassroomAllocations classroomAllocations)
    {
        return toAjax(classroomAllocationsService.updateClassroomAllocations(classroomAllocations));
    }

    /**
     * 删除教室分配
     */
    @PreAuthorize("@ss.hasPermi('manage:allocations:remove')")
    @Log(title = "教室分配", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(classroomAllocationsService.deleteClassroomAllocationsByIds(ids));
    }
}
