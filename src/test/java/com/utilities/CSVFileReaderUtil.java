package com.utilities;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.pojos.User;

public class CSVFileReaderUtil {

	public static Iterator<User> readCsvFile(String fileName) {
		if (!fileName.toLowerCase().endsWith(".csv")) {
			System.err.println("Error: The file '" + fileName + "' is not a CSV file.");
			throw new IllegalArgumentException("The file '" + fileName + "' is not a CSV file.");
		}
		File csvFile = new File(
				System.getProperty("user.dir") + File.separator + "testData" + File.separator + fileName);
		List<User> userList = null;
		FileReader fileReader;
		CSVReader csvReader;
		String[] line;
		User userData;
		try {
			fileReader = new FileReader(csvFile);
			csvReader = new CSVReader(fileReader);
			csvReader.readNext();
			userList = new ArrayList<User>();
			while ((line = csvReader.readNext()) != null) {
				userData = new User(line[0], line[1]);
				userList.add(userData);
			}
		} catch (CsvValidationException | IOException e) {
			e.printStackTrace();
		}
		return userList.iterator();
	}

}
