package com.ruoyi.manage.mapper;

import java.util.List;
import com.ruoyi.manage.domain.Classrooms;

/**
 * 教室信息Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
public interface ClassroomsMapper 
{
    /**
     * 查询教室信息
     * 
     * @param id 教室信息主键
     * @return 教室信息
     */
    public Classrooms selectClassroomsById(Long id);

    /**
     * 查询教室信息列表
     * 
     * @param classrooms 教室信息
     * @return 教室信息集合
     */
    public List<Classrooms> selectClassroomsList(Classrooms classrooms);

    /**
     * 新增教室信息
     * 
     * @param classrooms 教室信息
     * @return 结果
     */
    public int insertClassrooms(Classrooms classrooms);

    /**
     * 修改教室信息
     * 
     * @param classrooms 教室信息
     * @return 结果
     */
    public int updateClassrooms(Classrooms classrooms);

    /**
     * 删除教室信息
     * 
     * @param id 教室信息主键
     * @return 结果
     */
    public int deleteClassroomsById(Long id);

    /**
     * 批量删除教室信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClassroomsByIds(Long[] ids);
}
