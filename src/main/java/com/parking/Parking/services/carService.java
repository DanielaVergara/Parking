package com.parking.Parking.services;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.parking.Parking.dominio.Car;
import com.parking.Parking.dominio.Vehicle;
import com.parking.Parking.repository.VehicleRepository;
import static java.lang.Math.toIntExact;


@RestController
public class carService {
	
	@Autowired
	VehicleRepository vehRepository;
	
	Map<String, Vehicle> custStores = new HashMap<String, Vehicle>();
	
	private final  String Car 	        =  "carro";
	private final  String DayNotAvalible =  "It is not a day avalible for entered, by type license plate";
	private final  String NotCar 			=  "It is not a car";
	private final  String EnteredCar		=  "The car has just entered";
	private final  String SpaceExceeded	=  "Space exceeded, no more cars can be entered";
	private final  String ValuePay		 = "Value to pay is";
	
	
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
		return validatePlateCar(day,car); 
	}
	
	public String validatePlateCar(String day,Car car){
	  if(car.getPlate().startsWith("A")){
			return validateDate(day,car);
		}else{
			return validateVehicle(car);
		}
	}
	
	public String validateDate(String day, Car car){
		if(day.toString() == "Monday" || day.toString() == "Sunday"){
			return validateVehicle(car);	
		}else{
			return DayNotAvalible;
		}
	}
	
	public String validateVehicle(Car car){
		  if(car.getType().equals(Car)){
			return validateQuantityCar(car);
		}else
			return NotCar;
		}

	public String validateQuantityCar(Car car){
		List<Vehicle> listV=vehRepository.findBytypeVehicle(car.getType());
		if(listV.size() < 20){
			return createCar(car);
		}else{
			return SpaceExceeded;
		}
	}
	
	public String createCar(Car car){
		Date currentDate = new Date();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		car.setHour(format.format(currentDate));
		car.setOutVehicle(true);
			 vehRepository.save(car);
			 return EnteredCar;
	}
	
	public List <Vehicle> deleteBylicensePlate(String licensePlate){
		return vehRepository.deleteBylicensePlate(licensePlate);
		//long today = outCar(v1);
		//return today;
		
	}
	
	public String updateCar(Car car,String licensePlate){
		try {
			custStores.remove(car);
			car.setPlate(licensePlate);
			car.setOutVehicle(false);
			 custStores.put(licensePlate, car);
			long today = outCar(car);
			//return today;
		return validationHours(today);
		} catch (Exception e) {
			return null;
		}
	}

	public String validationHours(long today){
	int day = toIntExact(today);

		if(day < 9){
			long valueByHour = 1000;
			long totalValueHour = day * valueByHour; 
		 return ValuePay + totalValueHour;
		}else{
			long valueByDay = 8000;
			long totalValueDay = day * valueByDay;
		  return ValuePay + totalValueDay;
		}
	}
	  

	 
	public long outCar(Vehicle veh){
		Date departureDate = new Date();
		try {

			SimpleDateFormat formate = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date startDate=formate.parse(veh.getHour());
			return TimeUnit.MILLISECONDS.toHours(departureDate.getTime() - startDate.getTime());
		
		} catch (Exception e) {
			return 0;
		}
	}
	
	public List<Vehicle> allCar(){
		List<Vehicle> listV=vehRepository.findAll();
		return listV;
	}
	
	public List<Vehicle> getType(Car car){
		return vehRepository.findBytypeVehicle(car.getType());
	}


}
	
