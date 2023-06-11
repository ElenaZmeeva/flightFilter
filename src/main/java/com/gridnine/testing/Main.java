package com.gridnine.testing;

import com.gridnine.testing.Flight;
import com.gridnine.testing.FlightBuilder;

import java.sql.SQLOutput;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        FlightBuilder flightBuilder=new FlightBuilder();
        List<Flight> flights= FlightBuilder.createFlights();
        FlightFilter flightFilter= new FlightFilterImpl();

        System.out.println("Вылет до текущего момента времени ");
        flightFilter.departureBeforeNow(flights);

        System.out.println("Имеются сегменты с датой прилета раньше даты вылета ");
        flightFilter.arrivalBeforeDepartureDate(flights);

        System.out.println("Общее время, проведённое на земле превышает два часа ");
        flightFilter.timeBetweenSegmentsMoreThenTwoHours(flights);
    }
}