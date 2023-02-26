package com.kiran.UMS.Entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String landmark;
    private String zipcode;
    private String district;
    private String state;
    private String country;

    public Address() {
    }

    public Address(String landmark, String zipcode, String district, String state, String country) {
        this.landmark = landmark;
        this.zipcode = zipcode;
        this.district = district;
        this.state = state;
        this.country = country;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
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
}
