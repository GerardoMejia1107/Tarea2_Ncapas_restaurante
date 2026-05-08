package com.gerardo.restaurante.Dish.utils;

import com.gerardo.restaurante.Dish.dto.CreateDishRequestDTO;
import com.gerardo.restaurante.Dish.dto.DishResponseDTO;
import com.gerardo.restaurante.Dish.model.DishModel;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * Utility component responsible for mapping dish-related DTOs and entities.
 *
 * <p>This mapper converts incoming request DTOs into {@link DishModel}
 * entities and converts persisted {@link DishModel} entities into
 * {@link DishResponseDTO} objects used as API responses.</p>
 */
@Component
@NoArgsConstructor
public class DishMapper {

    /**
     * Converts a {@link CreateDishRequestDTO} into a {@link DishModel} entity.
     *
     * <p>This method copies the dish creation data from the request DTO and
     * initializes the creation and update timestamps with the current date and time.</p>
     *
     * @param dto the request DTO containing the dish creation data
     * @return a {@link DishModel} entity populated with the provided request data
     */
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

    /**
     * Converts a {@link DishModel} entity into a {@link DishResponseDTO}.
     *
     * <p>This method extracts the public response data from the persisted dish entity
     * and prepares it to be returned by the API.</p>
     *
     * @param model the dish entity to convert
     * @return a {@link DishResponseDTO} containing the dish response data
     */
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