package POM_Classes;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPrice_POM 

{
	public ProductPrice_POM(WebDriver driver) {
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
	@FindAll({ 
		@FindBy(xpath=("//div[@class='inventory_item_price']"))
		
	})
	private List<WebElement> price;
	public List<WebElement> getPrice(){
		return price;
				}
	@FindAll({ 
		@FindBy(xpath=("//div[@class='inventory_item_name']"))
		
	})
	private List<WebElement> list;
	public List<WebElement> getProductName(){
		return list;
				}
	@FindBy(xpath="//*[@class='inventory_details_price']")
	private WebElement price1;
	public WebElement getIndividualPrice()
	{
		return price1;
	}
	
	@FindBy(xpath="//*[@class='error-message-container error']")
	private WebElement error;
	public WebElement getErrorMessage()
	{
		return error;
	}

}
