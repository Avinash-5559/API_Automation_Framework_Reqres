package com.avinashsinha.base;

import com.avinashsinha.asserts.AssertActions;
import com.avinashsinha.endpoints.APIConstants;
import com.avinashsinha.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    public RequestSpecification requestSpecification;
    public Response response;
    public ValidatableResponse validatableResponse;
    public PayloadManager payloadManager;
    public AssertActions assertActions;

    @BeforeMethod
    @BeforeTest
    public void setUp() {

        payloadManager = new PayloadManager();
        assertActions = new AssertActions();

        requestSpecification = RestAssured.given()
                .baseUri(APIConstants.BASE_URL)
                .header(APIConstants.API_KEY, APIConstants.API_VALUE)
                .contentType(ContentType.JSON)
                .log().all();

    }

}