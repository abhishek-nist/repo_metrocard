package com.example.geektrust.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CentralTest {

    private Central central;

    @BeforeEach
    public void setUp() {
        central = new Central();
    }

    @Test
    public void testSetAndGetTotalAmount() {
        central.setTotalAmount(500);
        assertEquals(500, central.getTotalAmount());
    }

    @Test
    public void testSetAndGetTotalDiscount() {
        central.setTotalDiscount(50);
        assertEquals(50, central.getTotalDiscount());
    }

    @Test
    public void testSetAndGetCentralPeopleTypeCount() {
        central.setCentralPeopleTypeCount("ADULT");
        central.setCentralPeopleTypeCount("KID");
        central.setCentralPeopleTypeCount("ADULT");

        assertEquals(2, central.getCentralPeopleTypeCount("ADULT"));
        assertEquals(1, central.getCentralPeopleTypeCount("KID"));
        assertEquals(0, central.getCentralPeopleTypeCount("SENIOR_CITIZEN"));
    }

    @Test
    public void testTotalAmountAndTotalDiscount() {
        central.totalAmount(100);
        central.totalDiscount(10);

        assertEquals(100, central.getTotalAmount());
        assertEquals(10, central.getTotalDiscount());
    }
}

