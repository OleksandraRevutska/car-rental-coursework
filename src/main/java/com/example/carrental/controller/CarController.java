package com.example.carrental.controller;

import com.example.carrental.model.Car;
import com.example.carrental.model.Rental;
import com.example.carrental.service.CarService;
import com.example.carrental.service.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Управління автомобілями",
        description = "Операції для роботи з автомобілями системи оренди"
)
@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;
    private final RentalService rentalService;

    public CarController(CarService carService, RentalService rentalService) {
        this.carService = carService;
        this.rentalService = rentalService;
    }

    @Operation(
            summary = "Створити автомобіль",
            description = "Додає новий автомобіль у систему оренди"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Автомобіль успішно створено"),
            @ApiResponse(responseCode = "400", description = "Некоректні дані автомобіля")
    })
    @PostMapping
    public ResponseEntity<Car> create(@RequestBody Car car) {
        return ResponseEntity.ok(carService.save(car));
    }

    @Operation(
            summary = "Отримати всі автомобілі",
            description = "Повертає список усіх автомобілів у системі"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Список автомобілів отримано")
    })
    @GetMapping
    public ResponseEntity<List<Car>> getAll() {
        return ResponseEntity.ok(carService.getAll());
    }

    @Operation(
            summary = "Отримати оренди автомобіля",
            description = "Повертає список договорів оренди для конкретного автомобіля"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Список оренд автомобіля отримано"),
            @ApiResponse(responseCode = "404", description = "Автомобіль не знайдено")
    })
    @GetMapping("/{id}/rentals")
    public ResponseEntity<List<Rental>> getCarRentals(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.getByCarId(id));
    }
}