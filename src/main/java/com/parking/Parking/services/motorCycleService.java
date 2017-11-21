package com.parking.Parking.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.parking.Parking.dominio.Motorcycle;
import com.parking.Parking.dominio.Vehicle;
import com.parking.Parking.repository.VehicleRepository;


@RestController
public class motorCycleService {

	@Autowired
	VehicleRepository vehRepository;
	
	private final static String Motorcycle 		= "moto";
	private final static String NotAllowed      =  "You can't enter today";
	private final static String DateNotobtained =  "Date not obtained";
	private final static String	EnteredMotorcycle =  "The motorcycle has just entered";
	private final static String SpaceExceeded	=  "Space exceeded, no more motorcycles can be entered";
	private final static String NotMotorcycle 	= "It is not motorcycle";
	
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
	
	public String validateMotorcycle( Motorcycle moto){
		String day= getDayWeek();
		return validateDate(day,moto);
	}
	
	public String validateDate(String day, Motorcycle moto){
		if(day.toString() == "Tuesday" || day.toString() == "Sunday"){
			return validatePlate(moto);
		}else{
			return DateNotobtained;
		}
	}
	
	public String validatePlate( Motorcycle moto){
		  if(moto.getPlate().startsWith("A")){
				return validateVehicle(moto);
			}else{
				return NotAllowed;
			}
		}
	
	public String validateVehicle(Motorcycle moto){
		
		if(moto.getType().equals(Motorcycle)){
			return validateCantMotorCycle(moto);
		}else{
			return NotMotorcycle;
		}
		
	  }
	
	public String validateCantMotorCycle(Motorcycle moto){
		List<Vehicle> listV=vehRepository.findBytypeVehicle(moto.getType());
		if(listV.size() < 10){
			return createMoto(moto);
		}else{
			return SpaceExceeded;
		}
	}
	
	public String createMoto(Motorcycle moto){
		Date fechaActual = new Date();
		SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		moto.setHour(formateador.format(fechaActual));
			vehRepository.save(moto);
			return EnteredMotorcycle;

	}
	
	
	public List<Vehicle> getType(Motorcycle moto){
		return vehRepository.findBytypeVehicle(moto.getType());
	}
	
	
}
