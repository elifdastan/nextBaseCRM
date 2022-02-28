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
        passwordButton.sendKeys("UserUser");

        WebElement logIn= driver.findElement(By.xpath("//input[@value='Log In']"));
        logIn.click();

        String expectedTitle = "Portal";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement messageBox = driver.findElement(By.xpath("//span[@class='feed-add-post-micro-title']"));
        messageBox.click();


        WebElement iframe = driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));
        driver.switchTo().frame(iframe);
        WebElement messageInputBox = driver.findElement(By.xpath("//body[@contenteditable='true']"));
        messageInputBox.sendKeys("Hello World");

        driver.switchTo().parentFrame();
        WebElement sendButton = driver.findElement(By.xpath("(//button[.='Send'])[3]"));
        sendButton.click();

    }

    @Test
    public void test2(){
        WebElement sigInButton = driver.findElement(By.xpath("//input[@name ='USER_LOGIN']"));
        sigInButton.sendKeys("hr7@cydeo.com" + Keys.ENTER);

        WebElement passwordButton = driver.findElement(By.xpath("//input[@name ='USER_PASSWORD']"));
        passwordButton.sendKeys("UserUser");

        WebElement logIn= driver.findElement(By.xpath("//input[@value='Log In']"));
        logIn.click();

        String expectedTitle = "Portal";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(actualTitle,expectedTitle);

        WebElement messageBox = driver.findElement(By.xpath("//span[@class='feed-add-post-micro-title']"));
        messageBox.click();

        WebElement sendButton = driver.findElement(By.xpath("(//button[.='Send'])[3]"));
        sendButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//span[.='The message title is not specified']"));

        String expectedText = "The message title is not specified";
        String actualText = errorMessage.getText();

        Assert.assertEquals(actualText,expectedText);
    }

}
