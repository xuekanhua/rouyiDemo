package com.ruoyi.system.domain.dto;

import com.ruoyi.common.core.domain.entity.SysUser;
import com.ruoyi.system.domain.Club;
import com.ruoyi.system.domain.UserClub;
import lombok.Data;


@Data
public class UserClubDto extends UserClub{
    private SysUser userEntity;
    private Club clubEntity;

    public UserClubDto(UserClub userClub) {
        this.setSort(userClub.getSort());
        this.setClubId(userClub.getClubId());
        this.setUserId(userClub.getUserId());
        this.setUserRole(userClub.getUserRole());
        this.setSort(userClub.getSort());
        this.setId(userClub.getId());
    }

    public UserClubDto() {
    }
}
