package com.nextBaseCRM.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class CY3_7_Rabia extends TestBase{

    @Test
    public void Vote() throws InterruptedException {


        WebElement inputUserName = driver.findElement(By.className("login-inp"));
        inputUserName.sendKeys("hr7@cydeo.com");


        WebElement user_password = driver.findElement(By.name("USER_PASSWORD"));
        user_password.sendKeys("UserUser");


        WebElement loginButton = driver.findElement(By.className("login-btn"));
        loginButton.click();


        WebElement pollButton = driver.findElement(By.xpath("//span[.='Poll']/span"));
        Thread.sleep(2000);
        pollButton.click();

    WebElement voteAgainButton = driver.findElement(By.xpath("(//button[.='Vote again'])[1]"));


        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", voteAgainButton);
        voteAgainButton.click();




        WebElement optionButton = driver.findElement(By.xpath("//label[.='Java']//preceding-sibling::*/span"));
        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", optionButton);
        optionButton.click();
        Thread.sleep(2000);
        WebElement voteButton = driver.findElement(By.xpath("(//button[.='Vote'])[1]"));


        Thread.sleep(2000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", voteButton);
        voteButton.click();

       voteAgainButton = driver.findElement(By.xpath("(//button[.='Vote again'])[1]"));

        Thread.sleep(2000);
        assertTrue(voteAgainButton.isDisplayed());

        Thread.sleep(2000);
        voteAgainButton.click();


    }


}
