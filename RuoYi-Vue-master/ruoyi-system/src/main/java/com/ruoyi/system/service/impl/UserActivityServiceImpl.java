package com.ruoyi.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.UserActivityMapper;
import com.ruoyi.system.domain.UserActivity;
import com.ruoyi.system.service.IUserActivityService;

/**
 * 用户活动Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
@Service
public class UserActivityServiceImpl implements IUserActivityService 
{
    @Autowired
    private UserActivityMapper userActivityMapper;

    /**
     * 查询用户活动
     * 
     * @param id 用户活动主键
     * @return 用户活动
     */
    @Override
    public UserActivity selectUserActivityById(Long id)
    {
        return userActivityMapper.selectUserActivityById(id);
    }

    /**
     * 查询用户活动列表
     * 
     * @param userActivity 用户活动
     * @return 用户活动
     */
    @Override
    public List<UserActivity> selectUserActivityList(UserActivity userActivity)
    {
        return userActivityMapper.selectUserActivityList(userActivity);
    }

    /**
     * 新增用户活动
     * 
     * @param userActivity 用户活动
     * @return 结果
     */
    @Override
    public int insertUserActivity(UserActivity userActivity)
    {
        return userActivityMapper.insertUserActivity(userActivity);
    }

    /**
     * 修改用户活动
     * 
     * @param userActivity 用户活动
     * @return 结果
     */
    @Override
    public int updateUserActivity(UserActivity userActivity)
    {
        return userActivityMapper.updateUserActivity(userActivity);
    }

    /**
     * 批量删除用户活动
     * 
     * @param ids 需要删除的用户活动主键
     * @return 结果
     */
    @Override
    public int deleteUserActivityByIds(Long[] ids)
    {
        return userActivityMapper.deleteUserActivityByIds(ids);
    }

    /**
     * 删除用户活动信息
     * 
     * @param id 用户活动主键
     * @return 结果
     */
    @Override
    public int deleteUserActivityById(Long id)
    {
        return userActivityMapper.deleteUserActivityById(id);
    }

    @Override
    public int deleteUserActivityByUserIds(Long[] userIds) {
        return userActivityMapper.deleteUserActivityByUserIds(userIds);
    }

    @Override
    public int deleteUserActivityByActivityIds(Long[] ids) {
        return userActivityMapper.deleteUserActivityByActivityIds(ids);
    }
}
