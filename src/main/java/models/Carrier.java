package models;

import java.util.*;
import java.text.*;

public class Carrier {

    private static int carrierCounter = 1000;

    private int carrierId;

    private String carrierName;

    private int discount30DaysAdvance;

    private int discount60DaysAdvance;

    private int discount90DaysAdvance;

    private int bulkBookingDiscount;

    private int refundBefore2Days;

    private int refundBefore10Days;

    private int refundBefore20Days;

    private int silverUserDiscount;

    private int goldUserDiscount;

    private int platinumUserDiscount;

    // constructor

    public Carrier(String carrierName, int discount30DaysAdvance, int discount60DaysAdvance,

            int discount90DaysAdvance, int bulkBookingDiscount, int refundBefore2Days, int refundBefore10Days,

            int refundBefore20Days, int silverUserDiscount, int goldUserDiscount, int platinumUserDiscount) {

        this.carrierId = carrierCounter++;

        this.carrierName = carrierName;

        this.discount30DaysAdvance = discount30DaysAdvance;

        this.discount60DaysAdvance = discount60DaysAdvance;

        this.discount90DaysAdvance = discount90DaysAdvance;

        this.bulkBookingDiscount = bulkBookingDiscount;

        this.refundBefore2Days = refundBefore2Days;

        this.refundBefore10Days = refundBefore10Days;

        this.refundBefore20Days = refundBefore20Days;

        this.silverUserDiscount = silverUserDiscount;

        this.goldUserDiscount = goldUserDiscount;

        this.platinumUserDiscount = platinumUserDiscount;

    }

    public static int getCarrierCounter() {

        return carrierCounter;

    }

    public int getCarrierId() {

        return carrierId;

    }

    public String getCarrierName() {

        return carrierName;

    }

    public int getDiscount30DaysAdvance() {

        return discount30DaysAdvance;

    }

    public int getDiscount60DaysAdvance() {

        return discount60DaysAdvance;

    }

    public int getDiscount90DaysAdvance() {

        return discount90DaysAdvance;

    }

    public int getBulkBookingDiscount() {

        return bulkBookingDiscount;

    }

    public int getRefundBefore2Days() {

        return refundBefore2Days;

    }

    public int getRefundBefore10Days() {

        return refundBefore10Days;

    }

    public int getRefundBefore20Days() {

        return refundBefore20Days;

    }

    public int getSilverUserDiscount() {

        return silverUserDiscount;

    }

    public int getGoldUserDiscount() {

        return goldUserDiscount;

    }

    public int getPlatinumUserDiscount() {

        return platinumUserDiscount;

    }

    public void displayCarrierInfo() {

        System.out.println("CarrierID: " + carrierId);

        System.out.println("CarrierName: " + carrierName);

        System.out.println("DiscountPercentage30DaysAdvanceBooking: " + discount30DaysAdvance + "%");

        System.out.println("DiscountPercentage60DaysAdvanceBooking: " + discount60DaysAdvance + "%");

        System.out.println("DiscountPercentage90DaysAdvanceBooking: " + discount90DaysAdvance + "%");

        System.out.println("BulkBookingDiscount: " + bulkBookingDiscount + "%");

        System.out.println("RefundPercentageForTicketCancellation2DaysBeforeTravelDate: " + refundBefore2Days + "%");

        System.out.println("RefundPercentageForTicketCancellation10DaysBeforeTravelDate: " + refundBefore10Days + "%");

        System.out.println(
                "RefundPercentageForTicketCancellation20DaysOrMoreBeforeTravelDate: " + refundBefore20Days + "%");

        System.out.println("SilverUserDiscount: " + silverUserDiscount + "%");

        System.out.println("GoldUserDiscount: " + goldUserDiscount + "%");

        System.out.println("PlatinumUserDiscount: " + platinumUserDiscount + "%");

    }

    public static void setCarrierCounter(int carrierCounter) {

        Carrier.carrierCounter = carrierCounter;

    }

    public void setCarrierId(int carrierId) {

        this.carrierId = carrierId;

    }

    public void setCarrierName(String carrierName) {

        this.carrierName = carrierName;

    }

    public void setDiscount30DaysAdvance(int discount30DaysAdvance) {

        this.discount30DaysAdvance = discount30DaysAdvance;

    }

    public void setDiscount60DaysAdvance(int discount60DaysAdvance) {

        this.discount60DaysAdvance = discount60DaysAdvance;

    }

    public void setDiscount90DaysAdvance(int discount90DaysAdvance) {

        this.discount90DaysAdvance = discount90DaysAdvance;

    }

    public void setBulkBookingDiscount(int bulkBookingDiscount) {

        this.bulkBookingDiscount = bulkBookingDiscount;

    }

    public void setRefundBefore2Days(int refundBefore2Days) {

        this.refundBefore2Days = refundBefore2Days;

    }

    public void setRefundBefore10Days(int refundBefore10Days) {

        this.refundBefore10Days = refundBefore10Days;

    }

    public void setRefundBefore20Days(int refundBefore20Days) {

        this.refundBefore20Days = refundBefore20Days;

    }

    public void setSilverUserDiscount(int silverUserDiscount) {

        this.silverUserDiscount = silverUserDiscount;

    }

    public void setGoldUserDiscount(int goldUserDiscount) {

        this.goldUserDiscount = goldUserDiscount;

    }

    public void setPlatinumUserDiscount(int platinumUserDiscount) {

        this.platinumUserDiscount = platinumUserDiscount;

    }

}
