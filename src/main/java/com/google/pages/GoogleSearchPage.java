package com.google.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonFunctions;

public class GoogleSearchPage {
	@SuppressWarnings("unused")
	private WebDriver driver;
	CommonFunctions functions;
	private Logger log = LogManager.getLogger(this.getClass());

	@FindBy(xpath = "//input[@name='q']")
	private WebElement eleSearchBar;

	public GoogleSearchPage(WebDriver driver) {
		this.driver = driver;
		functions = new CommonFunctions(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * enter search text in search box
	 * 
	 * @param search text
	 */
	public void enterSearchText(String text) {
		if (functions.waitForElement(eleSearchBar)) {
			log.info("Search bar found");
			eleSearchBar.click();
			eleSearchBar.sendKeys(text);
			log.info("Entered text: " + text);
			eleSearchBar.sendKeys(Keys.ENTER);
		}
	}

}
