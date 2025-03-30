package com.restfulbooker.base;

import com.restfulbooker.asserts.Assert_Actions;
import com.restfulbooker.endpoints.API_Constants;
import com.restfulbooker.modules.Payload_Manager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

public class Base_test {

    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public Assert_Actions assertActions;
    public Payload_Manager payloadManager;
    public JsonPath jsonPath;

    @BeforeTest
    public void setUp(){
        //Base_Uri, Content Type, Json should be their before test

        payloadManager = new Payload_Manager();
        assertActions = new Assert_Actions();

        requestSpecification = RestAssured.given()
                .baseUri(API_Constants.Base_Url)
                .contentType(ContentType.JSON).log().all();

        //we can use both but currently going through new one

//        RequestSpecification requestSpecification = new RequestSpecBuilder()
//                .setBaseUri(API_Constants.Base_Url)
//                .addHeader("Content-Type","application/json").build().log().all();
    }

    public String getToken() {
        requestSpecification = RestAssured
                .given()
                .baseUri(API_Constants.Base_Url)
                .basePath(API_Constants.Auth_url);

        // Setting the payload
        String payload = payloadManager.setAuthPayload();

        // Get the Token
        response = requestSpecification.contentType(ContentType.JSON).body(payload).when().post();
        // String Extraction
        String token = payloadManager.getTokenFromJSON(response.asString());

        return token;


    }
}
