package com.avinashsinha.tests.crud;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import com.avinashsinha.pojos.DataResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestUserDetailsById extends BaseTest {

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Detail of User by Id")
    public void testDetailUserById_GET() {

        int userId = 5;

        requestSpecification.basePath(APIConstants.CRUD_OPER);

        response = RestAssured.given(requestSpecification)
                .pathParam("id", userId)
                .when()
                .get(APIConstants.USERS_ENDPOINT);

        validatableResponse = response.then().log().all().statusCode(200);

        DataResponse dataResponse = payloadManager.dataResponseJava(response.asString());

        System.out.println("\n------------------------------ VERIFY AND PRINT ------------------------------\n");

        String email = dataResponse.getData().getEmail();
        System.out.println("Email : " + email);
        assertActions.verityEmailNotBlank(email);

        String url = dataResponse.getSupport().getUrl();
        System.out.println("URL   : " + url);
        assertActions.verifyUrlNotBlank(url);

    }
}
