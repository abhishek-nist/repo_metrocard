package com.example.geektrust.controller;

public class TravelCharges {

final private int charges[]={200,100,50};

    public int getCharges(String type) {

        if(type.equals("ADULT")){
            return charges[0];
        }
        if(type.equals("SENIOR_CITIZEN")){
            return charges[1];
        }
        if(type.equals("KID")){
            return charges[2];
        }
        else{
            System.out.println("Not a Valid Passenger");
        }
        return -1;
    }
}
