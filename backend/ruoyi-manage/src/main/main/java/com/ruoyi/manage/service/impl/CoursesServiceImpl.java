package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.CoursesMapper;
import com.ruoyi.manage.domain.Courses;
import com.ruoyi.manage.service.ICoursesService;

/**
 * 课程信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
@Service
public class CoursesServiceImpl implements ICoursesService 
{
    @Autowired
    private CoursesMapper coursesMapper;

    /**
     * 查询课程信息
     * 
     * @param id 课程信息主键
     * @return 课程信息
     */
    @Override
    public Courses selectCoursesById(Long id)
    {
        return coursesMapper.selectCoursesById(id);
    }

    /**
     * 查询课程信息列表
     * 
     * @param courses 课程信息
     * @return 课程信息
     */
    @Override
    public List<Courses> selectCoursesList(Courses courses)
    {
        return coursesMapper.selectCoursesList(courses);
    }

    /**
     * 新增课程信息
     * 
     * @param courses 课程信息
     * @return 结果
     */
    @Override
    public int insertCourses(Courses courses)
    {
        return coursesMapper.insertCourses(courses);
    }

    /**
     * 修改课程信息
     * 
     * @param courses 课程信息
     * @return 结果
     */
    @Override
    public int updateCourses(Courses courses)
    {
        return coursesMapper.updateCourses(courses);
    }

    /**
     * 批量删除课程信息
     * 
     * @param ids 需要删除的课程信息主键
     * @return 结果
     */
    @Override
    public int deleteCoursesByIds(Long[] ids)
    {
        return coursesMapper.deleteCoursesByIds(ids);
    }

    /**
     * 删除课程信息信息
     * 
     * @param id 课程信息主键
     * @return 结果
     */
    @Override
    public int deleteCoursesById(Long id)
    {
        return coursesMapper.deleteCoursesById(id);
    }
}
