package com.ndyudev.lab6.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Table(name = "Categories")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Category {
    @Id
    private String id;
    @Column(name = "name", columnDefinition = "nvarchar(50)")
    private String name;

    @OneToMany(mappedBy = "category")
    private List<Product> products;
}
