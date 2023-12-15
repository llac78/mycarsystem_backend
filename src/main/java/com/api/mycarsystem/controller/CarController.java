package com.api.mycarsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.mycarsystem.exception.ResourceNotFoundException;
import com.api.mycarsystem.model.Car;
import com.api.mycarsystem.repository.CarRepository;

@RestController
@RequestMapping("/api")
public class CarController {
	
	@Autowired
	CarRepository carRepository;
	
	@GetMapping("/cars")
	public List<Car> getAllCars(){
		return carRepository.findAll();
	}
	
	//TODO validações
	@PostMapping("/cars") 
	public Car createCar(@Validated @RequestBody Car car) {
        return carRepository.save(car);
    }
	
	@GetMapping("/cars/{id}")
	public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> car = carRepository.findById(id);
        return car.map(response -> ResponseEntity.ok().body(response)).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	
	@DeleteMapping("/cars/{id}")
	public ResponseEntity<Car> deleteCarById(@PathVariable Long id) {
		carRepository.deleteById(id);
		return ResponseEntity.ok().build();
    }

	@PostMapping("/cars/{id}") 
	public Car updateCar(@Validated @RequestBody Car car) {
        return carRepository.save(car);
    }

	@PutMapping("/cars/{id}")
    public ResponseEntity < Car > updateCar(@PathVariable(value = "id") Long carId,
        @Validated @RequestBody Car carDetails) throws ResourceNotFoundException {
        Car car = carRepository.findById(carId)
            .orElseThrow(() -> new ResourceNotFoundException("Car not found for this id :: " + carId));

        car.setYear(carDetails.getYear());
        car.setLicensePlate(carDetails.getLicensePlate());
        car.setModel(carDetails.getModel());
        car.setColor(carDetails.getColor());
        final Car updatedCar = carRepository.save(car);
        return ResponseEntity.ok(updatedCar);
    }
	
}
