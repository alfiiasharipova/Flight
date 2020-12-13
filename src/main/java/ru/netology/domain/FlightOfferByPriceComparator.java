package ru.netology.domain;

import java.util.Comparator;

public class FlightOfferByPriceComparator implements Comparator<FlightOffer> {

    @Override
    public int compare(FlightOffer o1, FlightOffer o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
