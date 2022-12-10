package tests;

import amazon.config.EnvFactory;
import amazon.pages.BasePage;
import amazon.pages.HomePage;
import amazon.pages.ProductCategoryPage;
import amazon.pages.ProductDescriptionPage;
import amazon.pages.ProductSearchResultsPage;
import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class TestPageNavigation {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");

    HomePage homePage;
    ProductCategoryPage productCategoryPage;
    ProductSearchResultsPage productSearchResultsPage;
    ProductDescriptionPage productDescriptionPage;

    @Tag("amazonTest")
    @DisplayName("Test page navigation from Homepage -> Product category page -> Search results page ->  Product description page")
    @Test
    void assertPageNavigation() {
        BasePage.navigateToUrl(HOME_PAGE_URL);
        homePage = new HomePage();
        productCategoryPage =
                homePage.header.performCategoryNavigationFromSideMenu("TV, Appliances, Electronics","Televisions");
        assertEquals("Televisions", productCategoryPage.getHighlightedCategoryName(), "unexpected highlighted category name");
        productSearchResultsPage = productCategoryPage.filterByOption("Brands", "Samsung");
        productSearchResultsPage.sortByText("Price: Low to High");
        productDescriptionPage = productSearchResultsPage.clickOnSearchResult(1);
        assertTrue(productDescriptionPage.isAboutItemSectionPresent(), "About the Item section not present");
        log.info("About the Item section contents: " + productDescriptionPage.getAboutItemSectionContent());
    }

    @AfterEach
    void tearDown() {
        BasePage.teardownDriver();
    }
}
