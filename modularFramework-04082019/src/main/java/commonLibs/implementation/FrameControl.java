package commonLibs.implementation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonLibs.contracts.IFrameControl;

public class FrameControl implements IFrameControl {
	private WebDriver driver;

	public FrameControl(WebDriver driver) {
		this.driver = driver;
	}

	@Override
	public void switchToFrame(WebElement element) throws Exception {

		driver.switchTo().frame(element);

	}

	@Override
	public void switchToFrame(int index) throws Exception {
		driver.switchTo().frame(index);

	}

	@Override
	public void switchToFrame(String id) throws Exception {
		driver.switchTo().frame(id);

	}

	@Override
	public void switchToParentpage() throws Exception {
		driver.switchTo().defaultContent();

	}

}
