package com.nextBaseCRM.utilities;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

import static org.testng.Assert.assertTrue;

//In this class only general utility methods that are not related to some specific page.
public class BrowserUtils {


    /*
    This method will accept int (in seconds) and execute Thread.sleep
    for given duration
     */
    public static void sleep(int second){
        second *=1000;
        try {
            Thread.sleep(second);
        }catch (InterruptedException e ) {

        }
    }

    /*
       This method accepts 3 arguments.
       Arg1: webdriver
       Arg2: expectedInUrl : for verify if the url contains given String.
           - If condition matches, will break loop.
       Arg3: expectedInTitle to be compared against actualTitle
        */
    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedInTitle){

        Set<String> allWindowsHandles = driver.getWindowHandles();

        for (String each : allWindowsHandles) {
            driver.switchTo().window(each);
            System.out.println("Current URL = " + driver.getCurrentUrl());

            if(driver.getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        //5. Assert:Title contains “Etsy”
        String actualTittle = driver.getTitle();

        assertTrue(actualTittle.contains(expectedInTitle));

    }


    //This method accept s String "expectedTitle" and Asserts If it is true
    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

}
