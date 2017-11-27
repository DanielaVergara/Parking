package com.parking.Parking.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.parking.Parking.dominio.Car;
import com.parking.Parking.dominio.Vehicle;
import com.parking.Parking.repository.VehicleRepository;
import com.parking.Parking.services.carService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/car")

public class carController {

	@Autowired
	carService	carService;
	VehicleRepository vehRepository;

	Map<String, Vehicle> custStores = new HashMap<String, Vehicle>();
	
	@PostMapping("/save")
	@CrossOrigin(origins = "http://localhost:4200")
	public String  createCar(@RequestBody Car car){
		return carService.validateCar(car);
	}

	@GetMapping("/search")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Vehicle> allCar(){
		return carService.allCar();
	}
	
	@PutMapping("/edit/{licensePlate}")
	@CrossOrigin(origins = "http://localhost:4200")
	public String updateObject(@PathVariable String licensePlate,@RequestBody Car car){
		return carService.updateCar(car, licensePlate);
	}
	
	@GetMapping("/getType")
	@CrossOrigin(origins = "http://localhost:4200")
	public int findByType(Car car){
		return carService.getType(car).size();
	}
	
	@DeleteMapping("/delete/{licensePlate}")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Vehicle> deleteBylicensePlate(@PathVariable String licensePlate){
		return carService.deleteBylicensePlate(licensePlate);
	}
	
}
