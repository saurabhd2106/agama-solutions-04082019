package demo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestDataReader {

	@Test(dataProvider="getData")
	public void printTestData(String username, String password, int employeeId) {

		System.out.println("Username : " + username + " and password : " + password);
	}
	

	@DataProvider
	public Object[][] getData(){
		Object[][] data = new Object[4][3];
		
		data[0][0] = "Saurabh";
		data[0][1] = "xyz@123";
		data[0][2] = 349543;
		
		data[1][0] = "Gurkirat";
		data[1][1] = "abc@123";
		data[1][2] = 432423;
		
		data[2][0] = "Preet";
		data[2][1] = "xyz@123";
		data[2][2] = 432423;
		
		data[3][0] = "Alpher";
		data[3][1] = "abc@123";
		data[3][2] = 12321;
		
		return data;
	}
}
