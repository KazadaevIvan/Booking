package steps;

import com.codeborne.selenide.Configuration;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchResultsPage;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.testng.Assert.assertEquals;

public class BookingSteps {
    private String hotelName;
    private SearchResultsPage searchResultsPage;

    @Before
    public void setUp() {
        Configuration.browser = "firefox";
        Configuration.startMaximized = true;
        Configuration.timeout = 10000;
        Configuration.headless = true;
        searchResultsPage = new SearchResultsPage();
    }

    @Given("User is looking for hotels like {string}")
    public void userIsLookingForHotelsLike(String hotelName) {
        this.hotelName = hotelName;
    }

    @When("User does search")
    public void userDoesSearch() {
        searchResultsPage
                .openPage()
                .isPageOpened()
                .input(hotelName)
                .clickSearchButton();
    }

    @Then("Hotel {string} should be on the first page")
    public void hotelShouldBeOnTheFirstPage(String expectedName) {
        assertThat(searchResultsPage.getHotelsNames(), hasItem(expectedName));
    }

    @And("Rating of the hotel is {string}")
    public void ratingOfTheHotelIs(String expectedRating) {
        assertEquals(searchResultsPage.getHotelRating(hotelName), expectedRating);
    }

    @After
    public void tearDown() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
        }
    }
}
