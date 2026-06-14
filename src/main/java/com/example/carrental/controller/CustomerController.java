package com.example.carrental.controller;

import com.example.carrental.model.Customer;
import com.example.carrental.model.Rental;
import com.example.carrental.service.CustomerService;
import com.example.carrental.service.RentalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "Управління клієнтами",
        description = "Операції для роботи з клієнтами системи оренди автомобілів"
)
@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;
    private final RentalService rentalService;

    public CustomerController(CustomerService customerService, RentalService rentalService) {
        this.customerService = customerService;
        this.rentalService = rentalService;
    }

    @Operation(
            summary = "Створити клієнта",
            description = "Створює нового клієнта у системі оренди автомобілів"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Клієнта успішно створено"),
            @ApiResponse(responseCode = "400", description = "Некоректні дані клієнта")
    })
    @PostMapping
    public ResponseEntity<Customer> create(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerService.save(customer));
    }

    @Operation(
            summary = "Отримати всіх клієнтів",
            description = "Повертає список усіх клієнтів системи"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Список клієнтів отримано")
    })
    @GetMapping
    public ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(customerService.getAll());
    }

    @Operation(
            summary = "Отримати клієнта за ID",
            description = "Повертає інформацію про клієнта за його ідентифікатором"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Клієнта знайдено"),
            @ApiResponse(responseCode = "404", description = "Клієнта не знайдено")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Customer> getById(@PathVariable Long id) {
        return ResponseEntity.ok(customerService.getById(id));
    }

    @Operation(
            summary = "Отримати оренди клієнта",
            description = "Повертає список договорів оренди конкретного клієнта"
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Список оренд клієнта отримано"),
            @ApiResponse(responseCode = "404", description = "Клієнта не знайдено")
    })
    @GetMapping("/{id}/rentals")
    public ResponseEntity<List<Rental>> getCustomerRentals(@PathVariable Long id) {
        return ResponseEntity.ok(rentalService.getByCustomerId(id));
    }
}