package com.demoaut.newtours.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FlightDetailsPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "passCount")
    private WebElement passangers;

    @FindBy(name = "findFlights")
    private WebElement continueButton;

    public FlightDetailsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void selectPassengers(String noOfPassengers) {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.passangers));
        Select passengersSelect = new Select(this.passangers);
        passengersSelect.selectByValue(noOfPassengers);
    }

    public void goToFindFlightsPage() {
        this.continueButton.click();
    }
}
