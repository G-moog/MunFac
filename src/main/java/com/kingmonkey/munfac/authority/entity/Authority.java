package com.kingmonkey.munfac.authority.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "AUTHORITY")
@SequenceGenerator(
        name = "AUTHORITY_SEQ_GENERATOR",
        sequenceName = "SEQ_AUTHORITY_CODE",
        initialValue = 1, allocationSize = 1
)
public class Authority implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L; // 고유식별자 필드

    @Id
    @Column(name = "AUTH_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "AUTHORITY_SEQ_GENERATOR"
    )
    private int authNo;

    @Column(name = "AUTH_NM")
    private String authNm;

    @Column(name = "AUTH_LV")
    private int authLv;

}
