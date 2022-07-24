package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.dto.UserActivityDto;
import com.ruoyi.system.service.IActivityService;
import com.ruoyi.system.service.ISysUserService;
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
import com.ruoyi.system.domain.UserActivity;
import com.ruoyi.system.service.IUserActivityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 用户活动Controller
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
@RestController
@RequestMapping("/system/userActivity")
public class UserActivityController extends BaseController
{
    @Autowired
    private IUserActivityService userActivityService;

    @Autowired
    private ISysUserService userService;

    @Autowired
    private IActivityService activityService;




    /**
     * 查询用户活动列表
     */
    @PreAuthorize("@ss.hasPermi('system:userActivity:list')")
    @GetMapping("/list")
    @Transactional
    public TableDataInfo list(UserActivity userActivity)
    {
        startPage();
        List<UserActivity> list = userActivityService.selectUserActivityList(userActivity);
        List<UserActivityDto> listDto = list.stream().map((item) -> {
            UserActivityDto userActivityDto = new UserActivityDto(item);
            userActivityDto.setActivityEntity(activityService.selectActivityById(userActivityDto.getActivityId()));
            SysUser user = userService.selectUserById(userActivityDto.getUserId());
            if (user != null) {
                user.setPassword(null);
                userActivityDto.setUserEntity(user);
            }

            return userActivityDto;
        }).collect(Collectors.toList());
        return getDataTable(listDto);
    }

    /**
     * 导出用户活动列表
     */
    @PreAuthorize("@ss.hasPermi('system:userActivity:export')")
    @Log(title = "用户活动", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, UserActivity userActivity)
    {
        List<UserActivity> list = userActivityService.selectUserActivityList(userActivity);
        ExcelUtil<UserActivity> util = new ExcelUtil<UserActivity>(UserActivity.class);
        util.exportExcel(response, list, "用户活动数据");
    }

    /**
     * 获取用户活动详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:userActivity:query')")
    @GetMapping(value = "/{id}")
    @Transactional
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        UserActivity userActivity = userActivityService.selectUserActivityById(id);
        if(userActivity == null)return AjaxResult.success(new UserActivityDto());
        UserActivityDto userActivityDto = new UserActivityDto(userActivity);
        SysUser user = userService.selectUserById(userActivityDto.getUserId());
        if (user != null) {
            user.setPassword(null);
            userActivityDto.setUserEntity(user);
        }

        userActivityDto.setActivityEntity(activityService.selectActivityById(userActivityDto.getActivityId()));
        return AjaxResult.success(userActivityDto);
    }

    /**
     * 新增用户活动
     */
    @PreAuthorize("@ss.hasPermi('system:userActivity:add')")
    @Log(title = "用户活动", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody UserActivity userActivity)
    {
        return toAjax(userActivityService.insertUserActivity(userActivity));
    }

    /**
     * 修改用户活动
     */
    @PreAuthorize("@ss.hasPermi('system:userActivity:edit')")
    @Log(title = "用户活动", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody UserActivity userActivity)
    {
        return toAjax(userActivityService.updateUserActivity(userActivity));
    }

    /**
     * 删除用户活动
     */
    @PreAuthorize("@ss.hasPermi('system:userActivity:remove')")
    @Log(title = "用户活动", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(userActivityService.deleteUserActivityByIds(ids));
    }
}
