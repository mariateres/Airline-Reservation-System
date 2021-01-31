package org.airline.reservations;

public class Seat {

	//fields
	private int seatNumber;

	//constructors
	public Seat() {
		setSeatNumber(10);
	}
	
	public Seat(int seat) {
		setSeatNumber(seat);
	}

	//getters and setters
	public int getSeatNumber() {
		return seatNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	public String toString() {
		return "Seat: " + this.getSeatNumber();
	}

}