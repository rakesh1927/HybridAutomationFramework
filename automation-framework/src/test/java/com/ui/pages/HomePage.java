package com.ui.pages;

import static com.constants.Env.QA;
import static com.utilities.JSONUtil.readJsonFile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.constants.Browser;
import com.utilities.BrowserUtility;
import com.utilities.PropertiesUtil;

public final class HomePage extends BrowserUtility{
	public HomePage(WebDriver driver) {
		super(driver);
		navigateToWebsite(PropertiesUtil.getProperty(QA, "URL"));
	}

	public HomePage(Browser browserName, boolean isHeadless) {
		super(browserName, isHeadless);
		navigateToWebsite(readJsonFile(QA).getUrl());
	}

	public static final By SIGN_IN_LINK_LOCATOR = By.cssSelector("a[class='login']");
	
	public LoginPage goToLoginPage() {
		clickOnWebElement(SIGN_IN_LINK_LOCATOR);
		return new LoginPage(getDriver());
	}
}
