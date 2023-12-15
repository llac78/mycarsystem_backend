package com.api.mycarsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.mycarsystem.model.Car;

public interface CarRepository extends JpaRepository<Car, Long>{

}
