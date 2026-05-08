package com.gerardo.restaurante.Dish.controller;

import com.gerardo.restaurante.Dish.dto.CreateDishRequestDTO;
import com.gerardo.restaurante.Dish.dto.DishResponseDTO;
import com.gerardo.restaurante.Dish.dto.UpdateDishRequestDTO;
import com.gerardo.restaurante.Dish.service.DishService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller responsible for handling HTTP requests related to dishes.
 *
 * <p>This controller exposes endpoints for creating, retrieving, updating,
 * and deleting dishes. It delegates business logic to {@link DishService}
 * and returns API responses using {@link ResponseEntity}.</p>
 */
@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DishController {
    private final DishService service;

    /**
     * Creates a new dish.
     *
     * @param dto the request body containing the dish data to create
     * @return a response entity containing the created dish and HTTP status 201
     */
    @PostMapping("/dishes")
    public ResponseEntity<DishResponseDTO> createDish(@Valid @RequestBody CreateDishRequestDTO dto) {
        DishResponseDTO response = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    /**
     * Creates multiple dishes in a single request.
     *
     * @param list the request body containing a list of dishes to create
     * @return a response entity containing the created dishes and HTTP status 201
     */
    @PostMapping("/dishes/bulk")
    public ResponseEntity<List<DishResponseDTO>> createDishBulk(@Valid @RequestBody List<CreateDishRequestDTO> list) {
        List<DishResponseDTO> response = service.createBulk(list);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    /**
     * Retrieves all registered dishes.
     *
     * @return a response entity containing the list of all dishes and HTTP status 200
     */
    @GetMapping("/dishes")
    public ResponseEntity<List<DishResponseDTO>> getDishes() {
        List<DishResponseDTO> response = service.listAll();
        return ResponseEntity.ok(response);
    }

    /**
     * Retrieves a dish by its unique identifier.
     *
     * @param id the unique identifier of the dish to retrieve
     * @return a response entity containing the found dish and HTTP status 200
     */
    @GetMapping("/{id}/dish")
    public ResponseEntity<DishResponseDTO> getDishById(@PathVariable Long id) {
        DishResponseDTO response = service.listById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Retrieves dishes filtered by availability status.
     *
     * @param status the availability status used to filter dishes;
     *               {@code true} for available dishes and {@code false} for unavailable dishes
     * @return a response entity containing the filtered list of dishes and HTTP status 200
     */
    @GetMapping("/dishes/available")
    public ResponseEntity<List<DishResponseDTO>> getDishesByAvailableIs(@RequestParam Boolean status) {
        List<DishResponseDTO> response = service.listByStatus(status);
        return ResponseEntity.ok(response);
    }

    /**
     * Deletes a dish by its unique identifier.
     *
     * @param id the unique identifier of the dish to delete
     * @return a response entity containing the deleted dish and HTTP status 200
     */
    @DeleteMapping("/dishes/{id}/delete")
    public ResponseEntity<DishResponseDTO> removeById(@PathVariable Long id) {
        DishResponseDTO response = service.deleteById(id);
        return ResponseEntity.ok(response);
    }

    /**
     * Updates an existing dish by its unique identifier.
     *
     * @param id  the unique identifier of the dish to update
     * @param dto the request body containing the updated dish data
     * @return a response entity containing the updated dish and HTTP status 200
     */
    @PutMapping("/dishes/{id}/compleUpdate")
    public ResponseEntity<DishResponseDTO> updateById(@PathVariable Long id,
                                                      @RequestBody UpdateDishRequestDTO dto) {
        DishResponseDTO response = service.updateById(id, dto);
        return ResponseEntity.ok(response);
    }
}
