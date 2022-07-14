package com.ruoyi.system.mapper;

import java.util.List;
import com.ruoyi.system.domain.Message;

/**
 * 文章管理Mapper接口
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
public interface MessageMapper 
{
    /**
     * 查询文章管理
     * 
     * @param id 文章管理主键
     * @return 文章管理
     */
    public Message selectMessageById(Long id);

    /**
     * 查询文章管理列表
     * 
     * @param message 文章管理
     * @return 文章管理集合
     */
    public List<Message> selectMessageList(Message message);

    /**
     * 新增文章管理
     * 
     * @param message 文章管理
     * @return 结果
     */
    public int insertMessage(Message message);

    /**
     * 修改文章管理
     * 
     * @param message 文章管理
     * @return 结果
     */
    public int updateMessage(Message message);

    /**
     * 删除文章管理
     * 
     * @param id 文章管理主键
     * @return 结果
     */
    public int deleteMessageById(Long id);

    /**
     * 批量删除文章管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteMessageByIds(Long[] ids);

    public int updateMessageByClubIds(Long[] ids);
}
