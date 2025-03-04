package com.qa.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TestUtil {

    private WebDriver driver;
    static public long PAGE_LOAD_TIMEOUT = 20;
    static public long IMPLICIT_TIMEOUT = 10;

    public TestUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void wait_for_element_to_be_clickable(By element){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(element)));

    }

    public void scroll_the_screen_to_view_desired_element_using_xpath(By elementName) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // Scrolling down the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(elementName));
    }
}
