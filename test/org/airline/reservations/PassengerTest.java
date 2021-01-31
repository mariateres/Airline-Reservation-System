package org.airline.reservations;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassengerTest {

	@Test
	public void testPassenger() {
		Passenger testPassenger1 = new Passenger();
		String result = testPassenger1.getName();
		assertEquals("Unknown name", result);
	}

	@Test
	public void testSetName() {
		Passenger testPassenger2 = new Passenger();
		testPassenger2.setName("Mike Kelly");
		assertEquals("Mike Kelly", testPassenger2.getName());
	}
	
	@Test
	public void testPassenger2() { //test second constructor
		Passenger testPassenger3 = new Passenger("Mike Kelly");
		assertEquals("Mike Kelly", testPassenger3.getName());
	}
	
	@Test
	public void testToString() {
		Passenger testPassenger4 = new Passenger("Mike Kelly");
		assertEquals("Passenger: Mike Kelly", testPassenger4.toString());
	}

}