package com.example.carrental.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Car {
	@Id
	@GeneratedValue
	private Long id;
	private String plateNumber;
	private String brand;
	private int price;
	private boolean rented;
	
	public Car() {
		super();
	}
	
	public Car(String plateNumber, String brand, int price) {
		super();
		this.plateNumber = plateNumber;
		this.brand = brand;
		this.price = price;
		this.rented = false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPlateNumber() {
		return plateNumber;
	}
	
	public void setPlateNumber(String plateNumber) {
		this.plateNumber = plateNumber;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public int getPrice() {
		return price;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isRented() {
		return rented;
	}

	public void setRented(boolean rented) {
		this.rented = rented;
	}

	public boolean rentCar() {
		if (rented) {
			return false;
		}

		rented = true;
		return rented;
	}
	@JsonIgnore
	public boolean getBackCar() {
		if (!rented) {
			return false;
		}

		rented = false;
		return !rented;
	}

	@Override
	public String toString() {
		return "Car [plateNumber=" + plateNumber + ", brand=" + brand + ", price=" + price + "]";
	}

}
