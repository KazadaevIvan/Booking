package tests;

import com.codeborne.selenide.Configuration;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.SearchResultsPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

@CucumberOptions(
        features = {"classpath:features"},
        glue = "steps",
        plugin = {"pretty", "html:target/cucumber.html",
                "json:target/cucumber.json"}
)

public class BookingSearchTest extends AbstractTestNGCucumberTests {
    SearchResultsPage searchResultsPage;

    @BeforeMethod
    public void setUp() {
        Configuration.browser = "chrome";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        Configuration.headless = true;
        searchResultsPage = new SearchResultsPage();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
