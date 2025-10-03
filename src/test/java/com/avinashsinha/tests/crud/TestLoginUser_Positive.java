package com.avinashsinha.tests.crud;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import com.avinashsinha.pojos.LoginResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestLoginUser_Positive extends BaseTest {

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Login the User Positive")
    public void testLoginUserPositive_POST() {

        requestSpecification.basePath(APIConstants.LOGIN);

        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.loginPayloadUser_Positive())
                .post();

        validatableResponse = response.then().log().all().statusCode(200);

        LoginResponse loginResponse = payloadManager.loginResponseJava(response.asString());

        assertActions.verifyTokenNotNull(loginResponse.getToken());

    }
}