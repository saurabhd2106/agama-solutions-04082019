package com.amazon.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.amazon.pages.AmazonHomePage;
import com.amazon.pages.AmazonResultPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.ScreenshotControl;
import commonLibs.utils.ConfigReader;

public class BaseTests {

	CommonDriver cmnDriver;

	AmazonHomePage homepage;
	AmazonResultPage resultPage;

	ScreenshotControl screenshotControl;

	String currentWorkingDirectory;

	String executionStartTime;

	private WebDriver driver;

	ExtentReports extentReport;

	ExtentHtmlReporter htmlReporter;

	ExtentTest extentTest;

	String reportFileName;

	Properties configProperty;

	private String configFilename;

	@BeforeSuite
	public void setup() throws Exception {

		initializeTestExecutionStartTime();

		initializeCurrentWorkingDirectory();

		initializeConfigProperty();

		initializeExtentReport();

		invokeBrowser();

		initializePages();

		initializeScreenshotVariable();
	}

	private void initializeConfigProperty() throws Exception {

		configFilename = String.format("%s/config/config.properties", currentWorkingDirectory);
		configProperty = ConfigReader.readConfigProperty(configFilename);

	}

	private void initializeExtentReport() {

		extentReport = new ExtentReports();

		reportFileName = String.format("%s/reports/amazonReport_%s.html", currentWorkingDirectory, executionStartTime);

		htmlReporter = new ExtentHtmlReporter(reportFileName);

		htmlReporter.config().setReportName("Amazon Test series");

		htmlReporter.config().setDocumentTitle("Amazon  Test - ExtentReports");

		extentReport.attachReporter(htmlReporter);

	}

	private void initializeTestExecutionStartTime() {

		executionStartTime = String.valueOf(System.currentTimeMillis());

	}

	private void initializeCurrentWorkingDirectory() {
		currentWorkingDirectory = System.getProperty("user.dir");

	}

	private void initializeScreenshotVariable() {
		screenshotControl = new ScreenshotControl(driver);

	}

	@AfterSuite
	public void cleanUp() throws Exception {
		closeBrowser();

		extentReport.flush();
	}

	@AfterMethod
	public void afterAMethod(ITestResult result) throws Exception {

		String methodName = result.getName();
		String filename;

		if (result.getStatus() == ITestResult.FAILURE) {
			filename = String.format("%s/screenshots/%s_%s.jpeg", currentWorkingDirectory, methodName,
					executionStartTime);

			screenshotControl.captureAndSaveScreenshot(filename);

			extentTest.log(Status.FAIL, "Test case failed : " + methodName);

			extentTest.addScreenCaptureFromPath(filename);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			extentTest.log(Status.PASS, "Test pass : " + methodName);
		} else {
			extentTest.log(Status.FAIL, "Test fail" + methodName);
		}

	}

	private void closeBrowser() throws Exception {

		cmnDriver.closeAllBrowsers();

	}

	private void initializePages() {
		homepage = new AmazonHomePage(driver);
		resultPage = new AmazonResultPage(driver);

	}

	private void invokeBrowser() throws Exception {

		String browserType = configProperty.getProperty("browserType");
		cmnDriver = new CommonDriver(browserType);

		int pageloadTimeout = Integer.parseInt(configProperty.getProperty("pageloadTimeout"));
		cmnDriver.setPageloadTimeout(pageloadTimeout);

		int elementDetectionTimeout = Integer.parseInt(configProperty.getProperty("elementDetectionTimeout"));
		cmnDriver.setElementDetectionTimeout(elementDetectionTimeout);

		String baseUrl = configProperty.getProperty("baseUrl");
		cmnDriver.navigateToFirstUrl(baseUrl);

		driver = cmnDriver.getDriver();
	}
}
