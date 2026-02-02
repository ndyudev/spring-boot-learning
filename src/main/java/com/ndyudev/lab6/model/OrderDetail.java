package com.ndyudev.lab6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Table(name = "OrderDetails")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "Productid")
    private Product product;
    @ManyToOne()
    @JoinColumn(name = "Orderid")
    private Order order;

    public OrderDetail(Product product, Order order, BigDecimal price, Integer quantity) {
        this.product = product;
        this.order = order;
        this.price = price;
        this.quantity = quantity;
    }
}
