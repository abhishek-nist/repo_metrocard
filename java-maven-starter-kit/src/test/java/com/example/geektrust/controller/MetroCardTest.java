package com.example.geektrust.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MetroCardTest {

    private MetroCard metroCard;

    @BeforeEach
    public void setUp() {
        metroCard = new MetroCard();
    }

    @Test
    public void testMC1SetAndGetMetroId() {
        metroCard.setMetroId("MC1");
        assertEquals("MC1", metroCard.getMetroId());
    }
    @Test
    public void testMC2SetAndGetMetroId() {
        metroCard.setMetroId("MC2");
        assertEquals("MC2", metroCard.getMetroId());
    }
    @Test
    public void testMC3SetAndGetMetroId() {
        metroCard.setMetroId("MC3");
        assertEquals("MC3", metroCard.getMetroId());
    }

    @Test
    public void testGetMoneyInAccountInitiallyZero() {
        assertEquals(0, metroCard.getMoneyInAccount());
    }

    @Test
    public void testSetAndGetMoneyInAccountEquals100() {
        metroCard.setMoneyInAccount(100);
        assertEquals(100, metroCard.getMoneyInAccount());
    }

    @Test
    public void testSetAndGetMoneyInAccountEquals200() {
        metroCard.setMoneyInAccount(200);
        assertEquals(200, metroCard.getMoneyInAccount());
    }



}
