package com.example.springecosystem.exceptions;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class CustomExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleControllerCustomException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(new CustomErrorBody(status.value(), ex.getMessage()), status);
    }


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleControllerException(HttpServletRequest request, Throwable ex) {
        HttpStatus status = getStatus(request);
        return new ResponseEntity<>(new CustomErrorBody(status.value(), ex.getMessage()), status);
    }

    @ExceptionHandler({ AccessDeniedException.class })
    public ResponseEntity<Object> handleAccessDeniedException(Exception ex, WebRequest request) {
        return new ResponseEntity<Object>("Access denied message here", new HttpHeaders(), HttpStatus.FORBIDDEN);
    }




    @Override
    protected ResponseEntity<Object> handleNoHandlerFoundException(NoHandlerFoundException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        /*
            This exception is not captured if the class WebConfig of this package is not present.
         */
        return new ResponseEntity<Object>("Resource not found", new HttpHeaders(), HttpStatus.NOT_FOUND);
    }


    private HttpStatus getStatus(HttpServletRequest request) {
        Integer code = (Integer) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        HttpStatus status;
        if (code != null){
            status = HttpStatus.resolve(code);
        } else {
            status = HttpStatus.INTERNAL_SERVER_ERROR;
        }

        return (status != null) ? status : HttpStatus.INTERNAL_SERVER_ERROR;
    }

}
