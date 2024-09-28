package com.example.scribblingapi.core.error;

import com.example.scribblingapi.core.error.ex.ExceptionApi400;
import com.example.scribblingapi.core.error.ex.ExceptionApi404;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ExceptionController implements ErrorController {
    @RequestMapping("/error")
    public ResponseEntity<?> handleNoHandlerFoundException(HttpServletResponse response, HttpServletRequest request) {

        int status = response.getStatus();
        if (status == HttpStatus.NOT_FOUND.value()) {
            throw new ExceptionApi404("없는 URL입니다.");
        }
        if (status == HttpStatus.BAD_REQUEST.value()) {
            throw new ExceptionApi400("잘못된 요청값입니다.");
        }
        return null;
    }
}
