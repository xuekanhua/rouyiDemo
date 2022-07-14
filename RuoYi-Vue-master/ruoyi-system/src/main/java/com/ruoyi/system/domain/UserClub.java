package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 用户社团对象 user_club
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
public class UserClub extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户id */
    @Excel(name = "用户id")
    private Long userId;

    /** 社团id */
    @Excel(name = "社团id")
    private Long clubId;

    /** 用户在社团的角色 */
    @Excel(name = "用户在社团的角色")
    private String userRole;

    /** 用户在社团的排序 */
    @Excel(name = "用户在社团的排序")
    private Long sort;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setClubId(Long clubId) 
    {
        this.clubId = clubId;
    }

    public Long getClubId() 
    {
        return clubId;
    }
    public void setUserRole(String userRole) 
    {
        this.userRole = userRole;
    }

    public String getUserRole() 
    {
        return userRole;
    }
    public void setSort(Long sort) 
    {
        this.sort = sort;
    }

    public Long getSort() 
    {
        return sort;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userId", getUserId())
            .append("clubId", getClubId())
            .append("userRole", getUserRole())
            .append("sort", getSort())
            .toString();
    }
}
