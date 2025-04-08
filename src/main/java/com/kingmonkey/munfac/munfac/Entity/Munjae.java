package com.kingmonkey.munfac.munfac.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "MUNJAE")
@SequenceGenerator(
        name="MUNJAE_SEQ_GENERATOR",
        sequenceName="SEQ_MUNJAE_CODE",
        initialValue=1,
        allocationSize=1
)
@Data
@NoArgsConstructor
public class Munjae implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L; // 고유식별자 필드

    @Id
    @Column(name="MUN_NO")
    @GeneratedValue(
                        strategy = GenerationType.SEQUENCE,
                        generator="MUNJAE_SEQ_GENERATOR"
                   )
    private int munNo;

    @Column(name="CATE_NO")
    private String cateNo = "9999";

    @Column(name="MEMBER_NO")
    private String memberNo = "9999";

    @Column(name="MUN_TITLE")
    private String munTitle;

    @Column(name="MUN_CONT")
    private String munContent;

    @Column(name="MUN_TYPE")
    private String munType;

    @Column(name="CHOOSE1CONT")
    private String choose1Content;

    @Column(name="CHOOSE2CONT")
    private String choose2Content;

    @Column(name="CHOOSE3CONT")
    private String choose3Content;

    @Column(name="CHOOSE4CONT")
    private String choose4Content;

    @Column(name="CHOOSE5CONT")
    private String choose5Content;

    @Column(name="ANSWER")
    private String answer;

    @Column(name="ORIGIN")
    private String origin;

    @Column(name="USEYN")
    private String useYn;

}
