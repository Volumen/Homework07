package com.example.demo.enums;

public enum  CountryOfManufactured {
    Poland("Poland"),
    Germany("Germany"),
    Japan("Japan"),
    China("China"),
    Canada("Canada");

    private String countryOfManufactured;

    CountryOfManufactured(String countryOfManufactured) {
        this.countryOfManufactured = countryOfManufactured;
    }

    public String getCountryOfManufactured() {
        return countryOfManufactured;
    }
}
