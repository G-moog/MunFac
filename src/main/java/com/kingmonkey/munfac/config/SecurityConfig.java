package com.kingmonkey.munfac.config;

import java.util.Arrays;

import com.kingmonkey.munfac.jwt.JwtAccessDeniedHandler;
import com.kingmonkey.munfac.jwt.JwtAuthenticationEntryPoint;
import com.kingmonkey.munfac.jwt.JwtAuthenticationFilter;
import com.kingmonkey.munfac.jwt.TokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final TokenProvider tokenProvider;
    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    private final JwtAccessDeniedHandler jwtAccessDeniedHandler;

    @Autowired
    public SecurityConfig(@Lazy TokenProvider tokenProvider
                        , JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint
                        , JwtAccessDeniedHandler jwtAccessDeniedHandler) {
        this.tokenProvider = tokenProvider;
        this.jwtAuthenticationEntryPoint = jwtAuthenticationEntryPoint;
        this.jwtAccessDeniedHandler = jwtAccessDeniedHandler;
    }


    // 1. 암호화 처리를 위한 PasswordEncoder를 빈으로 설정(빈을 등록시 메소드 이름 오타 없을 것)
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    // 2. 시큐리티 설정을 무시할 정적 리소스 등록
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers("/css/**", "/js/**", "/images/**"
                , "/lib/**", "/productimgs/**", "/stampimgs/**"
                , "approvalfiles/**");
    }


    // 3. HTTP요청에 대한 권한별 설정(세션 인증 -> 토큰 인증으로 인해 바뀐 부분 있음)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(jwtAuthenticationEntryPoint)
                        .accessDeniedHandler(jwtAccessDeniedHandler)
                )
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/").authenticated()
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers("/auth/**").permitAll()
                        .requestMatchers("/api/v1/**").permitAll()
                        .requestMatchers("/api/**").hasAnyRole("USER", "ADMIN")
                        .anyRequest().permitAll()
                )
                // 세션 기반으로 변경 (STATELESS 제거)
                .sessionManagement(session -> session
                        .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED) // 기본 세션 사용
                )
                .cors(cors -> cors.configurationSource(corsConfigurationSource()))
                // 폼 로그인 활성화 및 커스텀 로그인 페이지 설정
                .formLogin(form -> form
                        .loginPage("/auth/custom-login") // 커스텀 로그인 페이지 경로
                        .defaultSuccessUrl("/", true) // 로그인 성공 시 이동 경로
                        .permitAll()
                );

        return http.build();
    }



    // 4. CORS 설정용 Bean(허용할 origin과 httpMethod 종류와 header 값)
    @Bean
    CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));
        configuration.setAllowedMethods(Arrays.asList("GET", "PUT", "POST", "DELETE", "PATCH"));
        configuration.setAllowedHeaders(Arrays.asList("Access-Control-Allow-Origin", "Content-type"
                , "Access-Control-Allow-Headers", "Authorization"
                , "X-Requested-With"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }


}
