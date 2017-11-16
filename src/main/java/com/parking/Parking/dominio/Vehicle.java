package com.parking.Parking.dominio;


public class Vehicle {

	protected String cylinder;
	protected String typeVehicle;
	protected String licensePlate;
	protected String hour;
	
	public String getCylinder() {
		return cylinder;
	}
	public String getType() {
		return typeVehicle;
	}
	public String getPlate() {
		return licensePlate;
	}
	public String getHour() {
		return hour;
	}
	public void setCylinder(String cylinder) {
		this.cylinder = cylinder;
	}
	
	public void getType(String type) {
		this.typeVehicle = type;
	}
	public void setPlate(String plate) {
		this.licensePlate = plate;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	public Vehicle(){
		
	}

	public Vehicle(String cylinder, String typeVehicle, String plate, String hour){
		
		this.cylinder   = cylinder;
		this.typeVehicle= typeVehicle;
		this.licensePlate= plate;
		this.hour		= hour;
		
	}

}

