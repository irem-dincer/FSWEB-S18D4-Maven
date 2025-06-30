package com.workintech.s18d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// Global Error Handler - tüm controller'lardaki hataları yakalar
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    // BurgerException tipindeki hataları yakalar
    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleException(BurgerException exception) {
        // Hata logla
        log.error("BurgerException occurred: {}", exception.getMessage());

        // Error response oluştur
        BurgerErrorResponse errorResponse = new BurgerErrorResponse(exception.getMessage());

        // ResponseEntity ile HTTP status ve error response döndür
        return new ResponseEntity<>(errorResponse, exception.getHttpStatus());
    }

    // Genel Exception tipindeki hataları yakalar
    @ExceptionHandler
    public ResponseEntity<BurgerErrorResponse> handleException(Exception exception) {
        // Hata logla
        log.error("General Exception occurred: {}", exception.getMessage());

        // Error response oluştur
        BurgerErrorResponse errorResponse = new BurgerErrorResponse(exception.getMessage());

        // ResponseEntity ile INTERNAL_SERVER_ERROR döndür
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}