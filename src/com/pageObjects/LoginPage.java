package com.pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.TestCore;
import com.core.interfaces.PageObjects;

public class LoginPage extends TestCore implements PageObjects {
	
	// Login header
	By lblLoginHeader = By.xpath("//h1[text()='Login']");
	
	// Login fields
	By lblUsername = By.name("username") ;
	By lblPassword = By.name("password");
	By btnLogin = By.id("btnLogin");
	
	// Validation alert
	By lblWrongUser = By.xpath("//div[normalize-space()='Wrong username or password.']");
	
	@Override
	public void validatePageLoaded() {
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(lblLoginHeader));
	}
	
	/**
	 * This login method will login into our application with the username and password defined in out config.properties file.
	 */
	public void doLogin() {
		driver.findElement(lblUsername).sendKeys(prop.getProperty("username"));
		driver.findElement(lblPassword).sendKeys(prop.getProperty("password"));
		driver.findElement(btnLogin).click();
	}
	
	/**
	 * This methos will login into our application using the given @params. 
	 * @param username
	 * @param password
	 */
	public void doLogin(String username, String password) {
		driver.findElement(lblUsername).sendKeys(username);
		driver.findElement(lblPassword).sendKeys(password);
		driver.findElement(btnLogin).click();
	}

	/**
	 * Validates that when the user is trying to login with wrong data, that the application
	 * will show the expected message passed by parameter by the test.
	 * @param expectedMessage
	 */
	public void validateWrongUsernameOrPasswordAlert(String expectedMessage) {
		String currentMessage = driver.findElement(lblWrongUser).getText();
		assertEquals(currentMessage, expectedMessage);
	}
	
	

}
