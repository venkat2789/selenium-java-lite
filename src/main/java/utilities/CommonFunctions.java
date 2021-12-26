package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonFunctions {
	private WebDriver driver;
	private WebDriverWait wait;
	private JavascriptExecutor js;
	private Logger log = LogManager.getLogger(this.getClass());

	public CommonFunctions(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 15);
	}

	/**
	 * helper method to wait for element
	 * 
	 * @param ele - WebElement
	 * @return - boolean
	 */
	public boolean waitForElement(WebElement ele) {
		return wait.until(ExpectedConditions.elementToBeClickable(ele)) != null ? true : false;
	}

	/**
	 * element click using js executor
	 * 
	 * @param ele - WebElement
	 */
	public void jsClick(WebElement ele) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ele);

	}

	/**
	 * enter text using js executor
	 * 
	 * @param ele
	 * @param text
	 */
	public void jsEnterText(WebElement ele, String text) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value', '" + text + "')", ele);
	}

	/**
	 * take screenshot
	 * 
	 */
	public void takeScreenshot() {
		File scrnFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrnFile, new File(currentDir + "/screenshots" + formatTimeSDF() + ".png"));
		} catch (IOException e) {
			log.error("Exception in takeScreenshot method: " + e.getMessage());
		}
	}

	/**
	 * take screenshot and name file with test name + time stamp
	 * 
	 * @param testName
	 */
	public void takeScreenshot(String testName) {
		File scrnFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		try {
			FileUtils.copyFile(scrnFile,
					new File(currentDir + "/screenshots/" + testName + "_" + formatTimeSDF() + ".png"));
		} catch (IOException e) {
			log.error("Exception in takeScreenshot method: " + e.getMessage());
		}
	}

	/**
	 * format date/time
	 * 
	 * @return - String
	 */
	public static String formatTimeSDF() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
