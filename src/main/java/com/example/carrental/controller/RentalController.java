package com.example.carrental.controller;

import com.example.carrental.model.Rental;
import com.example.carrental.service.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Управління орендою",
        description = "Операції для створення, перегляду та видалення договорів оренди автомобілів"
)
@RestController
@RequestMapping("/rentals")
public class RentalController {

    private final RentalService service;

    public RentalController(RentalService service) {
        this.service = service;
    }

    @Operation(
            summary = "Створити оренду",
            description = "Створює новий договір оренди автомобіля"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Оренду успішно створено"),
            @ApiResponse(responseCode = "400", description = "Некоректні дані запиту")
    })
    @PostMapping
    public ResponseEntity<Rental> create(@RequestBody Rental rental) {
        return ResponseEntity.ok(service.save(rental));
    }

    @Operation(
            summary = "Отримати всі оренди",
            description = "Повертає список усіх договорів оренди"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Список оренд успішно отримано")
    })
    @GetMapping
    public ResponseEntity<List<Rental>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @Operation(
            summary = "Отримати оренду за ID",
            description = "Повертає інформацію про договір оренди за його ідентифікатором"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Оренду знайдено"),
            @ApiResponse(responseCode = "404", description = "Оренду не знайдено")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Rental> getById(@PathVariable Long id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @Operation(
            summary = "Видалити оренду",
            description = "Видаляє або завершує договір оренди за його ідентифікатором"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Оренду успішно видалено"),
            @ApiResponse(responseCode = "404", description = "Оренду не знайдено")
    })
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}