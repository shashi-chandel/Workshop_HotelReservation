package com.capgemini.hotelreservation;

public class Hotel {
	private String hotelName;
	private int regularCustRate;
	
	public Hotel(String hotelName,int regularCustRate) {
		this.hotelName = hotelName;
		this.regularCustRate = regularCustRate;
	}

	public String getHotelName() {
		return hotelName;
	}

	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	public int getRegularCustRate() {
		return regularCustRate;
	}

	public void setRegularCustRate(int regularCustRate) {
		this.regularCustRate = regularCustRate;
	}
}
