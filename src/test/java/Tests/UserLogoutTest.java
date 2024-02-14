package Tests;

import Base.BaseTest;
import Pages.HomePage;
import Pages.LoginPage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class UserLogoutTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://automationexercise.com/");

        homePage = new HomePage();
        loginPage = new LoginPage();

        wait.until(ExpectedConditions.visibilityOf(homePage.slider));
        Assert.assertTrue(homePage.slider.isDisplayed());

    }

    @Test(priority = 10)
    public void user_can_logout(){

        homePage.clickOnSignupLoginLink();
        Assert.assertTrue(loginPage.loginFormTitle.isDisplayed());
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.url);
        Assert.assertTrue(loginPage.signupButton.isDisplayed());

        loginPage.inputLoginEmail("pera12345@gmail.com");
        loginPage.inputLoginPassword("Lozinka123$");
        loginPage.clickOnLoginButton();
        Assert.assertTrue(homePage.loggedInAsText.isDisplayed());
        Assert.assertTrue(homePage.logoutLink.isDisplayed());
        Assert.assertTrue(homePage.deleteAccountLink.isDisplayed());

        homePage.clickOnLogoutLink();
        Assert.assertEquals(driver.getCurrentUrl(), loginPage.url);
        boolean loggedOut = true;
        try{
            if(homePage.logoutLink.isDisplayed())
                loggedOut = false;
        }catch (Exception e){}
        Assert.assertTrue(loggedOut);

    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
