package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utilities.BrowserUtility;

public final class LoginPage extends BrowserUtility{

	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public static final By EMAIL_ELEMENT_LOCATOR = By.id("email");
	public static final By PASSWORD_ELEMENT_LOCATOR = By.id("passwd");
	public static final By SIGN_IN_BUTTON_ELEMENT_LOCATOR = By.id("SubmitLogin");
	
	public AccountPage doLoginWith(String email, String password) {
		enterText(EMAIL_ELEMENT_LOCATOR, email);
		enterText(PASSWORD_ELEMENT_LOCATOR, password);
		clickOnWebElement(SIGN_IN_BUTTON_ELEMENT_LOCATOR);
		return new AccountPage(getDriver());
	}

}
