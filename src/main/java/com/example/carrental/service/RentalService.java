package com.example.carrental.service;

import com.example.carrental.model.Car;
import com.example.carrental.model.Customer;
import com.example.carrental.model.Rental;
import com.example.carrental.repository.CarRepository;
import com.example.carrental.repository.CustomerRepository;
import com.example.carrental.repository.RentalRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentalService {

    private final RentalRepository rentalRepository;
    private final CarRepository carRepository;
    private final CustomerRepository customerRepository;

    public RentalService(RentalRepository rentalRepository,
                         CarRepository carRepository,
                         CustomerRepository customerRepository) {
        this.rentalRepository = rentalRepository;
        this.carRepository = carRepository;
        this.customerRepository = customerRepository;
    }

    public Rental save(Rental rental) {

        if (rental.getCar() != null) {
            Car car = carRepository.findById(rental.getCar().getId())
                    .orElseThrow(() -> new RuntimeException("Car not found"));
            rental.setCar(car);
        }

        if (rental.getCustomer() != null) {
            Customer customer = customerRepository.findById(rental.getCustomer().getId())
                    .orElseThrow(() -> new RuntimeException("Customer not found"));
            rental.setCustomer(customer);
        }

        return rentalRepository.save(rental);
    }

    public List<Rental> getAll() {
        return rentalRepository.findAll();
    }

    public Rental getById(Long id) {
        return rentalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rental not found"));
    }

    public List<Rental> getByCustomerId(Long customerId) {
        return rentalRepository.findByCustomerId(customerId);
    }

    public List<Rental> getByCarId(Long carId) {
        return rentalRepository.findByCarId(carId);
    }

    public void delete(Long id) {
        rentalRepository.deleteById(id);
    }
}