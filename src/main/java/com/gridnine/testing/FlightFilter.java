package com.gridnine.testing;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public interface FlightFilter {

    Set<Flight> departureBeforeNow(List<Flight>flights);

    Set<Flight> arrivalBeforeDepartureDate(List<Flight>flightList);

    List<Flight> timeBetweenSegmentsMoreThenTwoHours(List<Flight> flight);

}
