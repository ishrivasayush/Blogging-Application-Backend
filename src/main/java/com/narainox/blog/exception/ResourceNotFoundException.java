package com.narainox.blog.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ResourceNotFoundException extends RuntimeException{
    private String resource;
    private String type;
    private Object value;

    public ResourceNotFoundException(String resource, String type, Object value) {
        super(String.format("%s Not Found With %s : %s"+resource,type,value));
        this.resource = resource;
        this.type = type;
        this.value = value;
    }
}
