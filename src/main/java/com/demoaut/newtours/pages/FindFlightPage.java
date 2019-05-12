package com.demoaut.newtours.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FindFlightPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(name = "reserveFlights")
    private WebElement firstSubmitButton;

    @FindBy(name = "buyFlights")
    private WebElement secondSubmitButton;


    public FindFlightPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
        PageFactory.initElements(driver, this);
    }

    public void submitFindFlightPage() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.firstSubmitButton));
        this.firstSubmitButton.click();
    }

    public void goToFlightConfirmationPage() {
        this.wait.until(ExpectedConditions.elementToBeClickable(this.secondSubmitButton));
        this.secondSubmitButton.click();
    }

}
