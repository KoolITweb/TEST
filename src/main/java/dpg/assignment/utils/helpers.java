package dpg.assignment.utils;

import dpg.assignment.config.testBaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class helpers extends testBaseConfig {

    public void acceptCookiesCheck() {
         WebElement cookie = Selenium_EC.elementPresence(driver, By.id("sp_message_iframe_257073"));
         driver.switchTo().frame(cookie);
         Selenium_EC.elementPresence(driver, By.cssSelector("button[title='Ja, prima']")).click();
         driver.switchTo().defaultContent();
    }
}
