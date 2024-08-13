package com.ruoyi.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教师信息对象 teachers
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
public class Teachers extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教师ID */
    private Long id;

    /** 教师姓名 */
    @Excel(name = "教师姓名")
    private String name;

    /** 所属学院ID */
    @Excel(name = "所属学院ID")
    private Long departmentId;

    /** 所属专业ID */
    @Excel(name = "所属专业ID")
    private Long professionalId;

    /** 职称 */
    @Excel(name = "职称")
    private String title;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setDepartmentId(Long departmentId) 
    {
        this.departmentId = departmentId;
    }

    public Long getDepartmentId() 
    {
        return departmentId;
    }
    public void setProfessionalId(Long professionalId) 
    {
        this.professionalId = professionalId;
    }

    public Long getProfessionalId() 
    {
        return professionalId;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("departmentId", getDepartmentId())
            .append("professionalId", getProfessionalId())
            .append("title", getTitle())
            .toString();
    }
}
