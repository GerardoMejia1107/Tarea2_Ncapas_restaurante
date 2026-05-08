package com.gerardo.restaurante.Dish.repository;

import com.gerardo.restaurante.Dish.dto.DishResponseDTO;
import com.gerardo.restaurante.Dish.enums.Category;
import com.gerardo.restaurante.Dish.model.DishModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * JPA repository for managing {@link DishModel} persistence operations.
 *
 * <p>This repository provides the standard CRUD operations inherited from
 * {@link JpaRepository} and custom query methods for filtering dishes by
 * availability status and category.</p>
 */
public interface DishJpaRepository extends JpaRepository<DishModel, Long> {

    /**
     * Retrieves all dishes that match the given availability status.
     *
     * @param available the availability status used to filter dishes;
     *                  {@code true} for available dishes and {@code false} for unavailable dishes
     * @return a list of dishes matching the given availability status
     */
    List<DishModel> getAllByAvailableIs(Boolean available);

    /**
     * Retrieves all dishes that belong to the given category.
     *
     * @param category the category used to filter dishes
     * @return a list of dishes matching the given category
     */
    List<DishModel> findByCategoryIs(Category category);
}