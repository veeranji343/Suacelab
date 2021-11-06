package test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Saucedemo.Base;
import POM_Classes.ProductPrice_POM;
import POM_Classes.particular_product_POM;

public class validate_ProductPrice {

	public static void main(String[] args) throws Throwable 
	{
		ExtentReports er=new ExtentReports("C:\\Users\\veera\\eclipse-workspace\\Project2\\src\\test\\resources\\File\\Reports.html",false);
		ExtentTest et=er.startTest("validate_ProductPrice");
		Base b=new Base();
		String UserName=b.getExcelData1(0, 1, 0);
		String Password=b.getExcelData1(0, 1, 1);
		b.getproperties();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		ProductPrice_POM pp=new ProductPrice_POM(driver);
		b.sendkeys(pp.getId(), UserName);
		b.sendkeys(pp.getPassword(), Password);
		b.btnclick(pp.getLoginButton());
	    List<WebElement> l=pp.getPrice();
	    List<WebElement> l2=pp.getProductName();
	    for(int i=0;i<l.size();i++)
	    {
	    	String price=l.get(i).getText().substring(1);
	    	String ProductName=l2.get(i).getText();
	    	b.click(l2.get(i));
	    	String Individualprice=pp.getIndividualPrice().getText().substring(1);
	    	if(price.equals(Individualprice))
	    	{
	    		System.out.println(ProductName +" "+"price's are equal"+" "+price);
	    		et.log(LogStatus.PASS, ProductName +" "+"price's are equal"+" "+price);
	    	}
	    	else
	    	{
	    		System.out.println(ProductName +" "+"price's are not equal"+" "+price);
	    		et.log(LogStatus.FAIL, ProductName +" "+"price's are not equal"+" "+price);
	    		
	    	}
	    	driver.navigate().back();
	    	
	    }
	    b.closeApp(driver);
	    er.endTest(et);
		er.flush();
		

	}

}
