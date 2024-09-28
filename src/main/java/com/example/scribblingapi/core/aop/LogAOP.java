package com.example.scribblingapi.core.aop;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Component
@Aspect
@RequiredArgsConstructor
public class LogAOP {

    private final HttpServletRequest request;

    @Before("@annotation(com.example.scribblingapi.core.aop.Log)")
    public void log() {
        System.out.println(request.getHeader("User-Agent"));
    }

}
