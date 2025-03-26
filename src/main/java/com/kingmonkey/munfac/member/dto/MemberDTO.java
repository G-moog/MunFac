package com.kingmonkey.munfac.member.dto;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private int memberNo;
    private String memberId;
    private String memberPw;
    private String memberNm;
    private String memberEmail;
    private  int authNo;
}
