package com.utilities;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.pojos.User;

public class ExcelReaderUtil {

	public static Iterator<User> readExcelFile(String fileName) {
		File excelFile = new File(System.getProperty("user.dir")
				+File.separator + "testData"
				+File.separator + fileName);
		XSSFWorkbook xssfworkbook = null;
		XSSFSheet xssfsheet;
		List<User> userList = null;
		Iterator<Row> rowIterator;
		Row row;
		Cell emailCell;
		Cell passwordCell;
		User user;
		try {
			xssfworkbook = new XSSFWorkbook(excelFile);
			xssfsheet = xssfworkbook.getSheet("LoginTestData");
			userList = new ArrayList<User>();
			rowIterator = xssfsheet.iterator();
			rowIterator.next();
			while(rowIterator.hasNext()) {
				row = rowIterator.next();
				emailCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user = new User(emailCell.toString(), passwordCell.toString());
				userList.add(user);
			}
		} catch (InvalidFormatException | IOException e) {
			e.printStackTrace();
		}finally {
			try {
				xssfworkbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}
		return userList.iterator();
	}

}
