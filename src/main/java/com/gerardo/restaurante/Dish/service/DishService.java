package com.gerardo.restaurante.Dish.service;


import com.gerardo.restaurante.Dish.dto.CreateDishRequestDTO;
import com.gerardo.restaurante.Dish.dto.DishResponseDTO;

import java.util.List;

public interface DishService {
    DishResponseDTO create(CreateDishRequestDTO dto);
    List<DishResponseDTO> listAll();
}
