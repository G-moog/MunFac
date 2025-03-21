package com.kingmonkey.munfac.munfac.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MunDTO {

    int munNo;

    String munType = "";

    String munContent = "";

    String choose1Content = "";

    String choose2Content = "";

    String choose3Content = "";

    String choose4Content = "";

    String choose5Content = "";

    String answer = "";

    String useYn = "Y";

}
