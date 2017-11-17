package com.parking.Parking.testdataBuilder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.parking.Parking.dominio.Vehicle;

import com.parking.Parking.testdataBuilder.VehicleTestDataBuilder;


public class VehicleServiceTest {

	
	private VehicleServiceTest vehicleService;
	


	@Test
	public void notifyTest() {
		//Arrange
		Vehicle veh = new VehicleTestDataBuilder().build();
		//Act
		//Assert

	}
}
