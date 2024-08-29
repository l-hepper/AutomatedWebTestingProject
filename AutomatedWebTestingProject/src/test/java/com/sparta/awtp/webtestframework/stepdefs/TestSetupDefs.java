package com.sparta.awtp.webtestframework.stepdefs;


import com.sparta.awtp.webtestframework.TestSetup;
import com.sparta.awtp.webtestframework.pages.Website;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

import java.io.IOException;

public class TestSetupDefs {

    private Website website;
    private static final String BASE_URL = "https://automationexercise.com/";

    @Before
    public void setup() throws IOException {
        TestSetup.startChromeService();
        TestSetup.createWebDriver();
    }

    @After
    public void afterEach() {
        TestSetup.quitWebDriver();
        TestSetup.stopService();
    }


    @Given("I am on the homepage")
    public void iAmOnTheHomePage() {
        website = TestSetup.getWebsite(BASE_URL);
    }

    @Then("The website url should be {string}")
    public void theWebsiteUrlShouldBe(String expected) {
        Assertions.assertEquals(expected, BASE_URL);
    }
}


