package Pages;

import Base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage extends BaseTest {

    public CartPage(){
        PageFactory.initElements(driver, this);
    }

    public String url = "https://automationexercise.com/view_cart";

    @FindBy(className = "single-widget")
    public WebElement subscriptionTitle;

    @FindBy(xpath = "//li[text()='Shopping Cart']")
    public WebElement breadcrumb;

    @FindBy(css = "h4 > a")
    public List<WebElement> itemsNames;

    @FindBy(css = ".cart_price > p")
    public List<WebElement> itemsPrices;

    @FindBy(css = ".cart_total_price")
    public List<WebElement> itemsTotalPrices;

    @FindBy(css = ".cart_quantity > button")
    public List<WebElement> itemsQuantity;

    //----------------------------------------------

    public WebElement findDeleteRemoveByItemID(String s){
        try{
            return driver.findElement(By.cssSelector("a[data-product-id='"+s+"']"));
        }catch (Exception e){}
        return null;
    }

    public void clickOnRemoveButtonByID(String s){
        findDeleteRemoveByItemID(s).click();
    }

}
