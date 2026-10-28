package com.utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.pojos.Config;
import com.pojos.Environment;

public class JSONUtil {
	public static Environment readJsonFile(Env env) {
		Gson gson = new Gson();
		File jsonFile = new File(System.getProperty("user.dir") + File.separator + "src" + File.separator + "test" + File.separator + "resources" + File.separator + "config" + File.separator + "Config.json");
		FileReader fileReader = null;
		try {
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return gson.fromJson(fileReader, Config.class).getEnvironments().get(env.name().toUpperCase());
	}
}
