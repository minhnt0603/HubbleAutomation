package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import testbase.TestBase;
import webElements.HomePage;
import webElements.SearchResultPage;
import webElements.WomenCategoryPage;

public class SearchProduct extends TestBase {

    static private String SEARCH_TEXT = "dress";
    static private String WOMEN_CATEGORY = "Women";
    static private int FOUND_ITEMS = 7;

    @Test
    public void SearchProduct() {
        /** Init Web elements in pages */
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        WomenCategoryPage womenCategoryPage = PageFactory.initElements(driver, WomenCategoryPage.class);
        SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);

        /** Step 1: navigate to Women Category */
        homePage.navigateTo(WOMEN_CATEGORY);

        /** Step 2: Search for "dress" */
        womenCategoryPage.searchProduct(SEARCH_TEXT);

        /** Step 3: Verify the search result */
        searchResultPage.verifySearchResult(SEARCH_TEXT, FOUND_ITEMS);
    }
}
