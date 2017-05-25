import elements.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.annotations.*;

import pages.ItemCardPage;
import pages.ResultsPage;
import pages.SearchPage;
import util.PriceParser;

import java.util.ArrayList;

import static org.testng.Assert.assertTrue;

/**
 * @author Vivyen
 */
public class TestRefinements {
	private static final int ITEMS_PER_PAGE = 25;
	private static final double REQUIRED_MATCH_RATIO = 0.7;
	private static final String URL = "https://ebay.com/";
	private WebDriver driver;
	private SearchPage searchPage;
	private ResultsPage resultsPage;
	private ItemCardPage itemCardPage;
	private PriceForm priceForm;
	private BrandCheckBox brandCheckBox;
	private CapacityCheckBox capacityCheckBox;
	private UsbCheckBox usbCheckBox;
	private FreeShippingCheckBox freeShippingCheckBox;
	private ConditionCheckBox conditionCheckBox;
	private ShowOnlyCheckBox showOnlyCheckBox;

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
	 * <p>Method cleans url before each test.<p/>
	 *  It uses url parameter {@code &_ipg=} to set items per page for result set.
	 */
	@BeforeMethod
	public void cleanUrl() {
		if (!driver.getCurrentUrl().equals(URL)) {
			driver.get(URL + "sch/i.html?&_ipg=" + ITEMS_PER_PAGE);
			searchPage.setLanguageToEnglish();
			searchPage.search("flash drive");
			resultsPage.clickOnBuyitnow();
		}
	}
	
	/**
	 * <p>Method tests brand checkbox.<p/>
	 * It uses {@link BrandCheckBox} class to find elements
	 */
	@Test
	public void testBrandFilter() {
		System.out.println("Starting brand filter test");
		int matchCounter = 0;
		brandCheckBox.click();
		ArrayList<String> titles;
		titles = resultsPage.getItemsTitles();
		for (String title : titles) {
			if (title.toLowerCase().contains(BrandCheckBox.BRAND_NAME.toLowerCase())) {
				matchCounter++;
			}
		}
		isPassOrFailed(matchCounter, resultsPage.getItemsTitles().size());
	}
	
	/**
	 * <p>Method tests price form.<p/>
	 * It uses {@link PriceForm} class to find elements
	 */
	@Test
	public void testPriceFiler() {
		System.out.println("Starting price filter test");
		
		final int MAXIMUM_PRICE = 317;
		final int MINIMUM_PRICE = 233;
		float lowPriceFromItemSnippet;
		float highPriceFromItemSnippet;
		priceForm.setLowPrice(MINIMUM_PRICE);
		priceForm.setHighPrice(MAXIMUM_PRICE);
		priceForm.click();
		ArrayList<String> prices = new ArrayList();
		prices = resultsPage.getItemsPrices();
		for (String price : prices) {
			lowPriceFromItemSnippet = PriceParser.getFirstPrice(price);
			highPriceFromItemSnippet = PriceParser.getSecondPrice();
			System.out.println("Price on snippet from:" + lowPriceFromItemSnippet);
			System.out.println("Price on snippet to:" + highPriceFromItemSnippet);
			System.out.println("______________");
			assertTrue((lowPriceFromItemSnippet < MAXIMUM_PRICE) || (highPriceFromItemSnippet < MAXIMUM_PRICE));
			assertTrue((lowPriceFromItemSnippet > MINIMUM_PRICE) || (highPriceFromItemSnippet > MINIMUM_PRICE));
		}
	}
	
	/**
	 * <p>Method tests capacity checkbox.<p/>
	 * It uses {@link CapacityCheckBox} class to find elements
	 */
	@Test
	public void testCapacityFilter() {
		System.out.println("Starting capacity filter test");
		
		int matchCounter = 0;
		capacityCheckBox.click();
		ArrayList<String> titles = new ArrayList();
		titles = resultsPage.getItemsTitles();
		String tmpTitle;
		for (String title : titles) {
			tmpTitle = title.replaceAll("\\s", "");
			if (tmpTitle.toLowerCase().contains(CapacityCheckBox.CAPACITY + "gb")) {
				matchCounter++;
			}
		}
		isPassOrFailed(matchCounter, resultsPage.getItemsTitles().size());
	}
	
	/**
	 * <p>Method tests usb version checkbox.<p/>
	 * It uses {@link UsbCheckBox} class to find elements
	 */
	@Test
	public void testUsbFilter() {
		System.out.println("Starting usb spec. version filter test");
		
		int matchCounter = 0;
		usbCheckBox.click();
		ArrayList<String> titles;
		titles = resultsPage.getItemsTitles();
		String tmpTitle;
		for (String title : titles) {
			tmpTitle = title.replaceAll("\\s", "");
			if (tmpTitle.toLowerCase().contains("usb" + UsbCheckBox.USB_VERSION)) {
				matchCounter++;
			}
		}
		isPassOrFailed(matchCounter, resultsPage.getItemsTitles().size());
	}
	
	/**
	 * <p>Method tests freeshipping option checkbox.<p/>
	 * It uses {@link FreeShippingCheckBox} class to find elements
	 */
	@Test
	public void testFreeShipingFilter() {
		System.out.println("Starting freeshiping option filter test");
		
		int matchCounter = 0;
		freeShippingCheckBox.click();
		ArrayList<String> elementsContent;
		elementsContent = freeShippingCheckBox.getFreeShipingElementsText();
		for (String text : elementsContent) {
			if (text.toLowerCase().contains(FreeShippingCheckBox.FREESHIPPING.toLowerCase())) {
				matchCounter++;
			}
		}
		isPassOrFailed(matchCounter, resultsPage.getItemsTitles().size());
	}
	
	/**
	 * <p>Method tests condition checkbox.<p/>
	 * It uses {@link ConditionCheckBox} class to find elements
	 */
	@Test(enabled = true)
	public void testConditionFilter() {
		System.out.println("Starting condition filter test");
		int currentItem = 1;
		int matchCounter = 0;
		int resultSelectionItemsNumber = resultsPage.getItemsTitles().size();
		conditionCheckBox.click();
		ArrayList<String> itemlinks;
		itemlinks = resultsPage.getItemsLinks();
		String itemCondition;
		for (String itemlink : itemlinks) {
			driver.get(itemlink);
			itemCondition = itemCardPage.getItemCondition();
			if (itemCondition.toLowerCase().contains(ConditionCheckBox.CONDITION.toLowerCase())) {
				matchCounter++;
			}
			System.out.println("Verifying " + currentItem++ + " item of " + resultSelectionItemsNumber);
		}
		isPassOrFailed(matchCounter, resultSelectionItemsNumber);
	}
	
	/**
	 * <p>Method tests showonly checkbox.<p/>
	 * It uses {@link ShowOnlyCheckBox} class to find elements
	 */
	@Test(enabled = true)
	public void testShowOnlyFilter() {
		System.out.println("Starting showonly filter test");
		int currentItem = 1;
		int matchCounter = 0;
		int resultSelectionItemsNumber = resultsPage.getItemsTitles().size();
		showOnlyCheckBox.click();
		ArrayList<String> itemlinks;
		itemlinks = resultsPage.getItemsLinks();
		String itemStatus;
		for (String itemlink : itemlinks) {
			driver.get(itemlink);
			itemStatus = itemCardPage.getItemStatus();
			if (itemStatus.toLowerCase().contains(ShowOnlyCheckBox.SOLD_LISTINGS_MESSAGE_ON_ITEM_CARD.toLowerCase())
					| itemStatus.toLowerCase().contains(ShowOnlyCheckBox.SOLD_LISTINGS_MESSAGE__ON_ITEM_CARD_2.toLowerCase())) {
				matchCounter++;
			}
			System.out.println("Verifying " + currentItem++ + " item of " + resultSelectionItemsNumber);
		}
		isPassOrFailed(matchCounter, resultSelectionItemsNumber);
	}
	
	/**
	 * <p>Its utility method that checks whether calling test is passed or failed.<p/>
	 * @param matchCounter  how many items match the filter.
	 * @param resultSelectionNumberOfItems current items on page in result set.
	 */
	public void isPassOrFailed(int matchCounter, int resultSelectionNumberOfItems) {
		if (matchCounter < resultSelectionNumberOfItems * REQUIRED_MATCH_RATIO) {
			Assert.fail("Number of items that meets filter is " + matchCounter + " lower than " +
					resultSelectionNumberOfItems * REQUIRED_MATCH_RATIO + " (required)");
		} else {
			System.out.println("Number of items that meets filter is " + matchCounter + " of " + resultSelectionNumberOfItems);
		}
	}
	
}
