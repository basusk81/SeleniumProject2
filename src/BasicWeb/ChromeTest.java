package BasicWeb;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ChromeTest extends base1 {

	@Test
	public void Banklogin1() throws InterruptedException, IOException{
		
	 
	FileInputStream fis1 = new FileInputStream("C:\\Selenium\\TestData3.xlsx");
	XSSFWorkbook workbook2 = new XSSFWorkbook(fis1);
	XSSFSheet sheet = workbook2.getSheetAt(0);
	XSSFRow row = sheet.getRow(0);
	XSSFCell cell = row.getCell(1);
	
	driver = initializeDrivers();
	Thread.sleep(2000);
	URL = Site();
	
	for (int r=1; r<=5; r++)   // Starting FOR loop
	{
	
	driver.get(URL);

	String src1 = sheet.getRow(2).getCell(1).getStringCellValue();
	System.out.println(src1);
	
	String src2 = sheet.getRow(2).getCell(2).getStringCellValue();
	System.out.println(src2);
	
	
	driver.findElement(By.name("uid")).sendKeys(src1);
	Thread.sleep(1000);
	driver.findElement(By.name("password")).sendKeys(src2);
	Thread.sleep(1000);
	driver.findElement(By.name("btnLogin")).click();
	System.out.println("Login Button CLicked");

	String Error = driver.switchTo().alert().getText();	
	System.out.println(Error);
	String Msg = "User or Password is not valid";
	
	if (Error.equalsIgnoreCase(Msg))
	{
	System.out.println("Error Alert Displayed");
	driver.quit();
	//continue;
	}
	
	String abc  = driver.findElement(By.xpath("//tr[@class='heading3']")).getText();
	System.out.println("abc is : " +abc);
	
	String def  = "Manger Id : mngr256768";
	
	if (abc.equalsIgnoreCase(def))
	{
		System.out.println("Correct Manager ID");
	}

	Thread.sleep(2000);
	driver.findElement(By.xpath("//a[contains(text(),'Log out')]")).click();
	Thread.sleep(2000);
	
	driver.switchTo().alert().accept();

	Thread.sleep(3000);
	
	}
	workbook2.close();
	driver.close();
	
	driver.quit();
	}
	
}
