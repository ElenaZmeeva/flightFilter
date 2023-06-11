package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.*;



public class FlightFilterImpl implements FlightFilter {

    /**
     * Вылет до текущего моммента времени
     */
    @Override
    public Set<Flight> departureBeforeNow(List<Flight>flights) {
        Set<Flight> flights1= new HashSet<>();
        LocalDateTime date= LocalDateTime.now();

        for (Flight flight: flights){
            if (date.isBefore(date)){
               flights1.add(flight);
}
        }
        return flights1;
    }

    /**
     * Сегменты с датой прилета раньше даты вылета
     */
    @Override
    public Set<Flight> arrivalBeforeDepartureDate(List<Flight>flights) {
        Set<Flight> flightSet= new HashSet<>();
        List<Segment> segments=new ArrayList<>();
        for (Flight flight: flights) {
        segments.addAll(flight.getSegments());
        }
        LocalDateTime departTime= segments.get(0).getDepartureDate();
        LocalDateTime arrTime=segments.get(0).getArrivalDate();

        if (departTime.isBefore(arrTime)){
            flightSet.add((Flight) flights);
        }
        return flightSet;
    }

    /**
     * Интервал между рейсами больше двух часов
     */
    @Override
    public List<Flight> timeBetweenSegmentsMoreThenTwoHours(List<Flight> flights) {
        List<Flight> flight=new ArrayList<>();
        List<Segment> segments=new ArrayList<>();
        for (Flight flight1: flights)
            segments.addAll(flight1.getSegments());

        if (segments.size()>2){
            LocalDateTime departTime= segments.get(0).getDepartureDate();
            LocalDateTime arrTime=segments.get(0).getArrivalDate();

            if (departTime.isAfter(arrTime.plusHours(2))){
                flight.add((Flight) flights);
            }
        }
           return flight;
        }
    }

