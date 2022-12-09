package amazon.pages;

import amazon.config.EnvFactory;
import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

/**
 * Base class for all page classes.
 * Helper class for common driver-operations(click, type, etc.)
 */
@Slf4j
public class BasePage {
    protected static Config config = EnvFactory.getInstance().getConfig();

    private WebDriver driver;

    protected WebDriverWait wait;

    protected final Duration NORMAL_WEBDRIVERWAIT_TIMEOUT_IN_DURATION = Duration.ofSeconds(20);

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Find web element identified by locator
     * @param locator {@link By} locator
     * @return a {@link WebElement}
     */
    protected WebElement elementBy(By locator) {
        return driver.findElement(locator);
    }

    /**
     * Find web elements identified by locator
     * @param locator {@link By} locator
     * @return list of {@link WebElement}
     */
    protected List<WebElement> elementsBy(By locator) {
        return driver.findElements(locator);
    }

    /**
     * Clicks an element
     * @param element {@link WebElement}
     */
    protected void click(WebElement element) {
        element.click();
    }

    /**
     * Clicks an element
     * @param locator {@link By} locator for webelement
     */
    protected void click(By locator) {
        click(elementBy(locator));
    }
}
