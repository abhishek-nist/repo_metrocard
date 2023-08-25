package com.example.geektrust;

import com.example.geektrust.service.MetroService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FareCollection {
    static MetroService metroService = new MetroService();
    public static void main(String[] args) {
        if (args.length != 1) {
            System.exit(1);
        }

        String filePath = args[0];
        processTextFile(filePath);
//        processTextFile("/Users/abhishek.yadav/Desktop/Test/Test.txt");
    }

    public static void processTextFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String data;
            while ((data = reader.readLine()) != null) {

                    if (data.contains("BALANCE")) {
                        metroService.addBalanceToCard(data);
                    }
                    else if (data.contains("CHECK_IN")) {
                        try {
                            metroService.checkIn(data);
                        } catch (Exception e) {
                            System.out.println("Card Details not Found");
                        }
                    } else if (data.contains("PRINT_SUMMARY")) {
                        metroService.printSummary();
                    }
                }
            } catch (IOException e) {
               System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
