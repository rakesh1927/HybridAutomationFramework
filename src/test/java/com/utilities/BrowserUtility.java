package com.utilities;

import static com.constants.Browser.CHROME;
import static com.constants.Browser.EDGE;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import com.constants.Browser;

public abstract class BrowserUtility {
	Logger logger = LoggerUtility.getLogger(this.getClass());
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	
	public WebDriver getDriver() {
		return driver.get();
	}

	public BrowserUtility(WebDriver driver) {
		super();
		BrowserUtility.driver.set(driver);
	}
	
	public BrowserUtility(Browser browserName, boolean isHeadless) {
		if(browserName == CHROME) {
			if(isHeadless) {
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless",
						"--window-size=1920,1080");
				driver.set(new ChromeDriver(options));
			}else {				
				driver.set(new ChromeDriver());
			}
		}else if(browserName == EDGE) {
			if(isHeadless) {
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--headless",
						"--window-size=1920,1080");
				driver.set(new EdgeDriver(options));
			}else {				
				driver.set(new EdgeDriver());
			}
		}else {
			System.err.print("Invalid Browser, please select Chrome/Edge");
			logger.error("Invalid Browser, please select Chrome/Edge");
		}
		logger.info("{} Launched with headless = {}", browserName, isHeadless);
	}

	public void navigateToWebsite(String url) {
		logger.info("Navigated to {}", url);
		driver.get().get(url);
	}

	public void clickOnWebElement(By locator) {
		logger.info("Clicking on the element: {}", locator);
		driver.get().findElement(locator).click();
	}
	
	public void enterText(By locator, String textToEnter) {
		logger.info("Sending: {} to: {}", textToEnter, locator);
		driver.get().findElement(locator).sendKeys(textToEnter);
	}
	
	public String getText(By locator) {
		logger.info("Getting the text from: {}", locator);
		return driver.get().findElement(locator).getText().trim();
	}
	
	public String takeScreenshot(String fileName) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String updatedFileName = fileName + " - " + timeStamp + ".png";
		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir")+File.separator+"screenshots"+File.separator+updatedFileName;
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return path;
	}
	
	public void quit() {
	    if (driver.get()!= null) {
	        driver.get().quit();
	    } else {
	        System.out.println("Driver was already null or not initialized.");
	    }
	}
}
