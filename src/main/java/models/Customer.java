package models;

import java.util.*;
import java.text.*;

public class Customer extends User {

    private long phone;

    private String emailId;

    private String address1;

    private String address2;

    private String city;

    private String state;

    private String country;

    private long zipCode;

    private Date dob;

    private String userCategory;

    public Customer(int userId, String userName, String password, long phone, String emailId,

            String address1, String address2, String city, String state, String country,

            long zipCode, Date dob) {

        this.userId = userId;

        this.userName = userName;

        this.password = password;

        this.phone = phone;

        this.emailId = emailId;

        this.address1 = address1;

        this.address2 = address2;

        this.city = city;

        this.state = state;

        this.country = country;

        this.zipCode = zipCode;

        this.dob = dob;

        // default populated

        this.role = "Customer";

        this.userCategory = "";

    }

    public String getUserName() {

        return userName;

    }

    public void setUserName(String userName) {

        this.userName = userName;

    }

    public boolean verifyPassword(String currPassword) {

        return password.equals(currPassword);

    }

    public void setPassword(String password) {

        this.password = password;

    }

    public long getPhone() {

        return phone;

    }

    public void setPhone(long phone) {

        this.phone = phone;

    }

    public String getEmailId() {

        return emailId;

    }

    public void setEmailId(String emailId) {

        this.emailId = emailId;

    }

    public String getAddress1() {

        return address1;

    }

    public void setAddress1(String address1) {

        this.address1 = address1;

    }

    public String getAddress2() {

        return address2;

    }

    public void setAddress2(String address2) {

        this.address2 = address2;

    }

    public String getCity() {

        return city;

    }

    public void setCity(String city) {

        this.city = city;

    }

    public String getState() {

        return state;

    }

    public void setState(String state) {

        this.state = state;

    }

    public String getCountry() {

        return country;

    }

    public void setCountry(String country) {

        this.country = country;

    }

    public long getZipCode() {

        return zipCode;

    }

    public void setZipCode(long zipCode) {

        this.zipCode = zipCode;

    }

    public Date getDob() {

        return dob;

    }

    public void setDob(Date dob) {

        this.dob = dob;

    }

    public String getUserCategory() {

        return userCategory;

    }

    public void setUserCategory(String userCategory) {

        this.userCategory = userCategory;

    }

    public void displayProfile() {

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        System.out.println("UserID: " + userId);

        System.out.println("UserName: " + userName);

        System.out.println("Phone: " + phone);

        System.out.println("EmailId: " + emailId);

        System.out.println("Address1: " + address1);

        System.out.println("Address2: " + address2);

        System.out.println("City: " + city);

        System.out.println("State: " + state);

        System.out.println("Country: " + country);

        System.out.println("ZipCode: " + zipCode);

        System.out.println("DOB: " + sdf.format(dob));

        System.out.println("Role: " + role);

        System.out.println("UserCategory: " + userCategory);

    }

}
