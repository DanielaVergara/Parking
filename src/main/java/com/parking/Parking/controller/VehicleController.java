package com.parking.Parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.parking.Parking.dominio.Vehicle;
import com.parking.Parking.repository.VehicleRepository;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	VehicleRepository vehicleRepository;

	//create
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public Vehicle create(@RequestBody Vehicle vehicle){
		return vehicleRepository.save(vehicle);
	}
	
	
	//read
	/*@RequestMapping(value = "/{licensePlate}")
	public Vehicle read(@PathVariable String licensePlate){
		return vehicleRepository.findOne(licensePlate);
			
	}*/
	
	//update
/*	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public void update(Vehicle vehicle){
		vehicleRepository.save(vehicle);
	}*/
	
	
	//delete
/*	@RequestMapping(value = "/{licensePlate}", method = RequestMethod.DELETE)
	public void delete(String licensePlate){
		vehicleRepository.delete(licensePlate);
	}*/
	
	
	
	
}
