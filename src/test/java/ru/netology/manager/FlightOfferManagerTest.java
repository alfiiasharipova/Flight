package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightOffer;
import ru.netology.repository.FlightOfferRepository;

import static org.junit.jupiter.api.Assertions.*;

class FlightOfferManagerTest {
    FlightOffer first = new FlightOffer(1, 2000, "LED", "DME", 90);
    FlightOffer second = new FlightOffer(2, 5000, "LED", "VKO", 100);
    FlightOffer third = new FlightOffer(3, 3000, "DME", "LED", 90);
    FlightOffer fourth = new FlightOffer(4, 3000, "DME", "LED", 120);
    FlightOffer fifth = new FlightOffer(5, 1000, "LED", "DME", 95);
    FlightOfferRepository repository = new FlightOfferRepository();
    FlightOfferManager flightOfferManager;

    @BeforeEach
    void setUp(){
        repository.save(first);
        repository.save(second);
        repository.save(third);
        repository.save(fourth);
        repository.save(fifth);
        flightOfferManager = new FlightOfferManager(repository);
    }

    @Test
    void searchTwoItems() {
        FlightOffer[] offers = flightOfferManager.searchBy("LED", "DME");
        FlightOffer[] expected = {fifth, first};
        assertArrayEquals(expected,offers);
    }

    @Test
    void searchOneItems() {
        FlightOffer[] offers = flightOfferManager.searchBy("LED", "VKO");
        FlightOffer[] expected = {second};
        assertArrayEquals(expected,offers);
    }

    @Test
    void searchZeroItems() {
        FlightOffer[] offers = flightOfferManager.searchBy("VKO", "DME");
        assertEquals(offers.length, 0);
    }

    @Test
    void searchTwoItemsWithSamePrice() {
        FlightOffer[] offers = flightOfferManager.searchBy("DME", "LED");
        FlightOffer[] expected = {third, fourth};
        assertArrayEquals(expected,offers);
    }
}