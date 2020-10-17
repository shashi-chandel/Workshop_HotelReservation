package com.capgemini.hotelreservation;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class HotelReservationTest {
	HotelReservation hotelReservation;
	Customer customer;

	@Before
	public void init() {
		hotelReservation = new HotelReservation();
		hotelReservation.addHotel("Lakewood", 110, 90, 3, 80, 80);
		hotelReservation.addHotel("Bridgewood", 160, 60, 4, 110, 50);
		hotelReservation.addHotel("Ridgewood", 220, 150, 5, 100, 40);
		customer = new Customer();
	}

	@Test
	public void whenHotelAdded_ShouldReturnTrue() {
		boolean isHotelAdded = hotelReservation.addHotel("ABC", 110, 90, 3, 100, 200);
		assertTrue(isHotelAdded);
	}

	@Test
	public void whenGivenDate_OneToSixOct2020_ShouldReturnLakewoodHotelCheapest() {
		customer.setCustomerType("regular");
		Hotel hotel = hotelReservation.findCheapestBestRatedHotel("01-Oct-2020", "06-Oct-2020", customer);
		assertEquals("Lakewood", hotel.getHotelName());
	}

	@Test
	public void whenGivenDate_Improper_ShouldReturnNull() {
		customer.setCustomerType("regular");
		Hotel hotel = hotelReservation.findCheapestBestRatedHotel("06-Oct-2020", "01-Oct-2020", customer);
		assertEquals(null, hotel);
	}

	@Test
	public void whenGivenDateRange_InvokingFindCheapestBestRatedHotel_ShouldReturnBetterRatedCheapestHotel() {
		customer.setCustomerType("regular");
		hotelReservation.addHotel("Cheapest Hotel", 110, 90, 5, 10, 20);
		Hotel hotel = hotelReservation.findCheapestBestRatedHotel("01-Oct-2020", "06-Oct-2020", customer);
		assertEquals("Cheapest Hotel", hotel.getHotelName());
	}

	@Test
	public void whenGivenDateRange_InvokingFindBestRatedHotel_ShouldReturnBestRatedHotel() {
		customer.setCustomerType("regular");
		hotelReservation.addHotel("Best Rated Hotel", 200, 150, 6, 50, 20);
		Hotel hotel = hotelReservation.findBestRatedHotel("01-Oct-2020", "06-Oct-2020", customer);
		assertEquals("Best Rated Hotel", hotel.getHotelName());
	}

	@Test
	public void whenGivenDateRange_FindCheapestBestRatedHotelForReward_ShouldReturnHotelWithRewardCustAmount() {
		customer.setCustomerType("reward");
		Hotel hotel = hotelReservation.findBestRatedHotel("01-Oct-2020", "06-Oct-2020", customer);
		assertEquals(480, hotel.getTotalRate());
	}
}
