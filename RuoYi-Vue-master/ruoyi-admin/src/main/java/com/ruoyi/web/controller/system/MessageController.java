package com.ruoyi.web.controller.system;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.framework.web.domain.server.Sys;
import com.ruoyi.system.domain.Club;
import com.ruoyi.system.domain.dto.MessageDto;
import com.ruoyi.system.service.IClubService;
import com.ruoyi.system.service.ISysUserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.system.domain.Message;
import com.ruoyi.system.service.IMessageService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文章管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
@RestController
@RequestMapping("/system/message")
public class MessageController extends BaseController
{
    @Autowired
    private IMessageService messageService;

    @Autowired
    private IClubService clubService;

    @Autowired
    private ISysUserService userService;


    /**
     * 查询文章管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:message:list')")
    @Transactional
    @GetMapping("/list")
    public TableDataInfo list(Message message)
    {
        startPage();
        List<Message> list = messageService.selectMessageList(message);

        List<MessageDto> listDto = list.stream().map((item) -> {
            MessageDto messageDto = new MessageDto();
            BeanUtils.copyProperties(item, messageDto);
            SysUser createUser = userService.selectUserById(item.getCreateUser());
            if (createUser != null) {
                createUser.setPassword(null);
                messageDto.setCreateUserEntity(createUser);
            }
            SysUser updateUser = userService.selectUserById(item.getUpdateUser());
            if (updateUser != null) {
                updateUser.setPassword(null);
                messageDto.setUpdateUserEntity(updateUser);
            }
            Club club = clubService.selectClubById(item.getClubId());
            if (club != null) {
                messageDto.setClubEntity(club);
            }
            return messageDto;
        }).collect(Collectors.toList());

        return getDataTable(listDto);
    }

    /**
     * 导出文章管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:message:export')")
    @Log(title = "文章管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Message message)
    {
        List<Message> list = messageService.selectMessageList(message);
        ExcelUtil<Message> util = new ExcelUtil<Message>(Message.class);
        util.exportExcel(response, list, "文章管理数据");
    }

    /**
     * 获取文章管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:message:query')")
    @GetMapping(value = "/{id}")
    @Transactional
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        Message message = messageService.selectMessageById(id);

        MessageDto messageDto = new MessageDto();
        BeanUtils.copyProperties(message, messageDto);
        SysUser createUser = userService.selectUserById(messageDto.getCreateUser());
        if (createUser != null) {
            createUser.setPassword(null);
            messageDto.setCreateUserEntity(createUser);
        }
        SysUser updateUser = userService.selectUserById(messageDto.getUpdateUser());
        if (updateUser != null) {
            updateUser.setPassword(null);
            messageDto.setUpdateUserEntity(updateUser);
        }
        Club club = clubService.selectClubById(messageDto.getClubId());
        if (club != null) {
            messageDto.setClubEntity(club);
        }


        return AjaxResult.success(messageDto);
    }

    /**
     * 新增文章管理
     */
    @PreAuthorize("@ss.hasPermi('system:message:add')")
    @Log(title = "文章管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Message message)
    {
        return toAjax(messageService.insertMessage(message));
    }

    /**
     * 修改文章管理
     */
    @PreAuthorize("@ss.hasPermi('system:message:edit')")
    @Log(title = "文章管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Message message)
    {
        return toAjax(messageService.updateMessage(message));
    }

    /**
     * 删除文章管理
     */
    @PreAuthorize("@ss.hasPermi('system:message:remove')")
    @Log(title = "文章管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(messageService.deleteMessageByIds(ids));
    }
}
