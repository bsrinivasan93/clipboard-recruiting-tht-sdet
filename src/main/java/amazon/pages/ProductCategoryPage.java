package amazon.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Page class representing any product category page
 * L1 category(Eg: Home Theater, TV & Video)
 *      |
 *      ---------->L2 category(Eg: Televisions)
 */
@Slf4j
public class ProductCategoryPage extends BasePage {
    public ProductCategoryPage() {
        wait = new WebDriverWait(driver, NORMAL_WEBDRIVERWAIT_TIMEOUT_IN_DURATION);

        wait.until(visibilityOfElementLocated(leftNavMenu));
    }

    By leftNavMenu = By.cssSelector("div.apb-browse-left-nav");
    By highlightedCategoryName = By.cssSelector("span.a-size-base.a-color-base.apb-browse-refinements-indent-1.a-text-bold");
    By filterSections = By.cssSelector("#s-refinements div.a-section.a-spacing-none");
        //children of filterSection
        By sectionName = By.cssSelector("div.a-spacing-small span.a-text-bold");
        By sectionOptions = By.cssSelector("ul.a-unordered-list li span.a-list-item");


    /**
     * Returns the name of the highlighted category name from left nav
     * @return the category name
     */
    public String getHighlightedCategoryName() {
        return elementBy(highlightedCategoryName).getText();
    }

    /**
     * Finds the filter by name & clicks on the option by name
     * @param filterName section name of filter
     * @param optionName name of option
     */
    public void filterByOption(String filterName, String optionName) {
        try {
            WebElement filterSection = elementsBy(filterSections)
                    .stream()
                    .filter(section -> section.findElement(sectionName).getText().equals(filterName))
                    .findFirst()
                    .orElseThrow();
            scrollToElement(filterSection);

            WebElement filterOption = filterSection.findElements(sectionOptions)
                    .stream()
                    .filter(option -> option.getText().equals(optionName))
                    .findFirst()
                    .orElseThrow();

            click(filterOption);
        } catch (NoSuchElementException e) {
            throw new IllegalArgumentException(String.format("\ninvalid arguments: filterName %s optionName %s exception %s", filterName, optionName, e.getMessage()));
        }
    }
}
