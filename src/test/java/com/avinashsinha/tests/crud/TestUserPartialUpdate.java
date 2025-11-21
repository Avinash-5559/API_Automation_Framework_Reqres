package com.avinashsinha.tests.crud;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import com.avinashsinha.pojos.UpdateResponse;
import com.avinashsinha.pojos.UserResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestUserPartialUpdate extends BaseTest {

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Partial Update the User by Id")
    public void testPartialUserId_PATCH() {

        int userId = 2;

        requestSpecification.basePath(APIConstants.CRUD_OPER);

        response = RestAssured.given(requestSpecification)
                .pathParam("id", userId)
                .body(payloadManager.partialUpdatePayloadUser())
                .when().log().all()
                .patch(APIConstants.USERS_ENDPOINT);

        validatableResponse = response.then().log().all().statusCode(200);

        System.out.println("\n------------------------------ VERIFY AND PRINT ------------------------------\n");

        UserResponse userResponse = payloadManager.userResponseJava(response.asString());

        String job = userResponse.getJob();
        System.out.println("Job        : " + job);
        assertActions.verifyJobNotEmpty(job);

        UpdateResponse updateResponse = payloadManager.updateResponseJava(response.asString());

        String updatedAt = updateResponse.getUpdatedAt();
        System.out.println("Updated At : " + updatedAt);
        assertActions.verifyUpdatedNotNull(updatedAt);

    }
}
