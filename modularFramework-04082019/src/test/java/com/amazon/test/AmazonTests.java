package com.amazon.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonTests extends BaseTests {

	@Test(priority = 0)
	public void searchAProduct() throws Exception {
		String product = "Apple Watch";

		String category = "Electronics";

		homepage.searchProduct(product, category);

		String actualResult = resultPage.getResult();

		System.out.println(actualResult);

		Assert.assertEquals(actualResult, "1-24 of over 4,000 results for");
	}
	
	@Test(priority=1000)
	public void verifyNthProduct() throws Exception{
		int productNumber = 5;
		
		resultPage.getNthProduct(productNumber);
	}
	
	@Test(priority=2000)
	public void verifyAllProducts() throws Exception{
		resultPage.getAllProductViaJsOperation();
	}
	
	
}
