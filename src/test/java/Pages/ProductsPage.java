package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductsPage extends BaseTest {

    public ProductsPage(){
        PageFactory.initElements(driver, this);
    }

    public String url = "https://automationexercise.com/products";

    @FindBy(xpath = "//h2[text()='All Products']")
    public WebElement allProductsTitle;

    @FindBy(xpath = "//a[text()='View Product']")
    public List<WebElement> viewProductLinks;

    @FindBy(id = "search_product")
    public WebElement searchField;

    @FindBy(id = "submit_search")
    public WebElement searchButton;

    @FindBy(css = ".title.text-center")
    public WebElement searchedProductsTitle;

    @FindBy(css = ".productinfo.text-center > p")
    public List<WebElement> productsNames;

    @FindBy(css = ".productinfo.text-center > a.add-to-cart")
    public List<WebElement> addToCartButtons;

    @FindBy(xpath = "//button[text()='Continue Shopping']")
    public WebElement continueShoppingButton;

    @FindBy(css = ".productinfo.text-center > h2")
    public List<WebElement> productsPrices;

    //-------------------------------------------------------------------------

    public void clickOnProductLink(WebElement we){
        scrollElementIntoView(we);
        we.click();
    }

    public void inputSearchTerm(String s){
        searchField.clear();
        searchField.sendKeys(s);
    }

    public void clickOnSearchButton(){
        searchButton.click();
    }

    public void clickOnAddToCartLink(WebElement we){
        scrollElementIntoView(we);
        we.click();
    }

    public void clickOnContinueShoppingButton(){
        continueShoppingButton.click();
    }

}
