package models;



import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import services.BookingService;
import services.CarrierService;
import services.FlightService;
import services.UserService;
import utils.Utils;

public class AirlineManagementSystem {

	private static Scanner sc = new Scanner(System.in);

	private static UserService userService = new UserService();

	private static CarrierService carrierService = new CarrierService();

	private static FlightService flightService = new FlightService();

	private static BookingService bookingService = new BookingService();

	public static void main(String[] args) {

		while (true) {

			System.out.println("Welcome to Airline Management System - AMS");

			System.out.println("1. Admin Sign-in");

			System.out.println("2. Customer Sign-in");

			System.out.println("3. Customer Sign-up");

			System.out.println("4. Exit");

			int choice = Utils.getIntInput("Enter your choice: ");

			switch (choice) {

			case 1:

				adminSignIn();

				break;

			case 2:

				customerSignIn();

				break;

			case 3:

				customerSignUp();

				break;

			case 4:

				System.out.println("Exiting AMS. Goodbye!");

				System.exit(0);

			default:

				System.out.println("Invalid Choice. Please try again.");

			}

		}

	}

	private static void adminSignIn() {

		int userId = Utils.getIntInput("Enter Admin UserID: ");

		String password = Utils.getStringInput("Enter Admin Password: ");

		Admin admin = userService.authenticateAdmin(userId, password);

		if (admin != null) {

			System.out.println("Admin Sign-in Successful.");

			adminMenu();

		} else {

			System.out.println("Invalid Admin Credentials.");

		}

	}

	// Admin Menu

	private static void adminMenu() {

		while (true) {

			System.out.println("\n--- Admin Menu ---");

			System.out.println("1. Add Carrier");

			System.out.println("2. Edit Carrier Details by CarrierId");

			System.out.println("3. Show all the available Carriers");

			System.out.println("4. Remove Carrier by Id");

			System.out.println("5. Flight Cancellation - Refund Price Calculation");

			System.out.println("6. Search All the available flights");

			System.out.println("7. Exit AMS");

			int choice = Utils.getIntInput("Enter your choice: ");

			switch (choice) {

			case 1:

				addCarrier();

				break;

			case 2:

				editCarrier();

				break;

			case 3:

				showAllCarrier();

				break;

			case 4:

				removeCarrier();

				break;

			case 5:

				flightCancellation();

				break;

			case 6:

				searchAllAvailableFlights();

				break;

			case 7:

				System.out.println("Exiting AMS. Goodbye!");

				System.exit(0);

			default:

				System.out.println("Invalid Choice. Please try again.");

			}

		}

	}

	public static void showAllCarrier() {

		List<Carrier> answer = carrierService.getAllCarriers();

		for (Carrier carrier : answer) {

			System.out.println("Carrier details:" + carrier.getCarrierName() + " " + carrier.getCarrierId());

		}

	}

	// display all the flights between origin and destination location

	private static void searchAllAvailableFlights() {

		System.out.println("\n--- Search All the available flights ---");

		System.out.println("\n--- Please enter the below details ---");

		String flightOrigin = Utils.getStringInput("Enter Flight origin: ");

		String flightDestination = Utils.getStringInput("Enter Flight destination: ");

		Date travelDate = Utils.getDateInput("Enter Travel date: ");

		List<Flight> allFlights = flightService.getAllFlightsFromOriginToDestination(flightOrigin, flightDestination,
				travelDate);

		for (Flight flight : allFlights) {

			System.out.print(flight.getFlightId());

		}

	}

	// Add Carrier

	private static void addCarrier() {

		System.out.println("\n--- Add Carrier ---");

		String carrierName = Utils.getStringInput("Enter Carrier Name: ");

		int discount30 = Utils.getIntInput("Enter Discount Percentage for 30 Days Advance Booking: ");

		int discount60 = Utils.getIntInput("Enter Discount Percentage for 60 Days Advance Booking: ");

		int discount90 = Utils.getIntInput("Enter Discount Percentage for 90 Days Advance Booking: ");

		int bulkDiscount = Utils.getIntInput("Enter Bulk Booking Discount Percentage: ");

		int refund2 = Utils.getIntInput("Enter Refund Percentage for Cancellation 2 Days Before: ");

		int refund10 = Utils.getIntInput("Enter Refund Percentage for Cancellation 10 Days Before: ");

		int refund20 = Utils.getIntInput("Enter Refund Percentage for Cancellation 20 Days or More Before: ");

		int silver = Utils.getIntInput("Enter Silver User Discount Percentage: ");

		int gold = Utils.getIntInput("Enter Gold User Discount Percentage: ");

		int platinum = Utils.getIntInput("Enter Platinum User Discount Percentage: ");

		carrierService.addCarrier(carrierName, discount30, discount60, discount90, bulkDiscount,

				refund2, refund10, refund20, silver, gold, platinum);

	}

	// Edit Carrier

	private static void editCarrier() {

		System.out.println("\n--- Edit Carrier Details ---");

		int carrierId = Utils.getIntInput("Enter Carrier ID to Edit: ");

		carrierService.editCarrier(carrierId, sc);

	}

	// Remove Carrier

	private static void removeCarrier() {

		System.out.println("\n--- Remove Carrier ---");

		int carrierId = Utils.getIntInput("Enter Carrier ID to Remove: ");

		carrierService.removeCarrier(carrierId, flightService.getAllFlights());

	}

	// Flight Cancellation - Refund Price Calculation

	private static void flightCancellation() {

		System.out.println("\n--- Flight Cancellation - Refund Price Calculation ---");

		int flightId = Utils.getIntInput("Enter Flight ID: ");

		Flight flight = flightService.getFlightById(flightId);

		if (flight == null) {

			System.out.println("Flight ID not found.");

			return;

		}

		Date travelDate = flight.getTravelDate();

		List<Booking> bookings = bookingService.getBookingsByFlightAndDate(flightId, travelDate, flightService);

		if (bookings.isEmpty()) {

			System.out.println("No bookings found for this flight.");

			return;

		}

		double totalRefund = 0.0;

		for (Booking booking : bookings) {

			totalRefund += booking.getTotalAmount();

		}

		// Calculate loss for carrier

		// Assuming loss is totalRefund plus 10% extra if cancellation within a week

		Date currentDate = new Date();

		long diffInMillies = flight.getTravelDate().getTime() - currentDate.getTime();

		long daysDiff = diffInMillies / (1000 * 60 * 60 * 24);

		double loss = totalRefund;

		if (daysDiff <= 7) {

			loss += totalRefund * 0.10; // 10% extra

		}

		System.out.println("Total Refund to Customers: $" + totalRefund);

		System.out.println("Total Loss to Carrier: $" + loss);

	}

	// Customer Sign-in

	private static void customerSignIn() {

		int userId = Utils.getIntInput("Enter Customer UserID: ");

		String password = Utils.getStringInput("Enter Customer Password: ");

		Customer customer = userService.authenticateCustomer(userId, password);

		if (customer != null) {

			System.out.println("Customer Sign-in Successful.");

			customerMenu(customer);

		} else {

			System.out.println("Invalid Customer Credentials.");

		}

	}

	// Customer Menu

	private static void customerMenu(Customer customer) {

		while (true) {

			System.out.println("\n--- Customer Menu ---");

			System.out.println("1. Customer Registration");

			System.out.println("2. Edit Customer Profile");

			System.out.println("3. Ticket Booking - Price Calculation");

			System.out.println("4. Ticket Cancellation - Refund Price Calculation");

			System.out.println("5. Exit AMS");

			int choice = Utils.getIntInput("Enter your choice: ");

			switch (choice) {

			case 1:

				// Registration is handled separately

				System.out.println("You are already registered and signed in.");

				break;

			case 2:

				editCustomerProfile(customer);

				break;

			case 3:

				bookTicket(customer);
				break;
			case 4:
				cancelTicket(customer);
				break;

			case 5:

				System.out.println("Exiting AMS. Goodbye!");

				System.exit(0);

			default:

				System.out.println("Invalid Choice. Please try again.");

			}

		}

	}

	// Edit Customer Profile

	private static void editCustomerProfile(Customer customer) {

		System.out.println("\n--- Edit Customer Profile ---");

		System.out.println("Leave field blank to keep current value.");

		String userName = Utils.getStringInput("Enter new UserName (" + customer.getUserName() + "): ");

		if (!userName.isEmpty())

			customer.setUserName(userName);

		String password = Utils.getStringInput("Enter new Password: ");

		if (!password.isEmpty())

			customer.setPassword(password);

		String phoneStr = Utils.getStringInput("Enter new Phone (" + customer.getPhone() + "): ");

		if (!phoneStr.isEmpty()) {

			try {

				long phone = Long.parseLong(phoneStr);

				customer.setPhone(phone);

			} catch (NumberFormatException e) {

				System.out.println("Invalid phone number. Keeping previous value.");

			}

		}

		String emailId = Utils.getStringInput("Enter new EmailId (" + customer.getEmailId() + "): ");

		if (!emailId.isEmpty())

			customer.setEmailId(emailId);

		String address1 = Utils.getStringInput("Enter new Address1 (" + customer.getAddress1() + "): ");

		if (!address1.isEmpty())

			customer.setAddress1(address1);

		String address2 = Utils.getStringInput("Enter new Address2 (" + customer.getAddress2() + "): ");

		if (!address2.isEmpty())

			customer.setAddress2(address2);

		String city = Utils.getStringInput("Enter new City (" + customer.getCity() + "): ");

		if (!city.isEmpty())

			customer.setCity(city);

		String state = Utils.getStringInput("Enter new State (" + customer.getState() + "): ");

		if (!state.isEmpty())

			customer.setState(state);

		String country = Utils.getStringInput("Enter new Country (" + customer.getCountry() + "): ");

		if (!country.isEmpty())

			customer.setCountry(country);

		String zipStr = Utils.getStringInput("Enter new ZipCode (" + customer.getZipCode() + "): ");

		if (!zipStr.isEmpty()) {

			try {

				long zip = Long.parseLong(zipStr);

				customer.setZipCode(zip);

			} catch (NumberFormatException e) {

				System.out.println("Invalid ZipCode. Keeping previous value.");

			}

		}

		String dobStr = Utils.getStringInput("Enter new DOB (dd-MM-yyyy): ");

		if (!dobStr.isEmpty()) {

			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

			try {

				Date dob = sdf.parse(dobStr);

				customer.setDob(dob);

			} catch (Exception e) {

				System.out.println("Invalid DOB format. Keeping previous value.");

			}

		}

		System.out.println("Profile Updated Successfully.");

		customer.displayProfile();

	}

	// Book Ticket

	private static void bookTicket(Customer customer) {

		System.out.println("\n--- Ticket Booking ---");

		int flightId = Utils.getIntInput("Enter Flight ID to Book: ");

		Flight flight = flightService.getFlightById(flightId);

		if (flight == null) {

			System.out.println("Flight ID not found.");

			return;

		}

		int ticketCount = Utils.getIntInput("Enter Ticket Count: ");

		String seatCategory = Utils.getStringInput("Enter Seat Category (Economy/Business/Executive): ");

		String customerCategory = Utils.getStringInput("Enter customer Category: ");

		// Calculate Airfare based on seat category

		double baseAirfare = flight.getAirfare();

		double airfare = 0.0;

		switch (seatCategory.toLowerCase()) {

		case "economy":

			airfare = baseAirfare;

			break;

		case "business":

			airfare = 2 * baseAirfare;

			break;

		case "executive":

			airfare = 5 * baseAirfare;

			break;

		default:

			System.out.println("Invalid Seat Category. Defaulting to Economy.");

			airfare = baseAirfare;

		}

		double total = airfare * ticketCount;

		// Apply Discounts

		int daysBefore = Utils.getIntInput("Enter number of days before travel to book: ");

		Carrier carrier = carrierService.getCarrierById(flight.getCarrierId());

		if (carrier != null) {

			if (daysBefore >= 90) {

				total -= total * (carrier.getDiscount90DaysAdvance() / 100.0);

			} else if (daysBefore >= 60) {

				total -= total * (carrier.getDiscount60DaysAdvance() / 100.0);

			} else if (daysBefore >= 30) {

				total -= total * (carrier.getDiscount30DaysAdvance() / 100.0);

			}

		}

		if (ticketCount >= 10) {

			total -= total * 0.02; // 2% discount

		}

		if (customerCategory.equalsIgnoreCase("Silver")) {

			total -= total * 0.01;

		} else if (customerCategory.equalsIgnoreCase("Gold")) {

			total -= total * 0.02;

		} else if (customerCategory.equalsIgnoreCase("Platinum")) {

			total -= total * 0.04;

		}

		System.out.println("Total Booking Amount after Discounts: $" + total);

		bookingService.bookTicket(flightId, customer.getUserId(), ticketCount, seatCategory, customerCategory, total);

	}

	// Cancel Ticket

	private static void cancelTicket(Customer customer) {

		System.out.println("\n--- Ticket Cancellation ---");

		int bookingId = Utils.getIntInput("Enter Booking ID to Cancel: ");

		Booking booking = bookingService.getBookingById(bookingId);

		if (booking == null) {

			System.out.println("Booking ID not found.");

			return;

		}

		// Assume we have travel date information; for simplicity, skipping date checks

		System.out.println("Calculating Refund Amount...");

		// For simplicity, let's assume cancellation is being done today

		Date currentDate = new Date();

		Flight flight = flightService.getFlightById(booking.getFlightId());

		if (flight == null) {

			System.out.println("Associated Flight not found.");

			return;

		}

		long diffInMillies = flight.getTravelDate().getTime() - currentDate.getTime();

		long daysDiff = diffInMillies / (1000 * 60 * 60 * 24);

		double refundPercentage = 0.0;

		Carrier carrier = carrierService.getCarrierById(flight.getCarrierId());

		if (carrier != null) {

			if (daysDiff >= 20) {

				refundPercentage = carrier.getRefundBefore20Days();

			} else if (daysDiff >= 10) {

				refundPercentage = carrier.getRefundBefore10Days();

			} else if (daysDiff >= 2) {

				refundPercentage = carrier.getRefundBefore2Days();

			} else {

				refundPercentage = 0.0; // No refund

			}

		}

		double refundAmount = booking.getTotalAmount() * (refundPercentage / 100.0);

		System.out.println("Refund Amount: $" + refundAmount);

		bookingService.cancelBooking(bookingId);

	}
	// Customer signup

	public static void customerSignUp() {

		int userId = Utils.getIntInput("Enter the customerId: ");

		String userName = Utils.getStringInput("Enter the userName: ");

		String password = Utils.getStringInput("Enter the password: ");

		long phone = Utils.getLongInput("Enter the phone number: ");

		String emailId = Utils.getStringInput("Enter the emailId: ");

		String address1 = Utils.getStringInput("Enter the address1: ");

		String address2 = Utils.getStringInput("Enter the address2: ");

		String city = Utils.getStringInput("Enter the city: ");

		String state = Utils.getStringInput("Enter the state: ");

		String country = Utils.getStringInput("Enter the country: ");

		long zipCode = Utils.getLongInput("Enter the zipCode: ");

		Date dob = Utils.getDateInput("Enter the Date of birth: ");

		Customer customer = new Customer(userId, userName, password, phone, emailId, address1, address2,

				city, state, country, zipCode, dob);

		userService.addCustomer(customer);

	}

}
