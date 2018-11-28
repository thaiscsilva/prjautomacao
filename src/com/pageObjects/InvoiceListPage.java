package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.core.TestCore;
import com.core.interfaces.PageObjects;

public class InvoiceListPage extends TestCore implements PageObjects {
	
	// Invoice List header
	By lbl_invListHeader = By.xpath("//h2[text()='Invoice List']");

	@Override
	public void validatePageLoaded() {
		(new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(lbl_invListHeader));
	}
	
	
	
}
