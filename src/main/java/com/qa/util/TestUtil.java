package com.qa.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
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


    public String get_screen_shot(String testCaseName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File file = new File(System.getProperty("user.dir")+"//report//"+ testCaseName + ".png");
        try {
            FileUtils.copyFile(source, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Screen shot saved successfully");
        return System.getProperty("user.dir")+"//report//"+ testCaseName + ".png";
    }

    public String get_screen_shot_BASE(String testCaseName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        String base64Code = ts.getScreenshotAs(OutputType.BASE64);
        System.out.println("Screen shot saved successfully");
        return base64Code;
    }


}
