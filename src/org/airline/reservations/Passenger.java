package org.airline.reservations;

public class Passenger {
	//fields
	private String name; //Passenger name
	
	//constructors
	public Passenger() {
		name = "Unknown name";
	}
	
	public Passenger(String name) {
		setName(name);
	}
	
	//getters and setters
	public String getName() {
		return name;
	}
	
	public void setName(String newName) {
		name = newName;
	}
	
	public String toString() {
		return "Passenger: " + this.getName();
	}
}
