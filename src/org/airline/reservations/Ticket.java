package org.airline.reservations;

import java.time.LocalDate;

public class Ticket {
	
	//fields
	private LocalDate departureDate;
	private Passenger passenger;
	private Flight flight;
	private Seat seat;
	
	//constructors
	public Ticket() {
		departureDate = LocalDate.now();
	}

	//getters and setters
	public LocalDate getDepartureDate() {
		return departureDate;
	}

	public void setDepartureDate(LocalDate departureDate) {
		this.departureDate = departureDate;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Seat getSeat() {
		return seat;
	}

	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	
	public String toString() {
		return "Ticket: " + this.getPassenger().getName() + " departing on flight " + this.getFlight().getFlightNumber() + " from " + this.getFlight().getDepartureCity() + " to " + this.getFlight().getArrivalCity() + " on " + this.getDepartureDate() + " in seat " + this.getSeat().getSeatNumber();
	}
	

}