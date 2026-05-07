package com.gerardo.restaurante.Dish.controller;

import com.gerardo.restaurante.Dish.dto.CreateDishRequestDTO;
import com.gerardo.restaurante.Dish.dto.DishResponseDTO;
import com.gerardo.restaurante.Dish.service.DishService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DishController {
    private final DishService service;

    @PostMapping("/dishes")
    public ResponseEntity<DishResponseDTO> createDish(@Valid @RequestBody CreateDishRequestDTO dto) {
        DishResponseDTO response = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/dishes")
    public ResponseEntity<List<DishResponseDTO>> getDishes() {
        List<DishResponseDTO> response = service.listAll();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}/dish")
    public ResponseEntity<DishResponseDTO> getDishById(@PathVariable Long id) {
        DishResponseDTO response = service.listById(id);
        return ResponseEntity.ok(response);
    }
}
