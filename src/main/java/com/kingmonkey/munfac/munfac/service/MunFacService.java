package com.kingmonkey.munfac.munfac.service;

import com.kingmonkey.munfac.munfac.dto.MunDTO;

public interface MunFacService {

    //문제 생성
    int createMun(MunDTO munDTO) throws Exception;

    //문제 수정
    int updateMun(MunDTO munDTO) throws Exception;

    //문제 삭제
    int deleteMun(MunDTO munDTO) throws Exception;

    //문제 조회
    int selectMun(MunDTO munDTO) throws Exception;


}
