package com.amazon.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AmazonResultPage extends BasePage {

	@FindBy(xpath = "//div[@class='a-section a-spacing-small a-spacing-top-small']/span[1]")
	private WebElement result;

	private WebElement nthProduct;

	@FindBy(xpath = "//div[@class='s-result-list sg-row']/div")
	private List<WebElement> allProduct;

	private WebDriver driver;

	public AmazonResultPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public String getResult() throws Exception {
		return elementControl.getText(result);
	}

	public void getNthProduct(int productNumber) throws Exception {

		String productXpath = String.format("//div[@class='s-result-list sg-row']/div[@data-index='%d']",
				(productNumber - 1));

		nthProduct = driver.findElement(By.xpath(productXpath));

		System.out.println(elementControl.getText(nthProduct));

	}

	public void getAllProduct() throws Exception {

		int productCount = allProduct.size();

		System.out.println("Product count : " + productCount);
		
		for (WebElement product : allProduct) {

			System.out.println(elementControl.getText(product));

			System.out.println("------------------------------------------------------------");
		}
	}
	
	public void getAllProductViaScrollDownUsingMouseOperation() throws Exception {

		int productCount = allProduct.size();

		System.out.println("Product count : " + productCount);
		
		for (WebElement product : allProduct) {

			mouseControl.moveToElement(product);
			
			System.out.println(elementControl.getText(product));

			System.out.println("------------------------------------------------------------");
		}
	}
	
	public void getAllProductViaJsOperation() throws Exception {

		int productCount = allProduct.size();

		System.out.println("Product count : " + productCount);
		
		int X, Y;
		for (WebElement product : allProduct) {

			X = elementControl.getXLocationOfElement(product);
			
			Y = elementControl.getYLocationOfElement(product);
			
			jsControl.scrollDown(X, Y);
			
			System.out.println(elementControl.getText(product));

			System.out.println("------------------------------------------------------------");
		}
	}

}
