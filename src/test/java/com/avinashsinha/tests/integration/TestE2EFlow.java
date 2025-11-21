package com.avinashsinha.tests.integration;

import com.avinashsinha.base.BaseTest;
import com.avinashsinha.endpoints.APIConstants;
import com.avinashsinha.pojos.*;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class TestE2EFlow extends BaseTest {

    @Test(groups = "QA", priority = 1)
    @Owner("Avinash Sinha")
    @Description("TC#1 : Step 1. Register the User Positive")
    public void testRegisterUserPositive_POST() {

        requestSpecification.basePath(APIConstants.REGISTER);

        response = RestAssured.given(requestSpecification)
                .body(payloadManager.registerPayloadUser_Positive())
                .when().log().all()
                .post();

        validatableResponse = response.then().log().all().statusCode(200);

        RegisterResponse registerResponse = payloadManager.registerResponseJava(response.asString());

        assertActions.verifyIdNotNull(registerResponse.getId());
        assertActions.verifyTokenNotNull(registerResponse.getToken());
    }

    @Test(groups = "QA", priority = 2)
    @Owner("Avinash Sinha")
    @Description("TC#2 : Step 2. Login the User Positive")
    public void testLoginUserPositive_POST() {

        requestSpecification.basePath(APIConstants.LOGIN);

        response = RestAssured.given(requestSpecification)
                .body(payloadManager.loginPayloadUser_Positive())
                .when().log().all()
                .post();

        validatableResponse = response.then().log().all().statusCode(200);

        LoginResponse loginResponse = payloadManager.loginResponseJava(response.asString());

        assertActions.verifyTokenNotNull(loginResponse.getToken());

    }

    @Test(groups = "QA", priority = 3)
    @Owner("Avinash Sinha")
    @Description("TC#3 : Step 3. Create the User")
    public void testCreateUser_POST() {

        requestSpecification.basePath(APIConstants.CRUD_OPER);

        response = RestAssured.given(requestSpecification)
                .body(payloadManager.createPayloadUser())
                .when().log().all()
                .post();

        validatableResponse = response.then().log().all().statusCode(201);

        UserResponse userResponse = payloadManager.userResponseJava(response.asString());

        assertActions.verifyNameNotBlank(userResponse.getName());
        assertActions.verifyJobNotEmpty(userResponse.getJob());
        assertActions.verifyIdNotNull(userResponse.getId());
        assertActions.verifyCreatedNotNull(userResponse.getCreatedAt());

    }

    @Test(groups = "QA", priority = 4)
    @Owner("Avinash Sinha")
    @Description("TC#4 : Step 4. Details of User")
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

    @Test(groups = "QA", priority = 5)
    @Owner("Avinash Sinha")
    @Description("TC#5 : Step 5. Detail of User by Id")
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

    @Test(groups = "QA", priority = 6)
    @Owner("Avinash Sinha")
    @Description("TC#6 : Step 6. Full Update the User by Id")
    public void testUpdateUserId_PUT() {

        int userId = 4;

        requestSpecification.basePath(APIConstants.CRUD_OPER);

        response = RestAssured.given(requestSpecification)
                .pathParam("id", userId)
                .body(payloadManager.fullUpdatePayloadUser())
                .when().log().all()
                .put(APIConstants.USERS_ENDPOINT);

        validatableResponse = response.then().log().all().statusCode(200);

        System.out.println("\n------------------------------ VERIFY AND PRINT ------------------------------\n");

        UserResponse userResponse = payloadManager.userResponseJava(response.asString());

        System.out.println("Name         : " + userResponse.getName());
        System.out.println("Job          : " + userResponse.getJob());
        assertActions.verifyNameNotBlank(userResponse.getName());
        assertActions.verifyJobNotEmpty(userResponse.getJob());

        UpdateResponse updateResponse = payloadManager.updateResponseJava(response.asString());

        String updatedAt = updateResponse.getUpdatedAt();
        System.out.println("Updated At   : " + updatedAt);
        assertActions.verifyUpdatedNotNull(updateResponse.getUpdatedAt());

    }

    @Test(groups = "QA", priority = 7)
    @Owner("Avinash Sinha")
    @Description("TC#7 : Step 7. Partial Update the User by Id")
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

    @Test(groups = "QA", priority = 8)
    @Owner("Avinash Sinha")
    @Description("TC#8 : Step 8. Delete the User by Id")
    public void testDeleteUserId_DELETE() {

        int userId = 8;

        requestSpecification.basePath(APIConstants.CRUD_OPER);

        response = RestAssured.given(requestSpecification)
                .pathParam("id", userId)
                .when().delete(APIConstants.USERS_ENDPOINT);

        validatableResponse = response.then().log().all().statusCode(204);
    }

}