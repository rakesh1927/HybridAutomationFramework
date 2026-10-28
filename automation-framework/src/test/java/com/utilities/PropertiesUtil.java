package com.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.constants.Env;

public class PropertiesUtil {

	public static String getProperty(Env env, String propertyName) {
		File propFile = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\config\\" + env + ".properties");
		Properties prop = null;
		FileReader fileReader;
		try {
			fileReader = new FileReader(propFile);
			prop = new Properties();
			prop.load(fileReader);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(propertyName);
	}

}
