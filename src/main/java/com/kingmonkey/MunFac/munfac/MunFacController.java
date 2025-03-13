package com.kingmonkey.MunFac.munfac;

import com.kingmonkey.MunFac.common.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/munfac")
public class MunFacController {

    @GetMapping("/eqfactory")
    public String eqFactory() {
        System.out.println("이큐 팩토리 오나?");
        return "eqfactory.html";
    }

    @GetMapping("/mcfactory")
    public String mcFactory() {
        System.out.println("앰씨 팩토리 오나?");
        return "mcfactory.html";
    }

    @GetMapping("/oxfactory")
    public String oxFactory() {
        System.out.println("오엑스 팩토리 오나?");
        return "oxfactory.html";
    }

    @ResponseBody
    @GetMapping("/createmun")
    public ResponseEntity<ResponseDTO> createMun(MunDTO munDTO) {


        //여기서 munDTO의 데이터를 insert한다. 1은 성공. 0은 실패
        int insertResult = 0;
        try {
            insertResult = MunFacService.createMun(munDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(insertResult == 1){
            return ResponseEntity.ok()
                    .body(new ResponseDTO(HttpStatus.OK, "문제 생성 성공!!",200));
        }else{
            return ResponseEntity.ok()
                    .body(new ResponseDTO(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "문제 생성 실패ㅠㅠ",200));
        }

    }

}
