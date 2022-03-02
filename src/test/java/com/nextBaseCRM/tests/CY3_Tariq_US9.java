package com.nextBaseCRM.tests;

import com.nextBaseCRM.utilities.CRM_Utilities;
import com.nextBaseCRM.utilities.ConfigurationReader;
import com.nextBaseCRM.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class CY3_Tariq_US9 {
    public WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void afterMethod() {
        //  driver.close();
    }

    @Test
    // using Configuration.properties to set up the environment
    public void US009() throws InterruptedException {
        driver.get(ConfigurationReader.getProperty("env"));
        CRM_Utilities.crm_login(driver, ConfigurationReader.getProperty("username"), ConfigurationReader.getProperty("password"));
        driver.findElement(By.xpath("//span[@class='menu-favorites-more-text']")).click();

        // Expected results stored in the arrayList
        List<String> allModules = new ArrayList<>(Arrays.asList("Portal", "Site map", "Chat and Calls", "Workgroup", "Site map", "Site map", "Mail", "Contact Center", "Absence", "Company Structure", "Meeting Rooms", "Company"));

        // By loop to find the elements and get the title to compare with Expected results
        for (int i = 0; i <= 11; i++) {
            Thread.sleep(1000);
            WebElement activity = driver.findElement(By.xpath("(//span[@class='menu-item-link-text'])[(" + (i + 1) + ")]"));
            activity.click();

            //Special treatment when tab is at Chat and Calls.
            if (driver.getTitle().contains("Chat and Calls")) {
                Assert.assertEquals(driver.getTitle(), allModules.get(i));
                driver.findElement(By.xpath("//a[@class='bx-im-fullscreen-popup-back-link']")).click();
            } else {
                Thread.sleep(1000);
                // Assert to pass the Automation test.
                Assert.assertTrue(driver.getTitle().contains(allModules.get(i)));
            }
        }
    }

}


