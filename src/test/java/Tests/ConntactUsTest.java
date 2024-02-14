package Tests;

import Base.BaseTest;
import Pages.ContactUsPage;
import Pages.HomePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ConntactUsTest extends BaseTest {

    @BeforeMethod
    public void pageSetUp(){

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        driver.get("https://automationexercise.com/");

        homePage = new HomePage();
        contactUsPage = new ContactUsPage();

        wait.until(ExpectedConditions.visibilityOf(homePage.slider));
        Assert.assertTrue(homePage.slider.isDisplayed());

    }

    @Test(priority = 10)
    public void user_can_send_message_with_valid_inputs(){

        homePage.clickOnContactUsLink();
        Assert.assertEquals(driver.getCurrentUrl(), contactUsPage.url);
        Assert.assertTrue(contactUsPage.getInTouchTitle.isDisplayed());

        contactUsPage.inputName("Pera");
        contactUsPage.inputEmail("pera12345@gmail.com");
        contactUsPage.inputSubject("Lorem ipsum dolor sit amet");
        contactUsPage.inputMessage("Curabitur non erat laoreet, molestie massa non, gravida odio. Maecenas vel auctor massa, a lacinia eros. Proin blandit pharetra tempor. Duis eu volutpat enim, vel aliquam quam. Sed ullamcorper feugiat lectus sed egestas. In mollis ut quam ut malesuada. Pellentesque dignissim tincidunt est, a facilisis enim. Curabitur sed nibh sit amet ex tincidunt vehicula sit amet vitae dolor. Integer eu sem in odio consequat scelerisque. Maecenas tempus blandit sem, ac consequat dui rhoncus quis. Suspendisse mollis tellus quam, vel condimentum nulla rutrum nec. Donec id convallis nibh. Maecenas elementum ultrices lacinia. Vivamus egestas ante magna, a tincidunt ex rutrum in.\n" +
                "\n" +
                "Quisque sed semper diam. Nulla sollicitudin dictum ligula eget iaculis. Cras sagittis tristique odio in lacinia. Nam in quam vel ligula aliquam mattis. Suspendisse faucibus velit faucibus ornare blandit. Nam ac elit ex. Donec lobortis, est in blandit luctus, ante massa auctor libero, eu suscipit orci mauris vitae massa.\n" +
                "\n" +
                "Nulla aliquam tortor at sagittis tempus. Vivamus lobortis efficitur nibh. Phasellus lacinia placerat nisl, eget bibendum dolor lobortis interdum. Nunc vitae tellus bibendum, lobortis lacus non, scelerisque quam. Maecenas sit amet ipsum turpis. Integer ut auctor tortor, iaculis tincidunt neque. Duis nec nulla in magna aliquet semper iaculis vel ante. Morbi elementum risus eu tortor luctus efficitur. Donec id mi faucibus, pharetra felis vitae, dignissim metus.\n" +
                "\n" +
                "In faucibus sem vitae lacus lobortis, vitae faucibus lacus ullamcorper. Nunc molestie augue eu sapien efficitur ultrices. Quisque ligula risus, scelerisque ut arcu a, pellentesque finibus purus. Praesent blandit, nunc in tincidunt commodo, ipsum lectus lacinia velit, quis blandit enim elit vitae massa. Mauris tristique tellus et mauris volutpat blandit. Quisque tempus ultricies lectus id dignissim. Maecenas maximus ipsum urna, id sodales massa efficitur vel. Proin ultricies porta nunc, at tincidunt purus consequat ornare.\n" +
                "\n" +
                "Sed fermentum cursus tortor, nec molestie lectus sagittis non. Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos himenaeos. Duis posuere neque eget diam ornare convallis. Suspendisse bibendum sem dui, eu commodo lorem eleifend non. Maecenas vel odio a est ultricies ultrices at vitae neque. Aliquam elit arcu, suscipit sed accumsan vel, placerat eu erat. Nullam placerat neque nec gravida bibendum. Quisque magna mauris, scelerisque eget est sed, fringilla fermentum ante. Fusce condimentum convallis lacus id dapibus. Mauris eget neque diam. Suspendisse pretium tellus dui, in dapibus augue volutpat ut.");
        contactUsPage.uploadFile("D:\\Andra\\Faks\\JAVA\\eppf\\automationexcercise_com\\meme.png");
        contactUsPage.clickOnSubmitButton();
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
        Assert.assertTrue(contactUsPage.successMessage.isDisplayed());
        Assert.assertTrue(contactUsPage.homeButton.isDisplayed());
    }

    @AfterMethod
    public void tearDown(){
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
