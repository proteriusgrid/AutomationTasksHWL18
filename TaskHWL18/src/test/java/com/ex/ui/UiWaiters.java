package com.ex.ui;

import com.ex.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UiWaiters extends BaseTest {
    private WebElement findElement(By locator) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(5))
            .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement waitForElementToBeClickable(By locator) {
        return new WebDriverWait(webDriver, Duration.ofSeconds(5))
            .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView(true);", element);
    }


    @Test
    public void implicitTest() {
        webDriver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
        webDriver.findElement(By.xpath("//input[@id='email_create']")).sendKeys("someemail1@email.com");
        webDriver.findElement(By.xpath("//span[contains(., 'Create an account')]")).click();

        new WebDriverWait(webDriver, Duration.ofSeconds(5)).
        until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(., 'Register')]")));

        Wait<WebDriver> waiter = new FluentWait<>(webDriver)
            .withTimeout(Duration.ofSeconds(4))
            .pollingEvery(Duration.ofSeconds(1));

        waiter.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(., 'Register')]"))).click();
        System.out.println();
    }

    @Test
    public void newTab() {
        webDriver.get("https://www.gurock.com/testrail/");
        WebElement w = waitForElementToBeClickable(By.xpath("//a[contains(., 'Legal')]"));
        scrollToElement(w);
        w.click();

        List<String> tabs = new ArrayList<>(webDriver.getWindowHandles());
        webDriver.switchTo().window(tabs.get(1));
        findElement(By.xpath("//a[@id='ui-id-2']")).click();
        System.out.println();
    }
}
