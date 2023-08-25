package com.example.geektrust.service;

import com.example.geektrust.controller.MetroCard;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class MetroServiceTest {

    private MetroService metroService;

    @BeforeEach
    public void setUp() {
        metroService = new MetroService();
    }

    @Test
    public void testAddBalanceToCard() {
        metroService.addBalanceToCard("BALANCE MC1 500");
        HashMap<String, MetroCard> passengerIdAndMoney = metroService.passengerIdAndMoney;

        assertNotNull(passengerIdAndMoney);
        assertEquals(1, passengerIdAndMoney.size());
        assertEquals(500, passengerIdAndMoney.get("MC1").getMoneyInAccount());
    }

    @Test
    public void testCheckInAirport() throws Exception{
        metroService.addBalanceToCard("BALANCE MC1 500");
        metroService.checkIn("CHECK_IN MC1 ADULT AIRPORT");
        HashMap<String, Integer> checkInCount = metroService.checkInCount;

        assertNotNull(checkInCount);
        assertEquals(1, checkInCount.size());
        assertEquals(1, checkInCount.get("MC1"));
    }
    @Test
    public void testCheckInCentral() throws Exception{
        metroService.addBalanceToCard("BALANCE MC1 500");
        metroService.checkIn("CHECK_IN MC1 ADULT CENTRAL");
        HashMap<String, Integer> checkInCount = metroService.checkInCount;

        assertNotNull(checkInCount);
        assertEquals(1, checkInCount.size());
        assertEquals(1, checkInCount.get("MC1"));
    }

    @Test
    public void testStationFareCollection() throws Exception {
        metroService.addBalanceToCard("BALANCE MC1 500");
        metroService.addBalanceToCard("BALANCE MC2 500");

        metroService.checkIn("CHECK_IN MC1 ADULT CENTRAL");
        metroService.checkIn("CHECK_IN MC1 ADULT AIRPORT");
        assertEquals(200, metroService.central.getTotalAmount());
        assertEquals(100, metroService.airport.getTotalAmount());


        metroService.checkIn("CHECK_IN MC1 ADULT CENTRAL");
        metroService.checkIn("CHECK_IN MC1 ADULT AIRPORT");
        assertEquals(400, metroService.central.getTotalAmount());
        assertEquals(202, metroService.airport.getTotalAmount());

        assertEquals(0, metroService.central.getTotalDiscount());
        assertEquals(200, metroService.airport.getTotalDiscount());

        metroService.checkIn("CHECK_IN MC2 ADULT AIRPORT");
        metroService.checkIn("CHECK_IN MC2 ADULT CENTRAL");

        assertEquals(402, metroService.airport.getTotalAmount());
        assertEquals(500, metroService.central.getTotalAmount());

        metroService.checkIn("CHECK_IN MC2 ADULT AIRPORT");
        metroService.checkIn("CHECK_IN MC2 ADULT CENTRAL");

        assertEquals(602, metroService.airport.getTotalAmount());
        assertEquals(602, metroService.central.getTotalAmount());

        assertEquals(200, metroService.central.getTotalDiscount());
        assertEquals(200, metroService.airport.getTotalDiscount());

    }



    @Test
    public void testPrintSummary() throws Exception{
        metroService.addBalanceToCard("BALANCE MC1 300");
        metroService.addBalanceToCard("BALANCE MC2 500");

        metroService.checkIn("CHECK_IN MC1 ADULT CENTRAL");
        metroService.checkIn("CHECK_IN MC1 ADULT AIRPORT");
        metroService.checkIn("CHECK_IN MC1 ADULT CENTRAL");
        metroService.checkIn("CHECK_IN MC2 KID AIRPORT");


        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        metroService.printSummary();

        String expectedOutput = "TOTAL_COLLECTION CENTRAL 404 0\n" +
                "PASSENGER_TYPE_SUMMARY\n" +
                "ADULT 2\n" +
                "TOTAL_COLLECTION AIRPORT 150 100\n" +
                "PASSENGER_TYPE_SUMMARY\n" +
                "ADULT 1\n" +
                "KID 1";
        assertEquals(expectedOutput, outContent.toString().trim());

        System.setOut(System.out);
    }

}
