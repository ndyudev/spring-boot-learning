package com.ndyudev.slide6.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Categories")
@Entity(name = "Slide6Categories")
@Builder
public class Category {
    @Id
    private String id;
    @Column(columnDefinition = "nvarchar(50)")
    private String name;
}
