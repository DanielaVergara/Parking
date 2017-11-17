package com.parking.Parking.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.parking.Parking.dominio.Car;
import com.parking.Parking.dominio.Moto;
import com.parking.Parking.dominio.Vehicle;
import com.parking.Parking.repository.VehicleRepository;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

	@Autowired
	VehicleRepository vehicleRepository;

	@PostMapping
	public void createCar(@RequestBody Vehicle veh, @RequestBody Moto moto){
		Date fechaActual = new Date(0);
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		veh.setHour(formateador.format(fechaActual));
		 vehicleRepository.save(veh);
		 vehicleRepository.save(moto);
	}

	
	
	@PutMapping
	public void update(@RequestBody Vehicle vehicle){
		vehicleRepository.save(vehicle);
	}
	
	@DeleteMapping
	public void delete(String licensePlate){
		vehicleRepository.delete(licensePlate);
	}
	
	
	
	
}
