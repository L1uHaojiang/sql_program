package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.ClassroomBookingsMapper;
import com.ruoyi.manage.domain.ClassroomBookings;
import com.ruoyi.manage.service.IClassroomBookingsService;

/**
 * 教室借用Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
@Service
public class ClassroomBookingsServiceImpl implements IClassroomBookingsService 
{
    @Autowired
    private ClassroomBookingsMapper classroomBookingsMapper;

    /**
     * 查询教室借用
     * 
     * @param id 教室借用主键
     * @return 教室借用
     */
    @Override
    public ClassroomBookings selectClassroomBookingsById(Long id)
    {
        return classroomBookingsMapper.selectClassroomBookingsById(id);
    }

    /**
     * 查询教室借用列表
     * 
     * @param classroomBookings 教室借用
     * @return 教室借用
     */
    @Override
    public List<ClassroomBookings> selectClassroomBookingsList(ClassroomBookings classroomBookings)
    {
        return classroomBookingsMapper.selectClassroomBookingsList(classroomBookings);
    }

    /**
     * 新增教室借用
     * 
     * @param classroomBookings 教室借用
     * @return 结果
     */
    @Override
    public int insertClassroomBookings(ClassroomBookings classroomBookings)
    {
        return classroomBookingsMapper.insertClassroomBookings(classroomBookings);
    }

    /**
     * 修改教室借用
     * 
     * @param classroomBookings 教室借用
     * @return 结果
     */
    @Override
    public int updateClassroomBookings(ClassroomBookings classroomBookings)
    {
        return classroomBookingsMapper.updateClassroomBookings(classroomBookings);
    }

    /**
     * 批量删除教室借用
     * 
     * @param ids 需要删除的教室借用主键
     * @return 结果
     */
    @Override
    public int deleteClassroomBookingsByIds(Long[] ids)
    {
        return classroomBookingsMapper.deleteClassroomBookingsByIds(ids);
    }

    /**
     * 删除教室借用信息
     * 
     * @param id 教室借用主键
     * @return 结果
     */
    @Override
    public int deleteClassroomBookingsById(Long id)
    {
        return classroomBookingsMapper.deleteClassroomBookingsById(id);
    }
}
