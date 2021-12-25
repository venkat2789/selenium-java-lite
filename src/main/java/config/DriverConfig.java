package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.InvalidArgumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverConfig {
	private WebDriver driver;
	Properties props = new Properties();

	// resource paths
	private final String chromeDriverPath = "resources/chromedriver";
	private final String geckoDriverPath = "resources/geckodriver";
	private final String propsFilepath = "/resources/config.properties";

	/**
	 * initialize driver
	 * 
	 * @return - WebDriver
	 * @throws IOException
	 */
	public WebDriver initializeDriver() throws IOException {
		loadProperty();
		System.out.println("Test to be executed on: " + getBrowser());
		switch (getBrowser()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);
			driver = new FirefoxDriver();
			break;
		default:
			throw new InvalidArgumentException("Invalid browser/browser config doesnt exist");
		}
		System.out.println("Driver inittialized");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		return driver;
	}

	/**
	 * load properties file
	 * 
	 * @throws IOException
	 */
	public void loadProperty() throws IOException {
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
		props.load(fis);
		System.out.println("Loaded properties");
	}

	/**
	 * get url value from properties
	 * 
	 * @param url - key can be google-url, bing-url etc.
	 * @return - String
	 * @throws IOException
	 */
	public String getUrl(String url) throws IOException {
		return props.getProperty(url);
	}

	/**
	 * get browser value from properties
	 * 
	 * @return - String
	 * @throws IOException
	 */
	public String getBrowser() throws IOException {
		return props.getProperty("browser");
	}

}
