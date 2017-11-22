package com.parking.Parking.dominio;

import org.springframework.data.annotation.Id;

public class Car extends Vehicle {
	
	@Id
	private String id;
	public Car(){
		super();
	}
	
	
	public Car(String typeVehicle, String plate, String hour,String money){
		
		super(typeVehicle,plate, money, hour);
	}
}
