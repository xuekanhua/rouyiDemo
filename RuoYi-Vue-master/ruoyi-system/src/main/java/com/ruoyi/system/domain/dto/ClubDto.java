package com.ruoyi.system.domain.dto;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.Club;
import lombok.Data;

@Data
public class ClubDto extends Club {
    private SysUser userEntity;
}
