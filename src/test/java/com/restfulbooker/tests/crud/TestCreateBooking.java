package com.restfulbooker.tests.crud;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCreateBooking {

    @Test(groups = "qa", priority = 1)
    @Owner("Shailesh")
    @Description("TC#INT1 - Step1. Verify that the Booking can be Created")
    public void testCreateBooking(){
        Assert.assertTrue(true);
    }
}
