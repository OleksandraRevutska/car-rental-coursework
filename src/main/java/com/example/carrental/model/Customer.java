package com.example.carrental.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Schema(description = "Сутність клієнта системи оренди автомобілів")
@Entity
@Table(name = "customers")
public class Customer {

    @Schema(description = "Унікальний ідентифікатор клієнта", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "Ім'я клієнта", example = "Олександра")
    private String firstName;

    @Schema(description = "Прізвище клієнта", example = "Ревуцька")
    private String lastName;

    @Schema(description = "Email клієнта", example = "client@gmail.com")
    private String email;

    @Schema(description = "Номер телефону клієнта", example = "+380501112233")
    private String phone;

    public Customer() {}

    public Customer(Long id, String firstName, String lastName, String email, String phone) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}