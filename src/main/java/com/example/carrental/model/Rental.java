package com.example.carrental.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.time.LocalDate;

@Schema(description = "Сутність договору оренди автомобіля")
@Entity
public class Rental {

    @Schema(description = "Унікальний ідентифікатор оренди", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Дата початку оренди", example = "2025-05-18")
    private LocalDate startDate;

    @Schema(description = "Дата завершення оренди", example = "2025-05-25")
    private LocalDate endDate;

    @Schema(description = "Автомобіль, який орендується")
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;

    @Schema(description = "Клієнт, який оформив оренду")
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Rental() {}

    // getters
    public Long getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Car getCar() {
        return car;
    }

    public Customer getCustomer() {
        return customer;
    }

    // setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}