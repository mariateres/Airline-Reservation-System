package org.airline.reservations;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Test;

public class TicketTest {

	@Test
	public void testSetPassenger() {
		Ticket testTicket1 = new Ticket();
		Passenger testPassenger1 = new Passenger("Mike Kelly");
		testTicket1.setPassenger(testPassenger1);
		assertEquals("Mike Kelly", testTicket1.getPassenger().getName());
	}
	
	@Test
	public void testSetSeat() {
		Ticket testTicket2 = new Ticket();
		Seat testSeat2 = new Seat(2);
		testTicket2.setSeat(testSeat2);
		assertEquals(2, testTicket2.getSeat().getSeatNumber());
	}
	
	@Test
	public void testSetFlight() {
		Ticket testTicket3 = new Ticket();
		Flight testFlight3 = new Flight(3000, "Los Angeles", "Chicago");
		testTicket3.setFlight(testFlight3);
		assertEquals(3000, testTicket3.getFlight().getFlightNumber());
	}
	
	@Test
	public void testToString() {
		Ticket testTicket4 = new Ticket();
		Passenger testPassenger4 = new Passenger("Mike Kelly");
		Seat testSeat4 = new Seat(4);
		Flight testFlight4 = new Flight(4000, "Los Angeles", "Chicago");
		testTicket4.setPassenger(testPassenger4);
		testTicket4.setSeat(testSeat4);
		testTicket4.setFlight(testFlight4);
		assertEquals("Ticket: Mike Kelly departing on flight 4000 from Los Angeles to Chicago on " + LocalDate.now() + " in seat 4", testTicket4.toString());
		
	}

}