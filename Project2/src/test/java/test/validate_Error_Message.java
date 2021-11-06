package test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Base.Saucedemo.Base;
import POM_Classes.ProductPrice_POM;

public class validate_Error_Message {

	public static void main(String[] args) throws Throwable
	{
		ExtentReports er=new ExtentReports("C:\\Users\\veera\\eclipse-workspace\\Project2\\src\\test\\resources\\File\\Reports.html",false);
		ExtentTest et=er.startTest("validate_Error_Message");
		Base b=new Base();
		String UserName=b.getExcelData1(0, 1, 7);
		String Password=b.getExcelData1(0, 1, 1);
		String ErrorMessage=b.getExcelData1(0, 1, 6);
		
		b.getproperties();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		ProductPrice_POM pp=new ProductPrice_POM(driver);
		b.sendkeys(pp.getId(), UserName);
		b.sendkeys(pp.getPassword(), Password);
		b.btnclick(pp.getLoginButton());
		String Error=pp.getErrorMessage().getText();
		if(Error.contains(ErrorMessage))
		{
			System.out.println("Error message displaying properly :"+" "+Error);
			et.log(LogStatus.PASS, "Error message displaying properly :"+" "+Error);
			
		}
		else
		{
			System.out.println("Error message not displaying properly :"+" "+Error);
			et.log(LogStatus.FAIL, "Error message not displaying properly :"+" "+Error);
		}
		b.closeApp(driver);
		er.endTest(et);
		er.flush();
		

	}

}
