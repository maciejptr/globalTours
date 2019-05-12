package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    protected WebDriver driver;

    @BeforeTest
    public void setUpDriver() {
        System.out.println("Running 'setUpDriver' method from 'BaseTest.java'");
        System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");
        this.driver = new ChromeDriver();
    }

    @AfterTest
    public void closeBrowser() {
        this.driver.quit();
    }
}
