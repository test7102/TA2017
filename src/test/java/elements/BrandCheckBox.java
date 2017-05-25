package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrandCheckBox {
	public static final String BRAND_NAME = "Corsair";
	private static final String BRAND_LOCATOR = "//div[@id='LeftNavContainer']//span[contains(text(),'" + BRAND_NAME + "')]";
	private WebDriver driver;
	@FindBy(xpath = BRAND_LOCATOR)
	private WebElement appleCheck;
	
	public BrandCheckBox(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void click() {
		appleCheck.click();
	}
	
}
