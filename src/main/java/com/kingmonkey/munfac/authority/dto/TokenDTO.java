package com.kingmonkey.munfac.authority.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TokenDTO {

    private String grantType;            // 토큰 타입
    private String empCode;            // 인증받은 회원 이름
    private String accessToken;        // 액세스 토큰
    private Long accessTokenExpiresIn;    // Long 형의 만료 시간
}
