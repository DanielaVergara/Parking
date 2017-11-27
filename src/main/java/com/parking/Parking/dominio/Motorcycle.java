package com.parking.Parking.dominio;



public class Motorcycle extends Vehicle  {
	
	

	private int cylinder;
	
	public int getCylinder() {
		return cylinder;
	}
	
	public void setCylinder(int cylinder) {
		this.cylinder = cylinder;
	}

	
	public Motorcycle() {
		super();
	}
	
	public Motorcycle(int cylinder,String typeVehicle, String licensePlate, String hour, String money, boolean outVehicle){
		super(typeVehicle,licensePlate,hour,money,outVehicle);
		this.cylinder = cylinder;
	}
}
