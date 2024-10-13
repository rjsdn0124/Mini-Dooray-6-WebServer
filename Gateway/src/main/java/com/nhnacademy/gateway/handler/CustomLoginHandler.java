package com.nhnacademy.gateway.handler;

import com.nhnacademy.gateway.utils.loginUtil.CookieUtil;
import com.nhnacademy.gateway.utils.loginUtil.SessionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class CustomLoginHandler extends SimpleUrlAuthenticationSuccessHandler {
    private final SessionService sessionService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String id = authentication.getName().toString();
        String sessionId = sessionService.saveUser(id);

        CookieUtil.create(sessionId, response);

        super.onAuthenticationSuccess(request, response, authentication);
    }
}
