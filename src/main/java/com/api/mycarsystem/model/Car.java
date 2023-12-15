package com.api.mycarsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_cars")
public class Car {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long carId;
	private Integer carYear;
	private String licensePlate;
	private String model;
	private String color;
	
	public Car() {
	}
	
	public Car(Long id, Integer year, String licensePlate, String model, String color) {
		super();
		this.carId = id;
		this.carYear = year;
		this.licensePlate = licensePlate;
		this.model = model;
		this.color = color;
	}

	public Long getId() {
		return carId;
	}

	public void setId(Long id) {
		this.carId = id;
	}

	public Integer getYear() {
		return carYear;
	}

	public void setYear(Integer year) {
		this.carYear = year;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
