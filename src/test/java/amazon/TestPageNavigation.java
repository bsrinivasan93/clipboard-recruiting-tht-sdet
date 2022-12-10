package amazon;

import amazon.config.EnvFactory;
import amazon.pages.BasePage;
import amazon.pages.HomePage;
import amazon.pages.ProductCategoryPage;
import amazon.pages.ProductDescriptionPage;
import amazon.pages.ProductSearchResultsPage;
import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class TestPageNavigation {
    private static Config config = EnvFactory.getInstance().getConfig();
    private static final String HOME_PAGE_URL = config.getString("HOME_PAGE_URL");
    private static final String AMAZON_L1CATEGORY_NAME = config.getString("AMAZON_L1CATEGORY_NAME");
    private static final String AMAZON_L2CATEGORY_NAME = config.getString("AMAZON_L2CATEGORY_NAME");
    private static final String AMAZON_FILTER_NAME = config.getString("AMAZON_FILTER_NAME");
    private static final String AMAZON_FILTER_OPTION_NAME = config.getString("AMAZON_FILTER_OPTION_NAME");
    private static final String AMAZON_SORT_OPTION = config.getString("AMAZON_SORT_OPTION");

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
                homePage.header.performCategoryNavigationFromSideMenu(AMAZON_L1CATEGORY_NAME, AMAZON_L2CATEGORY_NAME);
        assertEquals(AMAZON_L2CATEGORY_NAME, productCategoryPage.getHighlightedCategoryName(), "unexpected highlighted category name");
        productSearchResultsPage = productCategoryPage.filterByOption(AMAZON_FILTER_NAME, AMAZON_FILTER_OPTION_NAME);
        productSearchResultsPage.sortByText(AMAZON_SORT_OPTION);
        productDescriptionPage = productSearchResultsPage.clickOnSearchResult(1);
        assertTrue(productDescriptionPage.isAboutItemSectionPresent(), "About the Item section not present");
        log.info("About the Item section contents: " + productDescriptionPage.getAboutItemSectionContent());
    }

    @AfterAll
    void tearDown() {
        //ideally should happen in the TestNG's @AfterSuite method equivalent in Junit
        BasePage.teardownDriver();
    }
}
