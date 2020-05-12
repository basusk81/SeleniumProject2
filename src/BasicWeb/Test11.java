package BasicWeb;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test11 {

	public static void main(String[] args) throws InterruptedException {
		
	
		System.setProperty("webdriver.gecko.driver","C:\\Selenium\\workspace\\SeleniumTest\\Lib\\GeckoDriver\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://demo.guru99.com/v4/");
		Thread.sleep(5000);
		driver.close();
		
	}

}
