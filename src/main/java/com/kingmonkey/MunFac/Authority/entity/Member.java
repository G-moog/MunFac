package com.kingmonkey.MunFac.Authority.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "MEMBER")
@SequenceGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        sequenceName = "SEQ_MEMBER_CODE",
        initialValue = 1, allocationSize = 1
)
public class Member {

    @Id
    @Column(name = "MEMBER_CODE")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "MEMBER_SEQ_GENERATOR"
    )
    private int memberCode;

    @Column(name = "MEMBER_PW")
    private String memberPw;

    @Column(name = "MEMBER_NAME")
    private String memberName;

    @Column(name = "MEMBER_RRN")
    private String memberRrn;

    @Column(name = "MEMBER_ENTDATE")
    private Date memberEntDate;

    @Column(name = "MEMBER_RETDATE")
    private Date memberRetDate;

    @Column(name = "MEMBER_PHONE")
    private String memberPhone;

    @Column(name = "MEMBER_MOBILE")
    private String memberMobile;

    @Column(name = "MEMBER_EMAIL")
    private String memberEmail;

    @Column(name = "MEMBER_ADDRESS")
    private String memberAddress;

    @Column(name = "MEMBER_IMAGE")
    private String memberImage;

    @Column(name = "MEMBER_ACCOUNT")
    private String memberAccount;

    @Column(name = "MEMBER_THEME")
    private String memberTheme;

    @Column(name = "MEMBER_STAMP")
    private String memberStamp;

    @OneToMany
    @JoinColumn(name = "MEMBER_CODE")
    private List<Authority> memberRole;


}
