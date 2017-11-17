package com.parking.Parking.dominio;

public class Moto extends Vehicle  {
	
	private String cylinder;
	
	public String getCylinder() {
		return cylinder;
	}
	
	public void setCylinder(String cylinder) {
		this.cylinder = cylinder;
	}

	
	public Moto() {
		super();
	}
	
	public Moto(String cylinder,String typeVehicle, String plate, String hour){
		super(typeVehicle,plate,hour,money);
		this.cylinder = cylinder;
	}
}
