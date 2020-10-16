package com.capgemini.hotelreservation;

import static org.junit.Assert.*;

import org.junit.Test;

public class HotelReservationTest {

	@Test
	public void whenHotelAdded_ShouldReturnTrue()
    {	
    	HotelReservation hotelReservation = new HotelReservation();
    	boolean isHotelAdded = hotelReservation.addHotel("Lakewood",110);
        assertTrue(isHotelAdded);
    }

}
