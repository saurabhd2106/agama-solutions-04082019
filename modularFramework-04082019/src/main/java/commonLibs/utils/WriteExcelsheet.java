package commonLibs.utils;

public class WriteExcelsheet {

	ExcelDriver excelDriver = new ExcelDriver();

	String filename = System.getProperty("user.dir") + "/testDataFiles/excelData.xlsx";
	String sheetname = "Test Data";

	public void createExcelsheet() throws Exception {
		excelDriver.createWorkbook(filename);
		excelDriver.openWorkbook(filename);

		excelDriver.createSheet(sheetname);
	}

	public void writeToAnExcelsheet(int rowNumber, int cellNumber, String info) throws Exception {

		excelDriver.setCellData(sheetname, rowNumber, cellNumber, info);

	}

	public void saveExcelsheet() throws Exception {
		excelDriver.saveFile();

		excelDriver.closeWorkbook();
	}

}
