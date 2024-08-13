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
import com.ruoyi.manage.domain.Majors;
import com.ruoyi.manage.service.IMajorsService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 专业信息Controller
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
@RestController
@RequestMapping("/manage/majors")
public class MajorsController extends BaseController
{
    @Autowired
    private IMajorsService majorsService;

    /**
     * 查询专业信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:majors:list')")
    @GetMapping("/list")
    public TableDataInfo list(Majors majors)
    {
        startPage();
        List<Majors> list = majorsService.selectMajorsList(majors);
        return getDataTable(list);
    }

    /**
     * 导出专业信息列表
     */
    @PreAuthorize("@ss.hasPermi('manage:majors:export')")
    @Log(title = "专业信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Majors majors)
    {
        List<Majors> list = majorsService.selectMajorsList(majors);
        ExcelUtil<Majors> util = new ExcelUtil<Majors>(Majors.class);
        util.exportExcel(response, list, "专业信息数据");
    }

    /**
     * 获取专业信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('manage:majors:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return success(majorsService.selectMajorsById(id));
    }

    /**
     * 新增专业信息
     */
    @PreAuthorize("@ss.hasPermi('manage:majors:add')")
    @Log(title = "专业信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Majors majors)
    {
        return toAjax(majorsService.insertMajors(majors));
    }

    /**
     * 修改专业信息
     */
    @PreAuthorize("@ss.hasPermi('manage:majors:edit')")
    @Log(title = "专业信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Majors majors)
    {
        return toAjax(majorsService.updateMajors(majors));
    }

    /**
     * 删除专业信息
     */
    @PreAuthorize("@ss.hasPermi('manage:majors:remove')")
    @Log(title = "专业信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(majorsService.deleteMajorsByIds(ids));
    }
}
