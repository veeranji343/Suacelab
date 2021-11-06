package test;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Saucedemo.Base;
import POM_Classes.Product_Details_POM;
import POM_Classes.particular_product_POM;
import freemarker.core.ParseException;

public class validate_particular_product_available_in_List {

	public static void main(String[] args) throws Throwable 
	
	{
		
		ExtentReports er=new ExtentReports("C:\\Users\\veera\\eclipse-workspace\\Project2\\src\\test\\resources\\File\\Reports.html",false);
		ExtentTest et=er.startTest("validate_particular_product_available_in_List");
		Base b=new Base();
		String UserName=b.getExcelData1(0, 1, 0);
		String Password=b.getExcelData1(0, 1, 1);
		String GivenItem=b.getExcelData1(0, 1, 5);
		b.getproperties();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		particular_product_POM vp2=new particular_product_POM(driver);
		b.sendkeys(vp2.getId(), UserName);
		b.sendkeys(vp2.getPassword(), Password);
		b.btnclick(vp2.getLoginButton());
		List<WebElement> l= vp2.getList();
		for(int i=0;i<l.size();i++)
		{
			
			String ExpectedItem=l.get(i).getText();
			if(ExpectedItem.equals(GivenItem))
			{
				System.out.println("Given Item is available in the product list:" +ExpectedItem);
				et.log(LogStatus.PASS, "Given Item is available in the product list:" +ExpectedItem);
				break;
			}
			else {
				if(i>=l.size())
				{
					System.out.println("Given Item is not available in the product list:" +ExpectedItem);
					et.log(LogStatus.PASS, "Given Item is not available in the product list:" +ExpectedItem);
				}
			 }
			
		}
		
		b.closeApp(driver);
		er.endTest(et);
		er.flush();
		
		}
	
		
		
		

	}


