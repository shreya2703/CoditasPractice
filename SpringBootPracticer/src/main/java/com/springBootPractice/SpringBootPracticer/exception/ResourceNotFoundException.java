package com.springBootPractice.SpringBootPracticer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    private String resourceName;
    private String fieildName;
    private Object fieldValue;

    public ResourceNotFoundException(String resourceName, String fieildName, Object fieldValue) {
        super(String.format("%s The given resource is not found %s",resourceName,fieildName,fieldValue));
        this.resourceName = resourceName;
        this.fieildName = fieildName;
        this.fieldValue = fieldValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public String getFieildName() {
        return fieildName;
    }

    public Object getFieldValue() {
        return fieldValue;
    }
}

