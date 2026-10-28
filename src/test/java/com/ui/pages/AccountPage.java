package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public final class AccountPage extends BrowserUtility{
	public AccountPage(WebDriver driver) {
		super(driver);
	}

	private static final By USER_NAME_LOCATOR = By.xpath("//a[@class='account']/span");
	
	public String getUserName() {
		return getText(USER_NAME_LOCATOR);
	}
}
