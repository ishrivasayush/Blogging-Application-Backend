package com.narainox.blog.exception;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ResourceNotFoundException extends RuntimeException{
    private String resource;
    private String type;
    private Integer value;

    public ResourceNotFoundException(String resource, String type, Integer value) {
        super(String.format("%s Not Found With %s : %d",resource,type,value));
        this.resource = resource;
        this.type = type;
        this.value = value;
    }
}
