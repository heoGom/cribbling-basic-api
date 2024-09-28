package com.example.scribblingapi.core.error;

import com.example.scribblingapi.core.error.ex.ExceptionApi400;
import com.example.scribblingapi.core.error.ex.ExceptionApi404;
import com.example.scribblingapi.core.util.Resp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalApiExceptionHandler {

    @ExceptionHandler(ExceptionApi400.class)
    public ResponseEntity<?> ex400(Exception e) {
        return ResponseEntity.status(400).body(Resp.reason(e.getMessage()));
    }

    @ExceptionHandler(ExceptionApi404.class)
    public ResponseEntity<?> ex404(Exception e) {
        return ResponseEntity.status(404).body(Resp.reason(e.getMessage()));
    }
}
