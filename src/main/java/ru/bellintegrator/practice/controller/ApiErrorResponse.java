package ru.bellintegrator.practice.controller;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ApiErrorResponse {

    private int status;
    private String message;

    public ApiErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append(status)
                .append(message)
                .toString();
    }
}