package com.ui.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.ui.tests.BaseTest;
import com.utilities.BrowserUtility;
import com.utilities.ExtentReporterUtility;
import com.utilities.LoggerUtility;

public class TestListener implements ITestListener{
	Logger logger = LoggerUtility.getLogger(this.getClass());
	
	@Override
	public void onTestStart(ITestResult result) {
		logger.info(result.getMethod().getMethodName());
		logger.info(result.getMethod().getDescription());
		logger.info(Arrays.toString(result.getMethod().getGroups()));
		ExtentReporterUtility.createTest(result.getMethod().getMethodName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		logger.info("{} PASSED", result.getMethod().getMethodName());
		ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName()+" "+"PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		logger.error("{} FAILED. Exception: ", result.getMethod().getMethodName(), result.getThrowable());
		ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName()+" "+"FAILED")
		   .log(Status.FAIL, result.getThrowable().getMessage());
		Object testInstance = result.getInstance();
		BrowserUtility browserUtility = ((BaseTest)testInstance).getInstance();
		String screenshotPath = browserUtility.takeScreenshot(result.getMethod().getMethodName());
		ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		logger.warn("{} SKIPPED. Exception: ", result.getMethod().getMethodName(), result.getThrowable());
		ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName()+" "+"SKIPPED")
									   .log(Status.SKIP, result.getThrowable().getMessage());
	}

	@Override
	public void onStart(ITestContext context) {
		logger.info("Test Suite Started");
		ExtentReporterUtility.setupSparkReporter("report.html");
	}

	@Override
	public void onFinish(ITestContext context) {
		logger.info("Test Suite Completed");
		ExtentReporterUtility.flushReport();
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
   
	}
}
