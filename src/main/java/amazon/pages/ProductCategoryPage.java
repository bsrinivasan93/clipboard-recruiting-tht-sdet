package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Page class representing any product category page
 * L1 category(Eg: Home Theater, TV & Video)
 *      |
 *      ---------->L2 category(Eg: Televisions)
 */
public class ProductCategoryPage extends BasePage {
    public ProductCategoryPage() {
        wait = new WebDriverWait(driver, NORMAL_WEBDRIVERWAIT_TIMEOUT_IN_DURATION);

        wait.until(visibilityOfElementLocated(leftNavMenu));
    }

    By leftNavMenu = By.cssSelector("div.apb-browse-left-nav");
    By highlightedCategoryName = By.cssSelector("span.a-size-base.a-color-base.apb-browse-refinements-indent-1.a-text-bold");
}
