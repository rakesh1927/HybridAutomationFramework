package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

import com.constants.Env;
import com.utilities.JSONUtil;

public class MyRetryAnalyser implements IRetryAnalyzer{
	private static final int MAX_NUMBER_OF_ATTEMPTS = JSONUtil.readJsonFile(Env.QA).getMAX_NUMBER_OF_ATTEMPTS();
	
	private int currentAttempt = 0;
	
	@Override
	public boolean retry(ITestResult result) {
		if(currentAttempt < MAX_NUMBER_OF_ATTEMPTS) {
			currentAttempt++;
			return true;
		}
		return false;
	}

}
