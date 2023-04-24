package com.example.springecosystem.exceptions;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Instant;

public class CustomErrorBody {
    public final int statusCode;

    public final String message;

    public final Instant instant;


    public final String stackTrace;

    public CustomErrorBody (int statusCode, String message, Throwable throwable){
        this.statusCode = statusCode;
        this.message = message;
        this.instant = Instant.now();

        if(throwable != null){
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(baos);
            throwable.printStackTrace(printStream);
            stackTrace = baos.toString();
        } else {
            stackTrace = null;
        }
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getMessage() {
        return message;
    }

    public Instant getInstant() {
        return instant;
    }

    public String getStackTrace(){
        return this.stackTrace;
    }
}
