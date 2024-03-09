package com.food.receipe.manage.common;

import lombok.Builder;

import java.time.LocalDateTime;

public class DatabaseException extends Exception {
    private LocalDateTime timestamp;
    private String errorMsg;

    public DatabaseException(String errorMsg, Throwable cause) {
        super(errorMsg,cause);
        this.timestamp = LocalDateTime.now();
    }


}
