package ru.bellintegrator.practice.model.response;

import org.apache.commons.lang.builder.ToStringBuilder;

public class ApiErrorResponse{

    private int status;
    private String message;

    public ApiErrorResponse(int status, String message) {
        this.status = status;
        this.message = message;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
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