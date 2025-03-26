package com.kingmonkey.munfac.munfac.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "CATEGORY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@SequenceGenerator(
        name = "CATEGORYLIST_SEQ_GENERATOR",
        sequenceName = "SEQ_CATEGORYLIST_CODE",
        initialValue = 1, allocationSize = 1
)
public class Category implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L; // 고유식별자 필드

    @Id
    @Column(name = "CATE_NO")
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "CATEGORYLIST_SEQ_GENERATOR"
    )
    private int cateNo;

    @Column(name = "MEMBER_NO")
    private int memberNo;

    @Column(name = "CATE_NM")
    private String cateNm;

}
