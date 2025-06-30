package com.workintech.s18d1.exceptions;

public class BurgerErrorResponse {

    // Hata mesajı
    private String message;

    public BurgerErrorResponse(String message) {
        this.message = message;
    }

    public BurgerErrorResponse() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
