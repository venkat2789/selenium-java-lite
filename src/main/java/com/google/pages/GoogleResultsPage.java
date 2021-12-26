package com.google.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonFunctions;

public class GoogleResultsPage {
	@SuppressWarnings("unused")
	private WebDriver driver;
	CommonFunctions functions;
	private Logger log = LogManager.getLogger(this.getClass());

	@FindBy(xpath = "//a[contains(@href, 'selenium.dev')]/h3")
	private WebElement eleResults;

	public GoogleResultsPage(WebDriver driver) {
		this.driver = driver;
		functions = new CommonFunctions(driver);
		PageFactory.initElements(driver, this);
	}

	/**
	 * returns first search result
	 * 
	 * @return - String
	 */
	public String getFirstResult() {
		String text = null;

		if (functions.waitForElement(eleResults)) {
			text = eleResults.getText();
			log.info("Result found: " + text);
		}
		return text;
	}

}
