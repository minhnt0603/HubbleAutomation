package testcases;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import testbase.TestBase;
import util.GlobalVariables;
import webElements.*;

public class BuyProduct extends TestBase {

    static private String SIGNIN_PAGE = "Sign In";
    static private String BLOUSE = "Blouse";
    static private int QUANTITY = 5;
    static private String SIZE_M = "M";
    static private String COLOR_WHITE = "White";

    @Test
    public void BuyProduct() {
        /** Init Web elements in pages */
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        SignInPage signInPage = PageFactory.initElements(driver, SignInPage.class);
        MyAccountPage myAccountPage = PageFactory.initElements(driver, MyAccountPage.class);
        SearchResultPage searchResultPage = PageFactory.initElements(driver, SearchResultPage.class);
        ProductDetailsPage productDetailsPage = PageFactory.initElements(driver, ProductDetailsPage.class);

        /** Step 1: navigate to Login Page */
        homePage.navigateTo(SIGNIN_PAGE);

        /** Step 2: Sign In */
        signInPage.signIn(GlobalVariables.EMAIL, GlobalVariables.PASSWORD);

        /** Step 3: Search for Product */
        myAccountPage.searchProduct(BLOUSE);

        /** Step 4: Open Product Detail */
        searchResultPage.openProduct(BLOUSE);

        /** Step 5: Select Size/Color/Quantity */
        productDetailsPage.selectQuantity(QUANTITY);
        productDetailsPage.selectSize(SIZE_M);
        productDetailsPage.selectColor(COLOR_WHITE);

        /** Step 6: Add to Cart */
        productDetailsPage.addToCart();

        /** Step 7: Check Out */
    }
}
