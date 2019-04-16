package com.amazon.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class AmazonTests extends BaseTests {

	@Test(priority = 0)
	public void searchAProduct() throws Exception {
		
		extentTest = extentReport.createTest("TC - 001 - Search Product");
		
	
		String product = "Apple Watch";

		String category = "Electronics";

		extentTest.log(Status.INFO, "Searching a product : "+ product);
		extentTest.log(Status.INFO, "and the category is : "+ category);
		homepage.searchProduct(product, category);
		
		extentTest.log(Status.INFO, "Search for the mentioned product and category which are : "+ product+"  "+ category);
	
		String actualResult = resultPage.getResult();
		extentTest.log(Status.INFO, "After searching the product - get the result "+ actualResult);
		System.out.println(actualResult);

		Assert.assertEquals(actualResult, "1-24 of over 4,000 results for");
		
		extentTest.log(Status.INFO, "Assert statement executed fine");
	}
	
	
	
	
}
