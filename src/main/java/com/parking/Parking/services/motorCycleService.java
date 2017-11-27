package com.parking.Parking.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.parking.Parking.dominio.Motorcycle;
import com.parking.Parking.dominio.Vehicle;
import com.parking.Parking.repository.VehicleRepository;


@RestController
public class motorCycleService {

	@Autowired
	VehicleRepository vehRepository;
	Map<String, Vehicle> custStores = new HashMap<String, Vehicle>();
	
	private final  String DayNotAvalible =  "It is not a day avalible for entered, by type license plate";
	private final  String Motorcycle 		= "moto";
	private final  String EnteredMotorcycle =  "The motorcycle has just entered";
	private final  String SpaceExceeded	=  "Space exceeded, no more motorcycles can be entered";
	private final  String NotMotorcycle 	= "It is not motorcycle";
	private final  String ValuePay		 = "Value to pay is: ";
	
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
		return validatePlate(day, moto);
	}
	
	public String validatePlate(String day, Motorcycle moto){
		  if(moto.getPlate().startsWith("A")){
				return validateDate(day,moto);
			}else{
				return validateVehicle(moto);
			}
		}
	
	public String validateDate(String day, Motorcycle moto){
		if(day.toString() == "Monday" || day.toString() == "Sunday"){
			return validateVehicle(moto);
		}else{
			return DayNotAvalible;
		}
	}
	
	public String validateVehicle(Motorcycle moto){
		if(moto.getType().equals(Motorcycle)){
			return validateQuantityMotorCycle(moto);
		}else{
			return NotMotorcycle;
		}
	  }
	
	
	public String validateQuantityMotorCycle(Motorcycle moto){
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

	public String validateOutMotorCycle(Motorcycle moto, long today){
		return validationHours(today);
	}
		
	public String updateMotorCycle(Motorcycle moto,String licensePlate, long today){
		try {
			custStores.remove(moto);
			moto.setPlate(licensePlate);
			custStores.put(licensePlate, moto);
			//long today = outMotorCycle(moto);
			//return today;
		   	return validationHours(today);
		} catch (Exception e) {
			return null;
		}
	}
	
	public String validationHours(long today){
		if(today < 9){
			long valueByHour = 500;
			long totalValueHour = today * valueByHour; 
		 return ValuePay + totalValueHour;
		}else{
			long valueByDay = 600;
			long totalValueDay = today * valueByDay;
		  return ValuePay + totalValueDay;
		}
	}
	
	/*public String operationsCylinder(Motorcycle moto, long valueMoreCylinder){
		if(today < 9){
			long valueByHour = 500;
			long totalValueHour = today * valueByHour; 
		 return ValuePay + totalValueHour;
		}else{
			long valueByDay = 600;
			long totalValueDay = today * valueByDay;
		  return ValuePay + totalValueDay;
		}
	}*/
	
/*	public String validateCylinder(Motorcycle moto, long today){
		if(moto.getCylinder() > 500){
			long valueMoreCylinder = 2000;
			return operationsCylinder(moto, valueMoreCylinder);
		}
		else{
			return validationHours(today);
		}
	}
*/
	public long outMotorCycle(Vehicle veh){
		Date departureDate = new Date();
		try {
			SimpleDateFormat formate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date startDate=formate.parse(veh.getHour());
			return TimeUnit.MILLISECONDS.toHours(departureDate.getTime() - startDate.getTime());
		
		} catch (Exception e) {
			return 0;
		}
	}
	
	public List<Vehicle> getType(Motorcycle moto){
		return vehRepository.findBytypeVehicle(moto.getType());
	}
	
	
}
