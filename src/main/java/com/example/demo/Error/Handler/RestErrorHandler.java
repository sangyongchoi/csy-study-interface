package com.example.demo.Error.Handler;

import com.example.demo.Error.CoreExceptionONE;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestErrorHandler {

    @ExceptionHandler(CoreExceptionONE.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ResponseEntity notFoundException(CoreExceptionONE e){
        return ResponseEntity.status(e.getErrorCode().httpStatus)
                .build();
    }
}
