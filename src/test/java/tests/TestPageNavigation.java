package tests;

import amazon.config.EnvFactory;
import amazon.pages.BasePage;
import amazon.pages.HomePage;
import amazon.pages.ProductCategoryPage;
import com.typesafe.config.Config;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TestPageNavigation {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");

    HomePage homePage;
    ProductCategoryPage productCategoryPage;

    @Tag("amazonTest")
    @DisplayName("Test page navigation from Homepage -> Product Category page -> Product Description page")
    @Test
    void assertPageNavigation() {
        BasePage.navigateToUrl(HOME_PAGE_URL);
        homePage = new HomePage();
        productCategoryPage =
                homePage.header.performCategoryNavigationFromSideMenu("TV, Appliances, Electronics","Televisions");
    }

    @AfterEach
    void tearDown() {
        BasePage.teardownDriver();
    }
}
