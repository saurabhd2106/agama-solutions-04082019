package com.amazon.test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.amazon.pages.AmazonHomePage;
import com.amazon.pages.AmazonResultPage;

import commonLibs.implementation.CommonDriver;

public class BaseTests {

	CommonDriver cmnDriver;

	String url = "https://www.amazon.in/";

	AmazonHomePage homepage;
	AmazonResultPage resultPage;

	private WebDriver driver;

	@BeforeClass
	public void setup() throws Exception {

		invokeBrowser();

		initializePages();
	}

	@AfterClass
	public void cleanUp() throws Exception {
		closeBrowser();
	}

	private void closeBrowser() throws Exception {

		cmnDriver.closeAllBrowsers();

	}

	private void initializePages() {
		homepage = new AmazonHomePage(driver);
		resultPage = new AmazonResultPage(driver);

	}

	private void invokeBrowser() throws Exception {
		cmnDriver = new CommonDriver("chrome");

		cmnDriver.setPageloadTimeout(60);
		cmnDriver.setElementDetectionTimeout(10);

		cmnDriver.navigateToFirstUrl(url);

		driver = cmnDriver.getDriver();
	}
}
