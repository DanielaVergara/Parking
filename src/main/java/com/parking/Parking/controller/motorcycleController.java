package com.parking.Parking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.Parking.dominio.Motorcycle;
import com.parking.Parking.dominio.Vehicle;
import com.parking.Parking.services.motorCycleService;


@RestController
@RequestMapping("/motorcycle")
public class motorcycleController {

	@Autowired
	motorCycleService motoService;
	
	@PostMapping("/save")
	public String  createMoto(@RequestBody  Motorcycle moto){
		return motoService.validateMotorcycle( moto);
	}
	
	
}
