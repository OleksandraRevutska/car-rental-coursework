package com.example.carrental.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.web.bind.annotation.*;

@Tag(
        name = "Пошук",
        description = "Операції для повнотекстового пошуку в системі"
)
@RestController
@RequestMapping("/search")
public class SearchController {

    @Operation(
            summary = "Пошук автомобілів",
            description = "Виконує пошук автомобілів у системі"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Результати пошуку автомобілів отримано")
    })
    @GetMapping("/cars")
    public String cars() {
        return "Search cars OK";
    }

    @Operation(
            summary = "Пошук клієнтів",
            description = "Виконує пошук клієнтів у системі"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Результати пошуку клієнтів отримано")
    })
    @GetMapping("/customers")
    public String customers() {
        return "Search customers OK";
    }

    @Operation(
            summary = "Пошук оренд",
            description = "Виконує пошук договорів оренди"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Результати пошуку оренд отримано")
    })
    @GetMapping("/rentals")
    public String rentals() {
        return "Search rentals OK";
    }
}
