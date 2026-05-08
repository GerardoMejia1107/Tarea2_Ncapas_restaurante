package com.gerardo.restaurante.Dish.service;


import com.gerardo.restaurante.Dish.dto.CreateDishRequestDTO;
import com.gerardo.restaurante.Dish.dto.DishResponseDTO;
import com.gerardo.restaurante.Dish.dto.UpdateDishRequestDTO;
import com.gerardo.restaurante.Dish.enums.Category;

import java.util.List;

/**
 * Service contract for managing dishes in the restaurant system.
 *
 * <p>This interface defines operations for creating, retrieving, updating,
 * and deleting dishes. Implementations are responsible for applying business
 * rules and coordinating persistence operations.</p>
 */
public interface DishService {
    /**
     * Creates a new dish from the provided request data.
     *
     * @param dto the request DTO containing the dish information to be created
     * @return the response DTO representing the created dish
     */
    DishResponseDTO create(CreateDishRequestDTO dto);

    /**
     * Creates multiple dishes from a list of request DTOs.
     *
     * @param bulk the list of request DTOs containing the dishes to be created
     * @return a list of response DTOs representing the created dishes
     */
    List<DishResponseDTO> createBulk(List<CreateDishRequestDTO> bulk);

    /**
     * Retrieves all registered dishes.
     *
     * @return a list of response DTOs representing all dishes
     */
    List<DishResponseDTO> listAll();

    /**
     * Retrieves a dish by its unique identifier.
     *
     * @param id the unique identifier of the dish to retrieve
     * @return the response DTO representing the found dish
     */
    DishResponseDTO listById(Long id);

    /**
     * Retrieves dishes filtered by their availability status.
     *
     * @param status the availability status used to filter dishes;
     *               {@code true} for available dishes and {@code false} for unavailable dishes
     * @return a list of response DTOs representing the dishes that match the given status
     */
    List<DishResponseDTO> listByStatus(Boolean status);

    List<DishResponseDTO> listByCategory(Category category);

    /**
     * Deletes a dish by its unique identifier.
     *
     * @param id the unique identifier of the dish to delete
     * @return the response DTO representing the deleted dish
     */
    DishResponseDTO deleteById(Long id);

    /**
     * Updates an existing dish identified by its unique identifier.
     *
     * @param id  the unique identifier of the dish to update
     * @param dto the request DTO containing the updated dish information
     * @return the response DTO representing the updated dish
     */
    DishResponseDTO updateById(Long id, UpdateDishRequestDTO dto);

}
