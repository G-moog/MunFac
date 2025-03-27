package com.kingmonkey.munfac.exception.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

/* 예외 발생 시 보낼 데이터를 담을 DTO 객체 */
@Data
public class ApiExceptionDTO {
    private int status;            // 상태 코드
    private String message;    // 에러 메세지

    public ApiExceptionDTO() {
    }

    public ApiExceptionDTO(HttpStatus status, String message) {        // 첫번째 매개변수 int 아니니까 조심하자.
        this.status = status.value();
        this.message = message;
    }


}
