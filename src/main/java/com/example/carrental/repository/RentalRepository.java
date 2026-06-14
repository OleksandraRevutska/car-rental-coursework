package com.example.carrental.repository;

import com.example.carrental.model.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface RentalRepository extends JpaRepository<Rental, Long> {

    List<Rental> findByCustomerId(Long customerId);

    List<Rental> findByCarId(Long carId);
}