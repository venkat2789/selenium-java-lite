package com.google.tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.google.pages.GoogleResultsPage;
import com.google.pages.GoogleSearchPage;

import config.DriverConfig;

@Listeners(listeners.TestNGListener.class)
public class GoogleSearchTest extends DriverConfig {
	public WebDriver driver;
	private Logger log = LogManager.getLogger(this.getClass());

	/**
	 * initializes driver
	 * 
	 */
	@BeforeTest
	public void setup() {
		driver = initializeDriver();
	}

	/**
	 * testNG data provider for tests
	 * 
	 * @return - Object[][]
	 */
	@DataProvider
	public Object[][] getData() {
		return new Object[][] { { "Selenium", "Selenium" } };
	}

	/**
	 * launches home page URL
	 * 
	 */
	@BeforeMethod
	public void launchURL() {
		String url = getUrl("url");
		log.info("Launching URL: " + url);
		driver.get(url);
	}

	/**
	 * actual test, creates objects of pages, runs end-to-end and asserts the result
	 * 
	 * @param searchText     - from data provider
	 * @param expectedResult - from data provider
	 */
	@Test(dataProvider = "getData")
	public void validateGoogleResult(String searchText, String expectedResult) {
		GoogleSearchPage searchPage = new GoogleSearchPage(driver);
		searchPage.enterSearchText(searchText);

		GoogleResultsPage resultsPage = new GoogleResultsPage(driver);
		String actualText = resultsPage.getFirstResult();

		Assert.assertTrue(actualText.contains(expectedResult), "Actual: " + actualText);
	}

	/**
	 * closes driver
	 */
	@AfterTest
	public void tearDown() {
		if (driver != null) {
			log.debug("End of Test. Closing driver" + System.lineSeparator());
			driver.close();
		}
	}

}
