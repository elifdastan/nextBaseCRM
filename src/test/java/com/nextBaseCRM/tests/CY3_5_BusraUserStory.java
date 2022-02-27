package com.nextBaseCRM.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CY3_5_BusraUserStory extends TestBase{

    @Test
    public void  test1(){
        //1. When users click the MASSAGE tab, they should be able to write the message body and send a message successfully to the feed.

        WebElement sigInButton = driver.findElement(By.xpath("//input[@name ='USER_LOGIN']"));
        sigInButton.sendKeys("hr7@cydeo.com" + Keys.ENTER);

        WebElement passwordButton = driver.findElement(By.xpath("//input[@name ='USER_PASSWORD']"));
        passwordButton.sendKeys("UserUser" + Keys.ENTER);

        WebElement logIn= driver.findElement(By.xpath("//input[@value='Log In']"));
        logIn.click();

        String expectedTitle = "Portal";
        String actualTitle = logIn.getText();

        Assert.assertEquals(actualTitle,expectedTitle);



    }

}
