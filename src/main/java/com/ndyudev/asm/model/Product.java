package com.ndyudev.asm.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String image;
    private Double price;
    @Column(name = "CreateDate")
    LocalDate createDate = LocalDate.now();
    private Boolean available; // 0 = còn hàng , 1 = hết hàng
    private Integer quantity;

    private Boolean isActive; // true = hiển thị, false = ẩn

    public Product(String name, String image, Double price, Boolean available, Integer quantity, Boolean isActive) {
        this.name = name;
        this.image = image;
        this.price = price;
        this.available = available;
        this.quantity = quantity;
        this.isActive = isActive;
    }
}
