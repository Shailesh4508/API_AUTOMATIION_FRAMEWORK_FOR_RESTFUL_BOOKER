package com.restfulbooker.tests.crud;


import com.restfulbooker.Pojos.BookingResponse;
import com.restfulbooker.base.Base_test;
import com.restfulbooker.endpoints.API_Constants;
import com.restfulbooker.modules.Payload_Manager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.testng.annotations.Test;


public class Test_Create_Booking extends Base_test {

    @Test(groups = "Regression", priority = 1)
    @Owner("SHailesh")
    @TmsLink("https://www.atlassian.com/browser/TestCases -1")
    @Description("TC#INT1 - Step 1. Verify that the Booking can be Created")
    public void testCreateBooking(){

       requestSpecification.basePath(API_Constants.Create_Update_booking_url);
       response = RestAssured.given(requestSpecification)
               .when().body(Payload_Manager.CreatePayloadBooking()).post();
       validatableResponse = response.then().log().all();
       validatableResponse.statusCode(200);
        BookingResponse bookingResponse = payloadManager.javaBookingResponse(response.asString());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"Jonny");
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());


    }
}
