package com.comp303noah1.smartphone_order.models;

public class Order {

    private String firstName;
    private String middleName;
    private String lastName;
    private String eMail;
    private String phoneNumber;
    private String street1;
    private String street2;
    private String city;
    private String province;
    private String postal;
    private String country;
    private String productNumber;
    private String brand;
    private String model;
    private int quantity;


    public Order(String firstName, String middleName, String lastName, String eMail, String phoneNumber,
                 String street1, String street2, String city, String province, String postal,
                 String country, String productNumber, String brand, String model, int quantity) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.phoneNumber = phoneNumber;
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.province = province;
        this.postal = postal;
        this.country = country;
        this.productNumber = productNumber;
        this.brand = brand;
        this.model = model;
        this.quantity = quantity;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEMail() {
        return eMail;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getStreet1() {
        return street1;
    }

    public String getStreet2() {
        return street2;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getPostal() {
        return postal;
    }

    public String getCountry() {
        return country;
    }

    public String getProductNumber() {
        return productNumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getQuantity() {
        return quantity;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEMail(String eMail) {
        this.eMail = eMail;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setPostal(String postal) {
        this.postal = postal;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setProductNumber(String productNumber) {
        this.productNumber = productNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
