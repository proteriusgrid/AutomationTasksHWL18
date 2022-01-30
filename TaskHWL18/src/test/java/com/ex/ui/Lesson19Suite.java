package com.ex.ui;

import com.ex.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Objects;

public class Lesson19Suite extends BaseTest {
    @Test
    public void testUiContains() {
        webDriver.get("https://output.jsbin.com/osebed/2");
        Select fruit = new Select(webDriver.findElement(By.xpath("//select[@id='fruits']")));
        fruit.selectByValue("orange");
        fruit.selectByVisibleText("Grape");
        System.out.println();
    }
    @Test
    public void testUiSelect() {
        webDriver.get("https://theautomationzone.blogspot.com/");
        Select fruit = new Select(webDriver.findElement(By.xpath("//select[@id='course']")));
        fruit.selectByVisibleText("Computer Course");
        fruit.selectByVisibleText("Other Course");
        System.out.println();
    }
    @Test
    public void testUiList() {
        webDriver.get("https://parabank.parasoft.com/");
        List<WebElement> elementList = webDriver.findElements(By.xpath("//ul[@class='leftmenu']//li[not(contains(@class, 'Solutions'))]"));

        for (WebElement element: elementList) {
            if (Objects.equals(element.getText(), "Products")) {
                element.click();
            };
        }
        System.out.println();
    }

    @Test
    public void testUiRelative() {
        webDriver.get("https://parabank.parasoft.com/");

        By mainPanel = By.xpath("//div[@id='mainPanel']");
        String topPanelRelative = ".//div[@id='topPanel']/a";
        String bodyPanelRelative = ".//div[@id='bodyPanel']";
        webDriver.findElement(mainPanel).findElement(By.xpath(topPanelRelative)).click();
        System.out.println();
    }
}
