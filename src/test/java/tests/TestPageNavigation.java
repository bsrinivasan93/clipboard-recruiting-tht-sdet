package tests;

import amazon.config.EnvFactory;
import amazon.factories.DriverFactory;
import amazon.pages.HomePage;
import com.typesafe.config.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;

public class TestPageNavigation {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private WebDriver driver = DriverFactory.getDriver();

    @Tag("amazonTest")
    @DisplayName("Test page navigation from Homepage -> Product Category page -> Product Description page")
    @Test
    void assertPageNavigation() {
        driver.get(HOME_PAGE_URL);
        HomePage homePage = new HomePage(driver);
        homePage.header.performCategoryNavigationFromSideMenu("TV, Appliances, Electronics","Televisions");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
