package services;

import models.*;
import utils.*;


import java.util.*;

import models.Carrier;

import models.Flight;

public class CarrierService {

    private List<Carrier> carriers = new ArrayList<>();

    // Add carrier

    public void addCarrier(String carrierName, int discount30, int discount60, int discount90,

            int bulkDiscount, int refund2, int refund10, int refund20,

            int silver, int gold, int platinum) {

        Carrier carrier = new Carrier(carrierName, discount30, discount60, discount90,

                bulkDiscount, refund2, refund10, refund20, silver, gold, platinum);

        carriers.add(carrier);

        System.out.println("Carrier Information Saved Successfully in the System.");

    }

    // Edit Carrier

    public void editCarrier(int carrierId, Scanner sc) {

        Carrier carrier = getCarrierById(carrierId);

        if (carrier != null) {

            System.out.println("Editing Carrier ID: " + carrierId);

            System.out.print("Enter new Carrier Name (" + carrier.getCarrierName() + "): ");

            String name = sc.nextLine();

            if (!name.isEmpty()) {

                carrier.setCarrierName(name);

            }

            // Helper method to parse integer input

            carrier.setDiscount30DaysAdvance(

                    parseIntegerInput(sc, "Enter new Discount 30 Days (%)", carrier.getDiscount30DaysAdvance()));

            carrier.setDiscount60DaysAdvance(

                    parseIntegerInput(sc, "Enter new Discount 60 Days (%)", carrier.getDiscount60DaysAdvance()));

            carrier.setDiscount90DaysAdvance(

                    parseIntegerInput(sc, "Enter new Discount 90 Days (%)", carrier.getDiscount90DaysAdvance()));

            carrier.setBulkBookingDiscount(

                    parseIntegerInput(sc, "Enter new Bulk Booking Discount (%)", carrier.getBulkBookingDiscount()));

            carrier.setRefundBefore2Days(parseIntegerInput(sc, "Enter new Refund Percentage for 2 Days Before (%)",

                    carrier.getRefundBefore2Days()));

            carrier.setRefundBefore10Days(parseIntegerInput(sc, "Enter new Refund Percentage for 10 Days Before (%)",

                    carrier.getRefundBefore10Days()));

            carrier.setRefundBefore20Days(parseIntegerInput(sc, "Enter new Refund Percentage for 20 Days Before (%)",

                    carrier.getRefundBefore20Days()));

            carrier.setSilverUserDiscount(

                    parseIntegerInput(sc, "Enter new Silver User Discount (%)", carrier.getSilverUserDiscount()));

            carrier.setGoldUserDiscount(

                    parseIntegerInput(sc, "Enter new Gold User Discount (%)", carrier.getGoldUserDiscount()));

            carrier.setPlatinumUserDiscount(

                    parseIntegerInput(sc, "Enter new Platinum User Discount (%)", carrier.getPlatinumUserDiscount()));

            System.out.println("Carrier Information Updated Successfully.");

        } else {

            System.out.println(

                    "Either the data is incorrect or no Carrier Information is available for the given Carrier ID.");

        }

    }

    // Helper method to parse integer input with a default value

    private int parseIntegerInput(Scanner sc, String prompt, int defaultValue) {

        System.out.print(prompt + " (current: " + defaultValue + "): ");

        String input = sc.nextLine();

        try {

            if (!input.isEmpty()) {

                return Integer.parseInt(input);

            }

        } catch (NumberFormatException e) {

            System.out.println("Invalid number format, keeping the previous value.");

        }

        return defaultValue;

    }

    // Remove Carrier

    public void removeCarrier(int carrierId, List<Flight> flights) {

        Carrier carrier = getCarrierById(carrierId);

        if (carrier != null) {

            // Check if any flight is mapped to this carrier

            boolean hasFlights = false;

            for (Flight flight : flights) {

                if (flight.getCarrierId() == carrierId) {

                    hasFlights = true;

                    break;

                }

            }

            if (hasFlights) {

                System.out

                        .println("Remove All Flights Mapped to this Carrier before deleting this Carrier for system.");

            } else {

                carriers.remove(carrier);

                System.out.println("Carrier Information successfully removed from system.");

            }

        } else {

            System.out.println(

                    "Either the data is incorrect or no Carrier Information is available for the given Carrier ID.");

        }

    }

    // returns the carrier details with the given carrierId

    public Carrier getCarrierById(int carrierId) {

        for (Carrier carrier : carriers) {

            if (carrier.getCarrierId() == carrierId) {

                return carrier;

            }

        }

        return null;

    }

    public void displayAllCarriers() {

        if (carriers.isEmpty()) {

            System.out.println("No Carriers Available.");

            return;

        }

        for (Carrier carrier : carriers) {

            carrier.displayCarrierInfo();

            System.out.println("----------------------------");

        }

    }

    public List<Carrier> getAllCarriers() {

        return carriers;

    }

}
