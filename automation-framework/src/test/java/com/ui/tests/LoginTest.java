package com.ui.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.pojos.User;
import com.ui.dataProviders.LoginDataProvider;
import com.ui.listeners.MyRetryAnalyser;
import com.ui.listeners.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest{

	@Test(description = "This validates the login functionality of the application using json file", groups= {"sanity","e2e"}, 
			dataProviderClass = LoginDataProvider.class, dataProvider = "loginTestDataProvider")
	public void loginTest(User user) {
		Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(), "Rakesh Dash");
	}
	
	@Test(description = "This validates the login functionality of the application using csv file", groups= {"sanity","e2e"}, 
			dataProviderClass = LoginDataProvider.class, dataProvider = "loginCsvDataProvider")
	public void loginCsvTest(User user) {
		Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(), "Rakesh Dash");
	}
	
	@Test(description = "This validates the login functionality of the application using excel file", groups= {"sanity","e2e"}, 
			dataProviderClass = LoginDataProvider.class, dataProvider = "loginExcelDataProvider", retryAnalyzer = MyRetryAnalyser.class)
	public void loginExcelTest(User user) {
		Assert.assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmail(), user.getPassword()).getUserName(), "Rakesh Dash");
	}

}
