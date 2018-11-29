package com.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class TestCore {
	public static WebDriver driver;
	
	public static void initialize() {
		String browser = Settings.getProperty("browser");
		switch (browser.toUpperCase().trim()) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver", ".//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case "FF":

			break;
		case "IE":

			break;
		default:
			
			break;
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.get(EnvironmentDefinitions.URL);
	}

	@BeforeMethod
	public void beforeTest() {
		Settings.loadConfiguration();
		EnvironmentDefinitions.defineEnvironment();
	}

	@AfterMethod
	public void afterTest() {
		driver.quit();
	}

}
