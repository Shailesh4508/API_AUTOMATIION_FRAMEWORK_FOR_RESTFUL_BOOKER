package com.restfulbooker.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSamples {

    @Test(groups = "qa", priority = 1)
    @Owner("Shailesh")
    @Description("TC#INT1 - Step1. Verify that the Booking can be Created")
    public void testCreateBooking(){
        Assert.assertTrue(true);
    }


    @Test(groups = "qa", priority = 2)
    @Owner("Shailesh")
    @Description("TC#INT1 - Step2. Verify the Booking by ID")
    public void testBookingID(){
        Assert.assertTrue(true);
    }


    @Test(groups = "qa", priority = 3)
    @Owner("Shailesh")
    @Description("TC#INT1 - Step3. Verify Updated Booking by ID")
    public void testUpdateBookingByID(){
        Assert.assertTrue(true);
    }


    @Test(groups = "qa", priority = 4)
    @Owner("Shailesh")
    @Description("TC#INT1 - Step4. Verify Delete the Booking by ID")
    public void testDeleteBookingByID(){
        Assert.assertTrue(true);
    }
}
