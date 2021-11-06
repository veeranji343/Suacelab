package Base.Saucedemo;



import java.io.File;
import java.io.FileInputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.UUID;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;




public class Base 
{
	public static WebDriver driver;

	public void getproperties()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\veera\\eclipse-workspace\\Project\\target\\chromedriver.exe");
	}
	public void sendkeys(WebElement element,String name) 
	{
		element.sendKeys(name);

}
	
	public void click(WebElement element){
		element.click();
	}
	
	public Object getText(WebElement element)
	{
		String c=element.getText();
		return c;
	}
	
	public static void setText(WebElement element, String name) {
		//cleartextbox(element);
		element.sendKeys(name);

	}

	public static void cleartextbox(WebElement element) {
		element.clear();

	}
	public void timeclaculate() {
		 DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		 Date date = new Date();
		 String date1= dateFormat.format(date);
		 System.out.println("Current date and time is " +date1);


}
	public static void btnclick(WebElement element) {
		element.click();
	}

	public static void closeApp(WebDriver driver) {
		driver.close();

	}
	public static void GetText(WebElement element) {
	
		  System.out.println(element.getText());
	}
	 
	public static String getExcelData1(int sheetNo, int rowNum, int colNum) throws Throwable{
		File f=new File("C:\\Users\\veera\\eclipse-workspace\\Project\\src\\test\\resources\\File\\Data.xlsx");
	     FileInputStream fis = new FileInputStream(f);
	     XSSFWorkbook wb=new XSSFWorkbook(fis);
	     XSSFSheet s=wb.getSheetAt(sheetNo);
	     String data=s.getRow(rowNum).getCell(colNum).getStringCellValue();
			     return data;
	}
	
	
	
	
	
	
	
}



