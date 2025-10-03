package com.avinashsinha.asserts;

import static org.assertj.core.api.Assertions.assertThat;

public class AssertActions {

    public void verifyIdNotNull(Integer idExpect) {
        assertThat(idExpect).isNotNull();
    }

    public void verifyTokenNotNull(String tokenExpect) {
        assertThat(tokenExpect).isNotNull();
    }

    public void verifyNameNotBlank(String nameExpect) {
        assertThat(nameExpect).isNotBlank();
    }

    public void verifyJobNotEmpty(String jobExpect) {
        assertThat(jobExpect).isNotEmpty();
    }

    public void verifyIdNotNull(String idExpect) {
        assertThat(idExpect).isNotNull();
    }

    public void verifyCreatedNotNull(String createdExpect) {
        assertThat(createdExpect).isNotNull();
    }

    public void verifyTotalNotNull(Integer totalExpect){
        assertThat(totalExpect).isNotZero().isNotNegative().isPositive().isNotNull();
    }

    public void verityEmailNotBlank(String emailExpect){
        assertThat(emailExpect).isNotNull().isNotEmpty().isNotBlank();
    }

    public void verifyFirstNameNotBlank(String firstnameExpect){
        assertThat(firstnameExpect).isNotBlank().isNotEmpty();
    }

    public void verifyLastNameNotBlank(String lastnameExpect){
        assertThat(lastnameExpect).isNotBlank().isNotEmpty().isNotNull();
    }

    public void verifyUrlNotBlank(String urlExpect){
        assertThat(urlExpect).isNotBlank().isNotEmpty().isNotNull();
    }

    public void verifyTextNotBlank(String textExpect){
        assertThat(textExpect).isNotBlank().isNotEmpty().isNotNull();
    }

    public void verifyUpdatedNotNull(String updatedExpect) {
        assertThat(updatedExpect).isNotNull();
    }

}