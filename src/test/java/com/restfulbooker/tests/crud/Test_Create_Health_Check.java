package com.restfulbooker.tests.crud;

import com.restfulbooker.base.Base_test;
import com.restfulbooker.endpoints.API_Constants;
import com.restfulbooker.modules.Payload_Manager;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class Test_Create_Health_Check extends Base_test {

    @Test(groups = "Regression", priority = 1)
    @Owner("SHailesh")
    @TmsLink("https://www.atlassian.com/browser/TestCases -1")
    @Description("TC#INT1 - Step 2. Verify Health Check")
    public void testHealthCheck(){

        requestSpecification.basePath(API_Constants.ping_url);
        response = RestAssured.given(requestSpecification)
                .when().get();
        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(201);



    }
}
