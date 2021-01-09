package webElements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WomenCategoryPage {
    WebDriver driver;
    WebDriverWait wait;
    private static String WOMEN_CATEGORY_TITLE = "Women - My Store";

    public WomenCategoryPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    /**
     * Capture all elements in Hubble Automation Home Page
     **/
    @FindBy(id = "search_query_top")
    WebElement txtSearch;

    /**
     * All actions on Home Page
     **/
    public void searchProduct(String searchText) {
        this.wait.until(ExpectedConditions.titleIs(WOMEN_CATEGORY_TITLE));
        this.wait.until(ExpectedConditions.elementToBeClickable(txtSearch));
        txtSearch.sendKeys(searchText);
        txtSearch.sendKeys(Keys.ENTER);
    }
}
