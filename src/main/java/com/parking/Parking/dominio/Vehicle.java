package com.parking.Parking.dominio;

import org.springframework.data.annotation.Id;

public class Vehicle extends Parking{

	
	@Id
	private String id;
	protected String typeVehicle;
	protected String licensePlate;
	protected boolean outVehicle;
	
	public boolean getOutVehicle() {
		return outVehicle;
	}
	public void setOutVehicle(boolean outVehicle) {
		this.outVehicle = outVehicle;
	}	

	public String getType() {
		return typeVehicle;
	}
	public String getPlate() {
		return licensePlate;
	}

	public void setType(String typeVehicle) {
		this.typeVehicle = typeVehicle;
	}
	public void setPlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	
	

	
	public Vehicle(){
		super();
	}

	public Vehicle(String hour, String money, String typeVehicle, String licensePlate, boolean outVehicle){
		super(hour,money);
		this.outVehicle = outVehicle;
		this.typeVehicle= typeVehicle;
		this.licensePlate= licensePlate;
		
	}


}

