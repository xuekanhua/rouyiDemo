package com.ruoyi.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社团管理对象 club
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
public class Club extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 社团名称 */
    @Excel(name = "社团名称")
    private String name;

    /** 社团简介 */
    @Excel(name = "社团简介")
    private String introduce;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long createUser;

    /** 社团类别 */
    @Excel(name = "社团类别")
    private String type;

    /** 社团状态 */
    @Excel(name = "社团状态")
    private Long status;

    /** 是否删除 */
    @Excel(name = "是否删除")
    private Long deleted;

    /** 社团标志 */
    @Excel(name = "社团标志")
    private String img;

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
    public void setIntroduce(String introduce) 
    {
        this.introduce = introduce;
    }

    public String getIntroduce() 
    {
        return introduce;
    }
    public void setCreateUser(Long createUser) 
    {
        this.createUser = createUser;
    }

    public Long getCreateUser() 
    {
        return createUser;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }
    public void setDeleted(Long deleted) 
    {
        this.deleted = deleted;
    }

    public Long getDeleted() 
    {
        return deleted;
    }
    public void setImg(String img) 
    {
        this.img = img;
    }

    public String getImg() 
    {
        return img;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("introduce", getIntroduce())
            .append("createTime", getCreateTime())
            .append("createUser", getCreateUser())
            .append("type", getType())
            .append("status", getStatus())
            .append("deleted", getDeleted())
            .append("img", getImg())
            .toString();
    }
}
