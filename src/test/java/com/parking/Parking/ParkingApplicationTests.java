package com.parking.Parking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.parking.Parking.controller.carController;
import com.parking.Parking.dominio.Car;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingApplicationTests {

	@MockBean
	carController vh;
	
	@Test
	public void createCar() {
		Car car=new Car();
		when(vh.createCar(car))
        .thenReturn("success");
	}
	
	@Test
	public void validateCar(){
		Car car=new Car();
		when(vh.createCar(car))
        .thenReturn("Monday");
	}
	

}
