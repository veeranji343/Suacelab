package POM_Classes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Details_POM 
{
	public Product_Details_POM (WebDriver driver) {
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(id="user-name")
	private WebElement Id;
	public WebElement getId() {
		return Id;
	}
	
	@FindBy(id="password")
	private WebElement Pass;
	public WebElement getPassword() {
		return Pass;
	}
	
	@FindBy(id="login-button")
	private WebElement LoginButton;
	public WebElement getLoginButton() {
		return LoginButton;
	}
	
	@FindBy(name="add-to-cart-sauce-labs-backpack")
	private WebElement AddCard;
	public WebElement getAddcardItem() {
		return AddCard;
	}
	
	@FindBy(xpath="//*[@class='shopping_cart_link']")
	private WebElement ClickCart;
	public WebElement getClickCart() {
		return ClickCart;
	}
	
	
	@FindBy(name="checkout")
	private WebElement checkout;
	public WebElement getcheckout() {
		return checkout;
	}
	
	@FindBy(id="first-name")
	private WebElement Name;
	public WebElement getName() {
		return Name;
	}
	
	@FindBy(id="last-name")
	private WebElement lastname;
	public WebElement getLastName() {
		return lastname;
	}
	
	@FindBy(id="postal-code")
	private WebElement ZipCode;
	public WebElement getZipCode() {
		return ZipCode;
	}
	
	@FindBy(xpath="(//*[@class='inventory_item_name'])[1]")
	private WebElement productname;
	public WebElement getProductname() {
		return productname;
	}
	
	@FindBy(xpath="(//*[@class='inventory_item_price'])[1]")
	private WebElement productprice;
	public WebElement getProductprice() {
		return productprice;
	}
	
	@FindBy(xpath="//*[@class='inventory_item_name']")
	private WebElement FinaleProductName;
	public WebElement getFinaleProductName() {
		return FinaleProductName;
	}	
	
	
	@FindBy(xpath="//*[@class='inventory_item_price']")
	private WebElement FinaleProductValue;
	public WebElement getFinaleProductValue() {
	return FinaleProductValue;
	}
		
	@FindBy(id="continue")
	private WebElement Continue;		
	public WebElement getContinue() {
	return Continue;
		
	}	

}
