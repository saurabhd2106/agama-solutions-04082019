package demo;

import commonLibs.utils.ExcelDriver;

public class DemoExcelDriver {

	public static void main(String[] args) throws Exception{
		
		ExcelDriver excelDriver = new ExcelDriver();
		
		String filename = "C:/Users/Saurabh Dhingra/git/agamaSolution-04092019/modularFramework-04082019/testDataFiles/testdata.xlsx" ;
		
		String sheetname = "TestData";
		
		excelDriver.createWorkbook(filename);

		excelDriver.openWorkbook(filename);
		
		excelDriver.createSheet(sheetname);
		
		excelDriver.setCellData(sheetname, 1, 0, "Saurabh");
		excelDriver.setCellData(sheetname, 1, 1, "Dhingra");
		excelDriver.setCellData(sheetname, 0, 0, "Gurkirat");
		excelDriver.setCellData(sheetname, 0, 1, "Singh");
		
		excelDriver.saveFile();
		
		excelDriver.closeWorkbook();
	}

}
