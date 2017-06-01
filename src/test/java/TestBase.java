import elements.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.ItemCardPage;
import pages.ResultsPage;
import pages.SearchPage;

/**
 * Superclass for tests.
 * @see TestRefinements
 */
public class TestBase {
	protected static final int ITEMS_PER_PAGE = 25;
	protected static final double REQUIRED_MATCH_RATIO = 0.7;
	protected static final String URL = "https://ebay.com/sch/i.html?&_ipg=" + ITEMS_PER_PAGE;
	protected WebDriver driver;
	protected SearchPage searchPage;
	protected ResultsPage resultsPage;
	protected ItemCardPage itemCardPage;
	protected PriceForm priceForm;
	protected BrandCheckBox brandCheckBox;
	protected CapacityCheckBox capacityCheckBox;
	protected UsbCheckBox usbCheckBox;
	protected FreeShippingCheckBox freeShippingCheckBox;
	protected ConditionCheckBox conditionCheckBox;
	protected ShowOnlyCheckBox showOnlyCheckBox;
	
	@BeforeClass
	public void setUP() {
		driver = new ChromeDriver();
//		driver.manage().window().maximize();
		searchPage = new SearchPage(driver);
		resultsPage = new ResultsPage(driver);
		priceForm = new PriceForm(driver);
		itemCardPage = new ItemCardPage(driver);
		brandCheckBox = new BrandCheckBox(driver);
		capacityCheckBox = new CapacityCheckBox(driver);
		usbCheckBox = new UsbCheckBox(driver);
		freeShippingCheckBox = new FreeShippingCheckBox(driver);
		conditionCheckBox = new ConditionCheckBox(driver);
		showOnlyCheckBox = new ShowOnlyCheckBox(driver);
	}
	
	@AfterClass(enabled = true)
	public void tearDown() {
		driver.quit();
	}
	
	/**
	 * <p>Method cleans url before each test.
	 * <p>It uses url   {@link TestBase#URL} and {@link TestBase#ITEMS_PER_PAGE} to set items per page for result set.
	 */
	@BeforeMethod
	public void cleanUrl() {
		if (!driver.getCurrentUrl().equals(URL)) {
			driver.get(URL);
			searchPage.search("flash drive");
			searchPage.setLanguageToEnglish();
			resultsPage.clickOnBuyitnow();
		}
	}
}
