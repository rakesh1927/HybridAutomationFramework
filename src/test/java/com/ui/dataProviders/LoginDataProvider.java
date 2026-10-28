package com.ui.dataProviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.pojos.LoginData;
import com.pojos.User;
import com.utilities.CSVFileReaderUtil;
import com.utilities.ExcelReaderUtil;

public class LoginDataProvider {
	
	@DataProvider(name="loginTestDataProvider")
	public Iterator<Object[]> loginDataProvider() {
		Gson gson = new Gson();
		File file = new File(System.getProperty("user.dir")+"/testData/loginData.json");
		FileReader fileReader;
		LoginData data;
		List<Object[]> dataToReturn = new ArrayList<Object[]>();
		try {
			fileReader = new FileReader(file);
			data = gson.fromJson(fileReader, LoginData.class);
			for(User user:data.getData()) {
				dataToReturn.add(new Object[] {user});
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return dataToReturn.iterator();
	}
	
	@DataProvider(name="loginCsvDataProvider")
	public Iterator<User> loginCsvDataProvider() {
		return CSVFileReaderUtil.readCsvFile("loginData.csv");
	}
	
	@DataProvider(name="loginExcelDataProvider")
	public Iterator<User> loginExcelDataProvider() {
		return ExcelReaderUtil.readExcelFile("loginData.xlsx");
	}
	
}
