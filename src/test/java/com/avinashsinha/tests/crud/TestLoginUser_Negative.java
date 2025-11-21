package com.avinashsinha.tests.crud;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import com.avinashsinha.pojos.LoginResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestLoginUser_Negative extends BaseTest {

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Login the User Negative")
    public void testLoginUserNegative_POST() {

        requestSpecification.basePath(APIConstants.LOGIN);

        response = RestAssured.given(requestSpecification)
                .body(payloadManager.loginPayloadUser_Negative())
                .when().log().all()
                .post();

        validatableResponse = response.then().log().all().statusCode(400);

        LoginResponse loginResponse = payloadManager.loginResponseJava(response.asString());
    }
}
