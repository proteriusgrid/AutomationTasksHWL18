package com.ex.ui;

import com.ex.BaseTest;
import com.ex.Main;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SmokeUiSuite extends BaseTest {

    public static final String emailAddrField = "//input[@id='reg_email']";

    public static final String passwordField = "//input[@id='reg_password']";

    public static final String registerButton  = "//input[contains(@value,'Register')]";

    public static final String logoutButton  = "//li[contains(.,'Logout')]";
    public static final String  logoutBtn="//a[contains(.,'Logout')]";

    public static final String textError  = "//li[contains(.,'Error: An account is already registered with your email address. Please login.')]";


    @Test
    public void firstTest() {

        webDriver.manage().window().maximize();
        webDriver.get("http://practice.automationtesting.in/");
        By signIn = By.xpath("//a[contains(., 'My Account')]");
        webDriver.findElement(signIn).click();
        String rndEmail = Main.genRandomEmail();
        

//        TODO generate random email, and check register form is displayed

        webDriver.findElement(By.xpath(emailAddrField)).sendKeys(rndEmail);
        webDriver.findElement(By.xpath(passwordField)).sendKeys(Keys.chord("JABxAhbdasjhbb123nv223"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath(registerButton)).click();
        Assert.assertTrue(webDriver.findElement(By.xpath(logoutButton)).getText().equals("Logout"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        webDriver.findElement(By.xpath(logoutBtn)).click();

    }

    @Test
    public void firstTest1() {
        webDriver.manage().window().maximize();
        webDriver.get("http://practice.automationtesting.in");
        By signIn = By.xpath("//a[contains(., 'My Account')]");
        webDriver.findElement(signIn).click();

        //TODO verify that error 'email already exist' is displayed

        webDriver.findElement(By.xpath(emailAddrField)).sendKeys("qatester2@mailforspam.com");
        webDriver.findElement(By.xpath(registerButton)).click();
        Assert.assertTrue(webDriver.findElement(By.xpath(textError)).isDisplayed());

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
