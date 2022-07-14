package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserClubMapper;
import com.ruoyi.system.domain.UserClub;
import com.ruoyi.system.service.IUserClubService;

/**
 * 用户社团Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
@Service
public class UserClubServiceImpl implements IUserClubService 
{
    @Autowired
    private UserClubMapper userClubMapper;

    /**
     * 查询用户社团
     * 
     * @param id 用户社团主键
     * @return 用户社团
     */
    @Override
    public UserClub selectUserClubById(Long id)
    {
        return userClubMapper.selectUserClubById(id);
    }

    /**
     * 查询用户社团列表
     * 
     * @param userClub 用户社团
     * @return 用户社团
     */
    @Override
    public List<UserClub> selectUserClubList(UserClub userClub)
    {
        return userClubMapper.selectUserClubList(userClub);
    }

    /**
     * 新增用户社团
     * 
     * @param userClub 用户社团
     * @return 结果
     */
    @Override
    public int insertUserClub(UserClub userClub)
    {
        userClub.setUserRole("申请加入");
        userClub.setSort(999L);
        return userClubMapper.insertUserClub(userClub);
    }

    /**
     * 修改用户社团
     * 
     * @param userClub 用户社团
     * @return 结果
     */
    @Override
    public int updateUserClub(UserClub userClub)
    {
        return userClubMapper.updateUserClub(userClub);
    }

    /**
     * 批量删除用户社团
     * 
     * @param ids 需要删除的用户社团主键
     * @return 结果
     */
    @Override
    public int deleteUserClubByIds(Long[] ids)
    {
        return userClubMapper.deleteUserClubByIds(ids);
    }

    /**
     * 删除用户社团信息
     * 
     * @param id 用户社团主键
     * @return 结果
     */
    @Override
    public int deleteUserClubById(Long id)
    {
        return userClubMapper.deleteUserClubById(id);
    }
}
