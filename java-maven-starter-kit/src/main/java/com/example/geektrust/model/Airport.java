package com.example.geektrust.model;

import java.util.HashMap;

public class Airport implements Station{

    int totalAmount=0;
    int totalDiscount=0;

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        totalAmount(totalAmount);
    }

    public int getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(int totalDiscount) {
        totalDiscount(totalDiscount);
    }
    HashMap<String,Integer> airportPeopleTypeAndCount= new HashMap<>();



    public void setAirportPeopleTypeCount(String personType) {
        if(airportPeopleTypeAndCount.containsKey(personType)){
            airportPeopleTypeAndCount.put(personType,airportPeopleTypeAndCount.get(personType)+1);
        }else{
            airportPeopleTypeAndCount.put(personType,1);
        }

    }
    public int getAirportPeopleTypeCount(String personType) {
        if(airportPeopleTypeAndCount.containsKey(personType)){
            return airportPeopleTypeAndCount.get(personType);
        }
        else{
            return 0;
        }
    }

    @Override
    public void totalAmount(int money) {
        totalAmount+=money;
    }

    @Override
    public void totalDiscount(int money) {
        totalDiscount+=money;
    }
}
