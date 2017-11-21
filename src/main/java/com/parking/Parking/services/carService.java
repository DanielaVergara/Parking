package com.parking.Parking.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parking.Parking.dominio.Car;
import com.parking.Parking.dominio.Vehicle;
import com.parking.Parking.repository.VehicleRepository;

@RestController
public class carService {
	
	@Autowired
	VehicleRepository vehRepository;

	
	private final static String Car 	        =  "carro";
	private final static String NotAllowed      =  "You can't enter today";
	private final static String DateNotobtained =  "It is not a day avalible for entered, by type license";
	private final static String NotCar 			=  "It is not a car";
	private final static String	EnteredCar		=  "The car has just entered";
	private final static String SpaceExceeded	=  "Space exceeded, no more cars can be entered";
	
	public String getDayWeek(){
	String[] strDays = new String[]{
			"Sunday",
			"Monday",
			"Tuesday",
			"Wednesday",
			"Thursday",
			"Friday",
			"Saturday"
			};
	Calendar Day = Calendar.getInstance();
	Day.get(Calendar.DAY_OF_WEEK);
	String day;
	day = strDays[Day.get(Calendar.DAY_OF_WEEK) - 1];
		return day;
	}

	
	public String validateCar(@RequestBody  Car car){
		String day= getDayWeek();
		return validateDate(day,car); 
	}
	
	public String validateDate(String day, Car car){
		if(day.toString() == "Tuesday" || day.toString() == "Sunday"){
			return validatePlateCar(car);
		}else{
			return DateNotobtained;
		}
	}
	
	public String validatePlateCar( Car car){
	  if(car.getPlate().startsWith("A")){
			return validateVehicle(car);
		}else{
			return NotAllowed;
		}
	}
	
	public String validateVehicle(Car car){
		  if(car.getType().equals(Car)){
			return validateCantCar(car);
		}else
			return NotCar;
		}

	public String validateCantCar(Car car){
		List<Vehicle> listV=vehRepository.findBytypeVehicle(car.getType());
		if(listV.size() < 20){
			return createCar(car);
		}else{
			return SpaceExceeded;
		}
	}
	
	public String createCar(Car car){
		Date fechaActual = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		car.setHour(formateador.format(fechaActual));
			 vehRepository.save(car);
			 return EnteredCar;
	}
	
	
	public List<Vehicle> getType(Car car){
		return vehRepository.findBytypeVehicle(car.getType());
	}

}
	
