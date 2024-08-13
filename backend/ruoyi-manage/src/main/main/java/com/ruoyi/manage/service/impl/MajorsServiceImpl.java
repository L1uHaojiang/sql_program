package com.ruoyi.manage.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.manage.mapper.MajorsMapper;
import com.ruoyi.manage.domain.Majors;
import com.ruoyi.manage.service.IMajorsService;

/**
 * 专业信息Service业务层处理
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
@Service
public class MajorsServiceImpl implements IMajorsService 
{
    @Autowired
    private MajorsMapper majorsMapper;

    /**
     * 查询专业信息
     * 
     * @param id 专业信息主键
     * @return 专业信息
     */
    @Override
    public Majors selectMajorsById(Long id)
    {
        return majorsMapper.selectMajorsById(id);
    }

    /**
     * 查询专业信息列表
     * 
     * @param majors 专业信息
     * @return 专业信息
     */
    @Override
    public List<Majors> selectMajorsList(Majors majors)
    {
        return majorsMapper.selectMajorsList(majors);
    }

    /**
     * 新增专业信息
     * 
     * @param majors 专业信息
     * @return 结果
     */
    @Override
    public int insertMajors(Majors majors)
    {
        return majorsMapper.insertMajors(majors);
    }

    /**
     * 修改专业信息
     * 
     * @param majors 专业信息
     * @return 结果
     */
    @Override
    public int updateMajors(Majors majors)
    {
        return majorsMapper.updateMajors(majors);
    }

    /**
     * 批量删除专业信息
     * 
     * @param ids 需要删除的专业信息主键
     * @return 结果
     */
    @Override
    public int deleteMajorsByIds(Long[] ids)
    {
        return majorsMapper.deleteMajorsByIds(ids);
    }

    /**
     * 删除专业信息信息
     * 
     * @param id 专业信息主键
     * @return 结果
     */
    @Override
    public int deleteMajorsById(Long id)
    {
        return majorsMapper.deleteMajorsById(id);
    }
}
