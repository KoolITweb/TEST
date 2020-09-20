package dpg.assignment.pages;

import dpg.assignment.config.testBaseConfig;
import dpg.assignment.utils.Selenium_EC;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class searchPage extends testBaseConfig {

    By searchIcon = By.className("app-header-home__menu-search-icon");
    By searchInputField = By.className("search-form__query");
    By searchSubmitButton = By.className("search-form__submit");
    By searchResultsAmount = By.className("search-results__count");
    //By searchResultsTitles = By.id("teaser__title--compact");
    //By articleAuthorTime = By.className("article-element-authors");
    By articleIntro = By.className("artstyle__intro");


    public void searchArticle(String searchTerm) {
        Selenium_EC.elementClicakble(driver, searchIcon).click();
        Selenium_EC.elementClicakble(driver, searchInputField).sendKeys(searchTerm);
        Selenium_EC.elementClicakble(driver, searchSubmitButton).click();
    }

    public void openArticleFromSearch(String articleName){
        WebElement article = Selenium_EC.elementClicakble(driver, By.cssSelector("[aria-label='"+articleName+"']"));
        article.click();
    }

    public String getArticleIntroText(){
        return Selenium_EC.elementVisible(driver, articleIntro).getText();
    }

    public String articleSearchResultsAmount(){
        return Selenium_EC.elementVisible(driver, searchResultsAmount).getText();
    }
}