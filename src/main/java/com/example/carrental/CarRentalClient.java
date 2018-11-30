package com.example.carrental;

import java.util.List;

import com.example.carrental.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;

public class CarRentalClient {
	
	private static final Logger log = LoggerFactory.getLogger(CarRentalClient.class);

	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		HttpEntity<Car> request = new HttpEntity<>(new Car("44QQ66", "Peugeot", 1200));
		restTemplate.postForObject("http://localhost:8080/cars", request, Car.class);

		HttpEntity<Car> request2 = new HttpEntity<>(new Car("11AA22", "Ferrari", 1000));
		restTemplate.postForObject("http://localhost:8080/cars", request2, Car.class);

		HttpEntity<Car> request3 = new HttpEntity<>(new Car("33BB44", "Porshe", 2222));
		restTemplate.postForObject("http://localhost:8080/cars", request3, Car.class);
		
        List cars = restTemplate.getForObject("http://localhost:8080/cars", List.class);
        log.info(cars.toString());
        
	}

}