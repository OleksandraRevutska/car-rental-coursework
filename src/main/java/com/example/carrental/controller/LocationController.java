package com.example.carrental.controller;

import com.example.carrental.model.Location;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Локації",
        description = "Операції для роботи з локаціями автомобілів"
)
@RestController
@RequestMapping("/locations")
public class LocationController {

    @Operation(
            summary = "Створити локацію",
            description = "Створює нову локацію для зберігання автомобілів"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Локацію успішно створено"),
            @ApiResponse(responseCode = "400", description = "Некоректні дані")
    })
    @PostMapping
    public ResponseEntity<Location> create() {
        return ResponseEntity.ok(
                new Location(1L, "Kyiv", "Center")
        );
    }

    @Operation(
            summary = "Отримати всі локації",
            description = "Повертає список усіх локацій"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Список локацій отримано")
    })
    @GetMapping
    public ResponseEntity<List<Location>> getAll() {
        return ResponseEntity.ok(List.of(
                new Location(1L, "Kyiv", "Center")
        ));
    }

    @Operation(
            summary = "Отримати локацію за ID",
            description = "Повертає інформацію про локацію за її ідентифікатором"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Локацію знайдено"),
            @ApiResponse(responseCode = "404", description = "Локацію не знайдено")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Location> getById(@PathVariable Long id) {
        return ResponseEntity.ok(
                new Location(id, "Lviv", "Street 1")
        );
    }

    @Operation(
            summary = "Отримати автомобілі локації",
            description = "Повертає список автомобілів, які знаходяться на певній локації"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Автомобілі локації отримано")
    })
    @GetMapping("/{id}/cars")
    public ResponseEntity<String> cars() {
        return ResponseEntity.ok("Cars in location");
    }
}