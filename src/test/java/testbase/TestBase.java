package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class TestBase {
        public static WebDriver driver;
        public static WebDriverWait wait;

        @BeforeClass
        public void Initialize() {
            driver = new SafariDriver();
            wait = new WebDriverWait(driver,30);
            driver.manage().window().maximize();
            driver.navigate().to("http://automationpractice.com/");
        }

        @AfterClass
        public void CleanUp() {
            if (driver != null) {
                driver.close();
            }
        }
    }

