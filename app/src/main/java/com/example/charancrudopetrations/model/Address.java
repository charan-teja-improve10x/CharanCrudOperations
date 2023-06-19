package com.example.charancrudopetrations.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Address implements Serializable {
    private String streetAddress;
    private String city;
    private String state;
    private String country;
    @SerializedName("zip")
    private String zipCode;
    @SerializedName("geonameId")
    private Integer geoNameId;
    private String phoneNumber;
    private String ipAddress;
    private String countryCode;

    public Address() {
    }

    public Address(String streetAddress, String city, String state, String country, String zipCode,
                   Integer geoNameId, String phoneNumber, String ipAddress, String countryCode) {
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

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public Integer getGeoNameId() {
        return geoNameId;
    }

    public void setGeoNameId(Integer geoNameId) {
        this.geoNameId = geoNameId;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}

