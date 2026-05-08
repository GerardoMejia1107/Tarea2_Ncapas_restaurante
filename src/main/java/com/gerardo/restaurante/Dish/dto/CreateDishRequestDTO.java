package com.gerardo.restaurante.Dish.dto;

import com.gerardo.restaurante.Dish.enums.Category;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Request DTO used to receive the data required to create a new dish.
 *
 * <p>This object represents the expected request body for dish creation
 * endpoints. It includes validation constraints to ensure that the received
 * data is valid before reaching the service layer.</p>
 */
@Data
public class CreateDishRequestDTO {
    @NotBlank(message = "Name is required")
    @Size(min = 5, max = 200, message = "Dish name must contain at least 5 and maximum of 200 characters")
    private String name;

    @NotBlank(message = "Description is required")
    @Size(min = 5, max = 200, message = "Dish description must contain at least 5 and maximum of 200 characters")
    private String description;

    @NotNull(message = "Price is required")
    @Min(value = 1, message = "Price must  be at least grater than 1")
    private Double price;

    @NotNull(message = "Available status is required")
    private Boolean available;

    @NotNull(message = "Category is required")
    private Category category;
}
