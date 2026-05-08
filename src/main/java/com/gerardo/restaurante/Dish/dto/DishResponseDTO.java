package com.gerardo.restaurante.Dish.dto;

import com.gerardo.restaurante.Dish.enums.Category;
import jakarta.persistence.Column;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class DishResponseDTO {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Boolean available;
    private Category category;
}
