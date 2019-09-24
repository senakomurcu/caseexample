package seleniumdemo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumFirst {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
	
		Logger logger = Logger.getLogger("LogDemo");
		
		System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
		//chrome driver
		WebDriver driver = new ChromeDriver();
		//trendyol login page
		driver.get("https://www.trendyol.com/login?returnUrl=https%3A%2F%2Fwww.trendyol.com%2FHesabim&p=1");
		logger.info("Trendyol opened");
		//Thread.sleep(5000);
		driver.manage().window().maximize();
		//login
		WebElement email = driver.findElement(By.id("fEmailx"));
		WebElement password = driver.findElement(By.id("LoginModel_password"));
		email.sendKeys("senakomurcu96@hotmail.com");
		password.sendKeys("Fenerbahçe1907");
		driver.findElement(By.id("loginSubmitButton")).click();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		//tabs
		List<WebElement> list = driver.findElements(By.xpath("//div[@id='navigation-wrapper']"));
		for(int i=1; i<=9; i++ ) {
			list.get(i).click();
			
		}
		//photos
		List<WebElement> photoList = driver.findElements(By.xpath("//div[@class='component-list component-big-list']"));
		for(int i = 1; i<= photoList.size(); i++) {
			photoList.get(i).click();
		}

	}

}
