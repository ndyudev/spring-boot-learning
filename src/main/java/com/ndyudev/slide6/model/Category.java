//package com.ndyudev.slide6.model;
//
//import jakarta.persistence.Column;
//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.Table;
//import jakarta.validation.constraints.NotBlank;
//import jakarta.validation.constraints.Size;
//import lombok.AllArgsConstructor;
//import lombok.Builder;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@Table(name = "Categories")
//@Entity(name = "Slide6Categories")
//@Builder
//public class Category {
//    @Id
//    @NotBlank(message = "ID is required")
//    private String id;
//    @Column(columnDefinition = "nvarchar(50)")
//    @NotBlank(message = "Name is required")
//    @Size(max = 50, message = "Name must be at most 50 characters")
//    private String name;
//}
