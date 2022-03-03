package com.nextBaseCRM.tests;

import com.nextBaseCRM.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

    public class CY3_2_CheckBox extends TestBase {


        @Test
        public void checkBoxRememberMe_Test1() {

            WebElement rememberPasswordCheckBox = driver.findElement(By.id("USER_REMEMBER"));


            Boolean CheckBoxDispl = rememberPasswordCheckBox.isDisplayed();

            Assert.assertTrue(CheckBoxDispl, "CheckBox are not displaying");

        }

        @Test
        public void checkBoxRememberMe_Test2() {

//5. Locate Text "Remember me on this computer"
            WebElement checBoxText = driver.findElement(By.xpath("//label[@class='login-item-checkbox-label']"));


            String expectedCheckBoxText = "Remember me on this computer";
            String actualCheckBoxText = checBoxText.getText();
            Assert.assertEquals(actualCheckBoxText, expectedCheckBoxText, "CheckBox text verification FAILED!!!");

        }

    }
