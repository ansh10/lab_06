package com.example.listycity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    private City edmonton() {
        return new City("Edmonton", "Alberta");
    }

    private CityList withEdmonton() {
        CityList list = new CityList();
        list.add(edmonton());
        return list;
    }

    @Test
    void testAdd() {
        CityList list = withEdmonton();
        assertEquals(1, list.countCities());
        City regina = new City("Regina", "Saskatchewan");
        list.add(regina);
        assertEquals(2, list.countCities());
        assertTrue(list.hasCity(regina));
    }

    @Test
    void testAddExceptionOnDuplicate() {
        CityList list = withEdmonton();
        assertThrows(IllegalArgumentException.class, () -> list.add(edmonton()));
    }

    @Test
    void testHasCity() {
        CityList list = withEdmonton();
        assertTrue(list.hasCity(new City("Edmonton", "Alberta")));
        assertFalse(list.hasCity(new City("Calgary", "Alberta")));
    }

    @Test
    void testDelete() {
        CityList list = withEdmonton();
        list.delete(new City("Edmonton", "Alberta"));
        assertEquals(0, list.countCities());
        assertFalse(list.hasCity(edmonton()));
    }

    @Test
    void testDeleteThrowsWhenMissing() {
        CityList list = withEdmonton();
        assertThrows(IllegalArgumentException.class,
                () -> list.delete(new City("Calgary", "Alberta")));
    }

    @Test
    void testCountCities() {
        CityList list = new CityList();
        assertEquals(0, list.countCities());
        list.add(new City("Banff", "Alberta"));
        list.add(new City("Calgary", "Alberta"));
        assertEquals(2, list.countCities());
    }

    @Test
    void testGetCitiesSorted() {
        CityList list = new CityList();
        City yk = new City("Yellowknife", "Northwest Territories");
        City ch = new City("Charlottetown", "Prince Edward Island");
        City ed = new City("Edmonton", "Alberta");
        list.add(yk);
        list.add(ch);
        list.add(ed);

        var sorted = list.getCities();
        assertEquals(ch, sorted.get(0));
        assertEquals(ed, sorted.get(1));
        assertEquals(yk, sorted.get(2));
    }

    @Test
    void testEqualsAndHashCode() {
        City a1 = new City("Edmonton", "Alberta");
        City a2 = new City("Edmonton", "Alberta");
        assertEquals(a1, a2);
        assertEquals(a1.hashCode(), a2.hashCode());
    }
}
