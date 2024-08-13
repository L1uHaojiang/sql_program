package com.ruoyi.manage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教室信息对象 classrooms
 * 
 * @author ruoyi
 * @date 2024-08-13
 */
public class Classrooms extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 教室ID */
    private Long id;

    /** 教室名称 */
    @Excel(name = "教室名称")
    private String name;

    /** 教室容量 */
    @Excel(name = "教室容量")
    private Long capacity;

    /** 所在教学楼 */
    @Excel(name = "所在教学楼")
    private String building;

    /** 楼层 */
    @Excel(name = "楼层")
    private Long floor;

    /** 教室设备 */
    @Excel(name = "教室设备")
    private String equipment;

    /** 教室状态 */
    @Excel(name = "教室状态")
    private String status;

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
    public void setCapacity(Long capacity) 
    {
        this.capacity = capacity;
    }

    public Long getCapacity() 
    {
        return capacity;
    }
    public void setBuilding(String building) 
    {
        this.building = building;
    }

    public String getBuilding() 
    {
        return building;
    }
    public void setFloor(Long floor) 
    {
        this.floor = floor;
    }

    public Long getFloor() 
    {
        return floor;
    }
    public void setEquipment(String equipment) 
    {
        this.equipment = equipment;
    }

    public String getEquipment() 
    {
        return equipment;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("capacity", getCapacity())
            .append("building", getBuilding())
            .append("floor", getFloor())
            .append("equipment", getEquipment())
            .append("status", getStatus())
            .toString();
    }
}
