package com.kingmonkey.munfac.jwt;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{

    @Override
    public void commence(HttpServletRequest request
            , HttpServletResponse response
            , AuthenticationException authException)
            throws IOException, ServletException {

        // 필요한 권한이 없을시 403 상태코드 발생
        response.sendError(HttpServletResponse.SC_FORBIDDEN);
    }


}
