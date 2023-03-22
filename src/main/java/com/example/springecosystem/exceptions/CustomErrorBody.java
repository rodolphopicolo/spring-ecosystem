package com.example.springecosystem.exceptions;

import java.time.Instant;

public class CustomErrorBody {
    private int statusCode;

    private String message;

    public final Instant instant;

    public CustomErrorBody (int statusCode, String message){
        this.statusCode = statusCode;
        this.message = message;
        this.instant = Instant.now();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Instant getInstant() {
        return instant;
    }
}
