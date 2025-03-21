package com.kingmonkey.munfac.solvingpage.controller;

import com.kingmonkey.munfac.common.ResponseDTO;
import com.kingmonkey.munfac.munfac.dto.MunDTO;
import com.kingmonkey.munfac.munfac.service.MunFacService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("solvingpage")
public class SolvingPageController {


    private final MunFacService munFacService;

    @Autowired
    public SolvingPageController(MunFacService munFacService) {
        this.munFacService = munFacService;
    }

    @GetMapping("/")
    public String solvingpage() {
        return "solvingPage.html";
    }

    // 문제 조회
    @ResponseBody
    @GetMapping("/selectmun")
    public ResponseEntity<ResponseDTO> selectMun(MunDTO munDTO) {



        //여기서 munDTO의 데이터를 select한다. 1은 성공. 0은 실패
        int selectResult = 0;
        try {
            selectResult = munFacService.selectMun(munDTO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if(selectResult == 1){
            return ResponseEntity.ok()
                    .body(new ResponseDTO(HttpStatus.OK, "문제 삭제 성공!!",200));
        }else{
            return ResponseEntity.ok()
                    .body(new ResponseDTO(HttpStatus.UNAVAILABLE_FOR_LEGAL_REASONS, "문제 삭제 실패ㅠㅠ",400));
        }

    }
}
