package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CapacityCheckBox {
	private WebDriver driver;
	public static final String CAPACITY = "16";
	private static final String CAPACITY_LOCATOR = "//div[@id='LeftNavContainer']//span[contains(text(),'GB') and contains(text(),'"+CAPACITY+"')]";
	@FindBy(xpath = CAPACITY_LOCATOR)
	private WebElement capacityCheck;
	
	public CapacityCheckBox(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void click() {
		capacityCheck.click();
	}
	
	
}
