/*
 * This is the class containing main method from where our application would execute in a loop
 * In this simple application, we are creating flight tickets in a loop by adding all the info to the ticket
 * After entering info for one passenger, the application asks if we would like to book another ticket
 * If yes, then the loop executes one more time. Otherwise, the application terminates
 */

package org.airline.reservations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.ArrayList;

public class Console {

	public static void main(String[] args) {
		//initialize database
		Database prodDB = new Database(); // production ready Database
		prodDB.bootstrap();
		
		//initialize console
		boolean always = true;
		boolean loop; // for inner while loop to ask for booking another ticket
		BufferedReader screenInput = new BufferedReader(new InputStreamReader(System.in));
		String passengerName = null;
		String bookMoreTicket = null;
		int flightNumber = 0;
		LocalDate departureDate = LocalDate.now();
        int seatNumber = 0;

		while(always) {
			//ask for passengerName and add
			System.out.println("Enter passenger: ");
			try {
				passengerName = screenInput.readLine();
			} catch (IOException e) {
				System.out.println("Sorry, I don't understand.");
			}
			
			boolean result = prodDB.addPassenger(passengerName);
			if (result) {
                System.out.println("Welcome back " + passengerName);
			} else {
                System.out.println("Welcome " + passengerName);
			}
			
			//show flights and ask for flight
			System.out.println("\nHere are the available flights:");
            for (Flight item : prodDB.getFlights()) {
                 System.out.println(item);
            }
            System.out.println("Enter the flight number to book: ");
            try {
                   flightNumber = Integer.parseInt(screenInput.readLine());
              } catch (IOException e) {
                   System.out.println("Please enter a flight number");
              } catch (NumberFormatException e) {
                  System.out.println("That wasn't a number");
             }
			
            //show available seats and ask
            System.out.println("\nAssuming you are flying today,");
            System.out.println("Here are the available seats on that flight: ");
            ArrayList<Seat> openSeats = prodDB.getOpenSeats(departureDate, flightNumber);
            for (Seat item : openSeats) {
                 System.out.print(item.getSeatNumber() + ", ");
            }
            System.out.println("\nEnter the seat you want: ");
            try {
                   seatNumber = Integer.parseInt(screenInput.readLine());
              } catch (IOException e) {
                   System.out.println("Please enter a seat number");
              }
			
            //create ticket and return info
            String ticketInfo = prodDB.addTicket(departureDate, passengerName, flightNumber, seatNumber);
            System.out.println("\nReservation Successful. Here are your details:");
            System.out.println(ticketInfo + "\n");
            
            loop = true;
            while(loop) {
            	
	            System.out.println("Do you want to book more ticket? Please enter yes or no");
				try {
					bookMoreTicket = screenInput.readLine();
				} catch (IOException e) {
					System.out.println("Sorry, I don't understand.");
				}
	            if (bookMoreTicket.equals("no")) {
	            	always = false; // no need to execute the main loop again
	            	loop = false;
	            } else if (bookMoreTicket.equals("yes")) { // carry on booking a new ticket
	            	always = true; // need to execute the main loop again
	            	loop = false;
	            } else {
	            	System.out.println("Sorry, I didn't get that !");
	            	loop = true;
	            }
	            
            } // end of inner while loop
            
		} // repeat (end of main while loop)

	}

}