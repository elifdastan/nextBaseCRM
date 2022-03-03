package com.nextBaseCRM.tests;

import com.nextBaseCRM.utilities.CRM_Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CY3_US13_Bob extends TestBase{
    @Test
    public void users_make_Appreciation_successfully(){
        ArrayList<String> userNames=new ArrayList<>();
        userNames.addAll(Arrays.asList("hr8@cydeo.com","helpdesk8@cydeo.com","marketing8@cydeo.com"));
        for (String each : userNames) {
            CRM_Utilities.crm_login(driver,each,"UserUser");

            WebElement moreBtn=driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
            moreBtn.click();

            WebElement appreciationBtn= driver.findElement(By.xpath("//span[@class='menu-popup-item-text' and .='Appreciation']"));
            appreciationBtn.click();
            WebElement iframeElm=driver.findElement(By.xpath("//iframe[@class='bx-editor-iframe']"));

            driver.switchTo().frame(iframeElm);

            WebElement appreciationBox= driver.findElement(By.xpath("//body[@contenteditable='true']"));
            appreciationBox.sendKeys("Appreciation message Test");

            driver.switchTo().defaultContent();

            WebElement sendBtn=driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));

            sendBtn.click();

            WebElement appreciation=driver.findElement(By.xpath("//div[.='Appreciation message Test']"));

            String actualTxt=appreciation.getText();
            String expectedTxT="Appreciation message Test";

            Assert.assertEquals(actualTxt,expectedTxT);
            driver.findElement(By.xpath("//span[@id='user-name']")).click();
            driver.findElement(By.xpath("//span[.='Log out']")).click();
        }

    }

    @Test
    public void users_create_Appreciation_without_content() throws InterruptedException {

        ArrayList<String> userNames=new ArrayList<>();
        userNames.addAll(Arrays.asList("hr8@cydeo.com","helpdesk8@cydeo.com","marketing8@cydeo.com"));
        for (String each : userNames) {


            CRM_Utilities.crm_login(driver,each,"UserUser");

            WebElement moreBtn = driver.findElement(By.xpath("//span[@id='feed-add-post-form-link-text']"));
            moreBtn.click();

            WebElement appreciationBtn = driver.findElement(By.xpath("//span[@class='menu-popup-item-text' and .='Appreciation']"));
            appreciationBtn.click();

            WebElement sendBtn = driver.findElement(By.xpath("//button[@id='blog-submit-button-save']"));
            sendBtn.click();

            String actualTxt = driver.findElement(By.xpath("//span[.='The message title is not specified']")).getText();
            String expectedTxt = "The message title is not specified";

            Assert.assertEquals(actualTxt, expectedTxt);
            driver.findElement(By.xpath("//span[@id='user-name']")).click();
            driver.findElement(By.xpath("//span[.='Log out']")).click();


        }



    }
}
