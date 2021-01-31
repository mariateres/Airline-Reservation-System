/*
 * Creating FlightTest class before creating Flight class following TDD paradigm.
 * Creating the Test class and ensuring that it fails.
 * Later we would code the Flight class and code until we pass all the tests.
 * Subsequently we may clean up the code a little bit.
 */


package org.airline.reservations;

import static org.junit.Assert.*;

import org.junit.Test;

public class FlightTest {

	@Test
	public void testFlight() {
		Flight testFlight1 = new Flight();
		assertEquals("Unknown Departure City", testFlight1.getDepartureCity());
		assertEquals("Unknown Arrival City", testFlight1.getArrivalCity());
		assertEquals(100, testFlight1.getFlightNumber());
	}
		
	@Test
	public void testSetDepartureCity() {
		Flight testFlight2 = new Flight();
		testFlight2.setDepartureCity("Los Angeles");
		assertEquals("Los Angeles", testFlight2.getDepartureCity());
	}
	
	@Test
	public void testSetArrivalCity() {
		Flight testFlight3 = new Flight();
		testFlight3.setArrivalCity("Chicago");
		assertEquals("Chicago", testFlight3.getArrivalCity());
	}
	
	@Test
	public void testSetFlightNumber() {
		Flight testFlight4 = new Flight();
		testFlight4.setFlightNumber(1000);
		assertEquals(1000, testFlight4.getFlightNumber());
	}
	
	@Test
	public void testFlight2() { //test second constructor
		Flight testFlight5 = new Flight(2000, "Chicago", "New York City");
		assertEquals(2000, testFlight5.getFlightNumber());
		assertEquals("Chicago", testFlight5.getDepartureCity());
		assertEquals("New York City", testFlight5.getArrivalCity());
	}
	
	@Test
	public void testToString() {
		Flight testFlight6 = new Flight(2000, "Chicago", "New York City");
		assertEquals("Flight: 2000 Chicago - New York City", testFlight6.toString());
	}

}