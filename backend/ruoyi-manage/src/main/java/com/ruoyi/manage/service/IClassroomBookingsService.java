package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.ClassroomBookings;

/**
 * 教室借用Service接口
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
public interface IClassroomBookingsService 
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
     * 批量删除教室借用
     * 
     * @param ids 需要删除的教室借用主键集合
     * @return 结果
     */
    public int deleteClassroomBookingsByIds(Long[] ids);

    /**
     * 删除教室借用信息
     * 
     * @param id 教室借用主键
     * @return 结果
     */
    public int deleteClassroomBookingsById(Long id);
}
