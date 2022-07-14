package com.ruoyi.system.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 社团用户对象 user
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
public class Users extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 用户名 */
    @Excel(name = "用户名")
    private String username;

    /** 密码 */
    @Excel(name = "密码")
    private String password;

    /** 姓名 */
    @Excel(name = "姓名")
    private String name;

    /** 0 男 1 女 */
    @Excel(name = "0 男 1 女")
    private Long sex;

    /** 所属学院 */
    @Excel(name = "所属学院")
    private String college;

    /** 0 学生  1 管理员  2 老师 （用户权限） */
    @Excel(name = "0 学生  1 管理员  2 老师 ", readConverterExp = "用=户权限")
    private Long role;

    /** 手机号 */
    @Excel(name = "手机号")
    private String phone;

    /** 邮箱 */
    @Excel(name = "邮箱")
    private String mail;

    /** 上次登录 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上次登录", width = 30, dateFormat = "yyyy-MM-dd")
    private Date lastLogin;

    /** 1 删除 0 存在 */
    @Excel(name = "1 删除 0 存在")
    private Long deleted;

    /** 用户头像 */
    @Excel(name = "用户头像")
    private String img;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUsername(String username) 
    {
        this.username = username;
    }

    public String getUsername() 
    {
        return username;
    }
    public void setPassword(String password) 
    {
        this.password = password;
    }

    public String getPassword() 
    {
        return password;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setSex(Long sex) 
    {
        this.sex = sex;
    }

    public Long getSex() 
    {
        return sex;
    }
    public void setCollege(String college) 
    {
        this.college = college;
    }

    public String getCollege() 
    {
        return college;
    }
    public void setRole(Long role) 
    {
        this.role = role;
    }

    public Long getRole() 
    {
        return role;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setMail(String mail) 
    {
        this.mail = mail;
    }

    public String getMail() 
    {
        return mail;
    }
    public void setLastLogin(Date lastLogin) 
    {
        this.lastLogin = lastLogin;
    }

    public Date getLastLogin() 
    {
        return lastLogin;
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
            .append("username", getUsername())
            .append("password", getPassword())
            .append("name", getName())
            .append("sex", getSex())
            .append("college", getCollege())
            .append("role", getRole())
            .append("phone", getPhone())
            .append("mail", getMail())
            .append("createTime", getCreateTime())
            .append("lastLogin", getLastLogin())
            .append("deleted", getDeleted())
            .append("img", getImg())
            .toString();
    }
}
