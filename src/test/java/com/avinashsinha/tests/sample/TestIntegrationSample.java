package com.avinashsinha.tests.sample;

import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestIntegrationSample {

    @Test(groups = "qa", priority = 1)
    @Owner("Avniash Sinha")
    @Description("TC#1 : Step 1. Create the User")
    public void testCreateUser() {
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 2)
    @Owner("Avinash Sinha")
    @Description("TC#2 : Step 2. Verity the User")
    public void testVerifyUser() {
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 3)
    @Owner("Avniash Sinha")
    @Description("TC#3 : Step 3. Update the User")
    public void testUpdateUser() {
        Assert.assertTrue(true);
    }

    @Test(groups = "qa", priority = 4)
    @Owner("Avinash Sinha")
    @Description("TC#4 : Step 4. Delete the User")
    public void testDeleteUser() {
        Assert.assertTrue(true);
    }

}