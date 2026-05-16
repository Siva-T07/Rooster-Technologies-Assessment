package com.drons;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

    public static void main(String[] args) throws Exception {

        // SETUP CHROMEDRIVER
        WebDriverManager.chromedriver().setup();

        // OPEN CHROME
        WebDriver driver = new ChromeDriver();

        // MAXIMIZE WINDOW
        driver.manage().window().maximize();

        // JAVASCRIPT EXECUTOR
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // WAIT
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));

        // OPEN WEBSITE
        driver.get("https://airline.drona-aviation.com/AccountV1/Login?ReturnUrl=%2F");

        System.out.println("Website Opened");

        Thread.sleep(5000);

        // CLICK CHANGE BUTTON
        WebElement changeBtn = wait.until(
                ExpectedConditions.elementToBeClickable(By.id("change")));

        js.executeScript("arguments[0].click();", changeBtn);

        System.out.println("Clicked Change Button");

        Thread.sleep(4000);

        // ENTER CUSTOMER CODE
        WebElement customerCode = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[contains(@class,'modal')]//input")));

        customerCode.sendKeys("RwandAir");

        System.out.println("Entered Customer Code");

        Thread.sleep(2000);

        // CLICK SAVE BUTTON
        WebElement saveBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(text(),'Save')]")));

        js.executeScript("arguments[0].click();", saveBtn);

        System.out.println("Clicked Save Button");

        // WAIT PAGE REFRESH
        Thread.sleep(12000);

        // ENTER USERNAME
        WebElement username = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.name("UsernameOrEmailAddress")));

        username.sendKeys("Siva");

        System.out.println("Username Entered");

        Thread.sleep(2000);

        // ENTER PASSWORD
        WebElement password = driver.findElement(By.id("password"));

        password.sendKeys("123qwe");

        System.out.println("Password Entered");

        Thread.sleep(2000);

        // CLICK LOGIN BUTTON
        WebElement loginBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//button[contains(.,'Login')]")));

        js.executeScript("arguments[0].click();", loginBtn);

        System.out.println("Login Button Clicked");

        // WAIT NEXT PAGE
        Thread.sleep(10000);

        // CLICK FINAL OK BUTTON
        WebElement okBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("confirmSaveBtn")));

        js.executeScript("arguments[0].click();", okBtn);

        System.out.println("Final OK Button Clicked");

        Thread.sleep(5000);

        // CLICK ☰ MENU
        WebElement menuBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(text(),'☰')]")));

        js.executeScript("arguments[0].click();", menuBtn);

        System.out.println("Menu Clicked");

        Thread.sleep(4000);

        // CLICK REQUEST FOR QUOTATION
        WebElement rfqMenu = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(text(),'Request for Quotation')]")));

        js.executeScript("arguments[0].click();", rfqMenu);

        System.out.println("RFQ Menu Clicked");

        Thread.sleep(5000);

        // CLICK ENQUIRY QUEUE LIST
        WebElement enquiryQueue = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(text(),'Enquiry Queue List')]")));

        js.executeScript("arguments[0].click();", enquiryQueue);

        System.out.println("Enquiry Queue List Clicked");

        // WAIT PAGE LOAD
        Thread.sleep(15000);

        // SCROLL DOWN
        js.executeScript("window.scrollBy(0,500)");

        System.out.println("Page Scrolled");

        Thread.sleep(5000);

        // HORIZONTAL SCROLL RIGHT
        WebElement scrollArea = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//div[contains(@class,'shipment-card')])[1]")));

        js.executeScript("arguments[0].scrollLeft=1000;", scrollArea);

        System.out.println("Scrolled Right Side");

        Thread.sleep(4000);

        // STORE REQUESTED RATE VALUE
        WebElement requestedRate = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("(//td[contains(@class,'Request_rate')])[1]")));

        String requestValue = requestedRate.getText().trim();

        System.out.println("Stored Requested Rate Value = " + requestValue);

        Thread.sleep(3000);

        // CLICK RESPONSE BUTTON
        WebElement responseBtn = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//span[contains(text(),'Response')]")));

        js.executeScript("arguments[0].click();", responseBtn);

        System.out.println("Response Button Clicked");

        Thread.sleep(8000);

        // ENTER SAME VALUE INTO OFFERED RATE
        WebElement offeredRate = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.id("Offered_Rate")));

        offeredRate.clear();

        offeredRate.sendKeys(requestValue);

        System.out.println("Offered Rate Entered = " + requestValue);

        Thread.sleep(3000);

        // CLICK SAVE BUTTON
        WebElement finalSaveButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("saveButton")));

        js.executeScript("arguments[0].click();", finalSaveButton);

        System.out.println("Final Save Button Clicked");

        Thread.sleep(5000);

        // CLICK FINAL CONFIRM OK BUTTON
        WebElement confirmOkButton = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.id("confirmButton")));

        js.executeScript("arguments[0].click();", confirmOkButton);

        System.out.println("Final Confirm OK Button Clicked");

        Thread.sleep(5000);

        // PRINT CURRENT URL
        System.out.println(driver.getCurrentUrl());

        // CLOSE BROWSER
        // driver.quit();
    }
}