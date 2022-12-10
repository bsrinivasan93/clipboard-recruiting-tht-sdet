package amazon.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Page class representing a product description page
 */
public class ProductDescriptionPage extends BasePage {
    public ProductDescriptionPage() {
        wait = new WebDriverWait(driver, NORMAL_WEBDRIVERWAIT_TIMEOUT_IN_DURATION);

        wait.until(visibilityOfElementLocated(pageContent));
    }

    By pageContent = By.id("dp-container");
    By aboutItemSection = By.id("featurebullets_feature_div");

    /**
     * Checks if About the Item section is present
     * @return true or false
     */
    public boolean isAboutItemSectionPresent() {
        return isElementPresent(aboutItemSection);
    }

    /**
     * Returns the content of the About the Item section
     * @return string text of section
     */
    public String getAboutItemSectionContent() {
        return elementBy(aboutItemSection).getText();
    }
}
