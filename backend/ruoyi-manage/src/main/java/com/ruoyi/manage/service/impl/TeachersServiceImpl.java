package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.TeachersMapper;
import com.ruoyi.manage.domain.Teachers;
import com.ruoyi.manage.service.ITeachersService;

/**
 * 教师信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
@Service
public class TeachersServiceImpl implements ITeachersService 
{
    @Autowired
    private TeachersMapper teachersMapper;

    /**
     * 查询教师信息
     * 
     * @param id 教师信息主键
     * @return 教师信息
     */
    @Override
    public Teachers selectTeachersById(Long id)
    {
        return teachersMapper.selectTeachersById(id);
    }

    /**
     * 查询教师信息列表
     * 
     * @param teachers 教师信息
     * @return 教师信息
     */
    @Override
    public List<Teachers> selectTeachersList(Teachers teachers)
    {
        return teachersMapper.selectTeachersList(teachers);
    }

    /**
     * 新增教师信息
     * 
     * @param teachers 教师信息
     * @return 结果
     */
    @Override
    public int insertTeachers(Teachers teachers)
    {
        return teachersMapper.insertTeachers(teachers);
    }

    /**
     * 修改教师信息
     * 
     * @param teachers 教师信息
     * @return 结果
     */
    @Override
    public int updateTeachers(Teachers teachers)
    {
        return teachersMapper.updateTeachers(teachers);
    }

    /**
     * 批量删除教师信息
     * 
     * @param ids 需要删除的教师信息主键
     * @return 结果
     */
    @Override
    public int deleteTeachersByIds(Long[] ids)
    {
        return teachersMapper.deleteTeachersByIds(ids);
    }

    /**
     * 删除教师信息信息
     * 
     * @param id 教师信息主键
     * @return 结果
     */
    @Override
    public int deleteTeachersById(Long id)
    {
        return teachersMapper.deleteTeachersById(id);
    }
}
