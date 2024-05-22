package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constants;

public class ExcelUtility {
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static FileInputStream f;
	public static String getString(int i, int j, String sheet) {
		String file_path = Constants.TESTDATAFILE;
		try {
			f = new FileInputStream(file_path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(f);
		} catch (IOException e) {

			e.printStackTrace();
		}
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	}
	public static String getString(int i, int j, String sheet, String file_path) {
		try {
			f = new FileInputStream(file_path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(f);
		} catch (IOException e) {

			e.printStackTrace();
		}
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		return c.getStringCellValue();
	}
	public static String getInteger(int i, int j, String sheet) 
	{
		String file_path = Constants.TESTDATAFILE;
		try {
			f = new FileInputStream(file_path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(f);
		} catch (IOException e) {

			e.printStackTrace();
		}
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		int a=(int)c.getNumericCellValue();
		return String.valueOf(a);
	}
	public static String getInteger(int i, int j, String sheet, String file_path) {
		try {
			f = new FileInputStream(file_path);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		try {
			wb = new XSSFWorkbook(f);
		} catch (IOException e) {

			e.printStackTrace();
		}
		sh = wb.getSheet(sheet);
		Row r = sh.getRow(i);
		Cell c = r.getCell(j);
		int a=(int)c.getNumericCellValue();
		return String.valueOf(a);
		
	}
	public static ArrayList<String> getRow(String file_path, String sheet, int rownum) {
		try {
		f = new FileInputStream(System.getProperty(file_path));
		} catch (FileNotFoundException e) {
		e.printStackTrace();
		}
		try {
		wb = new XSSFWorkbook(f);
		} catch (IOException e) {
		e.printStackTrace();
		}
		sh = wb.getSheet(sheet);
		ArrayList<String> ExcelRows = new ArrayList<String>();
		Row row = sh.getRow(rownum);
		int cellCount = row.getLastCellNum();
		for (int j = 0; j < cellCount; j++) {
		ExcelRows.add(row.getCell(j).getStringCellValue());
		}
		return ExcelRows;
		}


}
