package pages;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selenide.*;

public class SearchResultsPage extends BasePage {
    public static final String URL = "https://www.booking.com/searchresults.en-gb.html";
    public static final By SEARCH_FIELD = By.id("ss");
    public static final By SEARCH_BUTTON = By.cssSelector(".sb-searchbox__button");
    public static final By HOTELS_NAMES = By.cssSelector(".sr-hotel__name ");
    public static final String HOTEL_RATING = "//*[contains(text(),'%s')]/ancestor::*[@class='sr_property_block_main_row']/descendant::*[@class='bui-review-score__badge']";

    @Override
    public SearchResultsPage openPage() {
        open(URL);
        return this;
    }

    @Override
    public SearchResultsPage isPageOpened() {
        $(SEARCH_FIELD).waitUntil(Condition.visible, 10000);
        return this;
    }

    public SearchResultsPage input(String hotelName) {
        $(SEARCH_FIELD).click();
        $(SEARCH_FIELD).sendKeys(hotelName);
        return this;
    }

    public SearchResultsPage clickSearchButton() {
        $(SEARCH_BUTTON).click();
        return this;
    }

    public List<String> getHotelsNames() {
        $(HOTELS_NAMES).waitUntil(Condition.visible, 10000);
        return $$(HOTELS_NAMES).texts();
    }

    public String getHotelRating(String hotelName) {
        return $(By.xpath(String.format(HOTEL_RATING, hotelName))).getText().trim();
    }
}
