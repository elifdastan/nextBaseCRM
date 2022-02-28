package com.nextBaseCRM.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PalinaUserStory extends TestBase{

    // check

    @Test
    public void verify_title() {
         //  go on log in page
        // The login page title should be “Authorization”.

        WebElement title = driver.findElement(By.xpath("//div[@id='login-popup']/div[1]"));
        String actualTitle = title.getText();
        String expected = "Authorization";
        Assert.assertTrue(title.isDisplayed(), "Title not displayed");
        Assert.assertEquals(actualTitle, expected, "Title not match");
    }

    @Test
    public void verify_checkbox_label() {

        //  go on log in page
        // Checkbox label should be displayed on the left side of “Remember me on this computer”.

        WebElement checkBox = driver.findElement(By.xpath("//input[@id='USER_REMEMBER']"));

        Assert.assertTrue(checkBox.isDisplayed(), "Not displayed");
        WebElement message =driver.findElement(By.xpath("//label[.='Remember me on this computer']"));
        Assert.assertTrue(message.isDisplayed());
        String actualText = message.getText();
        String expectedText = "Remember me on this computer";
        Assert.assertEquals(actualText,expectedText, "Text not match");
    }

    @Test
    public void login_with_valid_credentials1() {

        // on log in  page  (Log In with valid credentials)
        //hr6@cydeo.com
        //UserUser


        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        login.sendKeys("hr6@cydeo.com");
        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");


        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();

        // verify title
        String expectedTitle = "Portal";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);


    }

    @Test
    public void login_with_valid_credentials2() {

        // Log In with valid credentials
        // helpdesk6@cydeo.com
        //UserUser

        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        login.sendKeys("helpdesk6@cydeo.com");
        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();

        String expectedTitle = "Portal";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }


    @Test
    public void login_with_valid_credentials3() {

        // Log In with valid credentials
        // marketing6@cydeo.com
        //UserUser

        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        login.sendKeys("marketing6@cydeo.com");
        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("UserUser");

        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();

        String expectedTitle = "Portal";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle);
    }


    @Test
    public void login_with_invalid_credentials() {

//     “Incorrect username or password” should be displayed
//     under the “Authorization” header when a user enters the wrong username or password.

        WebElement login = driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        login.sendKeys("marke@cydeo.com");
        WebElement password = driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        password.sendKeys("User");

        WebElement logInButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        logInButton.click();

        WebElement errorMessage = driver.findElement(By.xpath("//div[@class='errortext']"));
        Assert.assertTrue(errorMessage.isDisplayed());

        String actualMessage = driver.findElement(By.xpath("//div[@class='errortext']")).getText();
        String expectedMessage = "Incorrect username or password";

        Assert.assertEquals(actualMessage, expectedMessage, "Messages does not match");


    }


}
