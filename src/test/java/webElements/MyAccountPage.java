package webElements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage {
    WebDriver driver;
    WebDriverWait wait;
    static private String MY_ACCOUNT_PAGE_TITLE = "My account - My Store";

    public MyAccountPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver,20);
    }

    /** Capture all elements in My Account Page **/
    @FindBy(id = "search_query_top") WebElement txtSearch;

    /** All actions on My Account Page **/
    public void searchProduct(String searchText) {
        this.wait.until(ExpectedConditions.titleIs(MY_ACCOUNT_PAGE_TITLE));
        this.wait.until(ExpectedConditions.elementToBeClickable(txtSearch));
        txtSearch.sendKeys(searchText);
        txtSearch.sendKeys(Keys.ENTER);
    }
}
