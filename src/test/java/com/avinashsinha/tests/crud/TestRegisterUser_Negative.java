package com.avinashsinha.tests.crud;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import com.avinashsinha.pojos.RegisterResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestRegisterUser_Negative extends BaseTest {

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Register the User Negative")
    public void testRegisterUserNegative_POST() {

        requestSpecification.basePath(APIConstants.REGISTER);

        response = RestAssured.given(requestSpecification)
                .body(payloadManager.registerUserRequest_Negative())
                .when().log().all()
                .post();

        validatableResponse = response.then().log().all().statusCode(400);

        RegisterResponse registerResponse = payloadManager.registerResponseJava(response.asString());

    }

}