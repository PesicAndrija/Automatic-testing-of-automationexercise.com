package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage extends BaseTest {

    public HomePage() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "slider")
    public WebElement slider;

    @FindBy(xpath = "//a[contains(text(), ' Signup / Login')]")
    public WebElement signupLoginLink;

    @FindBy(xpath = "//a[contains(text(), ' Logged in as ')]/b[text()='Petar']")
    public WebElement loggedInAsText;

    @FindBy(xpath = "//a[contains(text(), ' Logout')]")
    public WebElement logoutLink;

    @FindBy(xpath = "//a[contains(text(), ' Delete Account')]")
    public WebElement deleteAccountLink;

    @FindBy(xpath = "//a[text()=' Contact us']")
    public WebElement contactUsLink;

    @FindBy(xpath = "//a[text()=' Products']")
    public WebElement productsLink;

    @FindBy(className = "single-widget")
    public WebElement subscriptionTitle;

    @FindBy(xpath = "//a[text()=' Cart']")
    public WebElement cartLink;

    @FindBy(xpath = "//a[text()='View Product']")
    public List<WebElement> viewProductLinks;

    @FindBy(css = ".panel-title > a")
    public List<WebElement> itemCategories;

    @FindBy(css = ".title.text-center")
    public WebElement categorySubcategoryBrandTitle;

    @FindBy(css = ".brands-name a")
    public List<WebElement> itemBrands;

    //----------------------------------------------------

    public void clickOnSignupLoginLink() {
        signupLoginLink.click();
    }

    public void clickOnLogoutLink() {
        logoutLink.click();
    }

    public void clickOnContactUsLink() {
        contactUsLink.click();
    }

    public void clickOnProductsLink() {
        productsLink.click();
    }

    public void clickOnCartLink() {
        cartLink.click();
    }

    public void clickOnAddToCartLink(WebElement we) {
        scrollElementIntoView(we);
        we.click();
    }

    public List<WebElement> subcategoriesOfCategory(String s){
        try{
            return driver.findElements(By.cssSelector("#"+s+" a"));
        }catch (Exception e){}
        return null;
    }

    public WebElement subcategoryByName(String s){
        try{
            return driver.findElement(By.cssSelector("#"+s+" a"));
        }catch (Exception e){}
        return null;
    }

    public void clickOnCategoryByName(String s){
        scrollElementIntoView(driver.findElement(By.xpath("//a[contains(@href, '"+s+"')]")));
        driver.findElement(By.xpath("//a[contains(@href, '"+s+"')]")).click();
    }

    public void clickOnSubcategoryByName(String s){
        scrollElementIntoView(driver.findElement(By.xpath("//a[contains(text(), '"+s+"')]")));
        driver.findElement(By.xpath("//a[contains(text(), '"+s+"')]")).click();
    }

    public void clickOnBrandByName(String s){
        scrollElementIntoView(driver.findElement(By.xpath("//a[contains(@href, '"+s+"')]")));
        driver.findElement(By.xpath("//a[contains(@href, '"+s+"')]")).click();
    }
}
