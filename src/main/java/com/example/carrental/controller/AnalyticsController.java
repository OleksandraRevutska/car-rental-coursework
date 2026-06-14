package com.example.carrental.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    @GetMapping("/cars/count")
    public String carsCount() {
        return "Cars count OK";
    }

    @GetMapping("/customers/count")
    public String customersCount() {
        return "Customers count OK";
    }
}