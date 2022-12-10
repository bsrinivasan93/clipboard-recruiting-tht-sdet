package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.and;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Page class representing the product search/filter results page
 */
public class ProductSearchResultsPage extends BasePage {
    public ProductSearchResultsPage() {
        wait = new WebDriverWait(driver, NORMAL_WEBDRIVERWAIT_TIMEOUT_IN_DURATION);

        wait.until(and(visibilityOfElementLocated(pageContent),
                visibilityOfElementLocated(resultsInfoBar)));
    }

    By pageContent = By.id("search");
    By resultsInfoBar = By.cssSelector("span[data-component-type='s-result-info-bar']");
    By sortDropdownContainer = By.className("a-dropdown-container");
    By sortDropdown = By.id("s-result-sort-select");
    By searchResultsLocator = By.cssSelector("div[data-component-type='s-search-result']");


    /**
     * Selects the target sort option from results drop down menu
     * @param sortOption target sort option text
     */
    public void sortByText(String sortOption) {
        click(sortDropdownContainer);

        selectByText(elementBy(sortDropdown), sortOption);
    }

    /**
     * clicks on search result at index
     * @param index the index
     */
    public void clickOnSearchResult(int index) {
        List<WebElement> searchResults = elementsBy(searchResultsLocator);
        if(index >= searchResults.size())
            throw new IllegalArgumentException(String.format("invalid index %d for size %d", index, searchResults.size()));

        click(searchResults.get(index));
    }
}
