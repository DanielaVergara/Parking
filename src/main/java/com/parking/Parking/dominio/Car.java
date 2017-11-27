package com.parking.Parking.dominio;


public class Car extends Vehicle {
	
	
	public Car(){
		super();
	}
	
	
	public Car(String typeVehicle, String licensePlate, String hour,String money, boolean outVehicle){
		super(typeVehicle,licensePlate, money, hour,outVehicle);
	}
}
