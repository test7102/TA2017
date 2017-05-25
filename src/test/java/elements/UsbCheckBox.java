package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsbCheckBox {
	private WebDriver driver;
	public static final String USB_VERSION = "3.0";
	private static final String USB_LOCATOR = "//div[@id='LeftNavContainer']//span[contains(text(),'USB') and contains(text(),'"+USB_VERSION+"')]";
	@FindBy(xpath = USB_LOCATOR)
	private WebElement usbCheck;
	
	public UsbCheckBox(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void click() {
		usbCheck.click();
	}
}
