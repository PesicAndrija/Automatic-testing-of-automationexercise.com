package Tests;

import Base.BaseTest;
import Pages.CartPage;
import Pages.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class SubscriptionTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://automationexercise.com/");

        homePage = new HomePage();
        cartPage = new CartPage();

        wait.until(ExpectedConditions.visibilityOf(homePage.slider));
        Assert.assertTrue(homePage.slider.isDisplayed());

    }

    @Test(priority = 10)
    public void verify_subscription_title_on_homepage(){

        scrollElementIntoView(homePage.subscriptionTitle);
        Assert.assertTrue(homePage.subscriptionTitle.isDisplayed());

    }

    @Test(priority = 20)
    public void verify_subscription_title_on_cart_page(){

        homePage.clickOnCartLink();
        Assert.assertEquals(driver.getCurrentUrl(), cartPage.url);
        Assert.assertTrue(cartPage.breadcrumb.isDisplayed());

        scrollElementIntoView(cartPage.subscriptionTitle);
        Assert.assertTrue(cartPage.subscriptionTitle.isDisplayed());

    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
