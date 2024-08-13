package com.ruoyi.manage.mapper;

import java.util.List;
import com.ruoyi.manage.domain.ClassroomBookings;

/**
 * 教室借用Mapper接口
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
public interface ClassroomBookingsMapper 
{
    /**
     * 查询教室借用
     * 
     * @param id 教室借用主键
     * @return 教室借用
     */
    public ClassroomBookings selectClassroomBookingsById(Long id);

    /**
     * 查询教室借用列表
     * 
     * @param classroomBookings 教室借用
     * @return 教室借用集合
     */
    public List<ClassroomBookings> selectClassroomBookingsList(ClassroomBookings classroomBookings);

    /**
     * 新增教室借用
     * 
     * @param classroomBookings 教室借用
     * @return 结果
     */
    public int insertClassroomBookings(ClassroomBookings classroomBookings);

    /**
     * 修改教室借用
     * 
     * @param classroomBookings 教室借用
     * @return 结果
     */
    public int updateClassroomBookings(ClassroomBookings classroomBookings);

    /**
     * 删除教室借用
     * 
     * @param id 教室借用主键
     * @return 结果
     */
    public int deleteClassroomBookingsById(Long id);

    /**
     * 批量删除教室借用
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClassroomBookingsByIds(Long[] ids);
}
