package BasicWeb;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Amazon1 {

	@Test
	public void LoginPage() throws InterruptedException, IOException
	{
		System.setProperty("webdriver.chrome.driver", "C://Selenium//workspace//SeleniumTest//Lib//ChromeDriver//chromedriver.exe");
		WebDriver driverx = new ChromeDriver();
		driverx.manage().window().maximize();
		
		driverx.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		driverx.get("http://www.amazon.com");
		
		WebElement link1 = driverx.findElement(By.xpath("//a[@id='nav-link-accountList']"));
		Actions a = new Actions(driverx);
		
		//ACTIONS CLASS ; MOVE TO ELEMENT ; BUILD; PERFORM
		a.moveToElement(link1).build().perform();
		Thread.sleep(1000);
		
		Select dd = new Select(driverx.findElement(By.xpath("//*[@id='searchDropdownBox']")));
		
		//dd.selectByValue("Appliances");
		dd.selectByIndex(6);
		Thread.sleep(2000);
		a.moveToElement(driverx.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).click().keyDown(Keys.SHIFT).sendKeys("Microwave Oven").build().perform();
		Thread.sleep(2000);
		//a.moveToElement(driverx.findElement(By.xpath("//input[@id='twotabsearchtextbox']"))).doubleClick().build().perform();
		Thread.sleep(2000);
		driverx.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).clear();
		for (int i=0; i<5; i ++)
		{
		driverx.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys(Keys.PAGE_DOWN);
		Thread.sleep(1000);
		}
		driverx.findElement(By.xpath("//div[@class='navFooterLine navFooterLinkLine navFooterDescLine']")).click();
		Thread.sleep(1000);
		WebElement table = driverx.findElement(By.xpath("//table[@class='navFooterMoreOnAmazon']"));
		int rowcount = table.findElements(By.xpath("//table[@class='navFooterMoreOnAmazon']//tr")).size();
		int colcount = table.findElements(By.xpath("//table[@class='navFooterMoreOnAmazon']//tr//td")).size();
		//System.out.println("Table has rows " +rowcount);
		int ActualRow  = (rowcount + 1)/2;
		System.out.println(ActualRow);
		/*for (int k=0; k<rowcount; k++)
		{
			int colcount = table.findElements(By.xpath("//table[@class='navFooterMoreOnAmazon']//tr//td")).size();
			System.out.println("Table has columns " +colcount);
		}*/
		int ActualCol = (colcount + 1)/2;
		System.out.println(ActualCol);
		//driverx.findElement(By.xpath("//*[contains(text(),'Amazon Music')]")).click();
		
		
		String ab = table.findElement(By.xpath("//table[@class='navFooterMoreOnAmazon']//tr//td[1]//a[@class='nav_a']")).getText();
		String cd = table.findElement(By.xpath("//table[@class='navFooterMoreOnAmazon']//tr//td[3]//a[@class='nav_a']")).getText();
		String ef = table.findElement(By.xpath("//table[@class='navFooterMoreOnAmazon']//tr//td[5]//a[@class='nav_a']")).getText();
		String gh = table.findElement(By.xpath("//table[@class='navFooterMoreOnAmazon']//tr//td[7]//a[@class='nav_a']")).getText();
		String ij = table.findElement(By.xpath("//table[@class='navFooterMoreOnAmazon']//tr//td[9]//a[@class='nav_a']")).getText();
		String kl = table.findElement(By.xpath("//table[@class='navFooterMoreOnAmazon']//tr//td[11]//a[@class='nav_a']")).getText();
		String mn = table.findElement(By.xpath("//table[@class='navFooterMoreOnAmazon']//tr//td[13]//a[@class='nav_a']")).getText();
		System.out.println(ab);
		System.out.println(cd);
		System.out.println(ef);
		System.out.println(gh);
		System.out.println(ij);
		System.out.println(kl);
		System.out.println(mn);
		
		
		/*for(int j=1; j<=1; j++)
		{
		String z = table.findElements(By.xpath("//table[@class='navFooterMoreOnAmazon']//tr//td::nth-child(3)//a[@class='nav_a']")).get(j).getText();
		System.out.println(z);
		}*/
		/*int j,k,m;
		m=1;
		for(j=1; j<=1; j++)
		{
			for (k=1;k<=1; k++)
				{
				String ab = table.findElement(By.xpath("//table[@class='navFooterMoreOnAmazon']//tr[1]//td[1]//a[@class='nav_a']")).getText();
				System.out.println(j);
				System.out.println(k);
				System.out.println(ab);
				}
		}*/
		Thread.sleep(1000);
		driverx.quit();
		
	}
	
}
