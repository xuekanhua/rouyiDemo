package com.ruoyi.web.controller.system;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.system.domain.Club;
import com.ruoyi.system.domain.UserClub;
import com.ruoyi.system.domain.dto.UserClubDto;
import com.ruoyi.system.service.IClubService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.IUserClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 用户社团Controller
 *
 * @author ruoyi
 * @date 2022-07-14
 */
@RestController
@RequestMapping("/system/userClub")
public class UserClubController extends BaseController {
    @Autowired
    private IUserClubService userClubService;

    @Autowired
    private IClubService clubService;

    @Autowired
    private ISysUserService userService;


    /**
     * 申请加入l
     * @param userClub
     * @return
     */
    @PostMapping("/join")
    public AjaxResult joinClub(@RequestBody UserClub userClub) {
        userClub.setUserRole("申请加入");
        userClub.setSort(999L);
        return AjaxResult.success(userClubService.insertUserClub(userClub));
    }



    /**
     * 查询用户社团列表
     */
    @PreAuthorize("@ss.hasPermi('system:userClub:list')")
    @GetMapping("/list")
    @Transactional
    public TableDataInfo list(UserClub userClub) {
        startPage();
        List<UserClub> list = userClubService.selectUserClubList(userClub);
        List<UserClubDto> listDto = list.stream().map((item) -> {
            UserClubDto userClubDto = new UserClubDto(item);
            Club club = clubService.selectClubById(item.getClubId());
            if (club != null) {
                userClubDto.setClubEntity(club);
            }
            SysUser user = userService.selectUserById(item.getUserId());
            if (user != null) {
                user.setPassword(null);
                userClubDto.setUserEntity(user);
            }

            return userClubDto;
        }).collect(Collectors.toList());

        return getDataTable(listDto);
    }

    /**
     * 导出用户社团列表
     */
    @PreAuthorize("@ss.hasPermi('system:userClub:export')")
    @Log(title = "用户社团", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserClub userClub) {
        List<UserClub> list = userClubService.selectUserClubList(userClub);
        ExcelUtil<UserClub> util = new ExcelUtil<UserClub>(UserClub.class);
        util.exportExcel(response, list, "用户社团数据");
    }

    /**
     * 获取用户社团详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:userClub:query')")
    @GetMapping(value = "/{id}")
    @Transactional
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        UserClub userClub = userClubService.selectUserClubById(id);
        UserClubDto userClubDto = new UserClubDto(userClub);
        SysUser user = userService.selectUserById(userClubDto.getUserId());
        if(user != null) {
            user.setPassword(null);
            userClubDto.setUserEntity(user);
        }
        userClubDto.setClubEntity(clubService.selectClubById(userClubDto.getClubId()));

        return AjaxResult.success(userClubDto);
    }

    /**
     * 新增用户社团
     */
    @PreAuthorize("@ss.hasPermi('system:userClub:add')")
    @Log(title = "用户社团", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserClub userClub) {
        return toAjax(userClubService.insertUserClub(userClub));
    }

    /**
     * 修改用户社团
     */
    @PreAuthorize("@ss.hasPermi('system:userClub:edit')")
    @Log(title = "用户社团", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserClub userClub) {
        return toAjax(userClubService.updateUserClub(userClub));
    }

    /**
     * 删除用户社团
     */
    @PreAuthorize("@ss.hasPermi('system:userClub:remove')")
    @Log(title = "用户社团", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(userClubService.deleteUserClubByIds(ids));
    }
}
