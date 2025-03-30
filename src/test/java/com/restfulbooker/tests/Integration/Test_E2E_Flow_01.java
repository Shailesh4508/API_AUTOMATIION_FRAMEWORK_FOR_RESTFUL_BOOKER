package com.restfulbooker.tests.Integration;

import com.restfulbooker.Pojos.Booking;
import com.restfulbooker.Pojos.BookingResponse;
import com.restfulbooker.base.Base_test;
import com.restfulbooker.endpoints.API_Constants;
import com.restfulbooker.modules.Payload_Manager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class Test_E2E_Flow_01 extends Base_test {

    @Test(groups = "qa", priority = 1)
    @Owner("Shailesh")
    @Description("TC#INT1 - Step1. Verify that the Booking can be Created")
    public void testCreateBooking(ITestContext iTestContext){
        requestSpecification.basePath(API_Constants.Create_Update_booking_url);
        response = RestAssured.given(requestSpecification)
                .when().body(Payload_Manager.CreatePayloadBooking()).post();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        BookingResponse bookingResponse = payloadManager.javaBookingResponse(response.asString());
        assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(), "Jonny");
        assertActions.verifyStringKeyNotNull(bookingResponse.getBookingid());

        iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());

    }


    @Test(groups = "qa", priority = 2)
    @Owner("Shailesh")
    @Description("TC#INT1 - Step2. Verify the Booking by ID")
    public void testBookingID(ITestContext iTestContext){
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        requestSpecification.basePath(API_Constants.Create_Update_booking_url+ bookingid);
        response = RestAssured.given(requestSpecification)
                .when().get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        Booking booking = payloadManager.getResponseFromJSON(response.asString());
        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
    }


    @Test(groups = "qa", priority = 3)
    @Owner("Shailesh")
    @Description("TC#INT1 - Step3. Verify Updated Booking by ID")
    public void testUpdateBookingByID(ITestContext iTestContext){
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String token = getToken();
        iTestContext.setAttribute("token",token);

        String basePathPUTPATCH = API_Constants.Create_Update_booking_url + bookingid;
        System.out.println(basePathPUTPATCH);

        requestSpecification.basePath(basePathPUTPATCH);

        response = RestAssured
                .given(requestSpecification).cookie("token", token)
                .when().body(payloadManager.fullUpdatePayloadAsString()).put();


        validatableResponse = response.then().log().all();
        // Validatable Assertion
        validatableResponse.statusCode(200);

        Booking booking = payloadManager.getResponseFromJSON(response.asString());

        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("Lucky");
        assertThat(booking.getLastname()).isEqualTo("Dutta");
    }


    @Test(groups = "qa", priority = 4)
    @Owner("Shailesh")
    @Description("TC#INT1 - Step4. Verify Delete the Booking by ID")
    public void testDeleteBookingByID(ITestContext iTestContext){
        String token = (String)iTestContext.getAttribute("token");
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

        String basePathDELETE = API_Constants.Create_Update_booking_url+ bookingid;

        requestSpecification.basePath(basePathDELETE).cookie("token", token);
        validatableResponse = RestAssured.given().spec(requestSpecification)
                .when().delete().then().log().all();
        validatableResponse.statusCode(201);
    }
}
