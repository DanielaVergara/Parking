package com.parking.Parking.dominio;


public class Vehicle extends Parking{


	protected String typeVehicle;
	protected String licensePlate;

	

	public String getType() {
		return typeVehicle;
	}
	public String getPlate() {
		return licensePlate;
	}

	public void setType(String type) {
		this.typeVehicle = type;
	}
	public void setPlate(String plate) {
		this.licensePlate = plate;
	}

	
	public Vehicle(){
		super();
	}

	public Vehicle(String hour, String money, String typeVehicle, String plate){
		super(hour,money);
		this.typeVehicle= typeVehicle;
		this.licensePlate= plate;
		
	}

	
/*	public Moto(String cylinder,String typeVehicle, String plate, String hour){
		
		super(typeVehicle,plate,hour);
		this.cylinder = cylinder;
	}*/

}

