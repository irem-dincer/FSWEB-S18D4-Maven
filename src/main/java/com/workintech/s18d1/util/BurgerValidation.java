package com.workintech.s18d1.util;

import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

// Burger validation işlemleri için utility sınıfı
public class BurgerValidation {

    // Burger nesnesinin null olup olmadığını kontrol eder
    public static void checkBurgerIsNull(Burger burger) {
        if (burger == null) {
            throw new BurgerException("Burger cannot be null", HttpStatus.BAD_REQUEST);
        }
    }

    // Burger ID'sinin geçerli olup olmadığını kontrol eder
    public static void checkBurgerIdIsValid(Long id) {
        if (id == null || id <= 0) {
            throw new BurgerException("Burger ID must be a positive number", HttpStatus.BAD_REQUEST);
        }
    }

    // Burger adının geçerli olup olmadığını kontrol eder
    public static void checkBurgerNameIsValid(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new BurgerException("Burger name cannot be null or empty", HttpStatus.BAD_REQUEST);
        }
    }

    // Burger fiyatının geçerli olup olmadığını kontrol eder
    public static void checkBurgerPriceIsValid(Double price) {
        if (price == null || price <= 0) {
            throw new BurgerException("Burger price must be a positive number", HttpStatus.BAD_REQUEST);
        }
    }

    // Burger nesnesinin tüm alanlarını validate eder (Yeni burger için)
    public static void validateBurger(Burger burger) {
        checkBurgerIsNull(burger);
        checkBurgerNameIsValid(burger.getName());
        checkBurgerPriceIsValid(burger.getPrice());

        // BreadType kontrolü
        if (burger.getBreadType() == null) {
            throw new BurgerException("Burger bread type cannot be null", HttpStatus.BAD_REQUEST);
        }

        // IsVegan kontrolü
        if (burger.getIsVegan() == null) {
            throw new BurgerException("Burger vegan status cannot be null", HttpStatus.BAD_REQUEST);
        }
    }

    // Update işlemi için partial validation (sadece null olmayan alanları kontrol et)
    public static void validateBurgerForUpdate(Burger burger) {
        checkBurgerIsNull(burger);

        // Sadece null olmayan alanları validate et
        if (burger.getName() != null) {
            checkBurgerNameIsValid(burger.getName());
        }

        if (burger.getPrice() != null) {
            checkBurgerPriceIsValid(burger.getPrice());
        }

        // BreadType ve IsVegan için null kontrolü yapmıyoruz çünkü update'te opsiyonel olabilir
    }
}