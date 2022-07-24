package com.ruoyi.system.domain.dto;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.Activity;
import com.ruoyi.system.domain.UserActivity;
import lombok.Data;

@Data
public class UserActivityDto extends UserActivity {
    private SysUser userEntity;
    private Activity activityEntity;

    public UserActivityDto(UserActivity userActivity) {
        this.setId(userActivity.getId());
        this.setActivityId(userActivity.getActivityId());
        this.setUserId(userActivity.getUserId());
        this.setRemarks(userActivity.getRemarks());
    }
    public UserActivityDto() {

    }
}
