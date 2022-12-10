package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

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

    /**
     * Selects the target sort option from results drop down menu
     * @param sortOption target sort option text
     */
    public void sortByText(String sortOption) {
        click(sortDropdownContainer);

        selectByText(elementBy(sortDropdown), sortOption);
    }
}
