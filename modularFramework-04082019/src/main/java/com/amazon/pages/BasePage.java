package com.amazon.pages;

import org.openqa.selenium.WebDriver;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControl;
import commonLibs.implementation.JavascriptControl;
import commonLibs.implementation.MouseControl;

public class BasePage {

	DropdownControl dropdownControl;

	ElementControl elementControl;

	MouseControl mouseControl;

	JavascriptControl jsControl;

	public BasePage(WebDriver driver) {

		dropdownControl = new DropdownControl();

		elementControl = new ElementControl();

		mouseControl = new MouseControl(driver);

		jsControl = new JavascriptControl(driver);
	}

}
