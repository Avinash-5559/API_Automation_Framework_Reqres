package com.avinashsinha.tests.crud;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import com.avinashsinha.pojos.DetailsResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestUserDetails extends BaseTest {

    @Test(groups = "Regression", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Details of User")
    public void testDetailsUser_GET() {

        requestSpecification.basePath(APIConstants.CRUD_OPER);

        requestSpecification.queryParam("page", "1");

        response = RestAssured.given(requestSpecification)
                .when().get();

        validatableResponse = response.then().log().all().statusCode(200);

        DetailsResponse detailsResponse = payloadManager.detailsResponseJava(response.asString());

        assertActions.verifyTotalNotNull(detailsResponse.getTotal());

        System.out.println("\n---------------------------------------- VERIFY AND PRINT ----------------------------------------\n");

        String firstName = detailsResponse.getData().get(0).getFirstName();
        System.out.println("FirstName : " + firstName);
        assertActions.verifyFirstNameNotBlank(firstName);

        String lastName = detailsResponse.getData().get(5).getLastName();
        System.out.println("LastName  : " + lastName);
        assertActions.verifyLastNameNotBlank(lastName);

        String url = detailsResponse.getSupport().getUrl();
        System.out.println("URL       : " + url);
        assertActions.verifyUrlNotBlank(url);

        String text = detailsResponse.getSupport().getText();
        System.out.println("Text      : " + text);
        assertActions.verifyTextNotBlank(text);

    }
}