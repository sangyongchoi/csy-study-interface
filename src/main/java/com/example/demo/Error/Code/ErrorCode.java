package com.example.demo.Error.Code;

import lombok.Getter;

import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public enum  ErrorCode {



    ERROR_ONE(400,Code.ERR_ONE,"1번째 설정에러"),
    ERROR_TWO(400,Code.ERR_TWO,"2번째 설정에러"),
    ERR_UNKNOWN(500,Code.UNKNOWN,"처리되지 않은 에러");


    public static class Code{
        public static final String ERR_ONE = "1000";
        public static final String ERR_TWO = "2000";
        public static final String UNKNOWN = "9999";
    }

    @Getter
    public final int httpStatus;
    @Getter
    public final String code;
    @Getter
    public final String message;

    private static final Map<String,ErrorCode> codeMap;

    static{
        codeMap = Stream.of(values())
                .collect(toMap(ErrorCode::getCode,e->e));
    }

    ErrorCode(int httpStatus,String code,String message){
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }

    public static ErrorCode codeof(String code){
        return codeMap.get(code);
    }


}

