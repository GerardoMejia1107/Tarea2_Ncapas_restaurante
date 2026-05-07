package com.gerardo.restaurante.Dish.service;

import com.gerardo.restaurante.Dish.dto.CreateDishRequestDTO;
import com.gerardo.restaurante.Dish.dto.DishResponseDTO;
import com.gerardo.restaurante.Dish.model.DishModel;
import com.gerardo.restaurante.Dish.repository.DishJpaRepository;
import com.gerardo.restaurante.Dish.utils.DishMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DishServiceImp implements DishService {
    private final DishJpaRepository repository;
    private final DishMapper mapper;

    @Override
    public DishResponseDTO create(CreateDishRequestDTO dto) {
        DishModel newDish = repository.save(mapper.toDishModel(dto));
        return mapper.dishResponseDTO(newDish);
    }
}
