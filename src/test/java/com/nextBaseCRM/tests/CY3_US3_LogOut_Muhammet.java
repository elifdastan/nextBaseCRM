package com.nextBaseCRM.tests;

import com.nextBaseCRM.utilities.BrowserUtils;
import com.nextBaseCRM.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Arrays;

public class CY3_US3_LogOut_Muhammet extends TestBase {

    @Test
    public void logOut_test() {
    //checking each username with same password using for each loop
        ArrayList<String> users = new ArrayList<>();

        users.addAll(Arrays.asList("helpdesk7@cydeo.com", "hr8@cydeo.com", "marketing9@cydeo.com"));

        for (String eachUser : users) {

            CRM_Utilities.crm_login(driver, eachUser, "UserUser");

            //locate user profile name field on a home page and click on it
            WebElement profileMenu = driver.findElement(By.xpath("//div[@id='user-block']"));
            profileMenu.click();
            //after the clicking on user profile name the pop-up menu appears
            //wait 2 sec
            BrowserUtils.sleep(2);
            //on the pop-up menu locate the 'Log out' option and click on it
            WebElement logOutClick = driver.findElement(By.xpath("//span[.='Log out']"));
            logOutClick.click();
            //verification od driver is back to the 'Log in' page
            String expectedLoginPageTitle = "Authorization";
            String actualLoginPageTitle = driver.getTitle();
            Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle,
                    "Login page title verification is failed");

        }
       //wait 2 sec and push the 'back' arrow
        BrowserUtils.sleep(2);
        driver.navigate().back();
      ///verify that driver is on the same 'Log in' page even after pushing the 'back' arrow
        String expectedLoginPageTitle = "Authorization";
        String actualLoginPageTitle = driver.getTitle();
        Assert.assertEquals(actualLoginPageTitle, expectedLoginPageTitle,
                "Login page title verification is failed");

    }
}
