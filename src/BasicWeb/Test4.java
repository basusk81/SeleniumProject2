package BasicWeb;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.hslf.blip.PNG;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
//import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import ExcelHandling.ExcelDataPull;
import Resources.Base;

public class Test4 extends Base{

	
	@Test
	public void Banklogin1() throws Exception

	{
		
	 //Input Stream
	FileInputStream fis1 = new FileInputStream("C:\\Selenium\\TestData3.xlsx");
	XSSFWorkbook workbook2 = new XSSFWorkbook(fis1);
	XSSFSheet sheet = workbook2.getSheetAt(0);
	XSSFRow row = sheet.getRow(0);
	XSSFCell cell = row.getCell(1);
	/*
	 //Output Stream
	File file = new File("C:\\Selenium\\TestData2.xlsx");
	FileOutputStream fos1 = new FileOutputStream(file);
	XSSFWorkbook workbook3 = new XSSFWorkbook();
	//XSSFSheet sheet1 = workbook3.getSheetAt(0);
	XSSFSheet sheet1 = workbook3.createSheet();
	//XSSFRow rows = sheet1.getRow(0);
	//XSSFCell cells = rows.getCell(1);
	
	sheet1.createRow(0).createCell(2).setCellValue("Test1");
	sheet1.createRow(0).createCell(1).setCellValue("Test2");
	sheet1.createRow(1).createCell(1).setCellValue("Test3");
	workbook3.write(fos1);
	*/
	for (int r=1;r<=5;r++)
	{
	
	driver = initializeDrivers();
	//Thread.sleep(2000);
	URL = Site();
	
	//for (int r=1;r<=3;r++)
	//{
	driver.get(URL);
	System.out.println(r);
	
	//String src1 = ExcelDataPull.this.DataPull();
	
	
	String src1 = sheet.getRow(r).getCell(1).getStringCellValue();
	System.out.println();
	
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
	//driver.close();
	driver.switchTo().alert().accept();
	driver.close();
	}
	}
	if (def=="N")
	{
	String abc  = driver.findElement(By.xpath("//tr[@class='heading3']")).getText();
	System.out.println("abc is : " +abc);
	
	System.out.println(r);
	
	String ghi  = "Manger Id : mngr256768";
	//this.takeSnapShot(webdriver, "c://Selenium//test.png") ; 
	
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(source, new File("C:/Selenium/Screenshots/Screen.png"));
	System.out.println("the Screenshot is taken");
	
	if (abc.equalsIgnoreCase(ghi))
	{
		System.out.println("Correct Manager ID");
	}

	//Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
	//Thread.sleep(2000);
	driver.switchTo().alert().accept();
	driver.close();
	}  //end of If def ==n
	//driver.close();
	//Thread.sleep(3000);
	}  //End of For Loop
	workbook2.close();
	System.out.println("Outside For Loop");
	driver.quit();
	}
	//driver.quit();
	/*public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception{
	TakesScreenshot webdriver1;
	TakesScreenshot sc= ((TakesScreenshot)webdriver1);
	File srcFile = sc.getScreenshotAs(img.FILE);
	File DestFile =  new File("C:\\Selenium\\Screenshots");
	FileUtils.copyFile(srcFile, DestFile);
	}*/

}