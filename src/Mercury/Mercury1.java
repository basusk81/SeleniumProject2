package Mercury;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Mercury1 {
	
	
	@Test
	public void LoginPage() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "C://Selenium//workspace//SeleniumTest//Lib//ChromeDriver//chromedriver.exe");
		WebDriver driverx = new ChromeDriver();
		driverx.manage().window().maximize();
		
		driverx.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driverx.get("http://newtours.demoaut.com/mercurysignon.php");
		
		Thread.sleep(2000);
		driverx.findElement(By.xpath("//input[@name='userName']")).sendKeys("presarka");
		Thread.sleep(2000);
		driverx.findElement(By.xpath("//input[@name='password']")).sendKeys("presarka1");
		Thread.sleep(2000);
		driverx.findElement(By.xpath("//input[@name='login']")).click();
		
		driverx.findElement(By.xpath("//a[text()='Flights']")).click();
		
		driverx.findElement(By.xpath("//input[@vlaue='oneway']")).click();
		Thread.sleep(2000);
		driverx.findElement(By.xpath("//input[@vlaue='roundtrip']")).click();
		
		Select Psngr = new Select(driverx.findElement(By.xpath("//*[@name='passCount']")));
		Psngr.selectByValue("3");
		
		Select DepartCity = new Select(driverx.findElement(By.xpath("//*[@name='fromPort']")));
		Psngr.selectByValue("London");
		
		Select DepMonth = new Select(driverx.findElement(By.xpath("//*[@name='fromMonth']")));
		Psngr.selectByValue("February");
		
		Select DepDate = new Select(driverx.findElement(By.xpath("//*[@name='fromDay']")));
		Psngr.selectByValue("23");	
		
		Select ArrCity = new Select(driverx.findElement(By.xpath("//*[@name='toPort']")));
		Psngr.selectByValue("New York");
		
		Select RetMonth = new Select(driverx.findElement(By.xpath("//*[@name='toMonth']")));
		Psngr.selectByValue("February");
		
		Select RetDate = new Select(driverx.findElement(By.xpath("//*[@name='toDay']")));
		Psngr.selectByValue("28");	
		
		driverx.findElement(By.xpath("//input[@value='Business']")).click();
		
		Select Airline = new Select(driverx.findElement(By.xpath("//*[@name='airline']")));
		Psngr.selectByIndex(1);	
		Thread.sleep(2000);
		
		driverx.findElement(By.xpath("//input[@name='findFlights']")).click();
		Thread.sleep(3000);
		
		driverx.findElement(By.xpath("//input[@value='Blue Skies Airlines$361$271$7:10']")).click();
		Thread.sleep(3000);
		driverx.findElement(By.xpath("//input[@value='Unified Airlines$633$303$18:44']")).click();
		
		driverx.findElement(By.xpath("//input[@name='reserveFlights']")).click();
		
		File src=	 ((TakesScreenshot)driverx).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C://Selenium//screenshot.png"));
		
		driverx.close();
	}
	
	

}
