package com.gerardo.restaurante.Dish.utils;

import com.gerardo.restaurante.Dish.dto.CreateDishRequestDTO;
import com.gerardo.restaurante.Dish.dto.DishResponseDTO;
import com.gerardo.restaurante.Dish.model.DishModel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@NoArgsConstructor
public class DishMapper {
    public DishModel toDishModel(CreateDishRequestDTO dto) {
        DishModel dishModel = new DishModel();
        dishModel.setName(dto.getName());
        dishModel.setDescription(dto.getDescription());
        dishModel.setPrice(dto.getPrice());
        dishModel.setAvailable(dto.getAvailable());
        dishModel.setCategory(dto.getCategory());
        dishModel.setCreatedAt(LocalDateTime.now());
        dishModel.setUpdatedAt(LocalDateTime.now());

        return dishModel;
    }

    public DishResponseDTO toDishResponseDTO(DishModel model) {
        DishResponseDTO dishResponseDTO = new DishResponseDTO();
        dishResponseDTO.setId(model.getId());
        dishResponseDTO.setName(model.getName());
        dishResponseDTO.setDescription(model.getDescription());
        dishResponseDTO.setPrice(model.getPrice());
        dishResponseDTO.setAvailable(model.getAvailable());
        dishResponseDTO.setCategory(model.getCategory());

        return dishResponseDTO;
    }
}
