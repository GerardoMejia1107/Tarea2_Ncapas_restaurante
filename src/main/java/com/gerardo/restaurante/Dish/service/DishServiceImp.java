package com.gerardo.restaurante.Dish.service;

import com.gerardo.restaurante.Dish.dto.CreateDishRequestDTO;
import com.gerardo.restaurante.Dish.dto.DishResponseDTO;
import com.gerardo.restaurante.Dish.dto.UpdateDishRequestDTO;
import com.gerardo.restaurante.Dish.enums.Category;
import com.gerardo.restaurante.Dish.model.DishModel;
import com.gerardo.restaurante.Dish.repository.DishJpaRepository;
import com.gerardo.restaurante.Dish.utils.DishMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Service implementation for managing dish-related business operations.
 *
 * <p>This class implements the {@link DishService} contract and coordinates
 * persistence operations through {@link DishJpaRepository}. It also uses
 * {@link DishMapper} to convert between request/response DTOs and
 * {@link com.gerardo.restaurante.Dish.model.DishModel} entities.</p>
 */
@Service
@AllArgsConstructor
public class DishServiceImp implements DishService {
    private final DishJpaRepository repository;
    private final DishMapper mapper;

    @Override
    public DishResponseDTO create(CreateDishRequestDTO dto) {
        //Catch the new dish to be saved, we map it from request dto to model
        DishModel newDish = repository.save(mapper.toDishModel(dto));
        //Return the saved model but first map it from model to a response dto
        return mapper.toDishResponseDTO(newDish);
    }

    @Override
    public List<DishResponseDTO> listAll() {
        //Return all the dishes, but first map each one from model to a response dto
        return repository.findAll()
                .stream()
                .map(mapper::toDishResponseDTO)
                .toList();
    }

    @Override
    public DishResponseDTO listById(Long id) {
        //Check first if the object with the passed id exists, if exists return the model mapped to a response dto
        return repository.findById(id)
                .map(mapper::toDishResponseDTO)
                //Otherwise, return a new runtime exception
                .orElseThrow(
                        () -> new RuntimeException("Dish not found")
                );
    }

    @Override
    public List<DishResponseDTO> listByStatus(Boolean status) {
        //Return all the objects that satisfies the status
        return repository.getAllByAvailableIs(status)
                .stream()
                //Map model to response dto
                .map(mapper::toDishResponseDTO)
                .toList();
    }

    @Override
    public List<DishResponseDTO> listByCategory(Category category) {
        //Return all the objects that satisfies the category
        return repository.findByCategoryIs(category)
                .stream()
                .map(mapper::toDishResponseDTO)
                .toList();
    }

    @Override
    public DishResponseDTO deleteById(Long id) {
        //Check if the object with the passed id exists
        DishModel dish = repository.findById(id)
                //Otherwise, throw a new runtime exception
                .orElseThrow(() -> new RuntimeException("Dish not found"));

        //If exists then delete the object
        repository.deleteById(id);
        //We returned the deleted object
        return mapper.toDishResponseDTO(dish);
    }

    @Override
    public DishResponseDTO updateById(Long id, UpdateDishRequestDTO dto) {
        //Check if all the fields required are not null
        if (dto.getName() == null || dto.getDescription() == null || dto.getPrice() == null || dto.getCategory() == null || dto.getAvailable() == null) {
            //If at least once is null, return an exception
            throw new RuntimeException("All fields are required");
        }
        //Check if the object with the specific id exists
        DishModel dish = repository.findById(id)
                //if it does not exist then return an exception
                .orElseThrow(() -> new RuntimeException("Dish not found"));

        //Set the new values
        dish.setName(dto.getName());
        dish.setDescription(dto.getDescription());
        dish.setPrice(dto.getPrice());
        dish.setAvailable(dto.getAvailable());
        dish.setCategory(dto.getCategory());
        dish.setUpdatedAt(LocalDateTime.now());

        //Save the object to persist the new data
        repository.save(dish);
        //Return the object model mapped to response dto
        return mapper.toDishResponseDTO(dish);
    }

    @Override
    public List<DishResponseDTO> createBulk(List<CreateDishRequestDTO> bulk) {
        //Catch the list of object models to be saved
        List<DishModel> data = repository.saveAll(bulk.stream()
                .map(mapper::toDishModel)
                .toList());

        //Returned the list of models mapped to a list of response dto
        return data.stream()
                .map(mapper::toDishResponseDTO)
                .toList();

    }
}
