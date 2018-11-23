package com.example.carrental;
import com.example.carrental.model.Sample;
import com.example.carrental.repository.SampleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional
public class CarService {
    @Autowired
    private CarRespository carRespository;

    public Car save(Car car) { return carRespository.save(car); }

    public Optional<Car> getOne(Long id) { return carRespository.findById(id); }
}
