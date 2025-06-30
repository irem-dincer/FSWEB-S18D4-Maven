package com.workintech.s18d1.dao;

import com.workintech.s18d1.entity.BreadType;
import com.workintech.s18d1.entity.Burger;

import java.util.List;

public interface BurgerDao {

    Burger save(Burger burger);// Burger objesi alır ve bunu veritabanı tablosuna yazar.
    Burger findById(long id);//Integer id değeri alır ve karşılığında veritabanındaki Burger kaydını döner.
    List<Burger> findAll();// Veritabanındaki bütün Burgerleri döner
    List<Burger> findByPrice(Integer price);//Fiyata göre burgerları bul
    List<Burger> findByBreadType(BreadType breadType);// BreadType parametresi alır
    List<Burger> findByContent(String content);// İçeriğe göre burgerları bul - contents tablosunda ara
    Burger update(Burger burger);// Burger güncelle - mevcut burger objesi ile
     Burger remove(long id);// ID'ye göre burger sil
}
