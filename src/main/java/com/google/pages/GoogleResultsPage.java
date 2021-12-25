package com.google.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.CommonFunctions;

public class GoogleResultsPage {
	@SuppressWarnings("unused")
	private WebDriver driver;
	CommonFunctions functions;

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
			System.out.println("Results found");
			text = eleResults.getText();
		}
		return text;
	}

}
