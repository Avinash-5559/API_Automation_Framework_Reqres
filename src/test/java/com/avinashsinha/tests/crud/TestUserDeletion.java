package com.avinashsinha.tests.crud;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestUserDeletion extends BaseTest {

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Delete the User by Id")
    public void testDeleteUserId_DELETE() {

        int userId = 8;

        requestSpecification.basePath(APIConstants.CRUD_OPER);

        response = RestAssured.given(requestSpecification)
                .pathParam("id", userId)
                .when().delete(APIConstants.USERS_ENDPOINT);

        validatableResponse = response.then().log().all().statusCode(204);
    }
}