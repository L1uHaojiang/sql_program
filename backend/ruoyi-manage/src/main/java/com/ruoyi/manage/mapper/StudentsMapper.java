package com.ruoyi.manage.mapper;

import java.util.List;
import com.ruoyi.manage.domain.Students;

/**
 * 学生信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
public interface StudentsMapper 
{
    /**
     * 查询学生信息
     * 
     * @param id 学生信息主键
     * @return 学生信息
     */
    public Students selectStudentsById(Long id);

    /**
     * 查询学生信息列表
     * 
     * @param students 学生信息
     * @return 学生信息集合
     */
    public List<Students> selectStudentsList(Students students);

    /**
     * 新增学生信息
     * 
     * @param students 学生信息
     * @return 结果
     */
    public int insertStudents(Students students);

    /**
     * 修改学生信息
     * 
     * @param students 学生信息
     * @return 结果
     */
    public int updateStudents(Students students);

    /**
     * 删除学生信息
     * 
     * @param id 学生信息主键
     * @return 结果
     */
    public int deleteStudentsById(Long id);

    /**
     * 批量删除学生信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStudentsByIds(Long[] ids);
}
