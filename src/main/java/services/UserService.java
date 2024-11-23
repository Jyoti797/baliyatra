package services;

import java.util.*;

import models.*;
import utils.*;


import models.Customer;

import models.Admin;

public class UserService {

    private ArrayList<Admin> admins = new ArrayList<>();

    private ArrayList<Customer> customers = new ArrayList<>();

    private int customerCount = 2000;

    public UserService() {

        // Adding default admin

        admins.add(new Admin(1, "admin", "admin123"));

    }

    // Admin Authentication

    public Admin authenticateAdmin(int userId, String password) {

        for (Admin admin : admins) {

            if (admin.getUserId() == userId && admin.verifyPassword(password)) {

                return admin;

            }

        }

        return null;

    }

    // Customer Authentication

    public Customer authenticateCustomer(int userId, String password) {

        for (Customer customer : customers) {

            if (customer.getUserId() == userId && customer.verifyPassword(password)) {

                return customer;

            }

        }

        return null;

    }

    // Customer Registration

    public Customer registerCustomer(String userName, String password, long phone, String emailId,

            String address1, String address2, String city, String state,

            String country, long zipCode, Date dob) {

        Customer customer = new Customer(customerCount++, userName, password, phone, emailId,

                address1, address2, city, state, country, zipCode, dob);

        customers.add(customer);

        return customer;

    }

    // get customer details

    public Customer getCustomerById(int userId) {

        for (Customer customer : customers) {

            if (customer.getUserId() == userId) {

                return customer;

            }

        }

        return null;

    }

    public void addCustomer(Customer customer) {

        customers.add(customer);

    }

}
