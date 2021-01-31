/*
 * This is to test Database class where we would create and manage some fixed type of objects
 * that our application would use every time it runs.
 */

package org.airline.reservations;

import static org.junit.Assert.*;

import org.junit.Test;

public class DatabaseTest {

	@Test
	public void testDatabase() {
		Database testDB = new Database();
		assertEquals(0, testDB.getSeats().size()); // no seats have been added, so size should return 0
		assertEquals(0, testDB.getFlights().size());
		assertEquals(0, testDB.getPassengers().size());
		assertEquals(0, testDB.getTickets().size());
	}
	
	@Test
    public void testAddSeat() {
	    Database testDB2 = new Database();
	    testDB2.addSeat(2);
	    assertEquals(1, testDB2.getSeats().size());
	    assertEquals(2, testDB2.getSeats().get(0).getSeatNumber());
	}
	
	@Test
    public void testAddFlight() {
	    Database testDB3 = new Database();
	    testDB3.addFlight(1000, "Los Angeles", "Chicago");
	    assertEquals(1, testDB3.getFlights().size());
	}
	
	@Test
    public void testAddPassenger() {
	    Database testDB4 = new Database();
	    testDB4.addPassenger("Mike Kelly");
	    assertEquals(1, testDB4.getPassengers().size()); // checking to see if one passenger got added successfully
	}
	
	@Test
	public void testAddNewPassengers() {
		Database testDB6 = new Database();
		boolean result1 = testDB6.addPassenger("Mike Kelly");
		assertEquals(false, result1);
		boolean result2 = testDB6.addPassenger("Mike Kelly");
		assertEquals(true, result2); // checking for duplicate passenger entry
	}
	
	@Test
    public void testBootstrap() {
         Database testDB7 = new Database();
         testDB7.bootstrap();
         assertEquals(6, testDB7.getSeats().size());
         assertEquals(4, testDB7.getFlights().size());
	}

}