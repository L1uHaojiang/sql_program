package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.ClassroomAllocationsMapper;
import com.ruoyi.manage.domain.ClassroomAllocations;
import com.ruoyi.manage.service.IClassroomAllocationsService;

/**
 * 教室分配Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
@Service
public class ClassroomAllocationsServiceImpl implements IClassroomAllocationsService 
{
    @Autowired
    private ClassroomAllocationsMapper classroomAllocationsMapper;

    /**
     * 查询教室分配
     * 
     * @param id 教室分配主键
     * @return 教室分配
     */
    @Override
    public ClassroomAllocations selectClassroomAllocationsById(Long id)
    {
        return classroomAllocationsMapper.selectClassroomAllocationsById(id);
    }

    /**
     * 查询教室分配列表
     * 
     * @param classroomAllocations 教室分配
     * @return 教室分配
     */
    @Override
    public List<ClassroomAllocations> selectClassroomAllocationsList(ClassroomAllocations classroomAllocations)
    {
        return classroomAllocationsMapper.selectClassroomAllocationsList(classroomAllocations);
    }

    /**
     * 新增教室分配
     * 
     * @param classroomAllocations 教室分配
     * @return 结果
     */
    @Override
    public int insertClassroomAllocations(ClassroomAllocations classroomAllocations)
    {
        return classroomAllocationsMapper.insertClassroomAllocations(classroomAllocations);
    }

    /**
     * 修改教室分配
     * 
     * @param classroomAllocations 教室分配
     * @return 结果
     */
    @Override
    public int updateClassroomAllocations(ClassroomAllocations classroomAllocations)
    {
        return classroomAllocationsMapper.updateClassroomAllocations(classroomAllocations);
    }

    /**
     * 批量删除教室分配
     * 
     * @param ids 需要删除的教室分配主键
     * @return 结果
     */
    @Override
    public int deleteClassroomAllocationsByIds(Long[] ids)
    {
        return classroomAllocationsMapper.deleteClassroomAllocationsByIds(ids);
    }

    /**
     * 删除教室分配信息
     * 
     * @param id 教室分配主键
     * @return 结果
     */
    @Override
    public int deleteClassroomAllocationsById(Long id)
    {
        return classroomAllocationsMapper.deleteClassroomAllocationsById(id);
    }
}
