package com.ruoyi.system.service;

import java.util.List;
import com.ruoyi.system.domain.UserActivity;

/**
 * 用户活动Service接口
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
public interface IUserActivityService 
{
    /**
     * 查询用户活动
     * 
     * @param id 用户活动主键
     * @return 用户活动
     */
    public UserActivity selectUserActivityById(Long id);

    /**
     * 查询用户活动列表
     * 
     * @param userActivity 用户活动
     * @return 用户活动集合
     */
    public List<UserActivity> selectUserActivityList(UserActivity userActivity);

    /**
     * 新增用户活动
     * 
     * @param userActivity 用户活动
     * @return 结果
     */
    public int insertUserActivity(UserActivity userActivity);

    /**
     * 修改用户活动
     * 
     * @param userActivity 用户活动
     * @return 结果
     */
    public int updateUserActivity(UserActivity userActivity);

    /**
     * 批量删除用户活动
     * 
     * @param ids 需要删除的用户活动主键集合
     * @return 结果
     */
    public int deleteUserActivityByIds(Long[] ids);

    /**
     * 删除用户活动信息
     * 
     * @param id 用户活动主键
     * @return 结果
     */
    public int deleteUserActivityById(Long id);
}
