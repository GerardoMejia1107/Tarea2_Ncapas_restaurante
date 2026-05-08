package com.gerardo.restaurante.Dish.dto;


/**
 * Request DTO used to receive the data required to update an existing dish.
 *
 * <p>This class extends {@link CreateDishRequestDTO}, therefore it inherits
 * the same fields and validation rules used for dish creation. This makes
 * it suitable for full update operations where all dish attributes are
 * expected in the request body.</p>
 */
public class UpdateDishRequestDTO extends CreateDishRequestDTO {
}
