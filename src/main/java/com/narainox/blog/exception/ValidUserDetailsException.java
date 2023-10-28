package com.narainox.blog.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ValidUserDetailsException extends RuntimeException {
    private String message;
    private String value;
    private String type;

    public ValidUserDetailsException(String message, String value, String type) {
        super(String.format("%s Not good %s: %s",message,value,type));
        this.message = message;
        this.value = value;
        this.type = type;
    }
}
