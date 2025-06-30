package com.workintech.s18d1.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name="burger")
public class Burger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "name", nullable = false)
    private  String name;
    @Column(name = "price")
    private  Double price;
    @Column(name = "is_vegan")
    private  Boolean isVegan;
    @Enumerated(EnumType.STRING) // Enum'u string olarak sakla
    @Column(name = "bread_type")
    private  BreadType breadType;
    @Column(name = "contents")
    private  String contents;

}
