package com.ruoyi.manage.mapper;

import java.util.List;
import com.ruoyi.manage.domain.Teachers;

/**
 * 教师信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
public interface TeachersMapper 
{
    /**
     * 查询教师信息
     * 
     * @param id 教师信息主键
     * @return 教师信息
     */
    public Teachers selectTeachersById(Long id);

    /**
     * 查询教师信息列表
     * 
     * @param teachers 教师信息
     * @return 教师信息集合
     */
    public List<Teachers> selectTeachersList(Teachers teachers);

    /**
     * 新增教师信息
     * 
     * @param teachers 教师信息
     * @return 结果
     */
    public int insertTeachers(Teachers teachers);

    /**
     * 修改教师信息
     * 
     * @param teachers 教师信息
     * @return 结果
     */
    public int updateTeachers(Teachers teachers);

    /**
     * 删除教师信息
     * 
     * @param id 教师信息主键
     * @return 结果
     */
    public int deleteTeachersById(Long id);

    /**
     * 批量删除教师信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeachersByIds(Long[] ids);
}
