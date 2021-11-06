package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.runtime.model.ExceptionRevoked;
import org.openqa.selenium.edge.EdgeOptions;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;



import Base.Saucedemo.Base;
import POM_Classes.Product_Details_POM;

public class validate_Product_Details {

	public static void main(String[] args) throws Throwable 
	
	{
	
		ExtentReports er=new ExtentReports("C:\\Users\\veera\\eclipse-workspace\\Project2\\src\\test\\resources\\File\\Reports.html",false);
		ExtentTest et=er.startTest("validate_Product_Details");
	
	Base b=new Base();

	String UserName=b.getExcelData1(0, 1, 0);
	String Password=b.getExcelData1(0, 1, 1);
	String Name=b.getExcelData1(0, 1, 2);
	String LastName=b.getExcelData1(0, 1, 3);
	String Pincode=b.getExcelData1(0, 1, 3);
	b.getproperties();
	WebDriver driver=new ChromeDriver();
	driver.get("https://www.saucedemo.com/");
	driver.manage().window().maximize();
	Product_Details_POM vp=new Product_Details_POM(driver);
	b.sendkeys(vp.getId(), UserName);
	b.sendkeys(vp.getPassword(), Password);
	b.btnclick(vp.getLoginButton());	
	Object ProductName=b.getText(vp.getProductname());
	Object ProductValue=b.getText(vp.getProductprice());
	b.btnclick(vp.getAddcardItem());
	b.btnclick(vp.getClickCart());
	b.btnclick(vp.getcheckout());
	b.sendkeys(vp.getName(), Name);
	b.sendkeys(vp.getLastName(), LastName);
	b.sendkeys(vp.getZipCode(), Pincode);
	b.btnclick(vp.getContinue());
	Object FinalProductName	=b.getText(vp.getFinaleProductName());
	Object FinalProductValue=b.getText(vp.getFinaleProductValue());
	System.out.println(ProductName);
	System.out.println(FinalProductName);
	System.out.println(ProductValue);
	System.out.println(FinalProductValue);
	if(ProductName.equals(FinalProductName) && ProductValue.equals(FinalProductValue))
	{
		System.out.println("Checkout product is same as selected product :"+FinalProductName);
		et.log(LogStatus.PASS, "Checkout product is same as selected product:"+FinalProductName);
	}
	else
	{
		System.out.println("Checkout product is not same as selected product:"+FinalProductName);
		et.log(LogStatus.FAIL, "Checkout product is not same as selected product:"+FinalProductName);
	}
	b.closeApp(driver);
	
	er.endTest(et);
	er.flush();
	}
	
		

	}


