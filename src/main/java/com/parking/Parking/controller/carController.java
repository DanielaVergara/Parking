package com.parking.Parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.Parking.dominio.Car;
import com.parking.Parking.dominio.Vehicle;
import com.parking.Parking.services.carService;

@RestController
@RequestMapping("/car")

public class carController {

	@Autowired
	carService	carService;

	@PostMapping("/save")
	public String  createCar(@RequestBody Car car){
		return carService.validateCar(car);
	}
	
	
	@GetMapping("/search")
	public void findCar(Car car){
		carService.validateVehicle(car);
	}
	
	@GetMapping("/getType")
	public int findByType(Car car){
		return carService.getType(car).size();
	}
	
	
}
