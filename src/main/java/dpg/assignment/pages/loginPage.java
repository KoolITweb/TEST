package dpg.assignment.pages;

import dpg.assignment.config.testBaseConfig;
import dpg.assignment.utils.Selenium_EC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class loginPage extends testBaseConfig {

    By usernameInputField = By.id("username");
    By usernameProceedButton = By.id("loginSubmit");
    By passwordInputField = By.id("password");
    By signInButton = By.className("form__submit");

    public void userLogin(String username, String password){
        //Username password can normally be put into env variable to not have to commit them ofourse
        Selenium_EC.elementVisible(driver, usernameInputField).sendKeys(username);
        Selenium_EC.elementVisible(driver, usernameProceedButton).click();
        WebElement passwordField = Selenium_EC.elementVisible(driver, passwordInputField);
        passwordField.clear();
        passwordField.sendKeys(password);
        Selenium_EC.elementClicakble(driver, signInButton).click();
    }
}