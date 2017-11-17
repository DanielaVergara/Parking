package com.parking.Parking.dominio;

public class Parqueadero {

	protected String hour;
	protected static String money;
	
	
	public String getHour() {
		return hour;
	}
	public String getMoney() {
		return money;
	}
	public void setHour(String hour) {
		this.hour = hour;
	}
	public void setMoney(String money) {
		Parqueadero.money = money;
	}
	
	public Parqueadero(){
		
	}
	
	public Parqueadero(String hour, String money){
		
		this.hour = hour;
		Parqueadero.money= money;
		
	}
	
}
