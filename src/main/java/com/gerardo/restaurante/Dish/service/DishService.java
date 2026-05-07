package com.gerardo.restaurante.Dish.service;


import com.gerardo.restaurante.Dish.dto.CreateDishRequestDTO;
import com.gerardo.restaurante.Dish.dto.DishResponseDTO;

public interface DishService {
    DishResponseDTO create(CreateDishRequestDTO dto);
}
