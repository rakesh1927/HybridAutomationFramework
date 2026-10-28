package com.utilities;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.constants.Browser;

public class LambdaTestUtility {
	public static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
	private static ThreadLocal<WebDriver> driverLocal = new ThreadLocal<WebDriver>();
	private static ThreadLocal<DesiredCapabilities> capabilitiesLocal = new ThreadLocal<DesiredCapabilities>();
	
	public static WebDriver initializeLambdaTestSession(String testName, String browserName) {
		DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browserName);
        capabilities.setCapability("browserVersion", "latest");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "onlyforcoding19");
        ltOptions.put("accessKey", "hz0xgjzCRfVFTPtnUqnVyHfmgVKJbnMtPxOMoU4r56KQ2LLwqB");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name", testName);
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "latest");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitiesLocal.set(capabilities);
        WebDriver driver;
        try {
			driver = new RemoteWebDriver(new URL(HUB_URL), capabilitiesLocal.get());
			driverLocal.set(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
        return driverLocal.get();
	}
	
	public static void quitSession() {
		if(driverLocal.get() != null) {
			driverLocal.get().quit();
		}
	}
}
