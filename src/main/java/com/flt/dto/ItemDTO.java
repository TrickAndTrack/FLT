package com.flt.dto;

import lombok.Data;

import jakarta.validation.constraints.*;

@Data
public class ItemDTO {
    private Long id;

    @NotBlank(message = "Name is required")
    private String name;

    @Positive(message = "Price must be positive")
    private double price;
}

