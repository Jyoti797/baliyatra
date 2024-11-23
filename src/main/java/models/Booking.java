package models;

import java.util.*;
import java.text.*;

public class Booking {

    private static int bookingCounter = 5000;

    private int bookingId;

    private int flightId;

    private int userId;

    private int ticketCount;

    private String seatCategory;

    private String customerCategory;

    private double totalAmount;

    public Booking(int flightId, int userId, int ticketCount, String seatCategory, String customerCategory,
            double totalAmount) {

        this.bookingId = bookingCounter++;

        this.flightId = flightId;

        this.userId = userId;

        this.ticketCount = ticketCount;

        this.seatCategory = seatCategory;

        this.customerCategory = customerCategory;

        this.totalAmount = totalAmount;

    }

    // Getters

    public int getBookingId() {

        return bookingId;

    }

    public int getFlightId() {

        return flightId;

    }

    public int getUserId() {

        return userId;

    }

    public int getTicketCount() {

        return ticketCount;

    }

    public String getSeatCategory() {

        return seatCategory;

    }

    public String getCustomerCategory() {

        return customerCategory;

    }

    public double getTotalAmount() {

        return totalAmount;

    }

    // Setters

    public void setTotalAmount(double amount) {

        this.totalAmount = amount;

    }

}
