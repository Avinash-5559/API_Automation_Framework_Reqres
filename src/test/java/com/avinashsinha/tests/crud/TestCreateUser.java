package com.avinashsinha.tests.crud;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import com.avinashsinha.pojos.UserResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestCreateUser extends BaseTest {

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Create the User")
    public void testCreateUser_POST() {

        requestSpecification.basePath(APIConstants.CRUD_OPER);

        response = RestAssured.given(requestSpecification)
                .body(payloadManager.createUserRequest())
                .when().log().all()
                .post();

        validatableResponse = response.then().log().all().statusCode(201);

        UserResponse userResponse = payloadManager.userResponseJava(response.asString());

        assertActions.verifyNameNotBlank(userResponse.getName());
        assertActions.verifyJobNotEmpty(userResponse.getJob());
        assertActions.verifyIdNotNull(userResponse.getId());
        assertActions.verifyCreatedNotNull(userResponse.getCreatedAt());

    }
}