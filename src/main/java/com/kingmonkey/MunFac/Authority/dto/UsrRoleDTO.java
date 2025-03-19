package com.kingmonkey.MunFac.Authority.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UsrRoleDTO {

    private int userNo;

    private int authorityCode;

    private AuthorityDTO authority;
}