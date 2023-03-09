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

//    @Test
//    void removeCityTest(){
//        list = mockCityList();
//        City city = new City("Toronto", "ON");
//        list.addCity(city);
//        list.removeCity(city);
//        assertEquals(1, citylist.getCities().size());
//        assertThrows(IllegalArgumentException.class, () -> {
//            citylist.delete(city);
//        });
//    }
//
//    @Test
//    void countCitiesTest() {
//        CityList citylist = mockCityList();
//        assertEquals(1, citylist.countCities());
//        City city = new City("Toronto", "ON");
//        citylist.add(city);
//        assertEquals(2, citylist.countCities());
//        citylist.delete(city);
//        assertEquals(1, citylist.countCities());
//    }
}
