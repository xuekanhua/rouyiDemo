package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Club;

/**
 * 社团管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
public interface ClubMapper 
{
    /**
     * 查询社团管理
     * 
     * @param id 社团管理主键
     * @return 社团管理
     */
    public Club selectClubById(Long id);

    /**
     * 查询社团管理列表
     * 
     * @param club 社团管理
     * @return 社团管理集合
     */
    public List<Club> selectClubList(Club club);

    /**
     * 新增社团管理
     * 
     * @param club 社团管理
     * @return 结果
     */
    public int insertClub(Club club);

    /**
     * 修改社团管理
     * 
     * @param club 社团管理
     * @return 结果
     */
    public int updateClub(Club club);

    /**
     * 删除社团管理
     * 
     * @param id 社团管理主键
     * @return 结果
     */
    public int deleteClubById(Long id);

    /**
     * 批量删除社团管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteClubByIds(Long[] ids);
}
