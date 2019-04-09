package demo;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.CommonDriver;
import commonLibs.implementation.MouseControl;

public class DemoCommonDriver {

	public static void main(String[] args) {
		
		try {
			CommonDriver cmnDriver = new CommonDriver("edge");
			
			cmnDriver.setElementDetectionTimeout(10);
			
			cmnDriver.setPageloadTimeout(30);
			
			cmnDriver.navigateToFirstUrl("http://qatechhub.com");
			
			WebDriver driver= cmnDriver.getDriver();
			
			MouseControl mouseControl = new MouseControl(driver);
			
			cmnDriver.closeAllBrowsers();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
