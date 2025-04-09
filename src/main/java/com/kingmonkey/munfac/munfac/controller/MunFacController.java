package com.kingmonkey.munfac.munfac.controller;

import com.kingmonkey.munfac.common.ResponseDTO;
import com.kingmonkey.munfac.munfac.dto.MunDTO;
import com.kingmonkey.munfac.munfac.service.MunFacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/munfac")
public class MunFacController {

    private final MunFacService munFacService;

    @Autowired
    public MunFacController(MunFacService munFacService) {
        this.munFacService = munFacService;
    }


    @GetMapping("/eqfactory")
    public String eqFactory() {
        return "eqfactory.html";
    }

    @GetMapping("/mcfactory")
    public String mcFactory() {
        return "mcfactory.html";
    }

    @GetMapping("/oxfactory")
    public String oxFactory() {
        return "oxfactory.html";
    }

    // 문제 생성
    @ResponseBody
    @PostMapping("/createmun")
    public ResponseEntity<ResponseDTO> createMun(MunDTO munDTO) {

        System.out.println("===============================");
        System.out.println(munDTO.toString());
        System.out.println("===============================");

        //여기서 munDTO의 데이터를 insert한다. 1은 성공. 0은 실패
        int insertResult = 0;
        try {
            insertResult = munFacService.createMun(munDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(insertResult == 1){
            return ResponseEntity.ok()
                    .body(new ResponseDTO(HttpStatus.OK, "문제 생성 성공!!",200));
        }else{
            return ResponseEntity.ok()
                    .body(new ResponseDTO(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "문제 생성 실패ㅠㅠ",400));
        }

    }

    // 문제 수정
    @ResponseBody
    @GetMapping("/updatemun")
    public ResponseEntity<ResponseDTO> updateMun(MunDTO munDTO) {


        //여기서 munDTO의 데이터를 update한다. 1은 성공. 0은 실패
        int updateResult = 0;
        try {
            updateResult = munFacService.updateMun(munDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(updateResult == 1){
            return ResponseEntity.ok()
                    .body(new ResponseDTO(HttpStatus.OK, "문제 수정 성공!!",200));
        }else{
            return ResponseEntity.ok()
                    .body(new ResponseDTO(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "문제 수정 실패ㅠㅠ",400));
        }

    }

    // 문제 삭제
    @ResponseBody
    @GetMapping("/deletemun")
    public ResponseEntity<ResponseDTO> deleteMun(MunDTO munDTO) {


        //여기서 munDTO의 데이터를 delete한다. 1은 성공. 0은 실패
        int deleteResult = 0;
        try {
            deleteResult = munFacService.deleteMun(munDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(deleteResult == 1){
            return ResponseEntity.ok()
                    .body(new ResponseDTO(HttpStatus.OK, "문제 삭제 성공!!",200));
        }else{
            return ResponseEntity.ok()
                    .body(new ResponseDTO(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "문제 삭제 실패ㅠㅠ",400));
        }

    }

}
