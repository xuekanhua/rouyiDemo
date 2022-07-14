package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.Users;

/**
 * 社团用户Service接口
 * 
 * @author ruoyi
 * @date 2022-07-13
 */
public interface IUsersService 
{
    /**
     * 查询社团用户
     * 
     * @param id 社团用户主键
     * @return 社团用户
     */
    public Users selectUsersById(Long id);

    /**
     * 查询社团用户列表
     * 
     * @param users 社团用户
     * @return 社团用户集合
     */
    public List<Users> selectUsersList(Users users);

    /**
     * 新增社团用户
     * 
     * @param users 社团用户
     * @return 结果
     */
    public int insertUsers(Users users);

    /**
     * 修改社团用户
     * 
     * @param users 社团用户
     * @return 结果
     */
    public int updateUsers(Users users);

    /**
     * 批量删除社团用户
     * 
     * @param ids 需要删除的社团用户主键集合
     * @return 结果
     */
    public int deleteUsersByIds(Long[] ids);

    /**
     * 删除社团用户信息
     * 
     * @param id 社团用户主键
     * @return 结果
     */
    public int deleteUsersById(Long id);
}
