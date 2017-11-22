package com.parking.Parking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	public List<Vehicle> searchCar(){
		return carService.allCar();
	}
	
	@GetMapping("/getType")
	public int findByType(Car car){
		return carService.getType(car).size();
	}
	
	@DeleteMapping("/delete/{licensePlate}")
	public List<Vehicle> deleteBylicensePlate(@PathVariable String licensePlate){
		return carService.deleteBylicensePlate(licensePlate);
	}
	
}
