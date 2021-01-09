package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class SearchResultPage {
    WebDriver driver;
    WebDriverWait wait;
    private static String SEARCH_RESULT_TITLE = "Search - My Store";

    public SearchResultPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver,20);
    }

    /** Capture all elements in Hubble Automation Search Result Page **/
    @FindBy(how = How.XPATH, using = "//h1[@class='page-heading  product-listing']/span[1]") WebElement txtSearchText;
    @FindBy(how = How.XPATH, using = "//ul[@class='product_list grid row']") WebElement gridItemList;
    @FindBy(how = How.XPATH, using = "//span[@class='heading-counter']") WebElement txtNoOfFoundItems;


    /** All actions on Search Result Page **/
    public void verifySearchResult(String searchText, int noOfFoundItems) {
        this.wait.until(ExpectedConditions.titleIs(SEARCH_RESULT_TITLE));
        this.wait.until(ExpectedConditions.visibilityOf(gridItemList));
        Assert.assertTrue(txtSearchText.getText().replace("\"|\n","").
                trim().toUpperCase().matches("\"" + searchText.toUpperCase() + "\""));
        Assert.assertTrue(txtNoOfFoundItems.getText().replace("\"|\n","").
                trim().matches(noOfFoundItems + " results have been found."));
    }

    public void openProduct(String productName) {
        this.wait.until(ExpectedConditions.titleIs(SEARCH_RESULT_TITLE));
        this.wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//div[@class='product-container']//img[@title='"+ productName + "']")));
        WebElement imgProduct = driver.findElement(
                By.xpath("//div[@class='product-container']//img[@title='" + productName + "']"));
        imgProduct.click();
    }
}
