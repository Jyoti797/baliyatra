package services;

import models.*;
import utils.*;

import java.util.*;

import models.Booking;

import models.Flight;

public class BookingService {

    private List<Booking> bookings = new ArrayList<>();

    // Book Ticket

    public Booking bookTicket(int flightId, int userId, int ticketCount, String seatCategory,

            String customerCategory, double totalAmount) {

        Booking booking = new Booking(flightId, userId, ticketCount, seatCategory, customerCategory, totalAmount);

        bookings.add(booking);

        System.out.println("Ticket Booked Successfully. Booking ID: " + booking.getBookingId());

        return booking;

    }

    public Booking getBookingById(int bookingId) {

        for (Booking booking : bookings) {

            if (booking.getBookingId() == bookingId) {

                return booking;

            }

        }

        return null;

    }

    public List<Booking> getBookingsByFlightAndDate(int flightId, Date travelDate, FlightService flightService) {

        List<Booking> result = new ArrayList<>();

        Flight flight = flightService.getFlightById(flightId);

        if (flight != null && flight.getTravelDate().equals(travelDate)) {

            for (Booking booking : bookings) {

                if (booking.getFlightId() == flightId) {

                    result.add(booking);

                }

            }

        }

        return result;

    }

    public List<Booking> getAllBookings() {

        return bookings;

    }

    public void cancelBooking(int bookingId) {

        Booking booking = getBookingById(bookingId);

        if (booking != null) {

            bookings.remove(booking);

            System.out.println("Booking Cancelled Successfully.");

        } else {

            System.out.println("Booking ID not found.");

        }

    }

}
