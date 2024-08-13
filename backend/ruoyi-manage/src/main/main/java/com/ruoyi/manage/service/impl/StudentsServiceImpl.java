package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.StudentsMapper;
import com.ruoyi.manage.domain.Students;
import com.ruoyi.manage.service.IStudentsService;

/**
 * 学生信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
@Service
public class StudentsServiceImpl implements IStudentsService 
{
    @Autowired
    private StudentsMapper studentsMapper;

    /**
     * 查询学生信息
     * 
     * @param id 学生信息主键
     * @return 学生信息
     */
    @Override
    public Students selectStudentsById(Long id)
    {
        return studentsMapper.selectStudentsById(id);
    }

    /**
     * 查询学生信息列表
     * 
     * @param students 学生信息
     * @return 学生信息
     */
    @Override
    public List<Students> selectStudentsList(Students students)
    {
        return studentsMapper.selectStudentsList(students);
    }

    /**
     * 新增学生信息
     * 
     * @param students 学生信息
     * @return 结果
     */
    @Override
    public int insertStudents(Students students)
    {
        return studentsMapper.insertStudents(students);
    }

    /**
     * 修改学生信息
     * 
     * @param students 学生信息
     * @return 结果
     */
    @Override
    public int updateStudents(Students students)
    {
        return studentsMapper.updateStudents(students);
    }

    /**
     * 批量删除学生信息
     * 
     * @param ids 需要删除的学生信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentsByIds(Long[] ids)
    {
        return studentsMapper.deleteStudentsByIds(ids);
    }

    /**
     * 删除学生信息信息
     * 
     * @param id 学生信息主键
     * @return 结果
     */
    @Override
    public int deleteStudentsById(Long id)
    {
        return studentsMapper.deleteStudentsById(id);
    }
}
