package com.example.carrental.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.example.carrental.jms.JmsProducer;
import com.example.carrental.model.Car;
import com.example.carrental.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.http.HttpStatus;

@RestController
public class CarRentalRestService {
	
	private List<Car> cars = new ArrayList<Car>();

    @Autowired
	private CarService carService;


	public CarRentalRestService() {
		cars.add(new Car("11AA22", "Ferrari", 1000));
		cars.add(new Car("33BB44", "Porshe", 2222));
	}
	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value="/cars", method=RequestMethod.GET) 
	@ResponseStatus(HttpStatus.OK) 
	public List<Car> getListOfCars(){
		return carService.findAll();
	}

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/cars/{plateNumber}", method=RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Optional<Car> getOneCar(@PathVariable String plateNumber){
        return carService.findByPlateNumber(plateNumber);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping(value="/cars/{plateNumber}", method=RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Car> rentCar(@PathVariable String plateNumber, @RequestParam("louer") boolean isRented){
        Optional<Car> found = carService.findByPlateNumber(plateNumber);
        if(isRented) {
            return found.isPresent() && found.get().rentCar() ?
                    ResponseEntity.ok(carService.update(found.get())) : ResponseEntity.notFound().build();
        } else {
            return found.isPresent() && found.get().getBackCar() ?
                    ResponseEntity.ok(carService.update(found.get())) : ResponseEntity.notFound().build();
        }
    }

	@CrossOrigin(origins = "http://localhost:4200")
	@RequestMapping(value = "/cars", method = RequestMethod.POST, produces = "application/json")
	@ResponseStatus(HttpStatus.OK)
	public ResponseEntity<Car> addCar(@RequestBody Car car) throws Exception{
		return ResponseEntity.ok(carService.save(car));
	}

}
