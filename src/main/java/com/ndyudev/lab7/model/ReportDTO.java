package com.ndyudev.lab7.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

public interface ReportDTO {
    Serializable getCategory();

    Long getTotalQuantity();

    Double getTotalAmount();
}
