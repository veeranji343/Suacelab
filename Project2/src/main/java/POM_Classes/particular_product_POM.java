package POM_Classes;



import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class particular_product_POM 
{
	public particular_product_POM(WebDriver driver) {
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
		@FindBy(xpath=("//div[@class='inventory_item_name']"))
		
	})
	private List<WebElement> list;
	public List<WebElement> getList(){
		return list;
				}
	
	
}
