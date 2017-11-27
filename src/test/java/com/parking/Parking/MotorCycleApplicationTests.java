package com.parking.Parking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.parking.Parking.controller.motorcycleController;
import com.parking.Parking.dominio.Motorcycle;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MotorCycleApplicationTests {

	@MockBean
	motorcycleController motorCy;
	
	@Test
	public void createCar() {
		Motorcycle moto = new Motorcycle();
		when(motorCy.createMoto(moto))
        .thenReturn("success");
	}
}