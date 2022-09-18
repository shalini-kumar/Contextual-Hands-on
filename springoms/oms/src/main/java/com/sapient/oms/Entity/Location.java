package com.sapient.oms.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private int location_id;
    @NotBlank(message = "please provide address here")
    private String lineAddress;
    private int pincode;
    private String city;
    private String state;
    private String country;

    public Location() {

    }

    public Location(int location_id, String lineAddress, int pincode, String city, String state, String country) {
        this.location_id = location_id;
        this.lineAddress = lineAddress;
        this.pincode = pincode;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    public int getId() {
        return location_id;
    }

    public void setId(int location_id) {
        this.location_id = location_id;
    }

    public String getLineAddress() {
        return lineAddress;
    }

    public void setLineAddress(String lineAddress) {
        this.lineAddress = lineAddress;
    }

    public int getPincode() {
        return pincode;
    }

    public void setPincode(int pincode) {
        this.pincode = pincode;
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

    @Override
    public String toString() {
        return "Location [city=" + city + ", country=" + country + ", location_id=" + location_id + ", lineAddress=" + lineAddress
                + ", pincode=" + pincode + ", state=" + state + "]";
    }

}