package com.restfulbooker.modules;

import com.google.gson.Gson;
import com.restfulbooker.Pojos.Booking;
import com.restfulbooker.Pojos.Bookingdates;

public class Payload_Manager {

    Gson gson;

    public String CreatePayloadBooking(){
        Booking booking = new Booking();
        booking.setFirstname("Jonny");
        booking.setLastname("Joker");
        booking.setTotalprice(2000);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2025-03-30");
        bookingdates.setCheckout("2025-04-02");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Banana");


    }
}
