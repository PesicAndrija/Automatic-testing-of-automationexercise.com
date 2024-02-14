package Base;

import Pages.*;
import Pages.ProductPage;
import Pages.ProductsPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.util.Random;

public class BaseTest {

    public static WebDriver driver;
    public JavascriptExecutor jse;
    public WebDriverWait wait;
    public HomePage homePage;
    public LoginPage loginPage;
    public SignupPage signupPage;
    public Random random = new Random();
    public AccountCreatedPage accountCreatedPage;
    public ContactUsPage contactUsPage;
    public ProductsPage productsPage;
    public ProductPage productPage;
    public CartPage cartPage;

    @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
    }

    public void scrollElementIntoView(WebElement we){
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView()", we);

    }

}
