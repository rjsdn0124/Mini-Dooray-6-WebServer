package com.nhnacademy.gateway.advice;

import com.nhnacademy.gateway.exception.RestTemplateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ErrorControllerAdvice {
    @ExceptionHandler(RestTemplateException.class)
    public ModelAndView handleRestTemplateException(RestTemplateException ex) {
        ModelAndView mav = new ModelAndView("error/error"); // error.html이라는 뷰로 리턴
        mav.addObject("status", ex.getStatusCode());      // 에러 상태 코드
        mav.addObject("path", ex.getPath());            // 에러가 발생한 URI
        mav.addObject("message", ex.getMessage());  // 에러 메시지

        return mav;
    }
}
