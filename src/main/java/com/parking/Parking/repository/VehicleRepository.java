package com.parking.Parking.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.parking.Parking.dominio.Vehicle;

public interface VehicleRepository extends  MongoRepository<Vehicle, String>{

	public Vehicle findOne(String licensePlate);
	
	public List<Vehicle> findBytypeVehicle(String type);
	
	public List<Vehicle> deleteBylicensePlate(String plate);
}
