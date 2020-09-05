package com.example.demo.Error.Code;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@Builder
public class ErrorResponse {
    private String code;
    private String message;
    private String user_message;
}
