package testcases;

import utilities.ExcelReader;

public class ExcelReading {

	public static void main(String[] args) {


		ExcelReader excel = new ExcelReader(".\\src\\test\\resources\\excel\\testdata.xlsx");

		String sheetName = "LoginTest";
		System.out.println(excel.getRowCount(sheetName));
		System.out.println(excel.getColumnCount(sheetName));
		
		System.out.println(excel.getCellData(sheetName, 0, 2));
		
		
	}

}
