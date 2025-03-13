package com.kingmonkey.MunFac.munfac;

public interface MunFacService {

    //문제 생성
    public int createMun(MunDTO munDTO) throws Exception;

    //문제 수정
    public int updateMun(MunDTO munDTO) throws Exception;

    //문제 삭제
    public int deleteMun(MunDTO munDTO) throws Exception;

    //문제 조회
    public int selectMun(MunDTO munDTO) throws Exception;


}
