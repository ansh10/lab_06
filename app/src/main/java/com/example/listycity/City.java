package com.example.listycity;

import java.util.Objects;


public class City implements Comparable<City> {
    private final String city;

    private final String province;

    public City(String city, String province) {
        if (city == null || province == null) {
            throw new IllegalArgumentException("City and province must be non-null");
        }
        this.city = city;
        this.province = province;
    }

    public String getCityName() {
        return city;
    }


    public String getProvinceName() {
        return province;
    }


    @Override
    public int compareTo(City other) {
        int byName = this.city.compareTo(other.city);
        if (byName != 0) return byName;
        return this.province.compareTo(other.province);
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City)) return false;
        City c = (City) o;
        return city.equals(c.city) && province.equals(c.province);
    }

    @Override
    public String toString() {
        return city + ", " + province;
    }
}
