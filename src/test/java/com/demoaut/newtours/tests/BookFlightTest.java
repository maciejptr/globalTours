package com.demoaut.newtours.tests;

import com.demoaut.newtours.pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class BookFlightTest {

    private WebDriver driver;
    private String numberOfPassengers;
    private String expectedPrice;

    @BeforeTest
    @Parameters({"numberOfPassengers", "expectedPrice"})
    public void setUpDriver(String numberOfPassengers, String expectedPrice) {
        this.numberOfPassengers = numberOfPassengers;
        this.expectedPrice = expectedPrice;
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        this.driver = new ChromeDriver();
    }

    @Test
    public void registrationPage() {
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.visitNewToursRegistrationPage();
        registrationPage.enterUserDetails("Maciej", "Kowalski");
        registrationPage.enterUserCredentials("SomeUsername", "someRandomPassword");
        registrationPage.submit();
    }

    @Test(dependsOnMethods = "registrationPage")
    public void registrationConfirmationPage() {
        RegistrationConfirmationPage registrationConfirmationPage = new RegistrationConfirmationPage(driver);
        registrationConfirmationPage.goToFlightDetailsPage();
    }

    @Test(dependsOnMethods = "registrationConfirmationPage")
    public void flightDetailsPage() {
        FlightDetailsPage flightDetailsPage = new FlightDetailsPage(driver);
        flightDetailsPage.selectPassengers(numberOfPassengers);
        flightDetailsPage.goToFindFlightsPage();
    }

    @Test(dependsOnMethods = "flightDetailsPage")
    public void findFlightsPage() {
        FindFlightPage findFlightPage = new FindFlightPage(driver);
        findFlightPage.submitFindFlightPage();
        findFlightPage.goToFlightConfirmationPage();
    }

    @Test(dependsOnMethods = "findFlightsPage")
    public void flightConfirmationPage() {
        FlightConfirmationPage flightConfirmationPage = new FlightConfirmationPage(driver);
        String actualPrice = flightConfirmationPage.getPrice();
        Assert.assertEquals(actualPrice, expectedPrice);
    }

    @AfterTest
    public void closeBrowser(){
        this.driver.quit();
    }
}
