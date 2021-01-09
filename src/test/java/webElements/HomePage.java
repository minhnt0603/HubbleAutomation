package webElements;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    WebDriver driver;
    WebDriverWait wait;

    public HomePage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver,20);
    }

    /** Capture all elements in Hubble Automation Home Page **/
    @FindBy(id = "search_query_top") WebElement txtSearch;
    @FindBy(how = How.XPATH, using = "//div[@id='block_top_menu']//a[@title='Women']") WebElement btnWomenCategory;
    @FindBy(how = How.XPATH, using = "//div[@id='block_top_menu']//a[@title='Dresses']") WebElement btnDressesCategory;
    @FindBy(how = How.XPATH, using = "//div[@id='block_top_menu']//a[@title='T-shirts']") WebElement btnTshirtsCategory;

    /** All actions on Home Page **/
    public void searchProduct(String searchText) {
        this.wait.until(ExpectedConditions.elementToBeClickable(txtSearch));
        txtSearch.sendKeys(searchText);
        txtSearch.sendKeys(Keys.ENTER);
    }

    public void navigateTo(String pageName) {
        if (pageName.equalsIgnoreCase("women")) {
            this.wait.until(ExpectedConditions.elementToBeClickable(btnWomenCategory));
            btnWomenCategory.click();
        } else if (pageName.equalsIgnoreCase("dresses")) {
            this.wait.until(ExpectedConditions.elementToBeClickable(btnDressesCategory));
            btnDressesCategory.click();
        } else if (pageName.equalsIgnoreCase("t-shirts")) {
            this.wait.until(ExpectedConditions.elementToBeClickable(btnTshirtsCategory));
            btnTshirtsCategory.click();
        }
    }
}
