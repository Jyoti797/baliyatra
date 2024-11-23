package models;

import java.util.*;
import java.text.*;

public class Flight {

    private static int flightCounter = 1000;

    private int flightId;

    private int carrierId;

    private String origin;

    private String destination;

    private Date travelDate;

    private double airfare;

    public Flight(int carrierId, String origin, String destination, Date travelDate, double airfare) {

        this.flightId = flightCounter++;

        this.carrierId = carrierId;

        this.origin = origin;

        this.destination = destination;

        this.travelDate = travelDate;

        this.airfare = airfare;

    }

    public int getFlightId() {

        return flightId;

    }

    public int getCarrierId() {

        return carrierId;

    }

    public void setCarrierId(int carrierId) {

        this.carrierId = carrierId;

    }

    public String getOrigin() {

        return origin;

    }

    public void setOrigin(String origin) {

        this.origin = origin;

    }

    public String getDestination() {

        return destination;

    }

    public void setDestination(String destination) {

        this.destination = destination;

    }

    public Date getTravelDate() {

        return travelDate;

    }

    public void setTravelDate(Date travelDate) {

        this.travelDate = travelDate;

    }

    public double getAirfare() {

        return airfare;

    }

    public void setAirfare(double airfare) {

        this.airfare = airfare;

    }

    // Display Flight Information

    public void displayFlightInfo() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("FlightID: " + flightId);

        System.out.println("CarrierID: " + carrierId);

        System.out.println("Origin: " + origin);

        System.out.println("Destination: " + destination);

        System.out.println("Travel Date: " + sdf.format(travelDate));

        System.out.println("Airfare: $" + airfare);

    }

}
