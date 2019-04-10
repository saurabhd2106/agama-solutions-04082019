package com.amazon.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonResultPage extends BasePage {

	@FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]")
	private WebElement result;
	
	public AmazonResultPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
	}

	public String getResult() throws Exception {
		return elementControl.getText(result);
	}

}
