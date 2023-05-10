package com.SpringRestaurant.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String filedName;
    private Object fieldValue;

    public ResourceNotFoundException(String resourceName, String filedName, Object fieldValue) {
        super(String.format("%sNot found with %s",resourceName,filedName,fieldValue));
        this.resourceName = resourceName;
        this.filedName = filedName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFiledName() {
        return filedName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}
