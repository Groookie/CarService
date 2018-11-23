package com.example.carrental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRespository extends JpaRepository<Car, Long> {

}
