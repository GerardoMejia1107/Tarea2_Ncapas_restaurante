package com.gerardo.restaurante.Dish.repository;

import com.gerardo.restaurante.Dish.dto.DishResponseDTO;
import com.gerardo.restaurante.Dish.model.DishModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishJpaRepository extends JpaRepository<DishModel, Long> {

}
