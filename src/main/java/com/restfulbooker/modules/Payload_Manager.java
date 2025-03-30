package com.restfulbooker.modules;

import com.google.gson.Gson;
import com.restfulbooker.Pojos.*;

public class Payload_Manager {

    Gson gson;

    //Creating function for payload to return something
    public static String CreatePayloadBooking() {
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

        //Java Object -> Json
        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);
        return jsonStringBooking;
    }

    //Converting the String to Java Object
    public BookingResponse javaBookingResponse(String responseString){
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }

    public static String setAuthPayload(){
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        Gson gson = new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println(jsonPayloadString);
        return jsonPayloadString;
    }

    public String getTokenFromJSON(String tokenResponse){
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse,TokenResponse.class);
        return tokenResponse1.getToken().toString();
    }
}
