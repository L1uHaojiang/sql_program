package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.Departments;

/**
 * 学院信息Service接口
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
public interface IDepartmentsService 
{
    /**
     * 查询学院信息
     * 
     * @param id 学院信息主键
     * @return 学院信息
     */
    public Departments selectDepartmentsById(Long id);

    /**
     * 查询学院信息列表
     * 
     * @param departments 学院信息
     * @return 学院信息集合
     */
    public List<Departments> selectDepartmentsList(Departments departments);

    /**
     * 新增学院信息
     * 
     * @param departments 学院信息
     * @return 结果
     */
    public int insertDepartments(Departments departments);

    /**
     * 修改学院信息
     * 
     * @param departments 学院信息
     * @return 结果
     */
    public int updateDepartments(Departments departments);

    /**
     * 批量删除学院信息
     * 
     * @param ids 需要删除的学院信息主键集合
     * @return 结果
     */
    public int deleteDepartmentsByIds(Long[] ids);

    /**
     * 删除学院信息信息
     * 
     * @param id 学院信息主键
     * @return 结果
     */
    public int deleteDepartmentsById(Long id);
}
