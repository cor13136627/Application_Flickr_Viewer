package com.example.joe.application_flickr_viewer;


import java.io.Serializable;

public class TopLocationsObject implements Serializable{

    private String cityName;
    private String countryName;
    private Integer flagResource;

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        return countryName;
    }

    public Integer getFlagResource() {
        return flagResource;
    }

    public TopLocationsObject(String cityName, String countryName, Integer flagResource) {
        this.cityName = cityName;
        this.countryName = countryName;
        this.flagResource = flagResource;
    }
}
