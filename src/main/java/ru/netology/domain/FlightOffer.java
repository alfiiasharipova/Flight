package ru.netology.domain;

public class FlightOffer implements Comparable<FlightOffer>{
    private final int id;
    private int price;
    private String airportFrom;
    private String airportTo;
    private int travelTimeMinutes;

    public FlightOffer(int id, int price, String airportFrom, String airportTo, int travelTimeMinutes) {
        this.id = id;
        this.price = price;
        this.airportFrom = airportFrom;
        this.airportTo = airportTo;
        this.travelTimeMinutes = travelTimeMinutes;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAirportFrom() {
        return airportFrom;
    }

    public void setAirportFrom(String airportFrom) {
        this.airportFrom = airportFrom;
    }

    public String getAirportTo() {
        return airportTo;
    }

    public void setAirportTo(String airportTo) {
        this.airportTo = airportTo;
    }

    public int getTravelTimeMinutes() {
        return travelTimeMinutes;
    }

    public void setTravelTimeMinutes(int travelTimeMinutes) {
        this.travelTimeMinutes = travelTimeMinutes;
    }

    @Override
    public int compareTo(FlightOffer o) {
        return price - o.price;
    }
}
