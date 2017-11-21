package com.parking.Parking.dominio;


public class Parking {

	protected String hour;
	protected  String money;
	
	
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
		this.money = money;
	}
	
	public Parking(){
		
	}
	
	public Parking(String hour, String money){
		
		this.hour = hour;
		this.money= money;
		
	}
	
}
