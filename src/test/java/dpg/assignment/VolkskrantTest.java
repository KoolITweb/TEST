package dpg.assignment;

import dpg.assignment.config.testBaseConfig;
import dpg.assignment.pages.*;
import dpg.assignment.utils.helpers;
import org.testng.Assert;
import org.testng.annotations.Test;


public class VolkskrantTest extends testBaseConfig {
    homePage HomePage = new homePage();
    loginPage LoginPage = new loginPage();
    searchPage SearchPage = new searchPage();
    helpers Helpers = new helpers();

    @Test
    public void loginToVolkskrant() throws InterruptedException {
        driver.get("https://www.volkskrant.nl/login");
        Helpers.acceptCookiesCheck();
        LoginPage.userLogin("volkskranttest@gomaild.com","Volkskrant123!");
        HomePage.openServiceMenu();
        Assert.assertEquals(HomePage.loggedInText(), "Uitloggen\nvolkskranttest@gomaild.com");
        HomePage.closeServiceMenu();
    }

    @Test
    public void searchArticle() {
        String SEARCHTERM = "Vijf nieuwe eredivisiespelers om op te letten";
        SearchPage.searchArticle(SEARCHTERM);
        Assert.assertEquals(SearchPage.articleSearchResultsAmount(), "1");
        SearchPage.openArticleFromSearch(SEARCHTERM);
        Assert.assertTrue(SearchPage.getArticleIntroText().contains("Welke nieuwelingen gaan verrassen in het eredivisieseizoen"));
    }

    @Test
    public void verifyMenuDeeplinks() {
        Assert.assertEquals(HomePage.getFootTitles(), "[Algemeen, Service, Meer de Volkskrant, Navigeer]");
        Assert.assertEquals(HomePage.deeplinkCheck(), "[]");
    }
}