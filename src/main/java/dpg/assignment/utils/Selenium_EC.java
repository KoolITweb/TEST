package dpg.assignment.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class Selenium_EC {

    protected static long timeoutInSecs = 10;

    public static WebElement elementPresence (WebDriver driver, By elementLocator){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecs);
        WebElement element = wait.until(
                ExpectedConditions.presenceOfElementLocated(elementLocator));
        return element;
    }

    public static WebElement elementClicakble (WebDriver driver, By elementLocator){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecs);
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(elementLocator));
        return element;
    }

    public static WebElement elementVisible (WebDriver driver, By elementLocator){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecs);
        WebElement element = wait.until(
                ExpectedConditions.visibilityOfElementLocated(elementLocator));
        return element;
    }

    public static List<WebElement> allElementsPresent (WebDriver driver, By elementLocator){
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecs);
        List<WebElement> element = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(elementLocator));
        return element;
    }

    public static int allElementsCount (WebDriver driver, By elementLocator) {
        WebDriverWait wait = new WebDriverWait(driver, timeoutInSecs);
        int element = wait.until(
                ExpectedConditions.presenceOfAllElementsLocatedBy(elementLocator)).size();
        return element;
    }
}

