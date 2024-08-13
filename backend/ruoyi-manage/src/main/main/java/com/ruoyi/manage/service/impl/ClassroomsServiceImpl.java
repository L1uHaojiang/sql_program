package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.ClassroomsMapper;
import com.ruoyi.manage.domain.Classrooms;
import com.ruoyi.manage.service.IClassroomsService;

/**
 * 教室信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
@Service
public class ClassroomsServiceImpl implements IClassroomsService 
{
    @Autowired
    private ClassroomsMapper classroomsMapper;

    /**
     * 查询教室信息
     * 
     * @param id 教室信息主键
     * @return 教室信息
     */
    @Override
    public Classrooms selectClassroomsById(Long id)
    {
        return classroomsMapper.selectClassroomsById(id);
    }

    /**
     * 查询教室信息列表
     * 
     * @param classrooms 教室信息
     * @return 教室信息
     */
    @Override
    public List<Classrooms> selectClassroomsList(Classrooms classrooms)
    {
        return classroomsMapper.selectClassroomsList(classrooms);
    }

    /**
     * 新增教室信息
     * 
     * @param classrooms 教室信息
     * @return 结果
     */
    @Override
    public int insertClassrooms(Classrooms classrooms)
    {
        return classroomsMapper.insertClassrooms(classrooms);
    }

    /**
     * 修改教室信息
     * 
     * @param classrooms 教室信息
     * @return 结果
     */
    @Override
    public int updateClassrooms(Classrooms classrooms)
    {
        return classroomsMapper.updateClassrooms(classrooms);
    }

    /**
     * 批量删除教室信息
     * 
     * @param ids 需要删除的教室信息主键
     * @return 结果
     */
    @Override
    public int deleteClassroomsByIds(Long[] ids)
    {
        return classroomsMapper.deleteClassroomsByIds(ids);
    }

    /**
     * 删除教室信息信息
     * 
     * @param id 教室信息主键
     * @return 结果
     */
    @Override
    public int deleteClassroomsById(Long id)
    {
        return classroomsMapper.deleteClassroomsById(id);
    }
}
