package com.workintech.s18d1.controller;

import com.workintech.s18d1.dao.BurgerDao;
import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;
import com.workintech.s18d1.util.BurgerValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/burger")
public class BurgerController {

    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping("")
    public List<Burger> getAllBurgers() {
        return burgerDao.findAll();
    }


    @GetMapping("/{id}")
    public Burger getBurgerById(@PathVariable Long id) {
        return burgerDao.findById(id);
    }


    @PostMapping("")
    public Burger saveBurger(@RequestBody Burger burger) {
        log.info("POST /burger triggered");
        BurgerValidation.validateBurger(burger);
        return burgerDao.save(burger);
    }


    @PutMapping("/{id}")
    public Burger updateBurger(@PathVariable long id, @RequestBody Burger burger) {
        burger.setId(Long.valueOf(id));
        log.info("PUT /burger/{} triggered", id);
        BurgerValidation.checkBurgerIdIsValid(Long.valueOf(id));
        BurgerValidation.validateBurgerForUpdate(burger); // Partial validation
        return burgerDao.update(burger);
    }

    @DeleteMapping("/{id}")
    public Burger deleteBurger(@PathVariable Long id) {
        return burgerDao.remove(id);
    }

    @GetMapping("/price/{price}")
    public List<Burger> getBurgersByPrice(@PathVariable Integer price) {
        return burgerDao.findByPrice(price);
    }


    @GetMapping("/breadType/{breadType}")
    public List<Burger> getBurgersByBreadType(@PathVariable BreadType breadType) {
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/content/{content}")
    public List<Burger> getBurgersByContent(@PathVariable String content) {
        return burgerDao.findByContent(content);
    }

    @PutMapping("")
    public Burger updateBurgerWithoutId(@RequestBody Burger burger) {
        log.info("PUT /burger triggered");
        BurgerValidation.validateBurgerForUpdate(burger); // Partial validation kullan
        return burgerDao.update(burger);
    }
}