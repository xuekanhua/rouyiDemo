package com.ruoyi.web.controller.system;

import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.Club;
import com.ruoyi.system.domain.Message;
import com.ruoyi.system.domain.dto.ActivityDto;
import com.ruoyi.system.domain.dto.MessageDto;
import com.ruoyi.system.service.IClubService;
import com.ruoyi.system.service.ISysUserService;
import com.ruoyi.system.service.IUserActivityService;
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
import com.ruoyi.system.domain.Activity;
import com.ruoyi.system.service.IActivityService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动管理Controller
 * 
 * @author ruoyi
 * @date 2022-07-14
 */
@RestController
@RequestMapping("/system/activity")
public class ActivityController extends BaseController
{
    @Autowired
    private IActivityService activityService;

    @Autowired
    private IUserActivityService userActivityService;

    @Autowired
    private IClubService clubService;

    @Autowired
    private ISysUserService userService;

    /**
     * 查询活动管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:activity:list')")
    @GetMapping("/list")
    @Transactional
    public TableDataInfo list(Activity activity)
    {
        startPage();
        List<Activity> list = activityService.selectActivityList(activity);
        List<ActivityDto> listDto = list.stream().map((item) -> {
            ActivityDto activityDto = new ActivityDto();
            BeanUtils.copyProperties(item, activityDto);
            SysUser createUser = userService.selectUserById(item.getCreateUser());
            if (createUser != null) {
                createUser.setPassword(null);
                activityDto.setCreateUserEntity(createUser);
            }
            SysUser updateUser = userService.selectUserById(item.getUpdateUser());
            if (updateUser != null) {
                updateUser.setPassword(null);
                activityDto.setUpdateUserEntity(updateUser);
            }
            Club club = clubService.selectClubById(item.getClubId());
            if (club != null) {
                activityDto.setClubEntity(club);
            }
            return activityDto;
        }).collect(Collectors.toList());

        return getDataTable(listDto);
    }

    /**
     * 导出活动管理列表
     */
    @PreAuthorize("@ss.hasPermi('system:activity:export')")
    @Log(title = "活动管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Activity activity)
    {
        List<Activity> list = activityService.selectActivityList(activity);
        ExcelUtil<Activity> util = new ExcelUtil<Activity>(Activity.class);
        util.exportExcel(response, list, "活动管理数据");
    }

    /**
     * 获取活动管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('system:activity:query')")
    @GetMapping(value = "/{id}")
    @Transactional
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        Activity activity = activityService.selectActivityById(id);

        ActivityDto activityDto = new ActivityDto();
        BeanUtils.copyProperties(activity, activityDto);
        SysUser createUser = userService.selectUserById(activityDto.getCreateUser());
        if (createUser != null) {
            createUser.setPassword(null);
            activityDto.setCreateUserEntity(createUser);
        }
        SysUser updateUser = userService.selectUserById(activityDto.getUpdateUser());
        if (updateUser != null) {
            updateUser.setPassword(null);
            activityDto.setUpdateUserEntity(updateUser);
        }
        Club club = clubService.selectClubById(activityDto.getClubId());
        if (club != null) {
            activityDto.setClubEntity(club);
        }


        return AjaxResult.success(activityDto);
    }

    /**
     * 新增活动管理
     */
    @PreAuthorize("@ss.hasPermi('system:activity:add')")
    @Log(title = "活动管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Activity activity)
    {
        return toAjax(activityService.insertActivity(activity));
    }

    /**
     * 修改活动管理
     */
    @PreAuthorize("@ss.hasPermi('system:activity:edit')")
    @Log(title = "活动管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Activity activity)
    {
        return toAjax(activityService.updateActivity(activity));
    }

    /**
     * 删除活动管理
     */
    @PreAuthorize("@ss.hasPermi('system:activity:remove')")
    @Log(title = "活动管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    @Transactional
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        userActivityService.deleteUserActivityByActivityIds(ids);

        return toAjax(activityService.deleteActivityByIds(ids));
    }
}
