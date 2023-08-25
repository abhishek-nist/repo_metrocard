package com.example.geektrust;

import com.example.geektrust.service.MetroService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FareCollectionTest {

    private MetroService metroService;
    private FareCollection fareCollection;

    @BeforeEach
    public void setup() {
        metroService = new MetroService();
        fareCollection = new FareCollection();
        fareCollection.metroService = metroService;
    }

    @Test
    public void testProcessTextFile() throws IOException {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        fareCollection.processTextFile("sample_input/Test5.txt");

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
    @Test
    public void testMain()  {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        fareCollection.main(new String[]{"sample_input/Test5.txt"});


    }
}
