package com.example.blogapp.exceptions;

public class ResourceNotFoundException extends RuntimeException{

    String resorceName;
    String fieldName;
    Long fieldValue;


    public ResourceNotFoundException(String resorceName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with %s : %1", resorceName,fieldName,fieldValue));
        this.resorceName = resorceName;
        this.fieldName = fieldName;
        this.fieldValue = fieldValue;
    }

}
