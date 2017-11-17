package com.parking.Parking.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.parking.Parking.dominio.Car;
import com.parking.Parking.dominio.Moto;
import com.parking.Parking.dominio.Vehicle;

public interface VehicleRepository extends  MongoRepository<Vehicle, String>{

	public Vehicle findOne(String licensePlate);

	
//	public Moto find(String cylinder);

//	public Car findOneLicensePlate(String licensePlate);
}
