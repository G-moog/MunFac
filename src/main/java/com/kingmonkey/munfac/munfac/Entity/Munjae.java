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
    @Column(name="MUNNO")
    @GeneratedValue(
                        strategy = GenerationType.SEQUENCE,
                        generator="MUNJAE_SEQ_GENERATOR"
                   )
    private int munNo;

    @Column(name="CATENO")
    private String cateNo;

    @Column(name="MEMBERNO")
    private String memberNo;

    @Column(name="MUNTITLE")
    private String munTitle;

    @Column(name="MUNCONTENT")
    private String munContent;

    @Column(name="MUNTYPE")
    private String munType;

    @Column(name="CHOOSE1CONTENT")
    private String choose1Content;

    @Column(name="CHOOSE2CONTENT")
    private String choose2Content;

    @Column(name="CHOOSE3CONTENT")
    private String choose3Content;

    @Column(name="CHOOSE4CONTENT")
    private String choose4Content;

    @Column(name="CHOOSE5CONTENT")
    private String choose5Content;

    @Column(name="ANSWER")
    private String answer;

    @Column(name="ORIGIN")
    private String origin;

    @Column(name="USEYN")
    private String useYn;

}
