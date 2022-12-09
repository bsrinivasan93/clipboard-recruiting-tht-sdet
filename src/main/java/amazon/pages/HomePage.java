package amazon.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Page class representing the Amazon Home page
 */
@Slf4j
public class HomePage extends BasePage {
    final String HOME_PAGE_TITLE = config.getString("HOME_PAGE_TITLE");
    By pageContentLocator = By.id("pageContent");
    public Header header;

    public HomePage(WebDriver driver) {
        super(driver);
        header = new Header(driver);
        wait = new WebDriverWait(driver, NORMAL_WEBDRIVERWAIT_TIMEOUT_IN_DURATION);

        wait.until(//and(titleIs(HOME_PAGE_TITLE), -> commented cos page title keeps changing
                visibilityOfElementLocated(pageContentLocator));
    }
}
