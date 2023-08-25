package com.example.geektrust.service;

import com.example.geektrust.controller.MetroCard;
import com.example.geektrust.controller.TravelCharges;
import com.example.geektrust.model.Airport;
import com.example.geektrust.model.Central;
import com.example.geektrust.model.Station;

import java.util.Collection;
import java.util.HashMap;

public class MetroService {

    HashMap<String, MetroCard> passengerIdAndMoney= new HashMap<>();
    HashMap<String, Integer> checkInCount= new HashMap<>();


    TravelCharges travelCharges=new TravelCharges();

    Airport airport= new Airport();
    Central central= new Central();
    public void addBalanceToCard(String data){
        MetroCard metroCard = new MetroCard();
        String cardDetails[] = data.split(" ");

        for(String s:cardDetails){
            metroCard.setMetroId(cardDetails[1]);
            metroCard.setMoneyInAccount(Integer.parseInt(cardDetails[2]));
            passengerIdAndMoney.put(cardDetails[1],metroCard);
        }
    }

    public void checkIn(String data) throws Exception{
        String checkInDetails[] = data.split(" ");
        if(checkInCount.containsKey(checkInDetails[1])){
            checkInCount.put(checkInDetails[1],checkInCount.get(checkInDetails[1])+1);
        }
        else{
            checkInCount.put(checkInDetails[1],1);
        }
        stationFareCollection(checkInDetails[1],checkInDetails[2],checkInDetails[3]);

    }

    public void stationFareCollection(String personId , String personType, String station) throws Exception{

        int travelFare = travelCharges.getCharges(personType);
        MetroCard card = passengerIdAndMoney.get(personId);
        int moneyInCard = card.getMoneyInAccount();
        int processingCharge = 0;

        if(checkInCount.get(personId)%2==0){
            //give discount

            if(station.equals("AIRPORT")){

                airport.setAirportPeopleTypeCount(personType);

                if(moneyInCard<(travelFare/2)) {
                    processingCharge = (2 * ((travelFare/2) - moneyInCard)) / 100;
                    card.setMoneyInAccount(0);
                }
                else{
                    card.setMoneyInAccount(moneyInCard-(travelFare/2));
                }
               airport.setTotalAmount((travelFare/2)+processingCharge);
               airport.setTotalDiscount(travelFare/2);


            }else{
                central.setCentralPeopleTypeCount(personType);
                if(moneyInCard<(travelFare/2)){
                    processingCharge = (2*((travelFare/2)-moneyInCard))/100;
                    card.setMoneyInAccount(0);
                }
                else{
                    card.setMoneyInAccount(moneyInCard-(travelFare/2));
                }
                central.setTotalAmount((travelFare/2)+processingCharge);
                central.setTotalDiscount(travelFare/2);
            }
        }else{
            //no discount;
            if(moneyInCard<travelFare){
                processingCharge = (2*(travelFare-moneyInCard))/100;
                card.setMoneyInAccount(0);
            }
            else{
                card.setMoneyInAccount(moneyInCard-travelFare);
            }
            if(station.equals("AIRPORT")){
                airport.setAirportPeopleTypeCount(personType);
                airport.setTotalAmount(travelFare+processingCharge);
            }else{
                central.setCentralPeopleTypeCount(personType);
                central.setTotalAmount(travelFare+processingCharge);
            }
        }
    }


    public void printSummary() {

        System.out.print("TOTAL_COLLECTION CENTRAL "+central.getTotalAmount()+" "+central.getTotalDiscount()+"\n");
        System.out.println("PASSENGER_TYPE_SUMMARY");
        if(central.getCentralPeopleTypeCount("ADULT")>0)
            System.out.println("ADULT "+central.getCentralPeopleTypeCount("ADULT"));
        if(central.getCentralPeopleTypeCount("KID")>0)
            System.out.println("KID "+central.getCentralPeopleTypeCount("KID"));
        if(central.getCentralPeopleTypeCount("SENIOR_CITIZEN")>0)
            System.out.println("SENIOR_CITIZEN "+central.getCentralPeopleTypeCount("SENIOR_CITIZEN"));


        System.out.print("TOTAL_COLLECTION AIRPORT "+airport.getTotalAmount()+" "+airport.getTotalDiscount()+"\n");
        System.out.println("PASSENGER_TYPE_SUMMARY");
        if(airport.getAirportPeopleTypeCount("ADULT")>0)
            System.out.println("ADULT "+airport.getAirportPeopleTypeCount("ADULT"));
        if(airport.getAirportPeopleTypeCount("KID")>0)
            System.out.println("KID "+airport.getAirportPeopleTypeCount("KID"));
        if(airport.getAirportPeopleTypeCount("SENIOR_CITIZEN")>0)
            System.out.println("SENIOR_CITIZEN "+airport.getAirportPeopleTypeCount("SENIOR_CITIZEN"));

    }

}
