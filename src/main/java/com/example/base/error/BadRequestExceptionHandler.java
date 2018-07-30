package com.example.base.error;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice(annotations = RestController.class)
public class BadRequestExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ErrorResponse> getException(HttpServletRequest req, BadRequestException e){

        return ErrorResponse.createResponse(e);

    }

    /**
     * 400 - Bad Reque
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ErrorResponse> notReadable(HttpServletRequest req){
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse("All","unknown","NotReadable")
                ,HttpStatus.BAD_REQUEST);
    }

    /**
     * 404 - Not Found
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorResponse> notFound(HttpServletRequest req){
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse(null,null,"Not Found")
                ,HttpStatus.NOT_FOUND);
    }

    /**
     * 405 - Method Not Allowed
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> notSupported(HttpServletRequest req){
        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse(null,null,"Method Not Allowed")
                ,HttpStatus.METHOD_NOT_ALLOWED);
    }

    
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> anotherException(Exception e, HttpServletRequest req){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");

        // ログは、大事
        System.err.println("ERROR(500) " + (sdf.format((Calendar.getInstance()).getTime()))
                + ": remoteAddr:" + req.getRemoteAddr()
                + ", remoteHost:" + req.getRemoteHost()
                + ", requestURL:" + req.getRequestURL()
                );
        e.printStackTrace();

        return new ResponseEntity<ErrorResponse>(
                new ErrorResponse(null,null,"unknown error")
                ,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
