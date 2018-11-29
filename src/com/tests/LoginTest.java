package com.tests;

import org.testng.annotations.Test;

import com.core.TestCore;
import com.pageObjects.InvoiceListPage;
import com.pageObjects.LoginPage;

public class LoginTest extends TestCore {

	@Test(enabled = true)
	public void loginSuccessfully() {
		
		initialize();
		
		// Instantiating our pages
		LoginPage pLoginPage = new LoginPage();
		InvoiceListPage pInvoiceListPage = new InvoiceListPage();

		// Do the login
		pLoginPage.validatePageLoaded();
		pLoginPage.doLogin();

		// Validates if the next page was loaded after we logged in it
		pInvoiceListPage.validatePageLoaded();
	}

	@Test(enabled = true)
	public void loginNotSucessfull() {
		String username = "nomeerrado";
		String password = "abc123";
		String expectedMessage = "Wrong username or password.";

		initialize();
		
		LoginPage pLoginPage = new LoginPage();

		pLoginPage.validatePageLoaded();
		pLoginPage.doLogin(username, password);
		pLoginPage.validateWrongUsernameOrPasswordAlert(expectedMessage);
	}

}
