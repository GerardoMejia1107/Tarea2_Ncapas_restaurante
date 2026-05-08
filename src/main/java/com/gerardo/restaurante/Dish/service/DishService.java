package com.gerardo.restaurante.Dish.service;


import com.gerardo.restaurante.Dish.dto.CreateDishRequestDTO;
import com.gerardo.restaurante.Dish.dto.DishResponseDTO;
import com.gerardo.restaurante.Dish.dto.UpdateDishRequestDTO;

import java.util.List;

public interface DishService {
    DishResponseDTO create(CreateDishRequestDTO dto);

    List<DishResponseDTO> listAll();

    DishResponseDTO listById(Long id);

    List<DishResponseDTO> listByStatus(Boolean status);

    DishResponseDTO deleteById(Long id);

    DishResponseDTO updateById(Long id, UpdateDishRequestDTO dto);

    List<DishResponseDTO> createBulk(List<CreateDishRequestDTO> bulk);
}
