package com.ruoyi.system.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ruoyi.system.domain.UserClub;
import com.ruoyi.system.domain.dto.UserClubDto;

/**
 * 用户社团Service接口
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
public interface IUserClubService extends IService<UserClub>
{

    public int updateUserClubByUserIds(Long[] ids);

    /**
     * 查询用户社团
     * 
     * @param id 用户社团主键
     * @return 用户社团
     */
    public UserClub selectUserClubById(Long id);

    /**
     * 查询用户社团列表
     * 
     * @param userClub 用户社团
     * @return 用户社团集合
     */
    public List<UserClub> selectUserClubList(UserClub userClub);

    /**
     * 查询用户社团列表
     *
     * @param userClub 用户社团
     * @return 用户社团集合
     */
//    public List<UserClubDto> selectUserClubListDto(UserClub userClub);

    /**
     * 新增用户社团
     * 
     * @param userClub 用户社团
     * @return 结果
     */
    public int insertUserClub(UserClub userClub);

    /**
     * 修改用户社团
     * 
     * @param userClub 用户社团
     * @return 结果
     */
    public int updateUserClub(UserClub userClub);

    /**
     * 批量删除用户社团
     * 
     * @param ids 需要删除的用户社团主键集合
     * @return 结果
     */
    public int deleteUserClubByIds(Long[] ids);

    /**
     * 删除用户社团信息
     * 
     * @param id 用户社团主键
     * @return 结果
     */
    public int deleteUserClubById(Long id);

    public int updateUserClubByClubIds(Long[] ids);
}
