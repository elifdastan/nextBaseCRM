package com.nextBaseCRM.tests;


import com.nextBaseCRM.utilities.CRM_Utilities;
import com.nextBaseCRM.utilities.WebDriverFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import java.util.concurrent.TimeUnit;

public class MehmetUserStory {


    @Test
    public void allTestCases() throws InterruptedException {


        ArrayList<String> userNames = new ArrayList<>();
        userNames.addAll(Arrays.asList("hr7@cydeo.com", "helpdesk7@cydeo.com", "marketing7@cydeo.com"));


        for (String each : userNames) {


            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

            driver.get("https://login2.nextbasecrm.com");

            CRM_Utilities.crm_login(driver, each, "UserUser");


            WebElement chatAndCallsButton = driver.findElement(By.xpath("(//span[@class='menu-item-link-text'])[3]"));

            chatAndCallsButton.click();

            List<WebElement> allIcons = driver.findElements(By.xpath("//div[contains(@class,'bx-desktop-tab bx-desktop-tab')]"));
            for (WebElement eachone : allIcons) {

                System.out.println("each = " + eachone.isDisplayed());
            }
            Thread.sleep(5000);
            driver.close();

        }

    }
}


