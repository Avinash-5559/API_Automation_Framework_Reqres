package com.avinashsinha.modules;

import com.avinashsinha.pojos.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayloadManager {

    public String registerUserRequest_Positive() {

        Register register = new Register();

        register.setEmail("eve.holt@reqres.in");
        register.setPassword("pistol");

        String registerRequest;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            registerRequest = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(register);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return registerRequest;

    }

    public RegisterResponse registerResponseJava(String registerResponseString) {

        RegisterResponse registerResponse;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            registerResponse = objectMapper.readValue(registerResponseString, RegisterResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return registerResponse;
    }

    public String registerUserRequest_Negative() {

        Register register = new Register();

        register.setEmail("sydney@fife");

        String registerRequest;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            registerRequest = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(register);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return registerRequest;

    }

    public String loginUserRequest_Positive() {

        Login login = new Login();

        login.setEmail("eve.holt@reqres.in");
        login.setPassword("cityslicka");

        String loginRequest;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            loginRequest = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(login);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return loginRequest;

    }

    public LoginResponse loginResponseJava(String loginResponseString) {

        LoginResponse loginResponse;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            loginResponse = objectMapper.readValue(loginResponseString, LoginResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return loginResponse;
    }

    public String loginUserRequest_Negative() {

        Login login = new Login();

        login.setEmail("peter@klaven");

        String loginRequest;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            loginRequest = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(login);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return loginRequest;

    }

    public String createUserRequest() {

        Users users = new Users();

        users.setName("Noel Keller");
        users.setJob("Manager");

        String createRequest;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            createRequest = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return createRequest;

    }

    public UserResponse userResponseJava(String userResponseString) {

        UserResponse userResponse;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            userResponse = objectMapper.readValue(userResponseString, UserResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return userResponse;
    }

    public DetailsResponse detailsResponseJava(String detailsResponseString) {

        DetailsResponse detailsResponse;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            detailsResponse = objectMapper.readValue(detailsResponseString, DetailsResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return detailsResponse;
    }

    public DataResponse dataResponseJava(String dataResponseString) {

        DataResponse dataResponse;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            dataResponse = objectMapper.readValue(dataResponseString, DataResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return dataResponse;
    }

    public SupportResponse supportResponseJava(String supportResponseString) {

        SupportResponse supportResponse;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            supportResponse = objectMapper.readValue(supportResponseString, SupportResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return supportResponse;
    }

    public String fullUpdateUserRequest() {

        Users users = new Users();

        users.setName("Aled Moody");
        users.setJob("Employee");

        String fullUpdateRequest;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            fullUpdateRequest = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return fullUpdateRequest;

    }

    public UpdateResponse updateResponseJava(String updateResponseString) {

        UpdateResponse updateResponse;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            updateResponse = objectMapper.readValue(updateResponseString, UpdateResponse.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return updateResponse;
    }

    public String partialUpdateUserRequest() {

        Users users = new Users();

        users.setJob("Lead");

        String partialUpdateResponse;

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            partialUpdateResponse = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(users);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return partialUpdateResponse;

    }

}