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
import com.ruoyi.manage.domain.Teachers;
import com.ruoyi.manage.service.ITeachersService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教师信息Controller
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
@RestController
@RequestMapping("/manage/teachers")
public class TeachersController extends BaseController
{
    @Autowired
    private ITeachersService teachersService;

    /**
     * 查询教师信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:teachers:list')")
    @GetMapping("/list")
    public TableDataInfo list(Teachers teachers)
    {
        startPage();
        List<Teachers> list = teachersService.selectTeachersList(teachers);
        return getDataTable(list);
    }

    /**
     * 导出教师信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:teachers:export')")
    @Log(title = "教师信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Teachers teachers)
    {
        List<Teachers> list = teachersService.selectTeachersList(teachers);
        ExcelUtil<Teachers> util = new ExcelUtil<Teachers>(Teachers.class);
        util.exportExcel(response, list, "教师信息数据");
    }

    /**
     * 获取教师信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:teachers:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(teachersService.selectTeachersById(id));
    }

    /**
     * 新增教师信息
     */
    @PreAuthorize("@ss.hasPermi('manage:teachers:add')")
    @Log(title = "教师信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Teachers teachers)
    {
        return toAjax(teachersService.insertTeachers(teachers));
    }

    /**
     * 修改教师信息
     */
    @PreAuthorize("@ss.hasPermi('manage:teachers:edit')")
    @Log(title = "教师信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Teachers teachers)
    {
        return toAjax(teachersService.updateTeachers(teachers));
    }

    /**
     * 删除教师信息
     */
    @PreAuthorize("@ss.hasPermi('manage:teachers:remove')")
    @Log(title = "教师信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(teachersService.deleteTeachersByIds(ids));
    }
}
