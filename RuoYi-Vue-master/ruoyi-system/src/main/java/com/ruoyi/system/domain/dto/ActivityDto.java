package com.ruoyi.system.domain.dto;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.Activity;
import com.ruoyi.system.domain.Club;
import lombok.Data;

@Data
public class ActivityDto extends Activity {
    private SysUser CreateUserEntity;
    private SysUser UpdateUserEntity;
    private Club ClubEntity;
}
