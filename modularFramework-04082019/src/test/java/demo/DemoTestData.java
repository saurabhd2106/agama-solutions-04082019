package demo;

import org.testng.annotations.Test;

public class DemoTestData {
	
	@Test(dataProvider="getData",dataProviderClass= utils.TestDataReader.class)
	public void printTestData(String username, String password){
		
		System.out.println("Username : "+ username);
		
		System.out.println("Password : "+ password);
	}

}
