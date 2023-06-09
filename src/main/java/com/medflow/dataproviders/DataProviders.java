/**
 * 
 */
package com.medflow.dataproviders;


import org.testng.annotations.DataProvider;

import com.medflow.utils.ExcelLibrary;



public class DataProviders {
	

/*  VerifySuccessfulLogin.java -> verifyLogin
 */
	@DataProvider(name = "credentials")
	public Object[][] getCredentials() {
		
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\testdata\\TestData.xlsx";
		ExcelLibrary obj = new ExcelLibrary(path);
		
		// Totals rows count
		int rows = obj.getRowCount("loginData");
		// Total Columns
		int column = obj.getColumnCount("loginData");
		int actRows = rows - 1;

		Object[][] data = new Object[actRows][column];

		for (int i = 0; i < actRows; i++) {
			for (int j = 0; j < column; j++) {
				data[i][j] = obj.getCellData("loginData", j, i + 2);
			}
		}
		return data;
	}

}
