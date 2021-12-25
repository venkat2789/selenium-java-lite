package com.google.pages;

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
			System.out.println("Search bar found");
			eleSearchBar.click();
			eleSearchBar.sendKeys(text);
			eleSearchBar.sendKeys(Keys.ENTER);
		}
	}

}
