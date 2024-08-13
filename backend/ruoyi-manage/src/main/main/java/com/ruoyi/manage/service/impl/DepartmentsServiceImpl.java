package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.DepartmentsMapper;
import com.ruoyi.manage.domain.Departments;
import com.ruoyi.manage.service.IDepartmentsService;

/**
 * 学院信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
@Service
public class DepartmentsServiceImpl implements IDepartmentsService 
{
    @Autowired
    private DepartmentsMapper departmentsMapper;

    /**
     * 查询学院信息
     * 
     * @param id 学院信息主键
     * @return 学院信息
     */
    @Override
    public Departments selectDepartmentsById(Long id)
    {
        return departmentsMapper.selectDepartmentsById(id);
    }

    /**
     * 查询学院信息列表
     * 
     * @param departments 学院信息
     * @return 学院信息
     */
    @Override
    public List<Departments> selectDepartmentsList(Departments departments)
    {
        return departmentsMapper.selectDepartmentsList(departments);
    }

    /**
     * 新增学院信息
     * 
     * @param departments 学院信息
     * @return 结果
     */
    @Override
    public int insertDepartments(Departments departments)
    {
        return departmentsMapper.insertDepartments(departments);
    }

    /**
     * 修改学院信息
     * 
     * @param departments 学院信息
     * @return 结果
     */
    @Override
    public int updateDepartments(Departments departments)
    {
        return departmentsMapper.updateDepartments(departments);
    }

    /**
     * 批量删除学院信息
     * 
     * @param ids 需要删除的学院信息主键
     * @return 结果
     */
    @Override
    public int deleteDepartmentsByIds(Long[] ids)
    {
        return departmentsMapper.deleteDepartmentsByIds(ids);
    }

    /**
     * 删除学院信息信息
     * 
     * @param id 学院信息主键
     * @return 结果
     */
    @Override
    public int deleteDepartmentsById(Long id)
    {
        return departmentsMapper.deleteDepartmentsById(id);
    }
}
