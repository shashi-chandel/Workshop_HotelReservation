package com.capgemini.hotelreservation;

import static org.junit.Assert.*;

import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void whenHotelAdded_ShouldReturnTrue()
    {	
    	HotelReservation hotelReservation = new HotelReservation();
    	boolean isHotelAdded = hotelReservation.addHotel("Lakewood",110,90);
        assertTrue(isHotelAdded);
    }
	@Test 
    public void whenGivenDate_OneToSixOct2020_ShouldReturnLakewoodHotelCheapest() {
		HotelReservation hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90);
        hotelReservation.addHotel("Bridgewood", 160, 60);
        hotelReservation.addHotel("Ridgewood", 220, 150);
    	Hotel hotel = hotelReservation.findCheapestHotel("01-Oct-2020", "06-Oct-2020");
    	assertEquals("Lakewood", hotel.getHotelName());
    }
}
   