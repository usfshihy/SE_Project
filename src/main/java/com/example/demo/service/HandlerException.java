package com.example.demo.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.dao.DuplicateKeyException;

@NoArgsConstructor(access = AccessLevel.NONE)
public class HandlerException {

    static final String ERROR_STRING = "Operation failed on object %s";
    static final String DUPLICATE_ERROR_STRING = "Entry %s exists";
    static final String EMPTY_RESULT_BY_ID_ERROR_STRING = "Object %s with id %d not found";

    static void handlerException(Exception exception, String object) throws Exception {
        System.out.println(exception.getClass().getName());
        System.out.println(exception.getMessage());
        if(exception instanceof DuplicateKeyException)
            throw new Exception(String.format(DUPLICATE_ERROR_STRING, object));
        else
            throw new Exception(String.format(ERROR_STRING, object));
    }
} 