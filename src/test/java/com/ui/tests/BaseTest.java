package com.ui.tests;


import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utilities.BrowserUtility;
import com.utilities.LambdaTestUtility;

public class BaseTest {
	protected HomePage homePage;
	private boolean isLambdaTest;
	
	@Parameters({"browser", "isLambdaTest", "isHeadless"})
	@BeforeMethod(description = "This is used to navigate to the homepage of the application")
	public void setup(@Optional("chrome") String browser, 
			@Optional("false") boolean isLambdaTest, 
			@Optional("false") boolean isHeadless, 
			ITestResult result) {
		this.isLambdaTest = isLambdaTest;
		WebDriver lambdaDriver;
		if(isLambdaTest) {
			lambdaDriver = LambdaTestUtility.initializeLambdaTestSession(result.getMethod().getMethodName(), browser);
			homePage = new HomePage(lambdaDriver);
		}else {			
			homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isHeadless);
		}
	}
	
	public BrowserUtility getInstance() {
		return homePage;
	}
	
	@AfterMethod
	public void tearDown() {
		if(isLambdaTest) {
			LambdaTestUtility.quitSession();
		}else {
			homePage.quit();
		}
	}
}
