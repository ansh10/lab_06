package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Keeps a list of {@link City} objects and basic operations.
 */
public class CityList {
    /** Backing list of cities. */
    private final List<City> cities = new ArrayList<>();

    /**
     * Adds a city if it does not already exist (by equality).
     *
     * @param city candidate city to add
     * @throws IllegalArgumentException if {@code city} already exists
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException("City already exists");
        }
        cities.add(city);
    }

    /**
     * Returns whether the given city is present.
     *
     * @param city city to check
     * @return true if present; false otherwise
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Deletes the given city if present; otherwise throws an exception.
     *
     * @param city city to remove
     * @throws IllegalArgumentException if the city is not in the list
     */
    public void delete(City city) {
        boolean removed = cities.remove(city);
        if (!removed) {
            throw new IllegalArgumentException("City not found");
        }
    }

    /**
     * Returns how many cities are in the list.
     *
     * @return the count of cities
     */
    public int countCities() {
        return cities.size();
    }

    /**
     * Returns a new sorted list of cities (by city then province).
     *
     * @return sorted copy of the city list
     */
    public List<City> getCities() {
        List<City> list = new ArrayList<>(cities);
        Collections.sort(list);
        return list;
    }
}
