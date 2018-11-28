package com.pageObjects;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.TestCore;
import com.core.interfaces.PageObjects;

public class LoginPage extends TestCore implements PageObjects {
	
	// Login header
	By lbl_loginHeader = By.xpath("//h1[text()='Login']");
	
	// Login fields
	By lbl_username = By.name("username") ;
	By lbl_password = By.name("password");
	By btn_login = By.id("btnLogin");
	
	// Validation alert
	By lbl_wrongUser = By.xpath("//div[normalize-space()='Wrong username or password.']");
	
	@Override
	public void validatePageLoaded() {
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(lbl_loginHeader));
	}
	
	/**
	 * This login method will login into our application with the username and password defined in out config.properties file.
	 */
	public void doLogin() {
		driver.findElement(lbl_username).sendKeys(prop.getProperty("username"));
		driver.findElement(lbl_password).sendKeys(prop.getProperty("password"));
		driver.findElement(btn_login).click();
	}
	
	/**
	 * This methos will login into our application using the given @params. 
	 * @param username
	 * @param password
	 */
	public void doLogin(String username, String password) {
		driver.findElement(lbl_username).sendKeys(username);
		driver.findElement(lbl_password).sendKeys(password);
		driver.findElement(btn_login).click();
	}

	/**
	 * 
	 */
	public void validateWrongUsernameOrPasswordAlert(String expectedMessage) {
		String currentMessage = driver.findElement(lbl_wrongUser).getText();
		assertEquals(currentMessage, expectedMessage);
	}
	
	

}
