package dpg.assignment.pages;

import dpg.assignment.utils.Selenium_EC;
import dpg.assignment.config.testBaseConfig;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;


public class homePage extends testBaseConfig {
    By logout = By.cssSelector(".menu-list__item-link[tentacle-id='12e845a0088c36296734-7e");
    By closeServiceMenu = By.className("menu-close-icon");
    By footerMenus = By.className("app-footer__title");
    By footerMenuTopics = By.className("app-footer__list-link");
    By serviceMenu = By.className("app-header-home__menu-hamburger");


    public void openServiceMenu(){
        Selenium_EC.elementPresence(driver, serviceMenu).click();
    }

    public void closeServiceMenu() {
        WebElement closeMenu = Selenium_EC.elementClicakble(driver, closeServiceMenu);
        closeMenu.click();
    }

    public String loggedInText(){
        return Selenium_EC.elementVisible(driver, logout).getText();
    }

    public String getFootTitles(){
        List<String> titles = new ArrayList<String>();
        for ( WebElement footerMenu: Selenium_EC.allElementsPresent(driver, footerMenus))
        {
            String title = footerMenu.getText();
            titles.add(title);
        }
        return titles.toString();
    }

    public String deeplinkCheck() {
        List<String> NoDeeplinkList = new ArrayList<String>();
        for ( WebElement footerMenu: Selenium_EC.allElementsPresent(driver, footerMenuTopics)) {
            if (footerMenu.getAttribute("href") != null) {
                //Nothing to be done here
            } else {
                String footerSubmenuTitle = footerMenu.getText();
                NoDeeplinkList.add(footerSubmenuTitle);
            }
        }
        return NoDeeplinkList.toString();
    }
}