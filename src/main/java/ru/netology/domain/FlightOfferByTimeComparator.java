package ru.netology.domain;

import java.util.Comparator;

public class FlightOfferByTimeComparator implements Comparator<FlightOffer> {

    @Override
    public int compare(FlightOffer o1, FlightOffer o2) {
        return o1.getTravelTimeMinutes() - o2.getTravelTimeMinutes();
    }
}
