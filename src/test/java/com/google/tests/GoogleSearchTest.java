package com.google.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.pages.GoogleResultsPage;
import com.google.pages.GoogleSearchPage;

import config.DriverConfig;

//@Listeners(listeners.TestNGListener.class)
public class GoogleSearchTest extends DriverConfig {
	private WebDriver driver;

	/**
	 * initializes driver, launches home page URL
	 * 
	 * @throws IOException
	 */
	@BeforeTest
	public void setup() throws IOException {
		driver = initializeDriver();
		String url = getUrl("url");
		driver.get(url);
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
			System.out.println("---End of test---");
			driver.close();
		}
	}

}
