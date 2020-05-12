package BasicWeb;


import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class Test1 extends base1{

	
	@Test
	public void Banklogin1() throws InterruptedException, IOException

	{
		
	 //Input Stream
	FileInputStream fis1 = new FileInputStream("C:\\Selenium\\TestData3.xlsx");
	XSSFWorkbook workbook2 = new XSSFWorkbook(fis1);
	XSSFSheet sheet = workbook2.getSheetAt(0);
	XSSFRow row = sheet.getRow(0);
	XSSFCell cell = row.getCell(1);
	
	
	for (int r=1;r<=5;r++)
	{
	
	driver = initializeDrivers();
	//Thread.sleep(2000);
	URL = Site();
	
	//for (int r=1;r<=3;r++)
	//{
	driver.get(URL);
	System.out.println(r);
	String src1 = sheet.getRow(r).getCell(1).getStringCellValue();
	System.out.println(src1);
	
	String src2 = sheet.getRow(r).getCell(2).getStringCellValue();
	System.out.println(src2);
	
	
	driver.findElement(By.name("uid")).sendKeys(src1);
	//Thread.sleep(1000);
	driver.findElement(By.name("password")).sendKeys(src2);
	//Thread.sleep(1000);
		
	
	driver.findElement(By.name("btnLogin")).click();
	System.out.println("Login Button CLicked");
	//Thread.sleep(2000);
	
	String def="A";
	
	    try{
	    Alert alert = driver.switchTo().alert();
	    //System.out.println(alert.getText()+" Alert is Displayed"); 
	    
	    }
	    
	    catch(NoAlertPresentException ex)
	    {
	   // System.out.println("Alert is NOT Displayed");
	    def="N";
	    }
	    
	System.out.println("Is Alert Present" +def);
	if (def=="A")
	{
	
	String Error = driver.switchTo().alert().getText();	
	System.out.println(Error);
	String Msg = "User or Password is not valid";
	
	if (Error.equalsIgnoreCase(Msg))
	{
	System.out.println("Error Alert Displayed");
	//driver.quit();
	}
	}
	if (def=="N")
	{
	String abc  = driver.findElement(By.xpath("//tr[@class='heading3']")).getText();
	System.out.println("abc is : " +abc);
	
	System.out.println(r);
	
	String ghi  = "Manger Id : mngr256768";
	
	if (abc.equalsIgnoreCase(ghi))
	{
		System.out.println("Correct Manager ID");
	}

	//Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
	//Thread.sleep(2000);
	
	
	}  //end of If def ==n
	//driver.close();
	//Thread.sleep(3000);
	}  //End of For Loop
	workbook2.close();
	
	}
	//driver.quit();
	
	

/*		@Test
	public void Banklogin1() throws InterruptedException, IOException

	{
		
	 
	FileInputStream fis1 = new FileInputStream("C:\\Selenium\\TestData3.xlsx");
	XSSFWorkbook workbook2 = new XSSFWorkbook(fis1);
	XSSFSheet sheet = workbook2.getSheetAt(0);
	XSSFRow row = sheet.getRow(0);
	XSSFCell cell = row.getCell(1);
	
	driver = initializeDrivers();
	//Thread.sleep(2000);
	URL = Site();
	
	driver.get(URL);

	String src1 = sheet.getRow(3).getCell(1).getStringCellValue();
	System.out.println(src1);
	
	String src2 = sheet.getRow(3).getCell(2).getStringCellValue();
	System.out.println(src2);
	
	
	driver.findElement(By.name("uid")).sendKeys(src1);
	//Thread.sleep(1000);
	driver.findElement(By.name("password")).sendKeys(src2);
	//Thread.sleep(1000);
		
	
	driver.findElement(By.name("btnLogin")).click();
	System.out.println("Login Button CLicked");
	//Thread.sleep(2000);
	
	String def="A";
	
	    try{
	    Alert alert = driver.switchTo().alert();
	    //System.out.println(alert.getText()+" Alert is Displayed"); 
	    
	    }
	    
	    catch(NoAlertPresentException ex)
	    {
	   // System.out.println("Alert is NOT Displayed");
	    def="N";
	    }
	    
	System.out.println("Is Alert Present" +def);
	if (def=="A")
	{
	
	String Error = driver.switchTo().alert().getText();	
	System.out.println(Error);
	String Msg = "User or Password is not valid";
	
	if (Error.equalsIgnoreCase(Msg))
	{
	System.out.println("Error Alert Displayed");
	//driver.quit();
	}
	}
	if (def=="N")
	{
	String abc  = driver.findElement(By.xpath("//tr[@class='heading3']")).getText();
	System.out.println("abc is : " +abc);
	
	
	
	String ghi  = "Manger Id : mngr256768";
	
	if (abc.equalsIgnoreCase(ghi))
	{
		System.out.println("Correct Manager ID");
	}

	//Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
	//Thread.sleep(2000);
	

	//Thread.sleep(3000);
	
	workbook2.close();
	driver.close();
	}
	driver.quit();
	}
	
*/
		
}