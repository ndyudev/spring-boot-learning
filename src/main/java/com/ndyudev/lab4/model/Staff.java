package com.ndyudev.lab4.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Staff {
    private String id;
    private String fullName;
    @Builder.Default
    private String photo = "photo.jpg";
    @Builder.Default
    private Boolean gender = true;
    @Builder.Default
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date birthday = new Date();
    @Builder.Default
    private Double salary = 227184206.0;
    @Builder.Default
    private Integer level = 0;

}
