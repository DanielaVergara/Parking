package com.parking.Parking.testdataBuilder;

import com.parking.Parking.dominio.Vehicle;

public class VehicleTestDataBuilder {
	
 private String typeVehicle;
 private String licensePlate;
 private String money;
 private String hour;

	
	public VehicleTestDataBuilder() {
		this.typeVehicle =  "Carro";
		this.licensePlate = "E25IH";
		this.money  	  = "454";
		this.hour 		  = "232";
	}
	
	
	public VehicleTestDataBuilder withtypeVehicle(String typeVehicle) {
		this.typeVehicle = typeVehicle;
		return this;
	}
	
	public VehicleTestDataBuilder withlicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
		return this;
	}
	
	public VehicleTestDataBuilder withMoney(String money){
		this.money = money;
		return this;
	}
	
	public VehicleTestDataBuilder withHour(String hour){
		this.hour = hour;
		return this;
	}
	
	public Vehicle build() {
		return new Vehicle(this.typeVehicle,this.licensePlate,this.money, this.hour);
	}
	
}


