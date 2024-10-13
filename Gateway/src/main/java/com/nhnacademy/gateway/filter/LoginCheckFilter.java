package com.nhnacademy.gateway.filter;

import com.nhnacademy.gateway.dto.auth.LoginResponseDto;
import com.nhnacademy.gateway.utils.loginUtil.SessionService;
import com.nhnacademy.gateway.utils.loginUtil.CustomUserDetail;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.LinkedList;

@Component
@RequiredArgsConstructor
public class LoginCheckFilter extends OncePerRequestFilter {
    private final SessionService sessionService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        if (cookies != null)
            for (Cookie c : cookies) {
                if (c.getName().equals("SESSION")) {
                    Object o = sessionService.getUserId(c.getValue());

                    // TODO:: 유저 디테일 서비스 구현하기
                    if (o != null) {
                        String id = o.toString();
                        SecurityContextHolder.getContext().setAuthentication(new PreAuthenticatedAuthenticationToken(
                                new CustomUserDetail(new LoginResponseDto(id)),
                                null,
                                new LinkedList<>()
                                ));
                        if(request.getRequestURI().equals("/login")) response.sendRedirect("/");
                    }
                }
            }
        filterChain.doFilter(request, response);
    }
}
