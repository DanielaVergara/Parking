package com.parking.Parking.testdataBuilder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.aggregation.ConditionalOperators.Cond.WhenBuilder;

import com.parking.Parking.controller.carController;
import com.parking.Parking.dominio.Car;
import com.parking.Parking.dominio.Vehicle;

import com.parking.Parking.testdataBuilder.VehicleTestDataBuilder;

import de.flapdoodle.embed.process.store.CachingArtifactStore;


public class VehicleServiceTest {

	@MockBean
	carController vh;
	


	@Test
	public void notifyTest() {
		//Arrange
		Car car=new Car();
		//given(vh.createCar(car)).then(12);
		//Act	
		//var h=vh.createCar(car);
		//Assert
		
	}
}
