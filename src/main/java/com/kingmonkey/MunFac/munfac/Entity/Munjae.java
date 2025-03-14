package com.kingmonkey.MunFac.munfac.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

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
public class Munjae {

    @Id
    @Column(name="MUNNO")
    @GeneratedValue(
                        strategy = GenerationType.SEQUENCE,
                        generator="MUNJAE_SEQ_GENERATOR"
                   )
    private int munNo;

    @Column(name="MUNTYPE")
    private String munType;

    @Column(name="MUNCONTENT")
    private String munContent;

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

    @Column(name="USEYN")
    private String useYn;

}
