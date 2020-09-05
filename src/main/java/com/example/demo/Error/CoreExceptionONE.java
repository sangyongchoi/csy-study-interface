package com.example.demo.Error;

import com.example.demo.Error.Code.ErrorCode;
import com.example.demo.Error.Code.ErrorType;

public class CoreExceptionONE extends  CoreBaseException{
    private static final ErrorType error_type = ErrorType.ERROR_ONE;

    public CoreExceptionONE(ErrorCode errorCode) {
        super(error_type, errorCode);
    }

    public CoreExceptionONE(ErrorCode errorCode, Throwable t) {
        super(error_type, errorCode, t);
    }

    public CoreExceptionONE(ErrorCode errorCode, String userMsg) {
        super(error_type, errorCode, userMsg);
    }

    public CoreExceptionONE(ErrorCode errorCode, String userMsg, Throwable t) {
        super(error_type, errorCode, userMsg, t);
    }
}
