package com.nextBaseCRM.tests;

import com.nextBaseCRM.utilities.BrowserUtils;
import com.nextBaseCRM.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CY3_11_Elif {

    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    //             - STEP     1-

    @Test   //
    public void FirstTest(){

       // GO TO : https://login2.nextbasecrm.com
        driver.get("https://login2.nextbasecrm.com");

        // VALID USERNAME AND PASSWORD
        WebElement username = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        username.sendKeys("hr8@cydeo.com");

        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        // LOG IN
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

        BrowserUtils.verifyTitle(driver, "Portal");

    //}

    //             - STEP     2-

   // @Test
   // public void SecondTest(){

        // GO TO USER PROFILE PAGE
        WebElement UserMenu = driver.findElement(By.xpath("//div[@id='user-block']"));
        UserMenu.click();

        WebElement MyProfile = driver.findElement(By.cssSelector("span[class='menu-popup-item-text']"));
        MyProfile.click();



    }


}
