package webElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductDetailsPage {
    WebDriver driver;
    WebDriverWait wait;

    public ProductDetailsPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver,20);
    }

    /** Capture all elements in Product Details Page **/
    @FindBy(id = "quantity_wanted") WebElement txtQuantity;
    @FindBy(id = "group_1") WebElement drdSize;
    @FindBy(how = How.XPATH, using = "//p[@id='add_to_cart']/button[@name='Submit']") WebElement btnAddtoCart;
    @FindBy(id = "color_to_pick_list") WebElement lblColorOptions;


    /** All actions on Product Details Page **/
    public void selectQuantity(int quantity) {
        this.wait.until(ExpectedConditions.elementToBeClickable(txtQuantity));
        txtQuantity.sendKeys(String.valueOf(quantity));
    }

    public void selectSize(String size) {
        this.wait.until(ExpectedConditions.visibilityOf(drdSize));
        this.wait.until(ExpectedConditions.attributeContains(By.id("group_1"),"title",size));
        Select s_Size = new Select(drdSize);
        s_Size.selectByValue(size);
    }

    public void selectColor(String color) {
        this.wait.until(ExpectedConditions.visibilityOf(lblColorOptions));
        this.wait.until(ExpectedConditions.
                visibilityOfElementLocated(By.xpath("//ul[@id='color_to_pick_list']//a[@name='" + color + "']")));
        WebElement color_pick = driver.findElement(By.xpath("//ul[@id='color_to_pick_list']//a[@name='" + color + "']"));
        color_pick.click();
    }

    public void addToCart() {
        this.wait.until(ExpectedConditions.elementToBeClickable(btnAddtoCart));
        btnAddtoCart.click();
    }
}
