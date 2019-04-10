package com.amazon.pages;

import commonLibs.implementation.DropdownControl;
import commonLibs.implementation.ElementControl;

public class BasePage {

	DropdownControl dropdownControl;

	ElementControl elementControl;

	public BasePage() {

		dropdownControl = new DropdownControl();

		elementControl = new ElementControl();
	}

}
