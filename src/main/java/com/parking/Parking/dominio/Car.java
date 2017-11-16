package com.parking.Parking.dominio;

public class Car extends Vehicle {
	
	private String cylinder;
	
	public String getCylinder() {
		return cylinder;
	}

	public void setCylinder(String cylinder) {
		this.cylinder = cylinder;
	}

	public Car(){
		super();
	}
	
	public Car(String cylinder,String typeVehicle, String plate, String hour){
		
		super(typeVehicle,plate,hour);
		this.cylinder = cylinder;
	}
}
