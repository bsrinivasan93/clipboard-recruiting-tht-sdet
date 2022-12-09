package amazon.pages;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.NoSuchElementException;

import static org.openqa.selenium.support.ui.ExpectedConditions.and;
import static org.openqa.selenium.support.ui.ExpectedConditions.numberOfElementsToBeMoreThan;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

/**
 * Page class representing top navbar component
 * (that contains hamburger menu, zipcode, sign-in, etc.)
 */
@Slf4j
public class Header extends BasePage {
    By sectionLocator = By.id("navbar");

    public Header() {
        wait = new WebDriverWait(driver, NORMAL_WEBDRIVERWAIT_TIMEOUT_IN_DURATION);

        wait.until(visibilityOfElementLocated(sectionLocator));
    }

    //Hamburger menu
    By sideMenuIcon = By.id("nav-hamburger-menu");
    By sideBar = By.id("hmenu-canvas");
    By sideBarLinks = By.cssSelector("#hmenu-canvas .hmenu-item");
    By sideBarBackLink = By.cssSelector("#hmenu-canvas ul.hmenu-visible li a.hmenu-back-button");

    /**
     * Helper method to filter the category links by name, and click on it
     * @param categoryName the category name to find
     */
    private void filterAndClickCategoryLink(String categoryName) {
        try {
            WebElement categoryLink = elementsBy(sideBarLinks)
                    .stream()
                    .filter(link -> link.getText().equals(categoryName))
                    .findFirst()
                    .orElseThrow();

            click(categoryLink);
        } catch (NoSuchElementException e) {
            log.error("invalid argument: " + e.getMessage());
        }
    }

    /**
     * Performs two levels of category navigation from the side-menu
     * @param l1CategoryName name of the first category
     * @param l2CategoryName name of the second category
     * @return the {@link ProductCategoryPage} navigated to
     */
    public ProductCategoryPage performCategoryNavigationFromSideMenu(String l1CategoryName, String l2CategoryName) {
        click(sideMenuIcon);
        wait.until(and(visibilityOfElementLocated(sideBar),
                numberOfElementsToBeMoreThan(sideBarLinks, 0)));

        filterAndClickCategoryLink(l1CategoryName);
        wait.until(visibilityOfElementLocated(sideBarBackLink));
        filterAndClickCategoryLink(l2CategoryName);

        return new ProductCategoryPage();
    }

}
