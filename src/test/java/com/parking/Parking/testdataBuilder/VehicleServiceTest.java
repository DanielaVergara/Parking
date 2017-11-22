package com.parking.Parking.testdataBuilder;



import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import com.parking.Parking.controller.carController;


@RunWith(SpringRunner.class)
@SpringBootTest
public class VehicleServiceTest {

	@MockBean
	carController vh;
	


	@Test
	public void notifyTest() {
		//Arrange
		
		//Act	
		//var h=vh.createCar(car);
		//Assert
		
	}
}
