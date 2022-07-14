package com.ruoyi.system.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.system.domain.UserClub;
import com.ruoyi.system.service.IUserClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.system.mapper.ClubMapper;
import com.ruoyi.system.domain.Club;
import com.ruoyi.system.service.IClubService;
import org.springframework.transaction.annotation.Transactional;

/**
 * 社团管理Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
@Service
public class ClubServiceImpl implements IClubService 
{
    @Autowired
    private ClubMapper clubMapper;

    @Autowired
    private IUserClubService userClubService;

    /**
     * 查询社团管理
     * 
     * @param id 社团管理主键
     * @return 社团管理
     */
    @Override
    public Club selectClubById(Long id)
    {
        return clubMapper.selectClubById(id);
    }

    /**
     * 查询社团管理列表
     * 
     * @param club 社团管理
     * @return 社团管理
     */
    @Override
    public List<Club> selectClubList(Club club)
    {
        return clubMapper.selectClubList(club);
    }

    /**
     * 新增社团管理
     * 
     * @param club 社团管理
     * @return 结果
     */
    @Override
    @Transactional
    public int insertClub(Club club)
    {
        club.setCreateTime(DateUtils.getNowDate());
        System.out.println(club.toString());
        clubMapper.insertClub(club);
        UserClub userClub = new UserClub();
        userClub.setClubId(club.getId());
        userClub.setUserId(club.getCreateUser());
        userClub.setUserRole("社长");
        userClub.setSort(0L);

        return userClubService.insertUserClub(userClub);

    }

    /**
     * 修改社团管理
     * 
     * @param club 社团管理
     * @return 结果
     */
    @Override
    public int updateClub(Club club)
    {
        return clubMapper.updateClub(club);
    }

    /**
     * 批量删除社团管理
     * 
     * @param ids 需要删除的社团管理主键
     * @return 结果
     */
    @Override
    public int deleteClubByIds(Long[] ids)
    {
        return clubMapper.deleteClubByIds(ids);
    }

    /**
     * 删除社团管理信息
     * 
     * @param id 社团管理主键
     * @return 结果
     */
    @Override
    public int deleteClubById(Long id)
    {
        return clubMapper.deleteClubById(id);
    }
}
