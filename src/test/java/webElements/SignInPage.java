package webElements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage {
    WebDriver driver;
    WebDriverWait wait;

    public SignInPage (WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait (driver,20);
    }

    /** Capture all elements in Sign In Page **/
    @FindBy(id = "email") WebElement txtEmail;
    @FindBy(id = "passwd") WebElement txtPassword;
    @FindBy(id = "SubmitLogin") WebElement btnSignIn;

    /** All actions on Sign In Page **/
    public void signIn(String email, String password) {
        // Enter email
        this.wait.until(ExpectedConditions.elementToBeClickable(txtEmail));
        txtEmail.sendKeys(email);
        // Enter password
        this.wait.until(ExpectedConditions.elementToBeClickable(txtPassword));
        txtPassword.sendKeys(password);
        // Click button Sign In
        this.wait.until(ExpectedConditions.elementToBeClickable(btnSignIn));
        btnSignIn.click();
    }
}
