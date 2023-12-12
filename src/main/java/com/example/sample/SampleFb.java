package com.example.sample;

import java.io.FileInputStream;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class SampleFb {
	
	@Test
	public void loginFacebook() throws InterruptedException, MalformedURLException {

		try {		

			String browser = "chrome";

			System.setProperty("webdriver.chrome.driver",
					"C:/Users/DELL/.cache/selenium/chromedriver/win64/116.0.5845.62/chromedriver.exe");

			ChromeOptions options = new ChromeOptions();

			options.setBinary("C:/Users/DELL/.cache/selenium/chrome/win64/116.0.5845.62/chrome.exe");

			options.addArguments("--remote-allow-origins=*");

			// options.addArguments("--headless");

			options.addArguments("--disable-notifications");

			WebDriver driver = null;

			switch (browser.toLowerCase()) {

			case "chrome":

				driver = new ChromeDriver(options);
				
				break;

			default:

				System.out.println("Unsupported browser type: " + browser);

				break;
			}

			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			driver.get("https://www.facebook.com/");
			
			driver.manage().window().maximize();

			if (driver.getCurrentUrl().equals("https://www.facebook.com/") ) {

				Properties properties = new Properties();

				FileInputStream fileInputStream = new FileInputStream("config.properties");

				properties.load(fileInputStream);
				
				String username = properties.getProperty("username");

				WebElement userName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'email']")));
			
			      userName.sendKeys(username);
			    
			    String passKey = properties.getProperty("password");
			    
			    WebElement password = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name = 'pass']")));
			   
			      password.sendKeys(passKey);
			      
			      String title = driver.getTitle();
			      
			       if(title.equals("Facebook � log in or sign up")) {
			    	   
			    	   System.out.println("Test case is passed");
			      
			       } else {
			    	   
			    	   System.out.println("Test case is failed");
			       }
			  }
			
	
	    	} catch (Exception e) {

			e.getStackTrace();
			
			System.out.println(e.getMessage());
		}

	}
	

}
