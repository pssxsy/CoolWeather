package com.example.pssxsy.coolweather.model;

/**
 * Created by pssxsy on 2015/8/18.
 */
public class Province {
    int id;
    String province_name;
    String province_code;
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getProvince_code() {
        return province_code;
    }
    public void setProvince_code(String province_code) {
        this.province_code = province_code;
    }
    public String getProvince_name() {
        return province_name;
    }
    public void setProvince_name(String province_name) {
        this.province_name = province_name;
    }
}
