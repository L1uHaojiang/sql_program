package com.ruoyi.manage.service;

import java.util.List;
import com.ruoyi.manage.domain.Majors;

/**
 * 专业信息Service接口
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
public interface IMajorsService 
{
    /**
     * 查询专业信息
     * 
     * @param id 专业信息主键
     * @return 专业信息
     */
    public Majors selectMajorsById(Long id);

    /**
     * 查询专业信息列表
     * 
     * @param majors 专业信息
     * @return 专业信息集合
     */
    public List<Majors> selectMajorsList(Majors majors);

    /**
     * 新增专业信息
     * 
     * @param majors 专业信息
     * @return 结果
     */
    public int insertMajors(Majors majors);

    /**
     * 修改专业信息
     * 
     * @param majors 专业信息
     * @return 结果
     */
    public int updateMajors(Majors majors);

    /**
     * 批量删除专业信息
     * 
     * @param ids 需要删除的专业信息主键集合
     * @return 结果
     */
    public int deleteMajorsByIds(Long[] ids);

    /**
     * 删除专业信息信息
     * 
     * @param id 专业信息主键
     * @return 结果
     */
    public int deleteMajorsById(Long id);
}
