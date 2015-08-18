package com.example.pssxsy.coolweather.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.pssxsy.coolweather.model.City;
import com.example.pssxsy.coolweather.model.County;
import com.example.pssxsy.coolweather.model.Province;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by pssxsy on 2015/8/18.
 */
public class CoolWeatherDB {
    public static final String DB_NAME = "cool_weather";
    public static final int VERSION = 1;
    private static CoolWeatherDB coolWeatherDB;
    private SQLiteDatabase db;

    public CoolWeatherDB(Context context) {
        CoolWeatherOpenHelper dbHelper = new CoolWeatherOpenHelper(context, DB_NAME, null, VERSION);
        db = dbHelper.getWritableDatabase();
    }

    public synchronized static CoolWeatherDB getInstance(Context context) {
        if (coolWeatherDB == null) {
            coolWeatherDB = new CoolWeatherDB(context);
        }
        return coolWeatherDB;
    }

    public void saveProvince(Province province) {
        if (province != null) {
            ContentValues values = new ContentValues();
            values.put("province_name",province.getProvince_name());
            values.put("province_code",province.getProvince_code());
            db.insert("Province",null,values);
        }
    }
    public List<Province> loadProvinces() {
        ArrayList<Province> list = new ArrayList<>();
        Cursor cursor = db.query("Province", null, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Province province = new Province();
            province.setId(cursor.getInt(cursor.getColumnIndex("id")));
            province.setProvince_code(cursor.getString(cursor.getColumnIndex("province_code")));
            province.setProvince_name(cursor.getString(cursor.getColumnIndex("province_name")));
            list.add(province);
        }
        return list;
    }
    public void saceCity(City city) {
        if (city != null) {
            ContentValues values = new ContentValues();
            values.put("city_name",city.getCity_name());
            values.put("city_code",city.getCity_code());
            values.put("province_id",city.getProvince_id());
            db.insert("City", null, values);
        }
    }
    public List<City> loadCity(int provinceId) {
        ArrayList<City> list = new ArrayList<>();
        Cursor cursor = db.query("City", null, "province_id = ?", new String[]{String.valueOf(provinceId)}, null, null, null);
        while (cursor.moveToNext()) {
            City city = new City();
            city.setId(cursor.getInt(cursor.getColumnIndex("id")));
            city.setCity_code(cursor.getString(cursor.getColumnIndex("city_code")));
            city.setCity_name(cursor.getString(cursor.getColumnIndex("city_name")));
            city.setProvince_id(provinceId);
            list.add(city);
        }
        return list;
    }
    public void saveCounty(County county) {
        if (county != null) {
            ContentValues values = new ContentValues();
            values.put("county_name", county.getCounty_name());
            values.put("county_code", county.getCounty_code());
            values.put("county_id",county.getCity_id());
            db.insert("County", null, values);
        }
    }

    public List<County> loadCounty(int cityId) {
        ArrayList<County> list = new ArrayList<>();
        Cursor cursor = db.query("County", null, "city_id = ?", new String[]{String.valueOf(cityId)}, null, null, null);
        while (cursor.moveToNext()) {
            County county = new County();
            county.setId(cursor.getInt(cursor.getColumnIndex("id")));
            county.setCounty_code(cursor.getString(cursor.getColumnIndex("county_code")));
            county.setCounty_name(cursor.getString(cursor.getColumnIndex("county_name")));
            county.setCity_id(cityId);
            list.add(county);
        }
        return list;
    }
}

