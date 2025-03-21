package com.kingmonkey.munfac.munfac.Entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "CATEGORYLIST")
@SequenceGenerator(
        name = "CATEGORYLIST_SEQ_GENERATOR",
        sequenceName = "SEQ_CATEGORYLIST_CODE",
        initialValue = 1, allocationSize = 1
)
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L; // 고유식별자 필드

    @Id
    @Column(name = "CATENO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CATEGORYLIST_SEQ_GENERATOR"
    )
    private int cateNo;

    @Column(name = "MEMBERNO")
    private String memberNo;

    @Column(name = "CATENM")
    private int cateNm;

}
