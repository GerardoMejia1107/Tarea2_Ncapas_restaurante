package com.gerardo.restaurante.Dish.model;

import com.gerardo.restaurante.Dish.enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * Entity that represents a dish stored in the database.
 *
 * <p>This model is mapped to the {@code dish} table and contains the
 * persistent information of a restaurant dish, including its basic data,
 * availability status, category, and audit timestamps.</p>
 */
@Entity
@Table(name = "dish")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DishModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "price")
    private Double price;
    @Column(name = "available")
    private Boolean available;
    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    private Category category;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

}
