package com.ndyudev.lab7.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "Products")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "Name", columnDefinition = "nvarchar(100)")
    private String name;

    @Column(name = "Image")
    private String image;

    @Column(name = "Price")
    private Double price;

    @Column(name = "Quantity")
    private Integer quantity = 0;

    @Column(name = "CreateDate")
    private LocalDate createAt = LocalDate.now();

    @Column(name = "Available")
    private Boolean available;

    @ManyToOne
    @JoinColumn(name = "CategoryId")
    private Category category;


}