package com.example.geektrust.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class AirportTest {

    private Airport airport;

    @BeforeEach
    public void setUp() {
        airport = new Airport();
    }

    @Test
    public void testSetAndGetTotalAmount() {
        airport.setTotalAmount(500);
        assertEquals(500, airport.getTotalAmount());
    }

    @Test
    public void testSetAndGetTotalDiscount() {
        airport.setTotalDiscount(50);
        assertEquals(50, airport.getTotalDiscount());
    }

    @Test
    public void testSetAndGetAirportPeopleTypeCount() {
        airport.setAirportPeopleTypeCount("ADULT");
        airport.setAirportPeopleTypeCount("KID");
        airport.setAirportPeopleTypeCount("SENIOR_CITIZEN");

        assertEquals(1, airport.getAirportPeopleTypeCount("ADULT"));
        assertEquals(1, airport.getAirportPeopleTypeCount("KID"));
        assertEquals(1, airport.getAirportPeopleTypeCount("SENIOR_CITIZEN"));
        assertEquals(0,airport.getAirportPeopleTypeCount("NOT_VALID"));


    }

    @Test
    public void testTotalAmountAndTotalDiscount() {
        airport.totalAmount(100);
        airport.totalDiscount(10);

        assertEquals(100, airport.getTotalAmount());
        assertEquals(10, airport.getTotalDiscount());
    }
}
