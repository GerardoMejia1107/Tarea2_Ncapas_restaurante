package com.gerardo.restaurante.Dish.service;

import com.gerardo.restaurante.Dish.dto.CreateDishRequestDTO;
import com.gerardo.restaurante.Dish.dto.DishResponseDTO;
import com.gerardo.restaurante.Dish.dto.UpdateDishRequestDTO;
import com.gerardo.restaurante.Dish.model.DishModel;
import com.gerardo.restaurante.Dish.repository.DishJpaRepository;
import com.gerardo.restaurante.Dish.utils.DishMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class DishServiceImp implements DishService {
    private final DishJpaRepository repository;
    private final DishMapper mapper;

    @Override
    public DishResponseDTO create(CreateDishRequestDTO dto) {
        DishModel newDish = repository.save(mapper.toDishModel(dto));
        return mapper.toDishResponseDTO(newDish);
    }

    @Override
    public List<DishResponseDTO> listAll() {
        return repository.findAll()
                .stream()
                .map(mapper::toDishResponseDTO)
                .toList();
    }

    @Override
    public DishResponseDTO listById(Long id) {
        return repository.findById(id)
                .map(mapper::toDishResponseDTO)
                .orElseThrow(
                        () -> new RuntimeException("Dish not found")
                );
    }

    @Override
    public List<DishResponseDTO> listByStatus(Boolean status) {
        return repository.getAllByAvailableIs(status)
                .stream()
                .map(mapper::toDishResponseDTO)
                .toList();
    }

    @Override
    public DishResponseDTO deleteById(Long id) {
        DishModel dish = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found"));

        repository.deleteById(id);
        return mapper.toDishResponseDTO(dish);
    }

    @Override
    public DishResponseDTO updateById(Long id, UpdateDishRequestDTO dto) {
        if (dto.getName() == null || dto.getDescription() == null || dto.getPrice() == null || dto.getCategory() == null || dto.getAvailable() == null) {
            throw new RuntimeException("All fields are required");
        }

        DishModel dish = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dish not found"));

        dish.setName(dto.getName());
        dish.setDescription(dto.getDescription());
        dish.setPrice(dto.getPrice());
        dish.setAvailable(dto.getAvailable());
        dish.setCategory(dto.getCategory());
        dish.setUpdatedAt(LocalDateTime.now());

        repository.save(dish);

        return mapper.toDishResponseDTO(dish);
    }
}
