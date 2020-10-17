package com.capgemini.hotelreservation;

import static org.junit.Assert.*;

import org.junit.Test;

public class HotelReservationTest {
	HotelReservation hotelReservation = new HotelReservation();

	@Test
	public void whenHotelAdded_ShouldReturnTrue() {
		HotelReservation hotelReservation = new HotelReservation();
		boolean isHotelAdded = hotelReservation.addHotel("Lakewood", 110, 90, 3);
		assertTrue(isHotelAdded);
	}

	@Test
	public void whenGivenDate_OneToSixOct2020_ShouldReturnLakewoodHotelCheapest() {
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Bridgewood", 160, 60, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);
		Hotel hotel = hotelReservation.findCheapestBestRatedHotel("10-Oct-2020", "16-Oct-2020");
		assertEquals("Lakewood", hotel.getHotelName());
	}

	@Test
	public void whenGivenDateRange_ShouldReturnBetterRatedCheapestHotel() {
		hotelReservation.addHotel("Lakewood", 110, 90, 3);
		hotelReservation.addHotel("Best Hotel", 110, 90, 5);
		hotelReservation.addHotel("Bridgewood", 160, 60, 4);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5);
		Hotel hotel = hotelReservation.findCheapestBestRatedHotel("01-Oct-2020", "06-Oct-2020");
		assertEquals("Best Hotel", hotel.getHotelName());
	}
}
