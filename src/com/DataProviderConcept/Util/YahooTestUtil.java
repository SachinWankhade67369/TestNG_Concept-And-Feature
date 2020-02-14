package com.DataProviderConcept.Util;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class YahooTestUtil {

	public static final String EXCEL_SHEET_PATH = "D:\\Test WorkSpace\\TestNGConceptAndFeatures\\YahooUserAccountDetails.xlsx";
	public static Workbook workbook;
	public static Sheet sheet;

	public static Object[][] getTestData(String sheetName) throws Exception {

		FileInputStream fis = new FileInputStream(EXCEL_SHEET_PATH);
		
		workbook= WorkbookFactory.create(fis);
		
		sheet= workbook.getSheet(sheetName);
		
		int rowNum=sheet.getLastRowNum();
		int columnNum=sheet.getRow(0).getLastCellNum();
		
		Object [][] data= new Object[rowNum][columnNum];
		
		for (int i = 0; i < rowNum; i++) {
			for(int j=0;j< columnNum;j++) {
				data[i][j] = sheet.getRow(i+1).getCell(j).toString();
			}
			
		}
		
		return data;
		
		
		
	}

}
