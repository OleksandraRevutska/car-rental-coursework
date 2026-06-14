package com.example.carrental.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(description = "Сутність автомобіля системи оренди")
@Entity
@Table(name = "cars")
public class Car {

    @Schema(description = "Унікальний ідентифікатор автомобіля", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Марка автомобіля", example = "Toyota")
    private String brand;

    @Schema(description = "Модель автомобіля", example = "Camry")
    private String model;

    @Schema(description = "Рік випуску автомобіля", example = "2020")
    private Integer year;

    @Schema(description = "Номерний знак автомобіля", example = "BH1234AA")
    private String licensePlate;

    public Car() {}

    public Car(Long id, String brand, String model, Integer year, String licensePlate) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.licensePlate = licensePlate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public String getLicensePlate() {
        return licensePlate;
    }
}