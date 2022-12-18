package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManager;

public class DriverConfig {
	private WebDriver driver;
	Properties props = new Properties();
	private Logger log = LogManager.getLogger(this.getClass());

	// resource paths
	private final String propsFilepath = "/resources/config.properties";

	/**
	 * initialize driver
	 * 
	 * @return - WebDriver
	 */
	public WebDriver initializeDriver() {
		loadProperty();
		log.debug("Running on browser: " + getBrowser());
		switch (getBrowser()) {
		case "chrome":
			SeleniumManager.getInstance();
			driver = new ChromeDriver();
			break;
		case "firefox":
			SeleniumManager.getInstance();
			driver = new FirefoxDriver();
			break;
		case "edge":
			SeleniumManager.getInstance();
			driver = new EdgeDriver();
			break;
		default:
			log.fatal("Invalid browser/browser config doesnt exist");
		}
		log.debug("Driver initialized");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}

	/**
	 * load properties file
	 * 
	 */
	public void loadProperty() {
		try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + propsFilepath);
			log.debug("Loading properties");
			props.load(fis);
		} catch (IOException e) {
			log.error("Exception in loadProperty method: " + e.getMessage());
		}
	}

	/**
	 * get url value from properties
	 * 
	 * @param url - key can be google-url, bing-url etc.
	 * @return - String
	 */
	public String getUrl(String url) {
		return props.getProperty(url);
	}

	/**
	 * get browser value from properties
	 * 
	 * @return - String
	 */
	public String getBrowser() {
		return props.getProperty("browser");
	}

}
