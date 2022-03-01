package com.nextBaseCRM.tests;
import com.nextBaseCRM.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class DavidUserStory {
//user story #4
    WebDriver driver;

    @BeforeMethod
    public void setUp() {


        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://login2.nextbasecrm.com");
    }


    @Test
    public void accessUserProfileOptions() throws NoSuchElementException {

        WebElement UserName = driver.findElement(By.className("login-inp"));
        UserName.sendKeys("hr9@cydeo.com");


        WebElement userPassword = driver.findElement(By.name("USER_PASSWORD"));
        userPassword.sendKeys("UserUser");


        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();


        WebElement UserProfileBtn = driver.findElement(By.xpath("//div[@id='user-block']"));
        UserProfileBtn.click();

        WebElement ProfileBtn = driver.findElement(By.xpath("//a[@class='menu-popup-item menu-popup-no-icon ']"));
        System.out.println("ProfileBtn.isDisplayed() = " + ProfileBtn.isDisplayed());

        WebElement EditProfileSettingsBtn = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[2]"));
        System.out.println("EditProfileSettingsBtn.isDisplayed() = " + EditProfileSettingsBtn.isDisplayed());

        WebElement ThemesBtn = driver.findElement(By.xpath("(//span[@class='menu-popup-item menu-popup-no-icon '])[1]"));
        System.out.println("ThemesBtn.isDisplayed() = " + ThemesBtn.isDisplayed());

        WebElement configureNotificationsBtn = driver.findElement(By.xpath("(//span[@class='menu-popup-item-text'])[4]"));
        System.out.println("configureNotificationsBtn.isDisplayed() = " + configureNotificationsBtn.isDisplayed());

        WebElement LogoutBtn = driver.findElement(By.xpath("(//a[@class='menu-popup-item menu-popup-no-icon '])[3]"));
        System.out.println("LogoutBtn.isDisplayed() = " + LogoutBtn.isDisplayed());
    }
}




