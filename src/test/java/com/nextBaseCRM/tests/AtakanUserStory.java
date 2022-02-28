package com.nextBaseCRM.tests;

import com.nextBaseCRM.utilities.CRM_Utilities;
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
import java.util.concurrent.TimeUnit;

public class AtakanUserStory {

    @Test
    public void creatTaskSuccesfully() throws InterruptedException{

            String dataSample="Text sample";
            ArrayList<String> userNames = new ArrayList<>();
            userNames.addAll(Arrays.asList("hr7@cydeo.com"/* "helpdesk7@cydeo.com", "marketing7@cydeo.com"*/));



        for (String each : userNames) {


           WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            driver.get("https://login2.nextbasecrm.com");

            CRM_Utilities.crm_login(driver, each, "UserUser");

            WebElement taskButton= driver.findElement(By.xpath("(//span[.='Task'])[2]"));

            System.out.println("taskButton.isDisplayed() = " + taskButton.isDisplayed());

            taskButton.click();

           WebElement taskInfoSection= driver.findElement(By.xpath("//div[@class='task-info']"));

           System.out.println("taskInfoSection = " + taskInfoSection.isDisplayed());

            WebElement titleInputBox= driver.findElement(By.xpath("//input[@data-bx-id='task-edit-title']"));
            titleInputBox.sendKeys(dataSample);
            Thread.sleep(2000);
            System.out.println("title Sample = " + dataSample);

            driver.switchTo().frame(driver.findElement(By.xpath("//div[@id='bx-html-editor-iframe-cnt-lifefeed_task_form']//iframe")));
            WebElement messageInputBox=  driver.findElement(By.xpath("//*[@contenteditable='true']"));
            messageInputBox.click();
            messageInputBox.sendKeys(dataSample);
            driver.switchTo().parentFrame();

            System.out.println("message Sample = " + dataSample);

            WebElement sendBtn= driver.findElement(By.xpath("(//button[.='Send'])[4]"));
            sendBtn.click();

            WebElement TaskDisplayed = driver.findElement(By.xpath("(//div[contains(@id,'feed-post-contentview-')])[1]"));
            Assert.assertTrue(TaskDisplayed.isDisplayed());

            WebElement popUpBox= driver.findElement(By.xpath("//div[@id='blogPostEditCreateTaskPopup']"));

            System.out.println("popUpBox.isDisplayed() = " + popUpBox.isDisplayed());





            Assert.assertTrue( popUpBox.getText().contains("Task has been created"),"Display message not matched");




          Thread.sleep(3000);

          driver.close();


        }


    }


    @Test
    public void creat_Task_Without_title()throws InterruptedException{
        String dataSample="Text sample";
        ArrayList<String> userNames = new ArrayList<>();
        userNames.addAll(Arrays.asList("hr7@cydeo.com"/* "helpdesk7@cydeo.com", "marketing7@cydeo.com"*/));

        for (String each : userNames) {


            WebDriver driver = WebDriverFactory.getDriver("chrome");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


            driver.get("https://login2.nextbasecrm.com");

            CRM_Utilities.crm_login(driver, each, "UserUser");

            WebElement taskButton = driver.findElement(By.xpath("(//span[.='Task'])[2]"));

            System.out.println("taskButton.isDisplayed() = " + taskButton.isDisplayed());

            taskButton.click();

            WebElement taskInfoSection = driver.findElement(By.xpath("//div[@class='task-info']"));

            System.out.println("taskInfoSection = " + taskInfoSection.isDisplayed());

            WebElement sendBtn= driver.findElement(By.xpath("(//button[.='Send'])[4]"));
            sendBtn.click();



            WebElement warningMessage=driver.findElement(By.xpath("//div[@class='task-message-label error']"));
            System.out.println("warningMessage.isDisplayed() = " + warningMessage.isDisplayed());
            String actualMessage=warningMessage.getText();
            String expectedMessage="The task name is not specified.";
            Assert.assertEquals(actualMessage,expectedMessage);

            Thread.sleep(3000);

            driver.close();




        }
    }
}






/*      System.out.println("popUpWindow.isDisplayed() = " + popUpWindow.isDisplayed());

            Boolean actuallPop=popUpWindow.getText().contains("Task has been created");
            System.out.println(actuallPop);

       /*
            WebElement popUpWindow=driver.findElement(By.xpath("//div[.='Appreciation message Test']"));

            String actualTxt=popUpWindow.getText();
            String expectedTxT="Task has been created";

            Assert.assertEquals(actualTxt,expectedTxT);

             *//*
        WebElement messageInputBox=  driver.findElement(By.xpath("//*[@contenteditable='true']"));
        messageInputBox.sendKeys(dataSample);
        */