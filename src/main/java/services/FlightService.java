package services;

import models.*;
import utils.*;


import java.util.*;

import models.Flight;

public class FlightService {

    private List<Flight> flights = new ArrayList<>();

    // Add Flight

    public void addFlight(int carrierId, String origin, String destination, Date travelDate, double airfare) {

        Flight flight = new Flight(carrierId, origin, destination, travelDate, airfare);

        flights.add(flight);

        System.out.println("Flight Added Successfully with Flight ID: "

                + flight.getFlightId());

    }

    public Flight getFlightById(int flightId) {

        for (Flight flight : flights) {

            if (flight.getFlightId() == flightId) {

                return flight;

            }

        }

        return null;

    }

    public List<Flight> getFlightsByCarrierAndDate(int carrierId, Date travelDate) {

        List<Flight> result = new ArrayList<>();

        for (Flight flight : flights) {

            if (flight.getCarrierId() == carrierId && flight.getTravelDate().equals(travelDate)) {

                result.add(flight);

            }

        }

        return result;

    }

    public List<Flight> getAllFlights() {

        return flights;

    }

    public List<Flight> getAllFlightsFromOriginToDestination(String origin, String destination, Date travelDate) {

        List<Flight> answer = new ArrayList<>();

        for (Flight flight : flights) {

            if (flight.getOrigin().equalsIgnoreCase(origin) &&

                    flight.getDestination().equals(destination) &&

                    flight.getTravelDate().equals(travelDate)) {

                answer.add(flight);

            }

        }

        return answer;

    }

    public void displayAllFlights() {

        if (flights.isEmpty()) {

            System.out.println("No Flights Available.");

            return;

        }

        for (Flight flight : flights) {

            flight.displayFlightInfo();

            System.out.println("----------------------------");

        }

    }

    public void removeFlight(int flightId) {

        Flight flight = getFlightById(flightId);

        if (flight != null) {

            flights.remove(flight);

            System.out.println("Flight Removed Successfully.");

        } else {

            System.out.println("Flight ID not found.");

        }

    }

}
