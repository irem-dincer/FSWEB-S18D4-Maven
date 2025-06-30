package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {


    public static void checkBurgerIsNull(Burger burger) {
        if (burger == null) {
            throw new BurgerException("Burger cannot be null", HttpStatus.BAD_REQUEST);
        }
    }

    public static void checkBurgerIdIsValid(Long id) {
        if (id == null || id <= 0) {
            throw new BurgerException("Burger ID must be a positive number", HttpStatus.BAD_REQUEST);
        }
    }


    public static void checkBurgerNameIsValid(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new BurgerException("Burger name cannot be null or empty", HttpStatus.BAD_REQUEST);
        }
    }


    public static void checkBurgerPriceIsValid(Double price) {
        if (price == null || price <= 0) {
            throw new BurgerException("Burger price must be a positive number", HttpStatus.BAD_REQUEST);
        }
    }


    public static void validateBurger(Burger burger) {
        checkBurgerIsNull(burger);
        checkBurgerNameIsValid(burger.getName());
        checkBurgerPriceIsValid(burger.getPrice());


        if (burger.getBreadType() == null) {
            throw new BurgerException("Burger bread type cannot be null", HttpStatus.BAD_REQUEST);
        }


        if (burger.getIsVegan() == null) {
            throw new BurgerException("Burger vegan status cannot be null", HttpStatus.BAD_REQUEST);
        }
    }


    public static void validateBurgerForUpdate(Burger burger) {
        checkBurgerIsNull(burger);


        if (burger.getName() != null) {
            checkBurgerNameIsValid(burger.getName());
        }

        if (burger.getPrice() != null) {
            checkBurgerPriceIsValid(burger.getPrice());
        }

    }
}