package com.ruoyi.manage.mapper;

import java.util.List;
import com.ruoyi.manage.domain.ClassroomAllocations;

/**
 * 教室分配Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
public interface ClassroomAllocationsMapper 
{
    /**
     * 查询教室分配
     * 
     * @param id 教室分配主键
     * @return 教室分配
     */
    public ClassroomAllocations selectClassroomAllocationsById(Long id);

    /**
     * 查询教室分配列表
     * 
     * @param classroomAllocations 教室分配
     * @return 教室分配集合
     */
    public List<ClassroomAllocations> selectClassroomAllocationsList(ClassroomAllocations classroomAllocations);

    /**
     * 新增教室分配
     * 
     * @param classroomAllocations 教室分配
     * @return 结果
     */
    public int insertClassroomAllocations(ClassroomAllocations classroomAllocations);

    /**
     * 修改教室分配
     * 
     * @param classroomAllocations 教室分配
     * @return 结果
     */
    public int updateClassroomAllocations(ClassroomAllocations classroomAllocations);

    /**
     * 删除教室分配
     * 
     * @param id 教室分配主键
     * @return 结果
     */
    public int deleteClassroomAllocationsById(Long id);

    /**
     * 批量删除教室分配
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClassroomAllocationsByIds(Long[] ids);
}
