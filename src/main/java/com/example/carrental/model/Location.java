package com.example.carrental.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(description = "Сутність локації для розміщення автомобілів")
@Entity
@Table(name = "locations")
public class Location {

    @Schema(description = "Унікальний ідентифікатор локації", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Місто розташування локації", example = "Kyiv")
    private String city;

    @Schema(description = "Адреса локації", example = "Center Street 10")
    private String address;

    public Location() {}

    public Location(Long id, String city, String address) {
        this.id = id;
        this.city = city;
        this.address = address;
    }

    // --- GETTERS ---
    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public String getAddress() {
        return address;
    }

    // --- SETTERS ---
    public void setId(Long id) {
        this.id = id;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}