package commonLibs.implementation;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import commonLibs.contracts.IJavascript;

public class JavascriptControl implements IJavascript {

	private WebDriver driver;

	public JavascriptControl(WebDriver driver) {
		this.driver = driver;

	}

	@Override
	public void executeJavaScript(String scriptToExecute) throws Exception {

		JavascriptExecutor jsEngine;

		jsEngine = (JavascriptExecutor) driver;

		jsEngine.executeScript(scriptToExecute);

	}

	@Override
	public void scrollDown(int x, int y) throws Exception {
		
		String jsCommand = String.format("window.scrollBy(%d,%d)", x,y);
		
		executeJavaScript(jsCommand);

	}

	@Override
	public String executeJavaScriptWithReturnValue(String scriptToExecute) throws Exception {
		
		JavascriptExecutor jsEngine;

		jsEngine = (JavascriptExecutor) driver;

		return jsEngine.executeScript(scriptToExecute).toString();
		 
	}

}
