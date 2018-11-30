package com.example.carrental.repository;
import com.example.carrental.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRespository extends JpaRepository<Car, Long> {
    Optional<Car> findByPlateNumber(String plateNumber);
}
