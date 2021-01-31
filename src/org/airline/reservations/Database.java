/*
 * In this class, we would create list of seats, flights, passengers and tickets
 */

package org.airline.reservations;

import java.time.LocalDate;
import java.util.ArrayList;

public class Database {

	//fields
	private ArrayList<Seat> seats;
	private ArrayList<Flight> flights;
	private ArrayList<Passenger> passengers;
	private ArrayList<Ticket> tickets;
	
	//constructor
	public Database() {
		seats = new ArrayList<Seat>();
		flights = new ArrayList<Flight>();
		passengers = new ArrayList<Passenger>();
		tickets = new ArrayList<Ticket>();
	}
	
	//getters
	public ArrayList<Seat> getSeats() {
		return seats;
	}
	
	public ArrayList<Flight> getFlights() {
		return flights;
	}

	public ArrayList<Passenger> getPassengers() {
		return passengers;
	}

	public ArrayList<Ticket> getTickets() {
		return tickets;
	}

	//setters
	public void addSeat(int seatNumber) {
		seats.add(new Seat(seatNumber));
	}

	public void addFlight(int flightNumber, String departureCity, String arrivalCity) {
		flights.add(new Flight(flightNumber, departureCity, arrivalCity));
	}

	public boolean addPassenger(String passengerName) {
		Boolean passengerExists = false;
		for (Passenger item : getPassengers()) {
			if (passengerName.equals(item.getName())) {
				passengerExists = true;
			}
		}
		if (passengerExists == false) {
			passengers.add(new Passenger(passengerName));
		}
		return passengerExists;
	}
	
	public String addTicket(LocalDate departureDate, String passengerName, int flightNumber, int seatNumber) {
		//find passenger object
		Passenger ticketPassenger = null;
		for (Passenger item : getPassengers()) {
			if (passengerName.equals(item.getName())) {
				ticketPassenger = item;
			}
		}
		
		//find flight object
		Flight ticketFlight = null;
		for (Flight item : getFlights()) {
			if (flightNumber == item.getFlightNumber()) {
				ticketFlight = item;
			}
		}
		
		//find seat object
		Seat ticketSeat = null;
		for (Seat item : getSeats()) {
			if (seatNumber == item.getSeatNumber()) {
				ticketSeat = item;
			}
		}
		Ticket tempTicket = new Ticket();
		tempTicket.setDepartureDate(departureDate);
		tempTicket.setPassenger(ticketPassenger);
		tempTicket.setFlight(ticketFlight);
		tempTicket.setSeat(ticketSeat);
		tickets.add(tempTicket);
		return tempTicket.toString();
	}
	
	public ArrayList<Seat> getOpenSeats(LocalDate departureDate, int flightNumber) {
		ArrayList<Seat> openSeats = getSeats();
		for (Ticket item : getTickets()) {
			if (departureDate.equals(item.getDepartureDate()) && flightNumber == item.getFlight().getFlightNumber()) {
				openSeats.remove(item.getSeat());
				}
		}
		return openSeats;
	}


	public void bootstrap() {
		addSeat(1);
		addSeat(2);
        addSeat(3);
        addSeat(4);
        addSeat(5);
        addSeat(6);

        addFlight(1000,"Los Angeles", "Chicago");
        addFlight(1010,"Chicago","New York");
        addFlight(2000,"New York","Chicago");
        addFlight(2010,"Chicago","Los Angeles");

	}
}