package com.example.geektrust.controller;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TravelChargesTest {

    @Test
    public void testGetChargesForAdult() {
        TravelCharges travelCharges = new TravelCharges();
        int charges = travelCharges.getCharges("ADULT");
        assertEquals(200, charges);
    }

    @Test
    public void testGetChargesForSeniorCitizen() {
        TravelCharges travelCharges = new TravelCharges();
        int charges = travelCharges.getCharges("SENIOR_CITIZEN");
        assertEquals(100, charges);
    }

    @Test
    public void testGetChargesForKid() {
        TravelCharges travelCharges = new TravelCharges();
        int charges = travelCharges.getCharges("KID");
        assertEquals(50, charges);
    }

    @Test
    public void testGetChargesForInvalidPassengerType() {
        TravelCharges travelCharges = new TravelCharges();
        int charges = travelCharges.getCharges("INVALID_TYPE");
        assertEquals(-1, charges);
    }
}
