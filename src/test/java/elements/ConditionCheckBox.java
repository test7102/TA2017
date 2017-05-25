package elements;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConditionCheckBox {
	public static final String CONDITION = "New other";
	private static final String CONDITION_CHECKBOX_LOCATOR = "//div[@id='LeftNavContainer']//span[contains(text(),'" + CONDITION + "')]";
	private WebDriver driver;
	
	@FindBy(xpath = CONDITION_CHECKBOX_LOCATOR)
	private WebElement conditionCheck;
	
	
	public ConditionCheckBox(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	public void click() {
		conditionCheck.click();
	}
	
	
}
