package Resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	
	public WebDriver driver;
	public String URL;
	
	
	public WebDriver initializeDrivers() throws IOException
	{
		//Browser
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Selenium\\workspace\\SeleniumProject\\src\\BasicWeb\\data1.properties");
		
		prop.load(fis);
		//prop.getProperty("browser");
		String browserName = prop.getProperty("browser");
		
		if (browserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:/Selenium/workspace/SeleniumTest/Lib/ChromeDriver/chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		else if (browserName.equalsIgnoreCase("firefox"))	
		{
			//System.setProperty("webdriver.firefox.driver", "C:/Selenium/workspace/SeleniumTest/Lib/GeckoDriver/geckodriver.exe");
			System.setProperty("webdriver.gecko.driver","C:\\Selenium\\workspace\\SeleniumTest\\Lib\\GeckoDriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		return driver;
	}

	
	public String Site() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Selenium\\workspace\\SeleniumProject\\src\\BasicWeb\\data1.properties");
		prop.load(fis);
		String URL = prop.getProperty("url");
		//System.out.println(URL);
		return URL;
	}
	
	public String UserName() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Selenium\\workspace\\SeleniumProject\\src\\BasicWeb\\data1.properties");
		prop.load(fis);
		String UserName = prop.getProperty("UserName");
		//System.out.println(UserName);
		return UserName;
	}
	
	public String Password() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Selenium\\workspace\\SeleniumProject\\src\\BasicWeb\\data1.properties");
		prop.load(fis);
		String Password = prop.getProperty("Password");
		//System.out.println(Password);
		return Password;
	}
	
		
	
}
		
	


