package com.nhnacademy.gateway.utils.loginUtil;

import com.nhnacademy.gateway.dto.auth.LoginResponseDto;
import com.nhnacademy.gateway.enums.API;
import com.nhnacademy.gateway.utils.routeUtil.RestTemplateUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomUserDetailService implements UserDetailsService {
    private final RestTemplateUtil restTemplateUtil;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ResponseEntity<LoginResponseDto> re = restTemplateUtil.getResponse(username, API.ACCOUNT, "/login/" + username, LoginResponseDto.class);
        LoginResponseDto loginResponseDto = re.getBody();
        log.warn("{}" ,loginResponseDto);

        return new CustomUserDetail(loginResponseDto);
    }
}
