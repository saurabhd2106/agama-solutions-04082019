package com.amazon.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class AmazonResultPageTests extends AmazonTests {

	@Test(priority = 1000)
	public void verifyNthProduct() throws Exception {

		extentTest = extentReport.createTest("TC - 002 - Get Nth product after search");
		int productNumber = 5;

		extentTest.log(Status.INFO, "Search product item : " + productNumber);
		resultPage.getNthProduct(productNumber);
	}

	@Test(priority = 2000)
	public void verifyAllProducts() throws Exception {
		extentTest = extentReport.createTest("TC - 003 - Get all products");
		resultPage.getAllProductViaJsOperation();
	}

}
