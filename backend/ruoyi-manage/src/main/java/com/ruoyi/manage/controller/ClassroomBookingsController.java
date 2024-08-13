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
import com.ruoyi.manage.domain.ClassroomBookings;
import com.ruoyi.manage.service.IClassroomBookingsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教室借用Controller
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
@RestController
@RequestMapping("/manage/bookings")
public class ClassroomBookingsController extends BaseController
{
    @Autowired
    private IClassroomBookingsService classroomBookingsService;

    /**
     * 查询教室借用列表
     */
    @PreAuthorize("@ss.hasPermi('manage:bookings:list')")
    @GetMapping("/list")
    public TableDataInfo list(ClassroomBookings classroomBookings)
    {
        startPage();
        List<ClassroomBookings> list = classroomBookingsService.selectClassroomBookingsList(classroomBookings);
        return getDataTable(list);
    }

    /**
     * 导出教室借用列表
     */
    @PreAuthorize("@ss.hasPermi('manage:bookings:export')")
    @Log(title = "教室借用", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ClassroomBookings classroomBookings)
    {
        List<ClassroomBookings> list = classroomBookingsService.selectClassroomBookingsList(classroomBookings);
        ExcelUtil<ClassroomBookings> util = new ExcelUtil<ClassroomBookings>(ClassroomBookings.class);
        util.exportExcel(response, list, "教室借用数据");
    }

    /**
     * 获取教室借用详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:bookings:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(classroomBookingsService.selectClassroomBookingsById(id));
    }

    /**
     * 新增教室借用
     */
    @PreAuthorize("@ss.hasPermi('manage:bookings:add')")
    @Log(title = "教室借用", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ClassroomBookings classroomBookings)
    {
        return toAjax(classroomBookingsService.insertClassroomBookings(classroomBookings));
    }

    /**
     * 修改教室借用
     */
    @PreAuthorize("@ss.hasPermi('manage:bookings:edit')")
    @Log(title = "教室借用", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ClassroomBookings classroomBookings)
    {
        return toAjax(classroomBookingsService.updateClassroomBookings(classroomBookings));
    }

    /**
     * 删除教室借用
     */
    @PreAuthorize("@ss.hasPermi('manage:bookings:remove')")
    @Log(title = "教室借用", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(classroomBookingsService.deleteClassroomBookingsByIds(ids));
    }
}
