package com.ndyudev.lab6.model;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal; // Dùng BigDecimal cho tiền là chuẩn nhất
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