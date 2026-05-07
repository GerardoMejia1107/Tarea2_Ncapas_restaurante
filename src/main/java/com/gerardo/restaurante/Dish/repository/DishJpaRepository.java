package com.gerardo.restaurante.Dish.repository;

import com.gerardo.restaurante.Dish.model.DishModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishJpaRepository extends JpaRepository<DishModel, Long> {
}
