package dpg.assignment.config;

import com.vimalselvam.testng.listener.ExtentTestNgFormatter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.util.Date;

public class testBaseConfig {
    protected static WebDriver driver;

    @BeforeSuite
    public void setUp() {
        System.setProperty("webdriver.chrome.driver",
                "./src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }

    @AfterMethod
    public void screenshotOnFailure(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            String filename = "volkskrantTest-" + new Date().toString();
            File scr = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scr, new File("./test-output/screenshotOnFailure/" + filename + ".png"));
            if (ExtentTestNgFormatter.getInstance() != null) {
                ExtentTestNgFormatter.getInstance().addScreenCaptureFromPath(result, "img/" + filename + ".png");
            }
        }
    }

    @AfterSuite
    public void tearDown() {
        driver.navigate().to("https://www.volkskrant.nl/logout");
        driver.quit();
    }
}