package com.parking.Parking.dominio;

public class Motorcycle extends Vehicle  {
	
	private String cylinder;
	
	public String getCylinder() {
		return cylinder;
	}
	
	public void setCylinder(String cylinder) {
		this.cylinder = cylinder;
	}

	
	public Motorcycle() {
		super();
	}
	
	public Motorcycle(String cylinder,String typeVehicle, String plate, String hour, String money){
		super(typeVehicle,plate,hour,money);
		this.cylinder = cylinder;
	}
}
