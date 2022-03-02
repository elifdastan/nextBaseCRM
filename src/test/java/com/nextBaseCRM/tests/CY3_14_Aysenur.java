package com.nextBaseCRM.tests;

import com.nextBaseCRM.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class CY3_14_Aysenur  {

    WebDriver driver;


    @BeforeMethod
    public void setUp() {


        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://login2.nextbasecrm.com");


    }

    @Test
    public void visibilityAllDesktopOptions() throws NoSuchElementException {

        WebElement UserName = driver.findElement(By.className("login-inp"));
        UserName.sendKeys("hr9@cydeo.com");

        WebElement userPassword = driver.findElement(By.name("USER_PASSWORD"));
        userPassword.sendKeys("UserUser");


        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();

        WebElement macOsButton = driver.findElement(By.xpath("//span[.='Mac OS']"));
        System.out.println("macOsButton.isDisplayed(): " + macOsButton.isDisplayed());



        WebElement linuxButton = driver.findElement(By.cssSelector("a[style='width: 30%;'"));
        System.out.println("linuxButton.isDisplayed(): " + linuxButton.isDisplayed());


        WebElement windowsButton = driver.findElement(By.cssSelector("a[style='width: 37%;'"));
        System.out.println("windowsButton.isDisplayed(): " + windowsButton.isDisplayed());
//

    }

}
