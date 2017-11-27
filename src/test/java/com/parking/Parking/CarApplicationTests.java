package com.parking.Parking;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.parking.Parking.controller.carController;
import com.parking.Parking.dominio.Car;
import com.parking.Parking.services.carService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CarApplicationTests {

	@MockBean
	carController carController;
	carService    carServi;
	
	@Test
	public void createCar() {
		//Arrange
		Car car=new Car();
		//Act
		when(carController.createCar(car))
        .thenReturn("success");
		//Assert
		assertEquals("carro", car);
	}
	
	@Test
	public void validateCar(){
		Car car=new Car();
		when(carController.createCar(car))
        .thenReturn("Monday");
		assertEquals(car, car);
	}
	
	
	@Test
	public void findType(){
		//Arrange
		Car car = new Car();
		//Act
		when(carController.findByType(car))
		.thenReturn(10);
		//Assert
		assertEquals("carro",car);
	}

	
	  @Test
	  public void validateDateService() {
		//Arrange 
		Car car = new Car();
		String day = "Monday";
		//Act
		String cam =  carServi.validateDate(day,car);
		//Assert
		assertEquals(cam,day);
	  }
	  
	  @Test
	  public void createCarService(){
		  //Arrange
		  Car car  = new Car();
		  String msg = "EnteredCar";
		  //Act
		  String create = carServi.createCar(car);
		  //Assert
		  assertEquals(msg,create);
	  }
	  
	  

}
