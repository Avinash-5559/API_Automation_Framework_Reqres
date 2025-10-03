package com.avinashsinha.tests.crud;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import com.avinashsinha.pojos.RegisterResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestRegisterUser_Positive extends BaseTest {

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Register the User Positive")
    public void testRegisterUserPositive_POST() {

        requestSpecification.basePath(APIConstants.REGISTER);

        response = RestAssured.given(requestSpecification)
                .when().body(payloadManager.registerPayloadUser_Positive())
                .post();

        validatableResponse = response.then().log().all().statusCode(200);

        RegisterResponse registerResponse = payloadManager.registerResponseJava(response.asString());

        assertActions.verifyIdNotNull(registerResponse.getId());
        assertActions.verifyTokenNotNull(registerResponse.getToken());
    }

}