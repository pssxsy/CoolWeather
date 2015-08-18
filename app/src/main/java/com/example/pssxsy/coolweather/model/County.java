package com.example.pssxsy.coolweather.model;

/**
 * Created by pssxsy on 2015/8/18.
 */
public class County {
    int id;
    String county_name;
    String county_code;
    int city_id;

    public int getId() {
        return id;
    }

    public int getCity_id() {
        return city_id;
    }

    public String getCounty_code() {
        return county_code;
    }

    public String getCounty_name() {
        return county_name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCity_id(int city_id) {
        this.city_id = city_id;
    }

    public void setCounty_code(String county_code) {
        this.county_code = county_code;
    }

    public void setCounty_name(String county_name) {
        this.county_name = county_name;
    }
}
