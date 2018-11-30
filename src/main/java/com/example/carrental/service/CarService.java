package com.example.carrental.service;
import com.example.carrental.jms.JmsProducer;
import com.example.carrental.model.Car;
import com.example.carrental.repository.CarRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CarService {
    @Autowired
    private CarRespository carRespository;

    @Autowired
    private JmsProducer jmsProducer;

    public List<Car> findAll() { jmsProducer.sendMessage("Get Car"); return carRespository.findAll(); }

    public Optional<Car> findByPlateNumber(String plateNumber) { jmsProducer.sendMessage("Get Car by Plate Number"); return carRespository.findByPlateNumber(plateNumber); }

    public Car save(Car car) { jmsProducer.sendMessage("Save Car"); return carRespository.saveAndFlush(car); }

    public Car update(Car car) { jmsProducer.sendMessage("Update Car"); return carRespository.saveAndFlush(car); }

    public Optional<Car> getOne(Long id) { jmsProducer.sendMessage("Get Car by Id"); return carRespository.findById(id); }
}
