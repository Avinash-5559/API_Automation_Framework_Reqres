package com.avinashsinha.tests.crud;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import com.avinashsinha.pojos.UpdateResponse;
import com.avinashsinha.pojos.UserResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestUserFullUpdate extends BaseTest {

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Full Update the User by Id")
    public void testUpdateUserId_PUT() {

        int userId = 4;

        requestSpecification.basePath(APIConstants.CRUD_OPER);

        response = RestAssured.given(requestSpecification)
                .pathParam("id", userId)
                .when().body(payloadManager.fullUpdatePayloadUser())
                .put(APIConstants.USERS_ENDPOINT);

        validatableResponse = response.then().log().all().statusCode(200);

        System.out.println("\n------------------------------ VERIFY AND PRINT ------------------------------\n");

        UserResponse userResponse = payloadManager.userResponseJava(response.asString());

        System.out.println("Name         : "+userResponse.getName());
        System.out.println("Job          : "+userResponse.getJob());
        assertActions.verifyNameNotBlank(userResponse.getName());
        assertActions.verifyJobNotEmpty(userResponse.getJob());

        UpdateResponse updateResponse = payloadManager.updateResponseJava(response.asString());

        String updatedAt = updateResponse.getUpdatedAt();
        System.out.println("Updated At   : " + updatedAt);
        assertActions.verifyUpdatedNotNull(updateResponse.getUpdatedAt());

    }
}