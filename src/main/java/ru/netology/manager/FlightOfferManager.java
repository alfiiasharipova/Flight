package ru.netology.manager;

import ru.netology.domain.FlightOffer;
import ru.netology.domain.FlightOfferByPriceComparator;
import ru.netology.repository.FlightOfferRepository;

import java.util.Arrays;
import java.util.Comparator;

public class FlightOfferManager {
    FlightOfferRepository repository;

    public FlightOfferManager(FlightOfferRepository repository) {
        this.repository = repository;
    }

    public FlightOffer[] searchBy(String from, String to) {
        return searchBy(from, to, new FlightOfferByPriceComparator());
    }

    public FlightOffer[] searchBy(String from, String to, Comparator<FlightOffer> comparator) {
        FlightOffer[] result = new FlightOffer[0];
        int length = 0;
        for (FlightOffer item : repository.findAll()) {
            if (item.getAirportFrom().equals(from) && item.getAirportTo().equals(to)) {
                length++;
                FlightOffer[] tmp = new FlightOffer[length];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = item;
                result = tmp;
            }
        }
        Arrays.sort(result, comparator);
        return result;
    }
}
