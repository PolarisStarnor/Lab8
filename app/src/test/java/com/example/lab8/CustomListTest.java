package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {

    private CustomList list;

    public CustomList mockCityList(){
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    @Test
    public void addCityTest() {
        list = mockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(), listSize+1);
    }

    @Test
    void hasCityTest() {
        list = mockCityList();
        City city = new City("Toronto", "ON");
        list.addCity(city);
        assertTrue(list.hasCity(city));
        city = new City("Toronton't", "OFF");
        assertFalse(list.hasCity(city));
    }

    @Test
    void removeCityTest(){
        list = mockCityList();
        City city = new City("Toronto", "ON");
        list.addCity(city);
        list.removeCity(city);
        assertEquals(0, list.getCount());
        assertThrows(IllegalArgumentException.class, () -> {
            list.removeCity(city);
        });
    }

    @Test
    void countCitiesTest() {
        list = mockCityList();
        assertEquals(1, list.countCities());
        City city = new City("Toronto", "ON");
        list.addCity(city);
        assertEquals(2, list.countCities());
        list.removeCity(city);
        assertEquals(1, list.countCities());
    }
}
