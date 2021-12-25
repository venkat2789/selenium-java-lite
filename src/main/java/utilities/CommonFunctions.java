package utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
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
	 * @throws IOException
	 */
	public void takeScreenshot() throws IOException {
		File scrnFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrnFile, new File(currentDir + "/screenshots" + System.currentTimeMillis() + ".png"));
	}

	/**
	 * take screenshot and name file with test name + time stamp
	 * 
	 * @param testName
	 * @throws IOException
	 */
	public void takeScreenshot(String testName) throws IOException {
		File scrnFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrnFile,
				new File(currentDir + "/screenshots/" + testName + "_" + formatTimeSDF() + ".png"));
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
