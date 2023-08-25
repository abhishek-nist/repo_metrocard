package com.example.geektrust.model;

import java.util.HashMap;

public class Central implements Station{

    int totalAmount=0;
    int totalDiscount=0;

    HashMap<String,Integer> centralPeopleTypeCount= new HashMap<>();

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

    public void setCentralPeopleTypeCount(String personType) {
        if(centralPeopleTypeCount.containsKey(personType)){
            centralPeopleTypeCount.put(personType,centralPeopleTypeCount.get(personType)+1);
        }else{
            centralPeopleTypeCount.put(personType,1);
        }

    }
    public int getCentralPeopleTypeCount(String personType) {
        if(centralPeopleTypeCount.containsKey(personType)){
            return centralPeopleTypeCount.get(personType);
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
