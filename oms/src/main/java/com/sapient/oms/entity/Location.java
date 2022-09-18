package com.sapient.oms.entity;

public class Location {
    private int LocationId;
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    private int pincode;


    public Location(int LocationId, String streetAddress, String city, String state, String country, int pincode) {
        this.LocationId = LocationId;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pincode = pincode;
    }


    public int getLocationId() {
        return LocationId;
    }


    public void setLocationId(int LocationId) {
        this.LocationId = LocationId;
    }


    public String getStreetAddress() {
        return streetAddress;
    }


    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
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


    public int getPincode() {
        return pincode;
    }


    public void setPincode(int pincode) {
        this.pincode = pincode;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.LocationId);
        builder.append(", "+this.streetAddress);
        builder.append(", "+this.city);
        builder.append(", "+this.state);
        builder.append(", "+this.country);
        builder.append(" "+this.pincode);
        return builder.toString();
    }

    


}