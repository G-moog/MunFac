package com.kingmonkey.MunFac.munfac;

import java.util.Objects;

public class MunDTO {

    String munType = "";

    String munContent = "";

    String choose1Content = "";

    String choose2Content = "";

    String choose3Content = "";

    String choose4Content = "";

    String choose5Content = "";

    String answer = "";

    public String getMunNo() {
        return munNo;
    }

    public void setMunNo(String munNo) {
        this.munNo = munNo;
    }

    public String getMunType() {
        return munType;
    }

    public void setMunType(String munType) {
        this.munType = munType;
    }

    public String getMunContent() {
        return munContent;
    }

    public void setMunContent(String munContent) {
        this.munContent = munContent;
    }

    public String getChoose1Content() {
        return choose1Content;
    }

    public void setChoose1Content(String choose1Content) {
        this.choose1Content = choose1Content;
    }

    public String getChoose2Content() {
        return choose2Content;
    }

    public void setChoose2Content(String choose2Content) {
        this.choose2Content = choose2Content;
    }

    public String getChoose3Content() {
        return choose3Content;
    }

    public void setChoose3Content(String choose3Content) {
        this.choose3Content = choose3Content;
    }

    public String getChoose4Content() {
        return choose4Content;
    }

    public void setChoose4Content(String choose4Content) {
        this.choose4Content = choose4Content;
    }

    public String getChoose5Content() {
        return choose5Content;
    }

    public void setChoose5Content(String choose5Content) {
        this.choose5Content = choose5Content;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }



    @Override
    public String toString() {
        return "MunDTO{" +
                "munNo='" + munNo + '\'' +
                ", munType='" + munType + '\'' +
                ", munContent='" + munContent + '\'' +
                ", choose1Content='" + choose1Content + '\'' +
                ", choose2Content='" + choose2Content + '\'' +
                ", choose3Content='" + choose3Content + '\'' +
                ", choose4Content='" + choose4Content + '\'' +
                ", choose5Content='" + choose5Content + '\'' +
                ", answer='" + answer + '\'' +
                '}';
    }

    String munNo = "";

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        MunDTO munDTO = (MunDTO) o;
        return Objects.equals(munNo, munDTO.munNo) && Objects.equals(munType, munDTO.munType) && Objects.equals(munContent, munDTO.munContent) && Objects.equals(choose1Content, munDTO.choose1Content) && Objects.equals(choose2Content, munDTO.choose2Content) && Objects.equals(choose3Content, munDTO.choose3Content) && Objects.equals(choose4Content, munDTO.choose4Content) && Objects.equals(choose5Content, munDTO.choose5Content) && Objects.equals(answer, munDTO.answer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(munNo, munType, munContent, choose1Content, choose2Content, choose3Content, choose4Content, choose5Content, answer);
    }


}
