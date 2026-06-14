package com.example.carrental.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(description = "Сутність категорії автомобілів")
@Entity
@Table(name = "car_categories")
public class CarCategory {

    @Schema(description = "Унікальний ідентифікатор категорії", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Назва категорії автомобілів", example = "SUV")
    private String name;

    public CarCategory() {}
}