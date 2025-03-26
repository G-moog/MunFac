package com.kingmonkey.munfac.authority.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorityDTO {

    private int authNo;
    private String authNm;
    private int authLv;

}
