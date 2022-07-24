package com.ruoyi.system.domain.dto;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.Club;
import com.ruoyi.system.domain.Message;
import lombok.Data;

@Data
public class MessageDto extends Message {
    private SysUser CreateUserEntity;
    private SysUser UpdateUserEntity;
    private Club ClubEntity;
}
