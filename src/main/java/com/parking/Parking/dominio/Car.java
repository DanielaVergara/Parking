package com.parking.Parking.dominio;

public class Car extends Vehicle {
	

	public Car(){
		super();
	}
	
	
	public Car(String typeVehicle, String plate, String hour,String money){
		
		super(typeVehicle,plate, money, hour);
	}
}
