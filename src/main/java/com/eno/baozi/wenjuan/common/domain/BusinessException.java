package com.eno.baozi.wenjuan.common.domain;

public class BusinessException extends RuntimeException {
    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message) {
        super(message);
    }
}
