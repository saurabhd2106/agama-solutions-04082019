package demo;

import commonLibs.implementation.CommonDriver;

public class DemoCommonDriver {

	public static void main(String[] args) {
		
		try {
			CommonDriver cmnDriver = new CommonDriver("edge");
			
			cmnDriver.setElementDetectionTimeout(10);
			
			cmnDriver.setPageloadTimeout(30);
			
			cmnDriver.navigateToFirstUrl("http://qatechhub.com");
			
			cmnDriver.closeAllBrowsers();
		} catch (Exception e) {
			
			e.printStackTrace();
		}

	}

}
